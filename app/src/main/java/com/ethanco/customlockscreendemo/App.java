package com.ethanco.customlockscreendemo;

import android.app.Application;
import android.content.Intent;

import com.ethanco.customlockscreen.LockScreenHelper;
import com.ethanco.customlockscreen.PreLockActivity;
import com.ethanco.customlockscreen.Utils;

/**
 * @Description
 * Created by EthanCo on 2016/10/14.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        LockScreenHelper.getInstance().setCurrLockScreenActivityClass(MyLockScreenActivity.class);
        LockScreenHelper.getInstance().startLockScreenService(this);

        Utils.disableKeyguard(this);
        Intent lockIntent = new Intent(this, PreLockActivity.class);
        lockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(lockIntent);
    }
}
