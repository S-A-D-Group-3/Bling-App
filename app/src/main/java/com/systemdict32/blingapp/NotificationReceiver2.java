package com.systemdict32.blingapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class NotificationReceiver2 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String lgu_hotline_num = intent.getStringExtra("lgu_hotline_num");
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + lgu_hotline_num.trim()));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(callIntent);
    }
}
