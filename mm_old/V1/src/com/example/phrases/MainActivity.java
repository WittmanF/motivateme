// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.phrases;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

// Referenced classes of package com.example.phrases:
//            TimePickerFragment

public class MainActivity extends Activity
{

    private Button notifyButton;

    public MainActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f030018);
        notifyButton = (Button)findViewById(0x7f05003c);
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
    }

    protected void onResume()
    {
        super.onResume();
    }
}
