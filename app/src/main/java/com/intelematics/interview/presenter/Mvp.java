package com.intelematics.interview.presenter;


import com.intelematics.interview.SongListActivity;

public interface Mvp {
	interface View {
		void showLoadingDialog();

		void clearAdapter();

		SongListActivity getContext();
	}
	interface Presenter {

		void setView(View view);

		void retrieveSongListFromDB();

		void retrieveSongList();
	}
}
