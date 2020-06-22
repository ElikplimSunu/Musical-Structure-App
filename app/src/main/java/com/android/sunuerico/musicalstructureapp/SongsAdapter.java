package com.android.sunuerico.musicalstructureapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.SongViewHolder> {

	//variable to contain the songsList
	private ArrayList<Music> mSongsList;

	//variable to contain the interface created
	private OnItemClickListener mListener;

 	public interface OnItemClickListener {
		void onItemClick(int position);
	}

	public void setOnItemClickListener(OnItemClickListener listener) {
		mListener = listener;
	}

	public static class SongViewHolder extends RecyclerView.ViewHolder {

		//variable to store the song ImageView
		public ImageView mImageView;

		//variable to store the song title
		public TextView mSongTextView;

		//variable to store the artist name
		public TextView mArtistTextView;

		//variable to get album name
		public TextView mAlbumName;

		//variable to store song duration
		public TextView mSongTime;


		public SongViewHolder(@NonNull View itemView, final OnItemClickListener listener) {
			super(itemView);

			//referencing the views
			mImageView = itemView.findViewById(R.id.song_image);

			mSongTextView = itemView.findViewById(R.id.song_text_view);

			mArtistTextView = itemView.findViewById(R.id.artist_text_view);

			mAlbumName = itemView.findViewById(R.id.album_text_view);

			mSongTime = itemView.findViewById(R.id.song_time);

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
	public SongsAdapter(ArrayList<Music> songsList) {
		mSongsList = songsList;
	}


	@NonNull
	@Override
	public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		//passing the layout of the cards to the SongAdapter
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

		SongViewHolder songViewHolder = new SongViewHolder(view, mListener);

		return songViewHolder;
	}

	@Override
	public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
		Music currentSong = mSongsList.get(position);

		holder.mImageView.setImageResource(currentSong.getmImageResourceId());
		holder.mSongTextView.setText(currentSong.getmSongName());
		holder.mArtistTextView.setText(currentSong.getmArtistName());
		holder.mSongTime.setText(currentSong.getmSongTime());
	}

	@Override
	public int getItemCount() {
		return mSongsList.size();
	}
}
