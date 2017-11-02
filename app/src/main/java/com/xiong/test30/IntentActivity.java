package com.xiong.test30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * @author: xiong
 * @time: 2017/10/30
 * @说明:
 */
public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_intent);
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
