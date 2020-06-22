package com.android.sunuerico.musicalstructureapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class GenreFragment extends Fragment {

	private RecyclerView mRecyclerView;

	//provides as many items needed
	private RecyclerView.Adapter mAdapter;

	//Responsible for the arrangement of the views
	private RecyclerView.LayoutManager mLayoutManager;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.grid_view, container, false);


		//create the list of songs
		final ArrayList<Music> songs = new ArrayList<Music>();
		songs.add(new Music("Lil Mosey Type Beat", R.drawable.wild_one, R.raw.wild_one));
		songs.add(new Music("Hip Hop Beat", R.drawable.jump_off, R.raw.jumpoff));
		songs.add(new Music("Dance House Instrumental", R.drawable.city_lights, R.raw.city_lights));
		songs.add(new Music("Hard Trap Clap Beat", R.drawable.rumble, R.raw.rumble));
		songs.add(new Music("Blue Face Type Beat", R.drawable.money_walk, R.raw.money_walk));
		songs.add(new Music("Lloyd Banks Type Beat", R.drawable.club_jumpin, R.raw.club_jumpin));
		songs.add(new Music("Chris Brown Type Beat", R.drawable.remind_me, R.raw.remind_me));


		//initializing RecyclerView
		mRecyclerView = rootView.findViewById(R.id.grid_recyclerview);
//		mRecyclerView.setHasFixedSize(true);
		mLayoutManager = new GridLayoutManager(getActivity(), 2);
		mAdapter = new MusicAdapter(songs);

		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setAdapter(mAdapter);

		return rootView;
	}

}
