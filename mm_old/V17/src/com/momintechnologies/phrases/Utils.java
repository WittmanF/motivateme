// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Referenced classes of package com.momintechnologies.phrases:
//            CSVReader, Phrase

public class Utils
{

    private String TAG;

    public Utils()
    {
        TAG = getClass().getSimpleName();
    }

    public final List initializeDatabase(Context context)
    {
        ArrayList arraylist;
        int i;
        arraylist = new ArrayList();
        context = context.getAssets();
        i = 0;
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
            phrase = new Phrase(i, as[0], as[1], as[2]);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
            return arraylist;
        }
        i++;
        arraylist.add(phrase);
          goto _L1
    }

    public int randInt(int i, int j)
    {
        return (new Random()).nextInt((j - i) + 1) + i;
    }
}
