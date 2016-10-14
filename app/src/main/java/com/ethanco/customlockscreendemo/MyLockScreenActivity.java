package com.ethanco.customlockscreendemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.ethanco.customlockscreen.BaseLockScreenActivity;

/**
 * @Description 锁屏界面
 * Created by YOLANDA on 2016-02-15.
 */
public class MyLockScreenActivity extends BaseLockScreenActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockscreen);

        findViewById(R.id.btn_unlock).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
