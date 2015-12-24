package com.cis.surfaceviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout ll;
    private DisplayMetrics metrics;
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = (LinearLayout) findViewById(R.id.ll);
        MyViewTest myView = new MyViewTest (MainActivity.this);
        WindowManager wm = getWindowManager();
        Display defaultDisplay = wm.getDefaultDisplay();
        defaultDisplay.getMetrics(metrics =new DisplayMetrics());

        // myView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        ViewGroup.LayoutParams params = ll.getLayoutParams();
        params.width=metrics.widthPixels;
        params.height=metrics.heightPixels;
        ll.addView(myView,params);

        bt = (Button) findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MySurfaceViewActivity.class);
                startActivity(intent);
            }
        });
    }
}
