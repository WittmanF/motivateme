// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.os.CountDownTimer;
import android.widget.TextView;

// Referenced classes of package com.momintechnologies.phrases:
//            PhraseActivity

class this._cls0 extends CountDownTimer
{

    final PhraseActivity this$0;

    public void onFinish()
    {
        PhraseActivity.access$5(PhraseActivity.this).setText("See you Tomorrow!");
        finish();
    }

    public void onTick(long l)
    {
        PhraseActivity.access$5(PhraseActivity.this).setText((new StringBuilder()).append(l / 1000L).toString());
        PhraseActivity.access$6(PhraseActivity.this, l);
    }

    (long l, long l1)
    {
        this$0 = PhraseActivity.this;
        super(l, l1);
    }
}
