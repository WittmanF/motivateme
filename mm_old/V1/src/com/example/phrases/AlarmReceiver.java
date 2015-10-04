// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.example.phrases;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

// Referenced classes of package com.example.phrases:
//            PhraseActivity

public class AlarmReceiver extends BroadcastReceiver
{

    public AlarmReceiver()
    {
    }

    public void createNotification(Context context)
    {
        Object obj = PendingIntent.getActivity(context, 0, new Intent(context, com/example/phrases/PhraseActivity), 0);
        obj = (new android.app.Notification.Builder(context)).setContentTitle("Phrases").setContentText("Your daily phrase is here!").setSmallIcon(0x7f020026).setContentIntent(((PendingIntent) (obj))).build();
        context = (NotificationManager)context.getSystemService("notification");
        obj.flags = ((Notification) (obj)).flags | 0x10;
        context.notify(0, ((Notification) (obj)));
    }

    public void onReceive(Context context, Intent intent)
    {
        Toast.makeText(context, "Daily Phrase", 0).show();
        Log.d("AlarmReceiver", (new StringBuilder("Alarm fired at: ")).append(System.currentTimeMillis()).toString());
        createNotification(context);
    }
}
