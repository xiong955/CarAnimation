package com.xiong.test30;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.xiong.test30.wdiget.CarView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CarView rl;
    private CarView rl2;
    private CarView rl3;
    private CarView rl4;
    private CarView rl5;
    private CarView rl6;
    private CarView rl7;
    private CarView rl8;
    private CarView rl9;
    private CarView rl10;

    private ImageView fire;
    private ImageView fire2;
    private ImageView fire3;
    private ImageView fire4;
    private ImageView fire5;
    private ImageView fire6;
    private ImageView fire7;
    private ImageView fire8;
    private ImageView fire9;
    private ImageView fire10;

    private Button start;
    private Button stop;

    private int mWidth;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);

        initView();
    }

    private void initView() {
        rl = findViewById(R.id.rl);
        rl2 = findViewById(R.id.rl2);
        rl3 = findViewById(R.id.rl3);
        rl4 = findViewById(R.id.rl4);
        rl5 = findViewById(R.id.rl5);
        rl6 = findViewById(R.id.rl6);
        rl7 = findViewById(R.id.rl7);
        rl8 = findViewById(R.id.rl8);
        rl9 = findViewById(R.id.rl9);
        rl10 = findViewById(R.id.rl10);

        fire = findViewById(R.id.fire);
        fire2 = findViewById(R.id.fire2);
        fire3 = findViewById(R.id.fire3);
        fire4 = findViewById(R.id.fire4);
        fire5 = findViewById(R.id.fire5);
        fire6 = findViewById(R.id.fire6);
        fire7 = findViewById(R.id.fire7);
        fire8 = findViewById(R.id.fire8);
        fire9 = findViewById(R.id.fire9);
        fire10 = findViewById(R.id.fire10);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                start();
                break;

            case R.id.stop:
                stop();
                break;

            default:
                break;
        }
    }

    private void start() {
        WindowManager wm = this.getWindowManager();
        mWidth = wm.getDefaultDisplay().getWidth();

        rl.start(mWidth, rl, fire);
        rl2.start(mWidth, rl2, fire2);
        rl3.start(mWidth, rl3, fire3);
        rl4.start(mWidth, rl4, fire4);
        rl5.start(mWidth, rl5, fire5);
        rl6.start(mWidth, rl6, fire6);
        rl7.start(mWidth, rl7, fire7);
        rl8.start(mWidth, rl8, fire8);
        rl9.start(mWidth, rl9, fire9);
        rl10.start(mWidth, rl10, fire10);
    }

    private void stop() {
        rl.stop();
        rl2.stop();
        rl3.stop();
        rl4.stop();
        rl5.stop();
        rl6.stop();
        rl7.stop();
        rl8.stop();
        rl9.stop();
        rl10.stop();
    }
}
