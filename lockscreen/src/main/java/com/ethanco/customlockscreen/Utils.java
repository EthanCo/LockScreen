package com.ethanco.customlockscreen;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;

/**
 * Created by Zhk on 2016/10/12.
 */
public class Utils {
    /**
     * 判断屏幕状态
     *
     * @param context
     * @return
     */
    public static boolean isScreenOn(Context context) {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
            return pm.isInteractive();
        } else {
            return pm.isScreenOn();
        }
    }

    static int i = 0;

    /**
     * 对系统的屏保进行屏蔽
     *
     * @param context
     */
    public static void disableKeyguard(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock keyguardLock = keyguardManager.newKeyguardLock("KeyguardLock");
        keyguardLock.disableKeyguard();
        Log.i("Z-", "disableKeyguard i: " + i++);
    }
}
