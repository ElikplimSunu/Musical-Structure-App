package com.android.sunuerico.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class AlbumActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_category);
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.container_of_layout, new AlbumFragment())
				.commit();

	}
}
