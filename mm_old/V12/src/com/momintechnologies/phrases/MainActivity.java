// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.momintechnologies.phrases:
//            DatabaseHelper, Phrase, TimePickerFragment

public class MainActivity extends Activity
{

    private DatabaseHelper db;
    private int i;
    private Button notifyButton;
    private List phraseList;

    public MainActivity()
    {
        phraseList = new ArrayList();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(0x7f030018);
        db = new DatabaseHelper(getApplicationContext());
        bundle = getResources().getStringArray(0x7f0c0000);
        phraseList = db.getAllPhrases();
        if (phraseList.size() != 0) goto _L2; else goto _L1
_L1:
        i = 0;
_L5:
        if (i < bundle.length) goto _L3; else goto _L2
_L2:
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
        return;
_L3:
        Phrase phrase = new Phrase(i, bundle[i]);
        db.addPhrase(phrase);
        i = i + 1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onResume()
    {
        super.onResume();
    }
}
