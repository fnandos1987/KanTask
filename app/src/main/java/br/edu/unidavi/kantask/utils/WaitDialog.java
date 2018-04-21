package br.edu.unidavi.kantask.utils;

import android.app.ProgressDialog;
import android.content.Context;

import br.edu.unidavi.kantask.R;

public class WaitDialog {

    static ProgressDialog progressDialog;

    public static void showDialog(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(context.getString(R.string.message_wait));
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);
        progressDialog.show();
    }

    public static void hideDialog(){
        if(progressDialog != null && progressDialog.isShowing()){
            progressDialog.cancel();
        }
    }

}
