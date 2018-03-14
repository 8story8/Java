package com.example.kosta_inst.step11_userdefineadapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 *  사용자 정의 어댑터를 구현하여 목록과 아이템(개별항목)을 표현하는 예제
 *
 *  전체 목록(리스트) 레이아웃 : activity_main.xml
 *  개별 아이템(항목) 레이아웃 : item_layout.xml
 *
 *  ex) 트위터와 같은 화면을 정의하기 위해서는 개별항목을 자신의 의도에 맞게
 *      화면 배치해야 하는 필요가 생긴다
 *      이를 위해 사용자 정의 어댑터를 구현해서 개별항목 레이아웃에
 *      적절한 데이터 배치를 통해서 트위터의 개별 항목과 같은 정보를
 *      표현한다.
 *
 *      AdapterView (마트 진열대) --- Adapter(도매상) --- DataSource(상품들)
 *
 *  개발단계
 *      1. 데이터소스( xml or file or db or network(json) )
 *      2. Adapter 구현
 *      3. AdapterView 에 Adapter를 setting
 *      4. Event Handling
 */
public class MainActivity extends AppCompatActivity {
    //리스트 항목으로 표현할 데이터
    private String menu[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu=this.getResources().getStringArray(R.array.menu);
        ListView listView=(ListView)findViewById(R.id.listView);
        listView.setAdapter(new MenuAdapter(this));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(MainActivity.this,
                        menu[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
    class MenuAdapter extends BaseAdapter{
        // LayoutInflater : item_layout.xml 을 로딩해서 객체로 저장
        private LayoutInflater inflater;
        MenuAdapter(Context context){
            inflater=(LayoutInflater)context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
        }
        @Override
        public int getCount() {
            return menu.length;
        }

        @Override
        public Object getItem(int position) {
            return menu[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        /**
         * 실제 목록 화면에서 개별 아이템 단위로 정보를 보여주기 위해
         * 호출되는 메서드
         * 1.position : view(아이템)의 position
         * 2.view : 해당 item의 view 객체 전달
         *          최초에는 null이 들어온다
         * 3.parent : return 되는 item의 AdapterView가 전달
         * @param position
         * @param convertView
         * @param parent
         * @return
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
               convertView=inflater.inflate(R.layout.item_layout,null);
            }
            TextView tv1=(TextView)convertView.findViewById(R.id.txt1);
            tv1.setText(position+"번 메뉴항목");
            TextView tv2=(TextView)convertView.findViewById(R.id.txt2);
            tv2.setText(menu[position]);
            return convertView;
        }
    }
}












