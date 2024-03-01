package br.com.smixsistemas.smixflexmobile.Controller;

import android.content.Context;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class AlertController {

    // Método estático para exibir um alerta simples (Toast) com uma mensagem
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    // Método estático para exibir um alerta de diálogo com uma mensagem
    public static void showDialog(Context context, String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("OK", null) // Botão OK, que apenas fecha o diálogo
                .show();
    }
}
