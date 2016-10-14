package com.ethanco.customlockscreendemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ethanco.customlockscreen.BaseLockScreenActivity;

/**
 * @Description 预锁屏界面
 * Created by YOLANDA on 2016-02-15.
 */
public class MyLockScreenPreActivity extends BaseLockScreenActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MyLockScreenActivity.class);
        startActivity(intent);
        finish();
    }
}
