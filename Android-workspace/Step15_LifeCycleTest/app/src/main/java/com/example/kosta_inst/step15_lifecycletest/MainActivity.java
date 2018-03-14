package com.example.kosta_inst.step15_lifecycletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
/**
 * 안드로이드 라이프 사이클 테스트 
 * 1. 앱 실행 : onCreate -> onStart -> onResume
 * 2. back 버튼 : onPause -> onStop -> onDestory 
 * 3. finish() 호출 : back 버튼과 동일 , 종료된다. 
 * 4. home 버튼 눌렀을 때 :  onPause -> onStop
 * 5. home에서 다시 앱 실행 : onRestart -> onStart -> onResume 
 * 6. 다른 액티비티를 실행했을 때 MainActivity는 : 
 * 	   onPause->onStop
 * 7. 다른 액티비티가 종료되었을 때 MainActivity는 : 
 * 	   onRestart -> onStart -> onResume
 * 8. 화면전환
 * 	   onPause->onStop->onDestroy->onCreate->onStart->onResume
 * 
 * @author KOSTA-00-KANGSA
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button exitBtn=(Button) findViewById(R.id.exit);
		exitBtn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		Button secondBtn=(Button)findViewById(R.id.second);
		secondBtn.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(MainActivity.this,SecondActivity.class);
				startActivity(intent);
			}
		});
		Log.d("life","onCreate");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("life","onDestroy");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("life","onPause");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.d("life","onRestart");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("life","onResume");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("life","onStart");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("life","onStop");
	}



}
