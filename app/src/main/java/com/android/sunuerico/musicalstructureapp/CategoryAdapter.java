package com.android.sunuerico.musicalstructureapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

	/** Context of the app */
	private Context mContext;

	/**
	 * Create a new {@link CategoryAdapter} object.
	 *
	 * @param context is the context of the app
	 * @param fm is the fragment manager that will keep each fragment's state in the adapter
	 *           across swipes.
	 */
	public CategoryAdapter(Context context, @NonNull FragmentManager fm) {
		super(fm);
		mContext = context;

	}

	@NonNull
	@Override
	public Fragment getItem(int position) {
		switch (position){
			case 0:
				return new AlbumFragment();
			case 1:
				return new SongsFragment();
			case 2:
				return new ArtistFragment();
			case 3:
				return new GenreFragment();
			default:
				return null;
		}
	}

	@Nullable
	@Override
	public CharSequence getPageTitle(int position) {
		switch (position){
			case 0:
				return mContext.getString(R.string.albums);
			case 1:
				return mContext.getString(R.string.songs);
			case 2:
				return mContext.getString(R.string.artists);
			case 3:
				return mContext.getString(R.string.genre);
			default:
				return null;
		}
	}

	@Override
	public int getCount() {
		return 4;
	}
}
