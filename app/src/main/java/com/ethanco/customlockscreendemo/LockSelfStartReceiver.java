package com.ethanco.customlockscreendemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.ethanco.customlockscreen.LockScreenHelper;

/**
 * @Description 自启
 * Created by EthanCo on 2016/10/13.
 */

public class LockSelfStartReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {     // boot
            LockScreenHelper.getInstance().startLockScreenService(context);
            LockScreenHelper.getInstance().setCurrLockScreenActivityClass(MyLockScreenPreActivity.class);
        }
    }
}
