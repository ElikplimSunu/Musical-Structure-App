package com.android.sunuerico.musicalstructureapp;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment {


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.list_view, container, false);

		//create the list of songs
		final ArrayList<Music> songs = new ArrayList<>();
		songs.add(new Music("Lil Wayne", "Mona Lisa", "3:66", R.drawable.quiz5, R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "Mona Lisa", "3:66", R.drawable.quiz5, R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "Mona Lisa", "3:66", R.drawable.quiz5, R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "Mona Lisa", "3:66", R.drawable.quiz5, R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "Mona Lisa", "3:66", R.drawable.quiz5, R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "Mona Lisa", "3:66", R.drawable.quiz5, R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "Mona Lisa", "3:66", R.drawable.quiz5, R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "Mona Lisa", "3:66", R.drawable.quiz5, R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "Mona Lisa", "3:66", R.drawable.quiz5, R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "Mona Lisa", "3:66", R.drawable.quiz5, R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "Mona Lisa", "3:66", R.drawable.quiz5, R.raw.wild_one));


		SongsAdapter songsAdapter = new SongsAdapter(getActivity(), songs);

		// Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
		// There should be a {@link GridView} with the view ID called grid_view, which is declared in the
		// grid_view.xmllayout file.
		ListView listView = rootView.findViewById(R.id.list_recyclerview);

		// Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
		// {@link ListView} will display list items for each {@link Word} in the list.
		listView.setAdapter(songsAdapter);


		listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				Music song = songs.get(position);

				Intent intent = new Intent(getActivity(), NowPlayingActivity.class);
				intent.putExtra("SongItem",  song);
				startActivity(intent);

			}

		});
		return rootView;
	}

}
