package com.example.sarau_ete_2019;

import android.content.Context;
import android.support.v7.app.AlertDialog;

public class SaidaDeTexto {

    public void showAlert(Context context, String title, String msg, int icon){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setIcon(icon);
        dialog.setTitle(title);
        dialog.setMessage(msg);
        dialog.setNeutralButton("Ok", null);
        dialog.show();
    }

}
