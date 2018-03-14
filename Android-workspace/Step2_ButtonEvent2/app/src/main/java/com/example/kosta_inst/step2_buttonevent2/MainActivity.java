package com.example.kosta_inst.step2_buttonevent2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mybtn=(Button)findViewById(R.id.mybtn);
        mybtn.setOnClickListener(new ButtonHandler());
        tv=(TextView)findViewById(R.id.mytv);
    }
    private int count;
    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            /*Toast.makeText(
                    MainActivity.this, "click", Toast.LENGTH_SHORT).show();
            //android log
            Log.d("test", "click");*/
            //TextView에 count를 증가시킨다.
            tv.setText(tv.getText()+" "+count++);
        }
    }
}












