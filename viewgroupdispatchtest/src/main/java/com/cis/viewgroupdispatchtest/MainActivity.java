package com.cis.viewgroupdispatchtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.cis.viewgroupdispatchtest.widget.TestButton;
import com.cis.viewgroupdispatchtest.widget.TestLinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {

    private TestLinearLayout tll;
    private TestButton tbt;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tll = ((TestLinearLayout) findViewById(R.id.tl));
        tbt = ((TestButton) findViewById(R.id.tbt));

        //注册监听事件
        tll.setOnTouchListener(this);
        tbt.setOnTouchListener(this);

        tll.setOnClickListener(this);
        tbt.setOnClickListener(this);

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.i(MainActivity.class.getSimpleName(),"onTouch:"+ v + "===" + event.getAction());
        return false;
    }

    @Override
    public void onClick(View v) {
        Log.i(MainActivity.class.getSimpleName(), "onClick:"+v + "===");
    }
}
