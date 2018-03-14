package com.example.kosta_inst.step4_edittextevent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*
        EditText에 입력한 정보를 입력버튼을 누르면
        토스트로 출력하고
        리셋버튼을 누르면 EditText의 정보를 삭제한다
        api) EditText의 getText() , setText(text)

        inner class 명 : ButtonHandler

        step1 : 입력버튼 누르면 토스트로 입력정보 출력
        이벤트 소스(버튼)을 구분해서 이벤트 적용
        hint)
        오버라이딩 메서드의 매개변수 View 의 getId() 와 R.id.resetBtn 이 ==
        step2 : 리셋버튼 누르면 EditText의 정보 삭제
 */
public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.editText);
        Button inputBtn=(Button)findViewById(R.id.button);
        inputBtn.setOnClickListener(new ButtonHandler());
        Button resetBtn=(Button)findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(new ButtonHandler());
    }
    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.button)
            Toast.makeText(MainActivity.this, editText.getText().toString(),
                    Toast.LENGTH_SHORT).show();
            else if(v.getId()==R.id.resetBtn)
                editText.setText("");
        }
    }
}









