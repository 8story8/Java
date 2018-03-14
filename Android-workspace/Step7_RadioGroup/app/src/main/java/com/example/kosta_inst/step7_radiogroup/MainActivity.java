package com.example.kosta_inst.step7_radiogroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RadioGroup group;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        group=(RadioGroup)findViewById(R.id.radioGroup);
        imageView=(ImageView)findViewById(R.id.imageView);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButton:
                        Toast.makeText(MainActivity.this,
                                "아이유",Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.iu);
                        break;
                    case R.id.radioButton2:
                        Toast.makeText(MainActivity.this,
                                "김연아",Toast.LENGTH_SHORT).show();
                        imageView.setImageResource(R.drawable.kim);
                        break;
                }
                // ImageView 의 setImageResource(img id)
            }
        });
    }
}











