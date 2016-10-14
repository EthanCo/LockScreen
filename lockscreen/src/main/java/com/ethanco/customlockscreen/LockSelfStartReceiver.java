package com.ethanco.customlockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @Description 自启
 * Created by EthanCo on 2016/10/13.
 */

public class LockSelfStartReceiver extends BroadcastReceiver {

    public static final String TAG = "Z-LockSelfStartReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {//开机自启
            Intent lockIntent = new Intent(context, PreLockActivity.class);
            lockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(lockIntent);
            //abortBroadcast();
            Log.i(TAG, "onReceive BOOT_COMPLETED-disableKeyguard");
        }
    }
}
