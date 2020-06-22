package com.android.sunuerico.musicalstructureapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SongsActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container_of_layout, new SongsFragment())
				.commit();

	}


}


