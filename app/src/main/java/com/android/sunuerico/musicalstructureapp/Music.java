package com.android.sunuerico.musicalstructureapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Music implements Parcelable {

	//The artist's name
	private String mArtistName ;

	//the album's name
	private String mAlbumName = NO_ALBUM_NAME_PROVIDED;

//the genre of the song
	private String mGenreName;

	//the name of the song
	private String mSongName;

	//The image displayed for each category
	private  int mImageResourceId;

	//The song to be played
	private  int mAudioResourceId;

	//The duration if the song
	private String mSongTime;

	//When displaying the ArtistActivity
	public static final String NO_ALBUM_NAME_PROVIDED = "";






	//Constructor for Album Activity
	public Music( String artistName, String albumName, int imageResourceId, int audioResourceId){

		mAlbumName = albumName;
		mArtistName = artistName;
		mImageResourceId = imageResourceId;
		mAudioResourceId = audioResourceId;

	}
//Constructor for All the classes
	public Music( String artistName, String albumName, int imageResourceId, String genreName, int audioResourceId){

		mAlbumName = albumName;
		mArtistName = artistName;
		mImageResourceId = imageResourceId;
		mGenreName = genreName;
		mAudioResourceId = audioResourceId;

	}


	public Music( String artistName, String songName, String songTime, int imageResourceId, int audioResourceId){

		mArtistName = artistName;

		this.mSongName = songName;
		mSongTime = songTime;

		mImageResourceId = imageResourceId;

		mAudioResourceId = audioResourceId;

	}

	public Music( String artistName, int imageResourceId){

		mArtistName = artistName;


		mImageResourceId = imageResourceId;

	}


	protected Music(Parcel in) {
		mArtistName = in.readString();
		mAlbumName = in.readString();
		mGenreName = in.readString();
		mSongName = in.readString();
		mImageResourceId = in.readInt();
		mAudioResourceId = in.readInt();
		mSongTime = in.readString();
	}

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

	public int getmImageResourceId() {
		return mImageResourceId;
	}

	public boolean hasAlbumName(){
		return !(mAlbumName.equals(NO_ALBUM_NAME_PROVIDED));
	}

	/***
	 * Get the song
	 */



	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(mArtistName);
		dest.writeString(mAlbumName);
		dest.writeString(mGenreName);
		dest.writeString(mSongName);
		dest.writeInt(mImageResourceId);
		dest.writeInt(mAudioResourceId);
		dest.writeString(mSongTime);
	}
}


