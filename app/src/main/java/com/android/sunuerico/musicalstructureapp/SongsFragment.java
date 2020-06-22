package com.android.sunuerico.musicalstructureapp;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment {


	private MediaPlayer mediaPlayer;

	private RecyclerView mRecyclerView;

	//provides as many items needed
	private SongsAdapter mAdapter;

	//Responsible for the arrangement of the views
	private RecyclerView.LayoutManager mLayoutManager;


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.list_view, container, false);

		//create the list of songs
		final ArrayList<Music> songs = new ArrayList<>();
		songs.add(new Music("Free Beats", "Wild Ones", "2:35", "Lil Mosey Type Beat", R.drawable.wild_one, R.raw.wild_one));
		songs.add(new Music("The Journey", "Jump Off", "3:55", "BlueFace Type Beat", R.drawable.jump_off, R.raw.jumpoff));
		songs.add(new Music("Sami Thompson", "City Lights", "3:48", "Dance House Instrumental", R.drawable.city_lights, R.raw.city_lights));
		songs.add(new Music("EDM", "Rumble", "2:50", "Hard Trap Clap Beat", R.drawable.rumble, R.raw.rumble));
		songs.add(new Music("YG", "Money Walk", "3:53", "Blue Face Type Beat", R.drawable.money_walk, R.raw.money_walk));
		songs.add(new Music("Freebeats.io", "Club Jumpin'", "3:22", "Lloyd Banks Type Beat", R.drawable.club_jumpin, R.raw.club_jumpin));
		songs.add(new Music("Freebeats.io", "Remind Me", "3:57", "Chris Brown Type Beat", R.drawable.remind_me, R.raw.remind_me));


		//initializing RecyclerView
		mRecyclerView = rootView.findViewById(R.id.list_recyclerview);
//		mRecyclerView.setHasFixedSize(true);
		mLayoutManager = new LinearLayoutManager(getActivity());
		mAdapter = new SongsAdapter(songs);

		mRecyclerView.setLayoutManager(mLayoutManager);
		mRecyclerView.setAdapter(mAdapter);

		mAdapter.setOnItemClickListener(new SongsAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(int position) {
				Music song = songs.get(position);

				Intent intent = new Intent(getActivity(), NowPlayingActivity.class);
				intent.putExtra("SongItem", song);
				startActivity(intent);
			}
		});


		return rootView;
	}

}
