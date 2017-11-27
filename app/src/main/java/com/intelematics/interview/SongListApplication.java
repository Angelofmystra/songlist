package com.intelematics.interview;


import android.app.Application;
import android.content.Context;

import com.intelematics.interview.di.Injector;

public class SongListApplication extends Application {

	@Override
	protected void attachBaseContext(Context base) {
		super.attachBaseContext(base);
		Injector.init(this);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Injector.get().inject(this);
	}
}
