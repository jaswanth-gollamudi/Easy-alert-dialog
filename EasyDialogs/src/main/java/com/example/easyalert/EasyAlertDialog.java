package com.example.easyalert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

public class EasyAlertDialog {

    public static void showDialog(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                /*  .setNegativeButton("No", new DialogInterface.OnClickListener() {
                      @Override
                      public void onClick(DialogInterface dialogInterface, int i) {
                          //set what should happen when negative button is clicked
                      }
                  })*/
                .show();
    }

    public static void validationDialog(Context context, String status, String reason) {
        showDialog(context, "Error" + status, reason);
    }

    public static void showAlertDialog(Context context, String message) {
        showDialog(context, "Alert!", message);
    }

    public static void showSuccessDialog(Context context, String message) {
        showDialog(context, "Success!", message);
    }

    public static void showExitDialog(final Context context, String title, String message,
                                      Class<?> cls) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        //dialog.dismiss();
                        //activity.finish();
                        Intent intent = new Intent(context, cls);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        // No button clicked
                        dialog.dismiss();
                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        AlertDialog alertdialog = builder
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
        alertdialog.setCanceledOnTouchOutside(false);
        alertdialog.setCancelable(false);
    }

}
