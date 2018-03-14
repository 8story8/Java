package com.example.kosta_inst.step13_intenttest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by kosta-inst on 2015-12-28.
 */
public class SecondActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Button exitBtn=(Button)findViewById(R.id.exit);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //현 액티비티가 종료
                finish();
            }
        });
    }
}






