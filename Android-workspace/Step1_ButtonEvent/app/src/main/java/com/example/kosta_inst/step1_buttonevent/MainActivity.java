package com.example.kosta_inst.step1_buttonevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //버튼1 이벤트 처리
        //버튼1의 id를 이용해 버튼객체를 반환받는다
        Button btn1=(Button)findViewById(R.id.mybtn1);
        btn1.setOnClickListener(this);
        //버튼2 이벤트 처리
        Button btn2=(Button)findViewById(R.id.mybtn2);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,
                "버튼 눌렀구나",Toast.LENGTH_SHORT).show();
    }
}
