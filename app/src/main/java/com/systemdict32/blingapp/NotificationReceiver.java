package com.systemdict32.blingapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        String cell_num = intent.getStringExtra("ice_cell_num");
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: " + cell_num.trim()));
        callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(callIntent);
    }
}
