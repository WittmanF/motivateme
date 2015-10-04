// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

// Referenced classes of package com.momintechnologies.phrases:
//            PhraseActivity

public class AlarmReceiver extends BroadcastReceiver
{

    private Boolean isFirstTime;
    private SharedPreferences myPrefs;

    public AlarmReceiver()
    {
        isFirstTime = Boolean.valueOf(true);
    }

    public void createNotification(Context context)
    {
        Object obj = "Good Morning.";
        if (isFirstTime.booleanValue())
        {
            obj = "Hello! Here is your first phrase.";
        }
        PendingIntent pendingintent = PendingIntent.getActivity(context, 0, new Intent(context, com/momintechnologies/phrases/PhraseActivity), 0);
        obj = (new android.app.Notification.Builder(context)).setContentTitle("Motivate Me!").setContentText(((CharSequence) (obj))).setSmallIcon(0x7f020058).setContentIntent(pendingintent).build();
        context = (NotificationManager)context.getSystemService("notification");
        obj.flags = ((Notification) (obj)).flags | 0x10;
        context.notify(0, ((Notification) (obj)));
    }

    public void onReceive(Context context, Intent intent)
    {
        myPrefs = context.getSharedPreferences("my_pref", 0);
        isFirstTime = Boolean.valueOf(myPrefs.getBoolean("isFirstTime", true));
        if (isFirstTime.booleanValue())
        {
            Toast.makeText(context, "Hello! Here is your first phrase", 0).show();
        } else
        {
            Toast.makeText(context, "Good Morning", 0).show();
        }
        Log.d("AlarmReceiver", (new StringBuilder("Alarm fired at: ")).append(System.currentTimeMillis()).toString());
        myPrefs.edit().putBoolean("alreadyViewed", false).commit();
        createNotification(context);
    }
}
