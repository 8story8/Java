package com.example.kosta_inst.step14_intenttest2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by kosta-inst on 2015-12-28.
 */
public class SecondActivity extends Activity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        Button exitBtn=(Button)findViewById(R.id.exit);
        tv=(TextView)findViewById(R.id.angel);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MainActivity에 정보를 전달
                Intent intent=new Intent();
                intent.putExtra("mess",tv.getText());
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
















