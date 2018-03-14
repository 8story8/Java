package com.example.kosta_inst.step12_userdefineadapter2;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    private ArrayList<FoodVO> list;
    public MainActivity(){
        list=new DataSource().getList();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.listView);
        FoodAdapter adapter=new FoodAdapter(this);
        listView.setAdapter(adapter);
        //개별 아이템을 클릭하면 상품 상세 정보를 Toast로 출력하도록
        //익명 클래스 방식으로 이벤트 처리한다.
        // listView setOnItemClickListener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                                    long arg3) {
                String info = list.get(position).getInfo();
                Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();
            }
        });
    }

    class FoodAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        public FoodAdapter(Context context) {
            this.inflater
                    =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return list.size();
        }
        @Override
        public Object getItem(int position) {
            return list.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View view, ViewGroup arg2) {
            if(view==null){
                view=inflater.inflate(R.layout.item_layout, null);
            }
            // 개별 항목을 보여주기 위한 레이아웃의 왼쪽에 이미지 , 오른쪽에 상품명 배치
            ImageView iv=(ImageView) view.findViewById(R.id.img);
            iv.setImageResource(list.get(position).getImgId());
            TextView tv=(TextView)view.findViewById(R.id.txt);
            tv.setText(list.get(position).getName());
            return view;
        }
    }
}

