package com.cis.surfaceviewtest;

/**
 * Created by admin on 2015/12/14.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.Timer;
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private Timer timer = null;
    private TestTask task = null;
    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub

    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        timer = new Timer();

        task = new TestTask(holder);
        timer.schedule(task, 500, 1000);

    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        if(timer != null) {
            timer.cancel();
            timer = null;
        }
        task = null;
    }

}
