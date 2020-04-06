package com.android.sunuerico.musicalstructureapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<Music> {

	public MusicAdapter(Activity context, ArrayList<Music> songs){
		super(context, 0, songs);
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		View gridItemView = convertView;
		if(gridItemView == null){
			gridItemView = LayoutInflater.from(getContext()).inflate(
					R.layout.grid_item, parent, false
			);
		}

		Music currentSong = getItem(position);

		TextView albumTextView =  gridItemView.findViewById(R.id.album_text_view);

		if(currentSong.hasAlbumName()){
			albumTextView.setText(currentSong.getmAlbumName());
			albumTextView.setVisibility(View.VISIBLE);
		} else {
			albumTextView.setVisibility(View.GONE);
		}

		TextView artistTextView =  gridItemView.findViewById(R.id.artist_text_view);
		artistTextView.setText(currentSong.getmArtistName());



		return gridItemView;
	}
}
