// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.momintechnologies.phrases:
//            CSVReader, Phrase, DatabaseHelper, TimePickerFragment

public class MainActivity extends Activity
{

    private String TAG;
    private DatabaseHelper db;
    private List dbList;
    private int i;
    private Button notifyButton;
    private List phraseList;
    private SpannableString title;
    private TextView titleView;

    public MainActivity()
    {
        phraseList = new ArrayList();
        dbList = new ArrayList();
        TAG = getClass().getSimpleName();
    }

    public final List initializeDatabase(Context context)
    {
        ArrayList arraylist;
        int j;
        arraylist = new ArrayList();
        context = context.getAssets();
        j = 0;
        context = new CSVReader(new InputStreamReader(context.open("database.csv")));
        context.readNext();
_L1:
        String as[] = context.readNext();
        if (as == null)
        {
            return arraylist;
        }
        Phrase phrase;
        try
        {
            Log.d(TAG, (new StringBuilder("Phrase from db:")).append(as[0]).toString());
            phrase = new Phrase(j, as[0], as[1], as[2]);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return arraylist;
        }
        j++;
        arraylist.add(phrase);
          goto _L1
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
        if (phraseList.size() != 0) goto _L2; else goto _L1
_L1:
        dbList = initializeDatabase(getApplicationContext());
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
        super.onResume();
    }
}
