package com.android.sunuerico.musicalstructureapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NowPlayingActivity extends AppCompatActivity {
	private MediaPlayer mediaPlayer;


	private AudioManager audioManager;
	AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
		@Override
		public void onAudioFocusChange(int focusChange) {
			if ((focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
					focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) && mediaPlayer != null) {
				mediaPlayer.pause();
			} else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
				mediaPlayer.start();
			} else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
				releaseMediaPlayer();
			}
		}
	};


	@Override
	protected void onCreate(Bundle savedInstanceState) {

		audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


		super.onCreate(savedInstanceState);

		setContentView(R.layout.now_playing);

		//getting data from the parcel
		Intent intent = getIntent();
		Music songItem = intent.getParcelableExtra("SongItem");

		String songName = songItem.getmSongName();
		String artistName = songItem.getmArtistName();
		String albumName = songItem.getmAlbumName();
		int imageResource = songItem.getmImageResourceId();
		final int audioRes = songItem.getmAudioResourceId();

		TextView songTextView = findViewById(R.id.song_text_view);
		songTextView.setText(songName);

		TextView artistTextView = findViewById(R.id.artist_text_view);
		artistTextView.setText(artistName);

		TextView albumTextView = findViewById(R.id.album_text_view);
		albumTextView.setText(albumName);

		ImageView songImageView = findViewById(R.id.song_image);
		songImageView.setImageResource(imageResource);


		//reference to the icon
		final ImageView playIcon = findViewById(R.id.playIcon);

		final ImageView pauseIcon = findViewById(R.id.pauseIcon);

		final ImageView stopIcon = findViewById(R.id.stopIcon);


		playIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				int result = audioManager.requestAudioFocus(onAudioFocusChangeListener,
						AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN);
				if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {

					if (mediaPlayer == null) {

						mediaPlayer = MediaPlayer.create(NowPlayingActivity.this, audioRes);

					}
					mediaPlayer.start();
				}

			}

		});

		pauseIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (mediaPlayer != null) {

					mediaPlayer.pause();
				} else if(mediaPlayer == null){
					releaseMediaPlayer();

				}
			}
		});

		stopIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				releaseMediaPlayer();
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
