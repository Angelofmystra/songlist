package com.intelematics.interview.presenter;

import com.intelematics.interview.db.DBManager;
import com.intelematics.interview.tasks.DownloadSongListTask;
import com.intelematics.interview.tasks.ReadDBSongListTask;

public final class SongListPresenter implements Mvp.Presenter {

	Mvp.View mView;
	private DBManager dbManager;

	public SongListPresenter(DBManager dbManager) {
		this.dbManager = dbManager;
	}

	@Override
	public void setView(Mvp.View view) {
		mView = view;
	}

	@Override
	public void retrieveSongListFromDB(){
		mView.showLoadingDialog();
		mView.clearAdapter();
		ReadDBSongListTask fetchTask = new ReadDBSongListTask(mView.getContext(), dbManager);
		fetchTask.execute();
	}

	@Override
	public void retrieveSongList(){
		mView.showLoadingDialog();
		mView.clearAdapter();
		DownloadSongListTask fetchTask = new DownloadSongListTask(mView.getContext(), dbManager);
		fetchTask.execute();
	}
}
