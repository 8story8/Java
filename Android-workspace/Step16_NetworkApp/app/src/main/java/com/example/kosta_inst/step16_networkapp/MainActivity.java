package com.example.kosta_inst.step16_networkapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity implements OnClickListener {
	private EditText idET;
	private EditText passET;
	private EditText nameET;	
	private EditText addressET;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button sendBtn = (Button) findViewById(R.id.sendBtn);
		Button getBtn = (Button) findViewById(R.id.getBtn);
		Button clearBtn=(Button)findViewById(R.id.clearBtn);
		sendBtn.setOnClickListener(this);
		getBtn.setOnClickListener(this);
		clearBtn.setOnClickListener(this);
		idET = (EditText) findViewById(R.id.idET);
		passET = (EditText) findViewById(R.id.passET);
		nameET = (EditText) findViewById(R.id.nameET);
		addressET = (EditText) findViewById(R.id.addressET);
	}

	public void onClick(View view) {

		int id = view.getId();
		String command=null;
		try {
			// 검색버튼인 경우 :
			if (id == R.id.getBtn) {
				command="find";
				String mid=idET.getText().toString();
				new NetService().execute(command,mid);					
			} else if(id==R.id.sendBtn){// 등록버튼의 경우
				command="register";
				String mid=idET.getText().toString();
				String password=passET.getText().toString();
				String name = nameET.getText().toString();		
				String address = addressET.getText().toString();
				//String ... 와 같은 Vargs 형식으로 받기 때문에 여러 인자값 정의 가능  
				new NetService().execute(command,mid,password,name,address);				
			}else{// clear 버튼 초기화
				idET.setText("");
				passET.setText("");
				nameET.setText("");
				addressET.setText("");
			}
		} catch (Exception e) {
			Log.e("Http_Json", e.getMessage(), e);
		}
		hideKeyBoard();
	}
	public void hideKeyBoard(){
    	InputMethodManager im
    	=(InputMethodManager)this.getSystemService(
    			this.INPUT_METHOD_SERVICE);
    	im.hideSoftInputFromWindow(nameET.getWindowToken(), 0);
    }
	
	public class NetService extends AsyncTask<String,Void,String>{
		
		String command;
		String url = null;
		@Override
		protected String doInBackground(String... params) {
			String p="";
			for(String data:params){
				p+=data+" ";
			}
			Log.d("test","doInBackground.."+p);
			command=params[0];
			String result="";
			if(command.equals("find")){
				url = "http://192.168.0.112:8888/androidtest1/FindServlet";
				result=netServer(url,"id="+params[1]);
			}else if(command.equals("register")){
				url = "http://192.168.0.112:8888/androidtest1/RegisterServlet";
				StringBuilder paramData=new StringBuilder();
				paramData.append("id=" + params[1]);
				paramData.append("&password=" + params[2]);
				paramData.append("&name=" + params[3]);
				paramData.append("&address=" + params[4]);
				result=netServer(url, paramData.toString());
			}			
			return result;
		}
		/**
		 * doInBackground(Params... ) 메소드의 작업 결과를 UI에 반영하는 역할을 담당하는 메소드이며, 
		 * doInBackground(Params...) 메소드가 호출된 이후에 UI 스레드에서 실행
		 */
		@Override
		protected void onPostExecute(String result) {
			Log.d("test","onPostExecute.."+result);
			//super.onProgressUpdate(values);
			if(command.equals("find")){
				if(result.equals("")) {
					Toast.makeText(MainActivity.this, "회원이 존재하지 않습니다!", Toast.LENGTH_LONG).show();
				}else {
					// WAS 에서 응답한 JSON DATA를 안드로이드 앱에서 표현
					try {
						Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
						JSONObject obj = new JSONObject(result);
						nameET.setText(obj.getString("name"));
						addressET.setText(obj.getString("address"));
					} catch (Exception e) {
						Log.e("error", e.getMessage());
					}
				}
			}else if(command.equals("register")){
				Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();				
				try{
				JSONObject obj=new JSONObject(result);
				Toast.makeText(MainActivity.this, obj.getString("message"), Toast.LENGTH_SHORT).show();
				idET.setText("");passET.setText("");
				nameET.setText("");addressET.setText("");
				}catch(Exception e){
					Log.e("error",e.getMessage());
				}
			}
		}
		public String netServer(String url,String param){
			StringBuilder responseData=null;
			try {
			URL urlObj=new URL(url);
			HttpURLConnection conn = null;
			conn = (HttpURLConnection)urlObj.openConnection();
            conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");
			conn.setAllowUserInteraction(true);
			conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
            //서버 요청
            PrintWriter pw=new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"),true);
            pw.write(param);
			pw.flush();
			int resCode=conn.getResponseCode();
			Log.d("resCode",resCode+" "+param);// 200 정상수행
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),
						"utf-8"));			
				String str;
				 responseData=new StringBuilder();
				while ((str=br.readLine())!=null) {
					responseData.append(str + "\n");
					Log.d("resData",str);
				}
				pw.close();
				br.close();
			} catch (Exception e) {
				Log.e("net", e.getMessage(), e);
			}
			return responseData.toString();
		}
	}
}
