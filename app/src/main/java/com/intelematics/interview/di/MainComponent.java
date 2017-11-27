package com.intelematics.interview.di;


import com.intelematics.interview.SongListActivity;
import com.intelematics.interview.SongListApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MainModule.class)
public interface MainComponent {
	void inject(SongListActivity activity);
	void inject(SongListApplication application);
}
