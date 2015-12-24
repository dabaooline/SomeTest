package com.cis.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv=(TextView) findViewById(R.id.tv);
        String html = "<font color='red'>你好啊!</font><br><br><br>";
        html += "<font color='#0000ff'>拜拜,再见!<big><i></i></big></font><p>";
        html += "<big><a href='http://www.baidu.com'>百度</a></big><br>";
        CharSequence charSequence = Html.fromHtml(html);
        tv.setText(charSequence);

    }

}
