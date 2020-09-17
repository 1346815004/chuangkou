package com.example.chuangkou;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    private static final String ACTION1 = "zuckerberg";
    private static final String ACTION2 = "mayun";

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equals(ACTION1)){
            Toast.makeText(context, "收到zuckerberg", Toast.LENGTH_SHORT).show();
        }else if(intent.getAction().equals(ACTION2)){
            Toast.makeText(context, "收到mayun", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "没收到", Toast.LENGTH_SHORT).show();
        }
    }
}
