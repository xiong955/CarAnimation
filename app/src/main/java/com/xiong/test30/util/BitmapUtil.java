package com.xiong.test30.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * 作者：小民
 * 功能：xxxx
 * 时间：2017/10/21
 */

public class BitmapUtil {
    /**
     * 根据给定的宽和高进行拉伸
     *
     * @param origin    原图
     * @param newWidth  新图的宽
     * @param newHeight 新图的高
     * @return new Bitmap
     */
    public static Bitmap scaleBitmap(Bitmap origin, int newWidth, int newHeight) {
        if (origin == null) {
            return null;
        }
        //原图的宽高
        int height = origin.getHeight();
        int width = origin.getWidth();
        //默认值,如果  新图 宽/高 == 0  就不拉升
        if (newHeight == 0) newHeight = height;
        if (newWidth == 0) newWidth = width;
        //通过矩阵拉升
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);// 使用后乘
        Bitmap newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (!origin.isRecycled() && origin!=newBM) {
            origin.recycle();
        }
        return newBM;
    }

}
