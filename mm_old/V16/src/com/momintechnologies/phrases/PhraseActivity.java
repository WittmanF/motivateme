// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

// Referenced classes of package com.momintechnologies.phrases:
//            DatabaseHelper, Phrase, Utils, MainActivity

public class PhraseActivity extends Activity
{

    private String TAG;
    private Boolean alreadyViewed;
    private CountDownTimer countDownTimer;
    private DatabaseHelper db;
    private int index;
    private Boolean isFirstTime;
    private SharedPreferences myPrefs;
    private ImageView pause_button;
    private TextView phraseText;
    private long timeLeft;
    private TextView timerText;
    private Utils utils;

    public PhraseActivity()
    {
        isFirstTime = Boolean.valueOf(true);
        alreadyViewed = Boolean.valueOf(false);
        TAG = getClass().getSimpleName();
    }

    private CountDownTimer getCountDownTimer(long l)
    {
        return new CountDownTimer(l, 1000L) {

            final PhraseActivity this$0;

            public void onFinish()
            {
                finish();
            }

            public void onTick(long l1)
            {
                timerText.setText((new StringBuilder()).append(l1 / 1000L).toString());
                timeLeft = l1;
                if (timeLeft < 2000L)
                {
                    timerText.setText(0x7f0a0013);
                }
            }

            
            {
                this$0 = PhraseActivity.this;
                super(l, l1);
            }
        };
    }

    private void setupPhrase()
    {
        isFirstTime = Boolean.valueOf(myPrefs.getBoolean("isFirstTime", true));
        alreadyViewed = Boolean.valueOf(myPrefs.getBoolean("alreadyViewed", true));
        Phrase phrase;
        if (isFirstTime.booleanValue())
        {
            index = 0;
        } else
        {
            index = utils.randInt(0, db.getPhraseCount() - 1);
        }
        Log.d(TAG, (new StringBuilder("Random Index:[")).append(index).append("]").toString());
        phrase = db.getPhrase(index);
        phraseText.setText(phrase.getPhraseText());
        Log.d(TAG, (new StringBuilder("Index:[")).append(index).append("] & Phrase :").append(phrase.getPhraseText()).toString());
        countDownTimer = getCountDownTimer(10000L);
        countDownTimer.start();
        myPrefs.edit().putBoolean("isFirstTime", false).commit();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f03001a);
        db = new DatabaseHelper(getApplicationContext());
        timerText = (TextView)findViewById(0x7f05003f);
        phraseText = (TextView)findViewById(0x7f050040);
        pause_button = (ImageView)findViewById(0x7f050041);
        myPrefs = getSharedPreferences("my_pref", 0);
        utils = new Utils();
        pause_button.setOnTouchListener(new android.view.View.OnTouchListener() {

            final PhraseActivity this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    countDownTimer = getCountDownTimer(timeLeft);
                    countDownTimer.start();
                    pause_button.setPressed(false);
                    return true;
                } else
                {
                    pause_button.setPressed(true);
                    countDownTimer.cancel();
                    return true;
                }
            }

            
            {
                this$0 = PhraseActivity.this;
                super();
            }
        });
    }

    protected void onPause()
    {
        myPrefs.edit().putBoolean("alreadyViewed", true).commit();
        super.onPause();
    }

    protected void onResume()
    {
        alreadyViewed = Boolean.valueOf(myPrefs.getBoolean("alreadyViewed", true));
        if (alreadyViewed.booleanValue())
        {
            startActivity(new Intent(getApplicationContext(), com/momintechnologies/phrases/MainActivity));
            Toast.makeText(getApplicationContext(), "Today's phrase already viewed", 0).show();
            finish();
        } else
        {
            setupPhrase();
        }
        super.onResume();
    }







}
