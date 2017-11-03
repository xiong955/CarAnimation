package com.xiong.test30;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.xiong.test30.wdiget.CarView;
import com.xiong.test30.wdiget.CartView;

import java.util.Random;

/**
 * @author: xiong
 * @time: 2017/10/30
 * @说明:
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CartView bg;

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

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private EditText et8;
    private EditText et9;
    private EditText et10;

    private Button start;
    private Button stop;
    private Button cancel;
    private Button random;

    private int mWidth;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);

        initView();
    }

    private void initView() {
        bg = findViewById(R.id.bg);

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

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        et7 = findViewById(R.id.et7);
        et8 = findViewById(R.id.et8);
        et9 = findViewById(R.id.et9);
        et10 = findViewById(R.id.et10);

        start = findViewById(R.id.start);
        stop = findViewById(R.id.stop);
        cancel = findViewById(R.id.cancel);
        random = findViewById(R.id.random);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        cancel.setOnClickListener(this);
        random.setOnClickListener(this);
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

            case R.id.cancel:
                cancel();
                break;

            case R.id.random:
                random();
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

        bg.start();
    }

    private void stop() {
        bg.stop();

        stop(et1.getText().toString(), 1000, true);
        stop(et2.getText().toString(), 1300, true);
        stop(et3.getText().toString(), 1600, true);
        stop(et4.getText().toString(), 1900, false);
        stop(et5.getText().toString(), 2100, false);
        stop(et6.getText().toString(), 2400, false);
        stop(et7.getText().toString(), 2700, false);
        stop(et8.getText().toString(), 3000, false);
        stop(et9.getText().toString(), 3300, false);
        stop(et10.getText().toString(), 3600, false);
    }

    private void stop(String index, int time, boolean IsFire) {
        switch (index) {
            case "1":
                rl.setStopTime(time);
                rl.IsFire(IsFire);
                rl.stop();
                break;

            case "2":
                rl2.setStopTime(time);
                rl2.IsFire(IsFire);
                rl2.stop();
                break;

            case "3":
                rl3.setStopTime(time);
                rl3.IsFire(IsFire);
                rl3.stop();
                break;

            case "4":
                rl4.setStopTime(time);
                rl4.IsFire(IsFire);
                rl4.stop();
                break;

            case "5":
                rl5.setStopTime(time);
                rl5.IsFire(IsFire);
                rl5.stop();
                break;

            case "6":
                rl6.setStopTime(time);
                rl6.IsFire(IsFire);
                rl6.stop();
                break;

            case "7":
                rl7.setStopTime(time);
                rl7.IsFire(IsFire);
                rl7.stop();
                break;

            case "8":
                rl8.setStopTime(time);
                rl8.IsFire(IsFire);
                rl8.stop();
                break;

            case "9":
                rl9.setStopTime(time);
                rl9.IsFire(IsFire);
                rl9.stop();
                break;

            case "10":
                rl10.setStopTime(time);
                rl10.IsFire(IsFire);
                rl10.stop();
                break;
        }
    }

    private void cancel() {
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
        et5.setText("");
        et6.setText("");
        et7.setText("");
        et8.setText("");
        et9.setText("");
        et10.setText("");
    }

    private void random() {
        int[] list = new int[10];
        for (int i = 1; i < 11; i++) {
            list[i-1] = i;
        }
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int p = random.nextInt(10);
            int tmp = list[i];
            list[i] = list[p];
            list[p] = tmp;
        }
        et1.setText(list[0]+"");
        et2.setText(list[1]+"");
        et3.setText(list[2]+"");
        et4.setText(list[3]+"");
        et5.setText(list[4]+"");
        et6.setText(list[5]+"");
        et7.setText(list[6]+"");
        et8.setText(list[7]+"");
        et9.setText(list[8]+"");
        et10.setText(list[9]+"");
    }
}
