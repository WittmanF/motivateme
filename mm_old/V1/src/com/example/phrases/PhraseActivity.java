// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.phrases;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;
import java.util.Random;

public class PhraseActivity extends Activity
{

    private int index;
    private TextView phraseText;
    private TextView timerText;

    public PhraseActivity()
    {
    }

    public static int randInt(int i, int j)
    {
        return (new Random()).nextInt((j - i) + 1) + i;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f030019);
        bundle = getResources().getStringArray(0x7f0c0000);
        timerText = (TextView)findViewById(0x7f05003e);
        phraseText = (TextView)findViewById(0x7f05003d);
        index = randInt(0, 6);
        phraseText.setText(bundle[index]);
        Log.d("PhraseActivity", (new StringBuilder("Index:[")).append(index).append("] & Phrase :").append(bundle[index]).toString());
        (new CountDownTimer(10000L, 1000L) {

            final PhraseActivity this$0;

            public void onFinish()
            {
                timerText.setText("Done!");
                finish();
            }

            public void onTick(long l)
            {
                timerText.setText((new StringBuilder()).append(l / 1000L).toString());
            }

            
            {
                this$0 = PhraseActivity.this;
                super(l, l1);
            }
        }).start();
    }

}
