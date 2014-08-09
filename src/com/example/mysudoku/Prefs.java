package com.example.mysudoku;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.preference.PreferenceActivity;;
 
public class Prefs extends PreferenceActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
	}

	

}
