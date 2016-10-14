package com.ethanco.customlockscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * @Description 预锁屏界面
 * Created by YOLANDA on 2016-02-15.
 */
public class PreLockActivity extends BaseLockScreenActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, LockScreenHelper.getInstance().getCurrLockScreenActivityClass());
        if (!Utils.isScreenOn(this)) {
            startActivity(intent);
        }

        finish();
    }
}
