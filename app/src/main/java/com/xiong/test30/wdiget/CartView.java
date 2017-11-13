package com.xiong.test30.wdiget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.xiong.test30.R;
import com.xiong.test30.util.BitmapUtil;

/**
 * 作者：小民
 * 功能：xxxx
 * 时间：2017/10/26
 */

public class CartView extends View {
    //移动
    private int mOffsetX;
    //中路跑段
    private Bitmap mMiddleRunwayBitmap;
    // 跑道动画
    private ValueAnimator animator;

    public CartView(Context context) {
        this(context,null);
    }

    public CartView(Context context, @Nullable AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mMiddleRunwayBitmap != null){
            canvas.translate(mOffsetX,0);
            //跑道
            canvas.drawBitmap(mMiddleRunwayBitmap,0,0,null);
            //屏幕外的一段
            int width = mMiddleRunwayBitmap.getWidth();
            canvas.drawBitmap(mMiddleRunwayBitmap,-width,0,null);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int defaultWidth = MeasureSpec.getSize(widthMeasureSpec);
        Log.e("tag_width",defaultWidth + "");
        //初始化bitmap对象
        if (mMiddleRunwayBitmap == null){
            //初始化中间跑道
            initMiddleRunwayBitmap(defaultWidth);
            //初始化赛车
//            initCartBitmaps();
        }
        //大小设置
        int defaultHeight = mMiddleRunwayBitmap.getHeight();
        int width = measureDimension(defaultWidth, widthMeasureSpec);
        int height = measureDimension(defaultHeight, heightMeasureSpec);
        setMeasuredDimension(width, height);
        //动画 动起来
        animator = ValueAnimator.ofInt(0, width);
        animator.setDuration(750);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mOffsetX = +(int) animation.getAnimatedValue();
                invalidate();
            }
        });
    }
    /** 控件大小 */
    protected int measureDimension(int defaultSize, int measureSpec) {
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == MeasureSpec.AT_MOST) {
            result = Math.min(defaultSize, specSize);
        } else {
            result = defaultSize;
        }
        return result;
    }
    /** 创建中间跑到 */
    private void initMiddleRunwayBitmap(int defaultWidth){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.middle_runway);
        mMiddleRunwayBitmap = BitmapUtil.scaleBitmap(bitmap, defaultWidth, 0);
    }

    public void start() {
        if(!animator.isRunning()){
            animator.start();
        }
    }

    public void stop(){
        if(animator.isRunning()){
            animator.cancel();
        }
    }
}
