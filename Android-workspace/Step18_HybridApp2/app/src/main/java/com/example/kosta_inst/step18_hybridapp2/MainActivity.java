package com.example.kosta_inst.step18_hybridapp2;

import android.os.Bundle;

import org.apache.cordova.DroidGap;

public class MainActivity extends DroidGap {

	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        super.loadUrl("file:///android_asset/www/index.html");
	    }



}
