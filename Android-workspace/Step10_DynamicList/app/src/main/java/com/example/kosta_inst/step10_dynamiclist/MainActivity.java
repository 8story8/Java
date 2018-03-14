package com.example.kosta_inst.step10_dynamiclist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 *
 * step1. 자신의 클래스에서 해당 인터페이스를 implements 하는 방식으로 이벤트 처리
 *         각 버튼이 클릭될 때 Toast로 어떤 버튼인지를 구별해 메세지를 띄운다
 * step2. EditText에 여행지를 입력하고 추가 버튼을 누르면 ListView에 항목이 추가되도록
 *           처리한다.
 *       DataSource -> Adapter -> AdapterView
 *       ArrayList      ArrayAdapter    ListView
 *       1) 멤버변수로 ArrayList (DataSource) 를 추가
 *        2) ArrayAdapter 생성 (개별항목 레이아웃과 데이터 자원을 setting)
 *          3) ListView 를 반환받아 Adapter를 setting
 *          4) EditText에 입력된 여행지를 addBtn click 시 ListView 에 항목으로 추가
 *             여행지를 ArrayList에 추가하고
 *             버튼 이벤트 발생시에 adpater.notifyDataSetChanged()를 호출하면 리스트 갱신
 *  step3. ListView 개별항목을 클릭하면
 *        EditText로 항목의 정보가 setting 되고
 *          이를 이용해 delBtn 버튼 클릭하면
 *          여행지가 ListView에서 삭제되도록 처리한다.
 *          조건) 여행지를 입력하세요! , 여행지가 존재하지 않습니다!
 *          listView의 setOnItemClickListener(익명클래스) 이벤트 처리
 *
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editText;
    private ArrayList<String> items=new ArrayList<String>();
    private ArrayAdapter adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button addBtn=(Button)findViewById(R.id.addBtn);
        addBtn.setOnClickListener(this);
        Button deleteBtn=(Button)findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(this);
        Button allBtn=(Button)findViewById(R.id.allBtn);
        allBtn.setOnClickListener(this);
        Button allDelBtn=(Button)findViewById(R.id.allDelBtn);
        allDelBtn.setOnClickListener(this);
        editText=(EditText)findViewById(R.id.item);
        listView=(ListView)findViewById(R.id.listView);
        adapter=new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,items);
        listView.setAdapter(adapter);
        // listView를 익명 클래스 방식으로 이벤트 처리하여
        // 항목을 선택했을때 EditText에 정보가 나오도록 한다
        // setOnItemClickListener()
        // 두번째 인자값을 TextView로 casting 해서 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView=(TextView)view;
                editText.setText(textView.getText());
            }
        });
    }
    @Override
    public void onClick(View v) {
        int viewId=v.getId();
        switch (viewId){
            case R.id.addBtn:
                String item=editText.getText().toString();
                if(item.equals("")){
                    showToast("여행지를 입력하세요!");
                }else if(items.contains(item)){
                    showToast("여행지가 중복됩니다!");
                }else if(items.size()>=5){
                    showToast("여행지가 5개를 초과합니다!");
                }else {
                    showToast(item + " 추가!");
                    items.add(item);
                    //ListView 정보를 갱신한다.
                    adapter.notifyDataSetChanged();
                }
                editText.setText("");
                break;
            case R.id.deleteBtn:
                String delItem=editText.getText().toString();
                items.remove(delItem);
                adapter.notifyDataSetChanged();
                showToast("삭제완료");
                editText.setText("");
                break;
            case R.id.allBtn:
                showToast(items.toString());
                break;
            case R.id.allDelBtn:
                items.clear();
                adapter.notifyDataSetChanged();
                showToast("전체삭제");
                break;
        }//switch
        hideKeyBoard();
    }
    public void showToast(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
    //접촉식 키보드를 보이지 않게 하는 메서드
    public void hideKeyBoard(){
        InputMethodManager im =(InputMethodManager)getSystemService(
                MainActivity.INPUT_METHOD_SERVICE);
        im.hideSoftInputFromWindow(editText.getWindowToken(),0);

    }
}











