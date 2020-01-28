package com.eh.paraparbd.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.widget.Toast;

import com.eh.paraparbd.R;

public class CustomAlertMessage {

	public static void toastMessage(Context context, String message) {
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
	}

	public  static void showCustomAlert(Context context, String title, String message, Boolean status){

		final AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(message);
		alertDialog.setIcon(status ? R.drawable.success_icon : R.drawable.error_icon);
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				alertDialog.dismiss();
			}
		});

		Log.d(context.toString(), message + " ################# emranhos1@gmail.com ################# ");
		alertDialog.show();
	}
}
