package com.example.kosta_inst.step14_intenttest2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by kosta-inst on 2015-12-28.
 */
public class ThirdActivity extends Activity{
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_main);
        Button inputBtn=(Button)findViewById(R.id.inputok);
        editText=(EditText)findViewById(R.id.addrEt);
        inputBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address=editText.getText().toString();
                Intent intent=new Intent();
                intent.putExtra("address",address);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}








