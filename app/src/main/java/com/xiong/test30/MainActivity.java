package com.xiong.test30;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiong.test30.util.LotteryUtil;
import com.xiong.test30.wdiget.CarView;
import com.xiong.test30.wdiget.CartView;

import java.util.Random;

/**
 * @author: xiong
 * @time: 2017/10/30
 * @说明:
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // 跑动部分
    private LinearLayout che;
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
    private Button reset;

    private int mWidth;

    //开奖部分
    private LinearLayout mLottery;
    private LinearLayout mLineNO_1;
    private LinearLayout mLineNO_2;
    private LinearLayout mLineNO_3;
    private TextView mTvNO_1;
    private TextView mTvNO_2;
    private TextView mTvNO_3;
    private ImageView mIvNO_1;
    private ImageView mIvNO_2;
    private ImageView mIvNO_3;


    //
    private int[] lotteryCar = {R.drawable.ic_c1, R.drawable.ic_c2, R.drawable.ic_c3,
            R.drawable.ic_c4, R.drawable.ic_c5, R.drawable.ic_c6, R.drawable.ic_c7,
            R.drawable.ic_c8, R.drawable.ic_c9, R.drawable.ic_c10};
    private Handler handler = new Handler();

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);

        initView();
        initLottery();
    }

    private void initView() {
        che = findViewById(R.id.ll);
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
        reset= findViewById(R.id.reset);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
        cancel.setOnClickListener(this);
        random.setOnClickListener(this);
        reset.setOnClickListener(this);
    }

    private void initLottery() {
        mLottery = findViewById(R.id.lottery);
        mLineNO_1 = findViewById(R.id.lottery_ll_no1);
        mLineNO_2 = findViewById(R.id.lottery_ll_no2);
        mLineNO_3 = findViewById(R.id.lottery_ll_no3);
        mTvNO_1 = findViewById(R.id.lottery_tv_no1);
        mTvNO_2 = findViewById(R.id.lottery_tv_no2);
        mTvNO_3 = findViewById(R.id.lottery_tv_no3);
        mIvNO_1 = findViewById(R.id.lottery_iv_no1);
        mIvNO_2 = findViewById(R.id.lottery_iv_no2);
        mIvNO_3 = findViewById(R.id.lottery_iv_no3);
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

            case R.id.reset:
                reset();
                break;

            default:
                break;
        }
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            che.setVisibility(View.GONE);
            bg.setVisibility(View.GONE);
            mLottery.setVisibility(View.VISIBLE);
            LotteryUtil.setAnimation(mLineNO_1);
            LotteryUtil.setAnimation(mLineNO_2);
            LotteryUtil.setAnimation(mLineNO_3);
        }
    };

    /**
     * 开始
     */
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

        carNO(et1.getText().toString(),et2.getText().toString(),et3.getText().toString());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    handler.post(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    /**
     * 结束
     */
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

    /**
     * 清空
     */
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

    /**
     * 随机
     */
    private void random() {
        int[] list = new int[10];
        for (int i = 1; i < 11; i++) {
            list[i - 1] = i;
        }
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int p = random.nextInt(10);
            int tmp = list[i];
            list[i] = list[p];
            list[p] = tmp;
        }
        et1.setText(list[0] + "");
        et2.setText(list[1] + "");
        et3.setText(list[2] + "");
        et4.setText(list[3] + "");
        et5.setText(list[4] + "");
        et6.setText(list[5] + "");
        et7.setText(list[6] + "");
        et8.setText(list[7] + "");
        et9.setText(list[8] + "");
        et10.setText(list[9] + "");
    }

    /**
     * 开奖界面
     */
    private void carNO(String no1,String no2,String no3) {
        mTvNO_1.setText(no1);
        mIvNO_1.setBackgroundResource(lotteryCar[Integer.valueOf(no1)-1]);
        mTvNO_2.setText(no2);
        mIvNO_2.setBackgroundResource(lotteryCar[Integer.valueOf(no2)-1]);
        mTvNO_3.setText(no3);
        mIvNO_3.setBackgroundResource(lotteryCar[Integer.valueOf(no3)-1]);
    }

    /**
     * 重置动画布局
     */
    private void reset() {
        rl.reset();
        rl2.reset();
        rl3.reset();
        rl4.reset();
        rl5.reset();
        rl6.reset();
        rl7.reset();
        rl8.reset();
        rl9.reset();
        rl10.reset();
        cancel();
        mLottery.setVisibility(View.GONE);
        che.setVisibility(View.VISIBLE);
        bg.setVisibility(View.VISIBLE);
    }
}
