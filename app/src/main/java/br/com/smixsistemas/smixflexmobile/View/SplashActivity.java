package br.com.smixsistemas.smixflexmobile.View;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

import br.com.smixsistemas.smixflexmobile.Dao.BDHelper;
import br.com.smixsistemas.smixflexmobile.R;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_TIME_OUT = 2000; // Tempo de exibição da tela de splash (em milissegundos)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        //Instancia o Banco de Dados
        BDHelper dao = new BDHelper(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(!TextUtils.isEmpty(dao.buscar()[1])){
                    // Crie uma intenção para abrir a nova Activity
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    // Inicie a nova Activity
                    startActivity(intent);
                    // Feche a LoginActivity
                    finish();
                }
                else{
                    // Crie uma intenção para abrir a nova Activity
                    Intent intent = new Intent(SplashActivity.this, Configuracao.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    // Inicie a nova Activity
                    startActivity(intent);
                    // Feche a LoginActivity
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}