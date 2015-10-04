// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

// Referenced classes of package com.momintechnologies.phrases:
//            Utils, AlarmReceiver, DatabaseHelper, Phrase, 
//            TimePickerFragment

public class MainActivity extends Activity
{

    private String TAG;
    private DatabaseHelper db;
    private List dbList;
    private int i;
    private Boolean isFirstTime;
    private SharedPreferences myPrefs;
    private Button notifyButton;
    private List phraseList;
    private SpannableString title;
    private TextView titleView;
    private Utils utils;
    private TextView waitingMessageView;

    public MainActivity()
    {
        phraseList = new ArrayList();
        dbList = new ArrayList();
        TAG = getClass().getSimpleName();
        isFirstTime = Boolean.valueOf(true);
    }

    private void initializeAlarm()
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getDefault());
        int j = utils.randInt(7, 8);
        int k = utils.randInt(0, 60);
        calendar.set(11, j);
        calendar.set(12, k);
        setRecurringAlarm(getApplicationContext(), calendar);
    }

    private void setRecurringAlarm(Context context, Calendar calendar)
    {
        Object obj = new Intent(context, com/momintechnologies/phrases/AlarmReceiver);
        ((Intent) (obj)).addFlags(0x10000000);
        obj = PendingIntent.getBroadcast(context, 0, ((Intent) (obj)), 0x10000000);
        ((AlarmManager)context.getSystemService("alarm")).setRepeating(0, calendar.getTimeInMillis(), 0x5265c00L, ((PendingIntent) (obj)));
        Log.d("Phrases", (new StringBuilder("Set alarmManager.setRepeating to: ")).append(calendar.getTime().toLocaleString()).toString());
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f030019);
        db = new DatabaseHelper(getApplicationContext());
        title = new SpannableString(getText(0x7f0a000f));
        title.setSpan(new ForegroundColorSpan(Color.parseColor("#ff9800")), title.length() - 1, title.length(), 0);
        titleView = (TextView)findViewById(0x7f05002b);
        titleView.setText(title);
        phraseList = db.getAllPhrases();
        utils = new Utils();
        if (phraseList.size() != 0) goto _L2; else goto _L1
_L1:
        dbList = utils.initializeDatabase(getApplicationContext());
        i = 0;
_L5:
        if (i < dbList.size()) goto _L3; else goto _L2
_L2:
        notifyButton = (Button)findViewById(0x7f05003e);
        notifyButton.setOnClickListener(new android.view.View.OnClickListener() {

            final MainActivity this$0;

            public void onClick(View view)
            {
                (new TimePickerFragment()).show(getFragmentManager(), "timePicker");
            }

            
            {
                this$0 = MainActivity.this;
                super();
            }
        });
        return;
_L3:
        db.addPhrase((Phrase)dbList.get(i));
        i = i + 1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onResume()
    {
        myPrefs = getSharedPreferences("my_pref", 0);
        isFirstTime = Boolean.valueOf(myPrefs.getBoolean("isFirstTime", true));
        if (isFirstTime.booleanValue())
        {
            initializeAlarm();
        } else
        {
            waitingMessageView = (TextView)findViewById(0x7f05003d);
            waitingMessageView.setVisibility(0);
        }
        super.onResume();
    }
}
