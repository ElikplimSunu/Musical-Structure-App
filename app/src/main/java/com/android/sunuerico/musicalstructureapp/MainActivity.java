package com.android.sunuerico.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Set the content of the activity to use the activity_main.xml layout file
		setContentView(R.layout.activity_main);

		// Find the view pager that will allow the user to swipe between fragments
		ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

		// Create an adapter that knows which fragment should be shown on each page
		CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

		// Set the adapter onto the view pager
		viewPager.setAdapter(adapter);

		// Find the tab layout that shows the tabs
		TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

		tabLayout.setupWithViewPager(viewPager);

	}
}
