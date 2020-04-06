package com.android.sunuerico.musicalstructureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {
	private MediaPlayer mediaPlayer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.now_playing);

		//I tried using the Parcelable interface to pass the Music information from the Song list to the
		//Now playing but it never worked and I simply gave up. Trust me I spent an entire week on this feature
		//and I was running out of time to submit. I am very sorry I let you down mentor :(
//		Intent intent = getIntent();
//
//		Music songItem = intent.getParcelableExtra("Music");
//
//		String songName = songItem.getmSongName();
//		String artistName = songItem.getmArtistName();
//		String albumName = songItem.getmAlbumName();
//		int audioResource = songItem.getmAudioResourceId();
//		int imageResource = songItem.getmImageResourceId();
//
//		TextView songTextView = findViewById(R.id.song_text_view);
//songTextView.setText(songName);
//
//		TextView artistTextView = findViewById(R.id.artist_text_view);
//		artistTextView.setText(artistName);
//
//		TextView albumTextView = findViewById(R.id.album_text_view);
//		albumTextView.setText(albumName);
//
//		ImageView songImageView = findViewById(R.id.song_image);
//		songImageView.setImageResource(imageResource);






		final ImageView playIcon = findViewById(R.id.playIcon);


		playIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mediaPlayer == null) {
					releaseMediaPlayer();
					mediaPlayer = MediaPlayer.create(NowPlayingActivity.this, R.raw.wild_one);

					mediaPlayer.start();
					playIcon.setImageResource(R.drawable.ic_pause_black_24dp);
				} else if (mediaPlayer.isPlaying()) {
					mediaPlayer.pause();
					releaseMediaPlayer();
					playIcon.setImageResource(R.drawable.ic_play_arrow_black_24dp);
				}

//				mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//					@Override
//					public void onCompletion(MediaPlayer mp) {
//						Toast.makeText(NowPlayingActivity.this, "Song is done playing",Toast.LENGTH_SHORT).show();
//
//					}
//				});
			}

		});

	}


	/**
	 * Clean up the media player by releasing its resources.
	 */
	private void releaseMediaPlayer() {
		// If the media player is not null, then it may be currently playing a sound.
		if (mediaPlayer != null) {
			// Regardless of the current state of the media player, release its resources
			// because we no longer need it.
			mediaPlayer.release();

			// Set the media player back to null. For our code, we've decided that
			// setting the media player to null is an easy way to tell that the media player
			// is not configured to play an audio file at the moment.
			mediaPlayer = null;

		}
	}

//So that the music stop when you close the activity
	@Override
	protected void onStop() {
		super.onStop();
		releaseMediaPlayer();
	}
}
