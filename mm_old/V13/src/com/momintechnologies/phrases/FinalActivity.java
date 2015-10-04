// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;

public class FinalActivity extends Activity
{

    private long timerDuration;

    public FinalActivity()
    {
        timerDuration = 3000L;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f030018);
        (new CountDownTimer(timerDuration, 1000L) {

            final FinalActivity this$0;

            public void onFinish()
            {
                finish();
            }

            public void onTick(long l)
            {
            }

            
            {
                this$0 = FinalActivity.this;
                super(l, l1);
            }
        }).start();
    }
}
