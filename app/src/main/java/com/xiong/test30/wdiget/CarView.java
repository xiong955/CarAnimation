package com.xiong.test30.wdiget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.xiong.test30.R;

import java.util.Random;

/**
 * @author: xiong
 * @time: 2017/11/02
 * @说明:
 */

public class CarView extends RelativeLayout {


    private ValueAnimator valueAnimator;
    private ValueAnimator valueAnimator1;
    private ValueAnimator valueAnimator2;
    private ValueAnimator valueAnimator3;

    private AnimatorSet animSet;
    private AnimatorSet animSet1;

    private boolean isStop;
    private int stopTime;

    public CarView(Context context) {
        super(context);
    }

    public CarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public CarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void initAnimation(final int wh, final CarView cv, final ImageView fire) {
        fire.setImageResource(R.drawable.fire);
        final AnimationDrawable animationDrawable = (AnimationDrawable) fire.getDrawable();

        // 开始
        valueAnimator = ValueAnimator.ofFloat(fire.getX(), -(wh/5*3));
        valueAnimator.setDuration(new Random().nextInt(4000) + 2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                cv.setTranslationX((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                fire.setVisibility(View.VISIBLE);
                animationDrawable.start();
            }
        });
        valueAnimator.setTarget(cv);

        // 前进
        valueAnimator1 = ValueAnimator.ofFloat(0, -(wh/5*3));
        valueAnimator1.setDuration(new Random().nextInt(3000) + 1000);
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                cv.setTranslationX((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                fire.setVisibility(View.VISIBLE);
                animationDrawable.start();
            }
        });
        valueAnimator1.setTarget(cv);

        // 后退
        valueAnimator2 = ValueAnimator.ofFloat(-(wh/5*3), 0);
        valueAnimator2.setDuration(new Random().nextInt(5000) + 4000);
        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                cv.setTranslationX((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator2.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                fire.setVisibility(View.INVISIBLE);
                animationDrawable.stop();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (!isStop) {
                    valueAnimator1.setDuration(new Random().nextInt(3000) + 1000);
                    valueAnimator2.setDuration(new Random().nextInt(5000) + 4000);
                    animSet1.start();
                } else {
                    fire.setVisibility(View.INVISIBLE);
                    animationDrawable.stop();
                    if (isStop) {
                        initStopAnimator(wh, cv, fire, animationDrawable);
                    }
                }
            }
        });
        valueAnimator2.setTarget(cv);

        // 最开始的循环(从起点开始)
        animSet = new AnimatorSet();
        animSet.play(valueAnimator2).after(valueAnimator);
        animSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                fire.setVisibility(View.INVISIBLE);
                animationDrawable.stop();
                if (isStop) {
                    initStopAnimator(wh, cv, fire, animationDrawable);
                }
            }
        });

        // 第二次之后的循环(从第一次结束的地方开始)
        animSet1 = new AnimatorSet();
        animSet1.play(valueAnimator2).after(valueAnimator1);
        animSet1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                fire.setVisibility(View.INVISIBLE);
                animationDrawable.stop();
                if (isStop) {
                    initStopAnimator(wh, cv, fire, animationDrawable);
                }
            }
        });
    }

    /**
     * 冲线动画
     *
     * @param wh
     * @param cv
     * @param fire
     * @param animationDrawable
     */
    private void initStopAnimator(int wh, final CarView cv, final ImageView fire, final AnimationDrawable animationDrawable) {
        float a = (wh - cv.getX() - cv.getMeasuredWidth());
        valueAnimator3 = ValueAnimator.ofFloat(-a, -(wh + cv.getX()));
        valueAnimator3.setDuration(stopTime);
        valueAnimator3.setTarget(cv);
        // 冲线
        valueAnimator3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                cv.setTranslationX((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                fire.setVisibility(View.VISIBLE);
                animationDrawable.start();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                fire.setVisibility(View.INVISIBLE);
                animationDrawable.stop();
            }
        });
        valueAnimator3.start();
    }

    /**
     * 结束动画
     */
    public void stop() {
        isStop = true;
        if (animSet.isRunning()) {
            animSet.cancel();
        }
        if (animSet1.isRunning()) {
            animSet1.cancel();
        }
        if (valueAnimator2.isRunning()) {
            valueAnimator2.cancel();
        }
    }

    /**
     * 开始动画
     *
     * @param width
     * @param cv
     * @param fire
     */
    public void start(int width, final CarView cv, ImageView fire) {
        isStop = false;
        if (animSet == null && animSet1 == null ||
                !animSet.isRunning() && !animSet1.isRunning()) {
            initAnimation(width, cv, fire);
            animSet.start();
        }
    }

    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }
}
