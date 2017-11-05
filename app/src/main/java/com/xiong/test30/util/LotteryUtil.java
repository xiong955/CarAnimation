package com.xiong.test30.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * @author: xiong
 * @time: 2017/11/05
 * @说明:
 */

public class LotteryUtil {

    public static void setAnimation(View view){
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(view, "scaleX",
                0.5f, 1f);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(view, "scaleY",
                0.5f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(anim1).with(anim2);
        animSet.setDuration(2500);
        animSet.start();
    }
}
