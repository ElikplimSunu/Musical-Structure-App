package com.android.sunuerico.musicalstructureapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicViewHolder> {

	//variable to contain the musicList
	private ArrayList<Music> mMusicList;

	//variable to contain the interface created
	private OnItemClickListener mListener;

	//creating interface to handle click events on the grid items
	public interface OnItemClickListener {
		void onItemClick(int position);
	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		mListener = listener;
	}

	public static class MusicViewHolder extends RecyclerView.ViewHolder {

		//variable to store the song ImageView
		public ImageView mImageView;

		//variable to store the song title
		public TextView mSongTextView;

		//variable to store the artist name, album name and genre name
		public TextView mArtistAlbumGenreTextView;

		public MusicViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
			super(itemView);

			//referencing the views
			mImageView = itemView.findViewById(R.id.song_image);

			mSongTextView = itemView.findViewById(R.id.song_text_view);

			mArtistAlbumGenreTextView = itemView.findViewById(R.id.artist_album_genre_text);

			itemView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					if (listener != null) {
						int position = getAdapterPosition();

						//making sure the view is available
						if (position != RecyclerView.NO_POSITION) {
							listener.onItemClick(position);
						}
					}
				}
			});

		}
	}

	//getting the data from the ArrayList into the SongsAdapter
	public MusicAdapter(ArrayList<Music> musicList) {
		mMusicList = musicList;
	}


	@NonNull
	@Override
	public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		//passing the layout of the cards to the SongAdapter
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item, parent, false);

		MusicViewHolder musicViewHolder = new MusicViewHolder(view, mListener);

		return musicViewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
		Music currentSong = mMusicList.get(position);

		holder.mImageView.setImageResource(currentSong.getmImageResourceId());
		holder.mArtistAlbumGenreTextView.setText(currentSong.getmArtistAlbumGenre());
	}

	@Override
	public int getItemCount() {
		return mMusicList.size();
	}


}
