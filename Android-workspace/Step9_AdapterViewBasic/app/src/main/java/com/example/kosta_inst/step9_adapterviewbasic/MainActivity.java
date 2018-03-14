package com.example.kosta_inst.step9_adapterviewbasic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> list=new ArrayList<String>();
    public void createData(){
        for(int i=0;i<30;i++){
            list.add("리스트 아이템:"+i);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_main);
        createData();//data : memory , db ,file , network ..
        //1.context 2.개별항목 layout 3. 데이터
        ArrayAdapter<String> adapter
                =new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,list);
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tv=(TextView)view;
                Toast.makeText(MainActivity.this,
                        tv.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}












