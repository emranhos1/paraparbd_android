package com.eh.paraparbd.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.provider.Settings;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.eh.paraparbd.R;

public class AlertUtil {

    private static Dialog dialog;

    public static void showAlartDialog(final Context context, String title, String message, Boolean status){
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();

        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setIcon(status ? R.drawable.success_icon : R.drawable.error_icon);
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.startActivity(new Intent(Settings.ACTION_SETTINGS));
            }
        });
        alertDialog.show();
    }

    public static void showProgressDialog(Context context){
        dialog = new Dialog(context, android.R.style.Theme_Dialog);
        dialog.setCancelable(false);
        ImageView imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setBackgroundResource(R.drawable.custom_progress_animation);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(imageView);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        dialog.show();
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }

    public static void hideProgressDialog(){
        dialog.dismiss();
    }

    public static  void showAPInotResponseWarn(Context context){
        Toast.makeText(context, "Database Maintenance!!! Try Again in a few minutes", Toast.LENGTH_SHORT).show();
    }
}
