package com.example.kosta_inst.step14_intenttest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button secondBtn=(Button)findViewById(R.id.callBtn1);
        secondBtn.setOnClickListener(new ButtonHandler());
        Button thirdBtn=(Button)findViewById(R.id.callBtn2);
        thirdBtn.setOnClickListener(new ButtonHandler());
    }
    class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.callBtn1) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //1 은 requestCode이고 어떤 액티비티를 실행했는 지 알기 위한 구분값
                startActivityForResult(intent, 1);
            }else if(v.getId()==R.id.callBtn2){
                Intent intent = new Intent(
                        MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent, 2);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
       if(requestCode==1&&resultCode==RESULT_OK){
           Toast.makeText(MainActivity.this,
                   data.getStringExtra("mess"),Toast.LENGTH_SHORT).show();
       }else if(requestCode==2&&resultCode==RESULT_OK){
           Toast.makeText(MainActivity.this,
                   data.getStringExtra("address"),Toast.LENGTH_SHORT).show();
       }
    }
}











