// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.app.DialogFragment;
import android.view.View;

// Referenced classes of package com.momintechnologies.phrases:
//            MainActivity, TimePickerFragment

class this._cls0
    implements android.view.tener
{

    final MainActivity this$0;

    public void onClick(View view)
    {
        (new TimePickerFragment()).show(getFragmentManager(), "timePicker");
    }

    ent()
    {
        this$0 = MainActivity.this;
        super();
    }
}
