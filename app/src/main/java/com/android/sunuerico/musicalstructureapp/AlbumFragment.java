package com.android.sunuerico.musicalstructureapp;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumFragment extends Fragment {



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.grid_view, container, false);



		//create the list of songs
		final ArrayList<Music> songs =new ArrayList<Music>();
		songs.add(new Music("Lil Wayne", "V Carter",  R.drawable.quiz5,  R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "V Carter",  R.drawable.quiz5,  R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "V Carter",  R.drawable.quiz5,  R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "V Carter",  R.drawable.quiz5,  R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "V Carter",  R.drawable.quiz5,  R.raw.wild_one));
		songs.add(new Music("Lil Wayne", "V Carter",  R.drawable.quiz5,  R.raw.wild_one));




		MusicAdapter songsAdapter = new MusicAdapter(getActivity(), songs);

		// Find the {@link GridView} object in the view hierarchy of the {@link Activity}.
		// There should be a {@link GridView} with the view ID called grid_view, which is declared in the
		// grid_viewxml layout file.
		GridView gridView = rootView.findViewById(R.id.grid_recyclerview);

		// Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
		// {@link ListView} will display list items for each {@link Word} in the list.
		gridView.setAdapter(songsAdapter);

//		gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//			@Override
//			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//				Music song = songs.get(position);
//
//				Intent intent = new Intent(getActivity(), NowPlayingActivity.class);
//				intent.putExtra("SongItem",  song);
//				startActivity(intent);
//
//			}
//
//		});


		return  rootView;
	}

}
