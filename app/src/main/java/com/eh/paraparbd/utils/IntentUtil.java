package com.eh.paraparbd.utils;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class IntentUtil {

	public static void goToAnotherActivity(final Context context, Class goingTo){

		Intent intent = new Intent(context, goingTo);
		context.startActivity(intent);
		Log.d("## Going From : ## " + context.toString(), "Going To : ## " +goingTo);
	}
}
