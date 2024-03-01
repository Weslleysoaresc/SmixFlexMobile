package br.com.smixsistemas.smixflexmobile.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.smixsistemas.smixflexmobile.Controller.AppVersionController;
import br.com.smixsistemas.smixflexmobile.R;

public class LoginActivity extends AppCompatActivity {

    public Button btnLogin,btnSair;
    public ImageButton imgConfig;
    public TextView txtVersao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        // Obtendo a versão do aplicativo usando o controlador de versão do aplicativo
        String versao = AppVersionController.getAppVersion(this);

        btnLogin = findViewById(R.id.btEntrar);
        imgConfig = findViewById(R.id.imConfig);
        btnSair = findViewById(R.id.btSair);
        txtVersao = findViewById(R.id.txtVersao);

        txtVersao.setText(versao);

        imgConfig.setOnClickListener(view -> {
            // Crie uma intenção para abrir a nova Activity
            Intent intent = new Intent(this, Configuracao.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            // Inicie a nova Activity
            startActivity(intent);
            // Feche a LoginActivity
            finish();
        });

        btnLogin.setOnClickListener(view -> {
            // Crie uma intenção para abrir a nova Activity
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            // Inicie a nova Activity
            startActivity(intent);
            // Feche a LoginActivity
            finish();
        });

        btnSair.setOnClickListener(view -> {
            // Feche a LoginActivity
            finish();
            System.exit(0);
        });
    }
}