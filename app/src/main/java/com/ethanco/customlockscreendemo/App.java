package com.ethanco.customlockscreendemo;

import android.app.Application;

import com.ethanco.customlockscreen.LockScreenHelper;
import com.ethanco.customlockscreen.Utils;

/**
 * @Description Created by EthanCo on 2016/10/14.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Utils.disableKeyguard(this);
        LockScreenHelper.getInstance().setCurrLockScreenActivityClass(MyLockScreenActivity.class);
        LockScreenHelper.getInstance().startLockScreenService(this);
    }
}
