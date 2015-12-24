package com.cis.surfaceviewtest;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;

import java.util.TimerTask;

/**
 * Created by admin on 2015/12/14.
 */
public class TestTask extends TimerTask {

    private final SurfaceHolder holder;
    private final Paint paint;

    public TestTask(SurfaceHolder _holder){

        holder = _holder;
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(50.0f);
        paint.setStrokeWidth(10.0f);
    }

    @Override
    public void run() {
        Canvas canvas=null;
        canvas= holder.lockCanvas(null);
        canvas.drawText("再见",0,2,100,100,paint);
        holder.unlockCanvasAndPost(canvas);
    }
}
