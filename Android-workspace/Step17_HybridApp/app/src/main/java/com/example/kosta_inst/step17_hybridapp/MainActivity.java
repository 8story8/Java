package com.example.kosta_inst.step17_hybridapp;

import android.os.Bundle;

import org.apache.cordova.DroidGap;

public class MainActivity extends DroidGap {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.loadUrl("file:///android_asset/www/index.html");
	}
}
