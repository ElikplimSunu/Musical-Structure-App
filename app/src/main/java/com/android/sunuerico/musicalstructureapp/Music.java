package com.android.sunuerico.musicalstructureapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {

	//The artist's name
	private String mArtistName;

	//the album's name
	private String mAlbumName;

	//the name of the song
	private String mSongName;

	//the artist or album or genre name
	private String mArtistAlbumGenre;

	//The image displayed for each category
	private int mImageResourceId;

	//The song to be played
	private int mAudioResourceId;

	//The duration if the song
	private String mSongTime;


	//Constructor album, artist, genre tabs
	public Music(String artistAlbumGenre, int imageResourceId, int audioResourceId) {

		mArtistAlbumGenre = artistAlbumGenre;
		mImageResourceId = imageResourceId;
		mAudioResourceId = audioResourceId;

	}


	//Contructor for song list
	public Music(String artistName, String songName, String songTime, String albumName, int imageResourceId, int audioResourceId) {

		mArtistName = artistName;

		mSongName = songName;

		mSongTime = songTime;

		mImageResourceId = imageResourceId;

		mAudioResourceId = audioResourceId;

		mAlbumName = albumName;

	}


	protected Music(Parcel in) {
		mArtistAlbumGenre = in.readString();
		mArtistName = in.readString();
		mAlbumName = in.readString();
		mSongName = in.readString();
		mImageResourceId = in.readInt();
		mAudioResourceId = in.readInt();
		mSongTime = in.readString();
	}


	//The creator for the Parcleable
	public static final Creator<Music> CREATOR = new Creator<Music>() {
		@Override
		public Music createFromParcel(Parcel in) {
			return new Music(in);
		}

		@Override
		public Music[] newArray(int size) {
			return new Music[size];
		}
	};

	/***
	 * Get the artist's name
	 */
	public String getmArtistName() {
		return mArtistName;
	}

	/***
	 * Get the album's name
	 */
	public String getmAlbumName() {
		return mAlbumName;
	}


	/***
	 * Get the songs's name
	 */
	public String getmSongName() {
		return mSongName;
	}

	/***
	 * Get the duration of the song
	 */
	public String getmSongTime() {
		return mSongTime;
	}


	/***
	 * Get the song
	 */
	public int getmAudioResourceId() {
		return mAudioResourceId;
	}


	/***
	 * Get the song
	 */
	public int getmImageResourceId() {
		return mImageResourceId;
	}

	/***
	 * Get the artist name or album name or genre name
	 */
	public String getmArtistAlbumGenre() {
		return mArtistAlbumGenre;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(mArtistAlbumGenre);
		dest.writeString(mArtistName);
		dest.writeString(mAlbumName);
		dest.writeString(mSongName);
		dest.writeInt(mImageResourceId);
		dest.writeInt(mAudioResourceId);
		dest.writeString(mSongTime);
	}
}


