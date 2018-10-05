package agt.br.com.agt.helper;

import android.app.AlertDialog;
import android.content.Context;

import agt.br.com.agt.R;

public class Mensagem {
    public void Alert(Context context, String mensagem){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        alertDialog.setTitle(R.string.app_name);
        alertDialog.setMessage(mensagem);
        alertDialog.setPositiveButton("OK",null);
        alertDialog.show();
    }
}
