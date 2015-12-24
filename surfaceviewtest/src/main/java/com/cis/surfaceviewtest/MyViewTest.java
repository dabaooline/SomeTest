package com.cis.surfaceviewtest;

/**
 * Created by admin on 2015/12/11.
 */
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyViewTest extends SurfaceView implements SurfaceHolder.Callback {
    MainActivity father;

    private static final int MAX_TOUCHPOINTS = 10;
    private static final String START_TEXT = "请随便触摸屏幕进行测试";
    private Paint touchPaint  = new Paint();
    private int width, height;

    // private float scale = 1.0f;

    public MyViewTest(MainActivity father) {
        super(father);
        // TODO Auto-generated constructor stub
        this.father = father;
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        setFocusable(true); // 确保我们的View能获得输入焦点
        setFocusableInTouchMode(true); // 确保能接收到触屏事件
        init();
    }

    private void init() {
        // 初始化10个不同颜色的画笔
            touchPaint.setColor(Color.RED);
    }

    /*
     * 处理触屏事件
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // 锁定Canvas,开始进行相应的界面处理
        Canvas c = getHolder().lockCanvas();
        if (c != null) {
            c.drawColor(Color.BLACK);
            if (event.getAction() == MotionEvent.ACTION_UP) {
                // 当手离开屏幕时，清屏
            } else {
                    // 获取一个触点的坐标，然后开始绘制
                    int x = (int) event.getX();
                    int y = (int) event.getY();
                    drawCrosshairsAndText(x, y, touchPaint, c);
                    drawCircle(x, y, touchPaint, c);

            }
            // 画完后，unlock
            getHolder().unlockCanvasAndPost(c);
        }
        return true;
    }

    /**
     * 画十字及坐标信息
     */
    private void drawCrosshairsAndText(int x, int y, Paint paint, Canvas c) {
        c.drawLine(0, y, width, y, paint);
        c.drawLine(x, 0, x, height, paint);
    }

    /**
     * 画圆
     */
    private void drawCircle(int x, int y, Paint paint, Canvas c) {
        c.drawCircle(x, y, 40, paint);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width,
                               int height) {
        // TODO Auto-generated method stub
        this.width = width;
        this.height = height;
        Canvas c = getHolder().lockCanvas();
        if (c != null) {
            // 背景黑色
            c.drawColor(Color.BLACK);
            getHolder().unlockCanvasAndPost(c);
        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        // TODO Auto-generated method stub

    }
}
