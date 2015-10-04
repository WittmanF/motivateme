// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.os.CountDownTimer;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

// Referenced classes of package com.momintechnologies.phrases:
//            PhraseActivity

class this._cls0
    implements android.view.ner
{

    final PhraseActivity this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 1)
        {
            PhraseActivity.access$2(PhraseActivity.this, PhraseActivity.access$1(PhraseActivity.this, PhraseActivity.access$0(PhraseActivity.this)));
            PhraseActivity.access$3(PhraseActivity.this).start();
            PhraseActivity.access$4(PhraseActivity.this).setPressed(false);
            return true;
        } else
        {
            PhraseActivity.access$4(PhraseActivity.this).setPressed(true);
            PhraseActivity.access$3(PhraseActivity.this).cancel();
            return true;
        }
    }

    ()
    {
        this$0 = PhraseActivity.this;
        super();
    }
}
