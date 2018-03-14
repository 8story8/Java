package com.example.kosta_inst.step5_checkboxevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn=(Button)findViewById(R.id.mybtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,"click",Toast.LENGTH_SHORT).show();
            }
        });
        CheckBox checkBox=(CheckBox)findViewById(R.id.myCheckBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Toast.makeText(
                            MainActivity.this,"체크했음",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(
                            MainActivity.this,"체크해제",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}















