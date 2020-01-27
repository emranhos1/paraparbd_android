package com.eh.paraparbd.classes;

import android.content.Context;
import android.widget.Toast;

public class Message {

	public static void toastMessage(Context context, String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}
}
