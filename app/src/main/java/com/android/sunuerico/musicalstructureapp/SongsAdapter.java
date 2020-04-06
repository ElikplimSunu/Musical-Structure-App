package com.android.sunuerico.musicalstructureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SongsAdapter extends ArrayAdapter<Music> {
	public SongsAdapter(@NonNull Context context, ArrayList<Music> songs) {
		super(context,0, songs);
	}

	@NonNull
	@Override
	public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
		View listItemView = convertView;
		if(listItemView == null){
			listItemView = LayoutInflater.from(getContext()).inflate(
					R.layout.list_item, parent, false
			);
		}

		Music currentSong = getItem(position);

		TextView albumTextView =  listItemView.findViewById(R.id.song_text_view);
		albumTextView.setText(currentSong.getmSongName());

		TextView artistTextView =  listItemView.findViewById(R.id.artist_text_view);
		artistTextView.setText(currentSong.getmArtistName());

		TextView songTimeTextView = listItemView.findViewById(R.id.song_time);
		songTimeTextView.setText(currentSong.getmSongTime());




		return listItemView;
	}
}
