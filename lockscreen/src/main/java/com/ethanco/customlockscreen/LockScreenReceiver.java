package com.ethanco.customlockscreen;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @Description 锁屏广播
 * Created by YOLANDA on 2016-02-15.
 */
public class LockScreenReceiver extends BroadcastReceiver {

    public static final String TAG = "Z-LockScreenReceiver";
    private LockScreenHelper record = LockScreenHelper.getInstance();

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Log.i(TAG, "onReceive-action:" + action);

        if (action.equals(Intent.ACTION_SCREEN_OFF)) {
            Log.i(TAG, "onReceive isShown: " + BaseLockScreenActivity.isShown);
            Intent lockIntent = new Intent(context, record.getCurrLockScreenActivityClass());
            lockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            if (!BaseLockScreenActivity.isShown) {
                if (Utils.isScreenOn(context)) return;
                BaseLockScreenActivity.isShown = true;
                context.startActivity(lockIntent);
                Log.i(TAG, "onReceive startActivity...");
            }
        } else if (action.equals(Intent.ACTION_SCREEN_ON)) {

        }
    }
}
