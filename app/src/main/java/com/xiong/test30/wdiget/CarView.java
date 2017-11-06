package com.xiong.test30.wdiget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
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


    private ValueAnimator valueAnimator1;
    private ValueAnimator valueAnimator2;

    private AnimatorSet animSet;
    private AnimatorSet animSet1;

    private boolean isStop;
    private boolean isFire;
    private int stopTime;

    private float startPoint;

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
        fire.setVisibility(View.INVISIBLE);
        fire.setImageResource(R.drawable.fire);
        final AnimationDrawable animationDrawable = (AnimationDrawable) fire.getDrawable();

        // 开始
        startPoint = wh - fire.getX();
        final ValueAnimator valueAnimator = ValueAnimator.ofFloat(fire.getX(), -(wh / 6 * 2));
        valueAnimator.setDuration(new Random().nextInt(10000) + 3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                cv.setTranslationX((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @SuppressLint("NewApi")
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                if (valueAnimator.getTotalDuration() < 6500) {
                    fire.setVisibility(View.VISIBLE);
                    animationDrawable.start();
                }
            }
        });
        valueAnimator.setTarget(cv);

        // 前进
        valueAnimator1 = ValueAnimator.ofFloat(0, -(wh / 6 * 2));
        valueAnimator1.setDuration(new Random().nextInt(10000) + 4000);
        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                cv.setTranslationX((Float) animation.getAnimatedValue());
            }
        });
        valueAnimator1.addListener(new AnimatorListenerAdapter() {
            @SuppressLint("NewApi")
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                Log.e("xiong",valueAnimator1.getTotalDuration()+"");
                if (valueAnimator1.getTotalDuration() < 7000) {
                    Log.e("xiong","喷火");
                    fire.setVisibility(View.VISIBLE);
                    animationDrawable.start();
                }
            }
        });
        valueAnimator1.setTarget(cv);

        // 后退
        valueAnimator2 = ValueAnimator.ofFloat(-(wh / 6 * 2), 0);
        valueAnimator2.setDuration(new Random().nextInt(10000) + 5000);
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
                if (animationDrawable.isRunning()) {
                    fire.setVisibility(View.INVISIBLE);
                    animationDrawable.stop();
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (!isStop) {
                    valueAnimator1.setDuration(new Random().nextInt(10000) + 3000);
                    valueAnimator2.setDuration(new Random().nextInt(10000) + 5000);
                    animSet1.start();
                } else {
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
                if (animationDrawable.isRunning()) {
                    fire.setVisibility(View.INVISIBLE);
                    animationDrawable.stop();
                }
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
                if (animationDrawable.isRunning()) {
                    fire.setVisibility(View.INVISIBLE);
                    animationDrawable.stop();
                }
                if (isStop) {
                    initStopAnimator(wh, cv, fire, animationDrawable);
                }
            }
        });
    }

    /**
     * 冲线动画
     *
     * @param wh                屏幕宽度
     * @param cv                cv
     * @param fire              image
     * @param animationDrawable 喷火动画
     */
    private void initStopAnimator(int wh, final CarView cv, final ImageView fire, final AnimationDrawable animationDrawable) {
        float a = (wh - cv.getX() - cv.getMeasuredWidth());
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(-a, -(wh + cv.getX()));
        valueAnimator.setDuration(stopTime);
        valueAnimator.setTarget(cv);
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
                if (isFire) {
                    fire.setVisibility(View.VISIBLE);
                    animationDrawable.start();
                }
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                if (isFire) {
                    fire.setVisibility(View.INVISIBLE);
                    animationDrawable.stop();
                }
            }
        });
        valueAnimator.start();
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
     * @param width 屏幕宽度
     * @param cv    cv
     * @param fire  image
     */
    public void start(int width, final CarView cv, ImageView fire) {
        isStop = false;
        if (animSet == null && animSet1 == null ||
                !animSet.isRunning() && !animSet1.isRunning()) {
            initAnimation(width, cv, fire);
            animSet.start();
        }
    }

    /**
     * 设置冲线结束时间
     *
     * @param stopTime 结束时间
     */
    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }

    /**
     * 冲线是否喷火
     *
     * @param isfire 前三
     */
    public void IsFire(boolean isfire) {
        this.isFire = isfire;
    }

    /**
     * 重置布局
     */
    public void reset() {
        this.setX(startPoint);
    }
}
