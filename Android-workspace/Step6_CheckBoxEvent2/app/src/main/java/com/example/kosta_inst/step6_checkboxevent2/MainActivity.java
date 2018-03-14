package com.example.kosta_inst.step6_checkboxevent2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox cb=(CheckBox)findViewById(R.id.checkBox);
        CheckBox cb2=(CheckBox)findViewById(R.id.checkBox2);
        CheckBox cb3=(CheckBox)findViewById(R.id.checkBox3);
        cb.setOnCheckedChangeListener(new CheckBoxHandler());
        cb2.setOnCheckedChangeListener(new CheckBoxHandler());
        cb3.setOnCheckedChangeListener(new CheckBoxHandler());
    }

    private class CheckBoxHandler implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            String order=buttonView.getText().toString();
            if(isChecked){
                order+=" 주문";
            }else{
                order+=" 주문 취소";
            }
            Toast.makeText(MainActivity.this,order,Toast.LENGTH_SHORT).show();
        }
    }
}























