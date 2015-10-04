// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.momintechnologies.phrases;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.TimePicker;
import java.util.Calendar;
import java.util.TimeZone;

// Referenced classes of package com.momintechnologies.phrases:
//            AlarmReceiver

public class TimePickerFragment extends DialogFragment
    implements android.app.TimePickerDialog.OnTimeSetListener
{

    public TimePickerFragment()
    {
    }

    private void setRecurringAlarm(Context context, Calendar calendar)
    {
        Object obj = new Intent(context, com/momintechnologies/phrases/AlarmReceiver);
        ((Intent) (obj)).addFlags(0x10000000);
        obj = PendingIntent.getBroadcast(context, 0, ((Intent) (obj)), 0x10000000);
        ((AlarmManager)context.getSystemService("alarm")).setRepeating(0, calendar.getTimeInMillis(), 0x5265c00L, ((PendingIntent) (obj)));
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = Calendar.getInstance();
        int i = bundle.get(11);
        int j = bundle.get(12);
        return new TimePickerDialog(getActivity(), this, i, j, DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker timepicker, int i, int j)
    {
        Log.d("Time selected", (new StringBuilder("[")).append(i).append("]:[").append(j).append("]").toString());
        timepicker = Calendar.getInstance();
        timepicker.setTimeZone(TimeZone.getDefault());
        timepicker.set(11, i);
        timepicker.set(12, j);
        setRecurringAlarm(getActivity(), timepicker);
        getActivity().finish();
    }
}
