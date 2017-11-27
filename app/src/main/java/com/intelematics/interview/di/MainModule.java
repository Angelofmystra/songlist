package com.intelematics.interview.di;

import android.content.Context;

import com.intelematics.interview.db.DBManager;
import com.intelematics.interview.presenter.SongListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class MainModule {
	private final Context mContext;

	public MainModule(Context context) {
		mContext = context;
	}

	@Provides
	@Singleton
	Context provideContext() {
		return mContext;
	}

	@Provides
	SongListPresenter providePresenter(DBManager dbManager) {
		return new SongListPresenter(dbManager);
	}

	@Provides
	DBManager provideDatabase() {
		return new DBManager(mContext);
	}
}
