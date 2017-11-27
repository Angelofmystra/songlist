package com.intelematics.interview.di;

import android.content.Context;

public final class Injector {

	private static MainComponent sComponent;

	private Injector() {
		throw new AssertionError();
	}

	public static void init(Context context) {
		if (sComponent == null) {
			sComponent = DaggerMainComponent.builder().mainModule(new MainModule(context)).build();
		}
	}

	public static MainComponent get() {
		return sComponent;
	}
}
