package br.com.smixsistemas.smixflexmobile.View;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.smixsistemas.smixflexmobile.Controller.AlertController;
import br.com.smixsistemas.smixflexmobile.Controller.AppVersionController;
import br.com.smixsistemas.smixflexmobile.Dao.BDHelper;
import br.com.smixsistemas.smixflexmobile.R;

public class Configuracao extends AppCompatActivity {

    public Button btnSalvar,btnSair;
    public EditText edIPServer;
    public TextView txtVersao;
    public RadioGroup rdComunicacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_configuracao);

        // Obtendo a versão do aplicativo usando o controlador de versão do aplicativo
        String versao = AppVersionController.getAppVersion(this);

        txtVersao = findViewById(R.id.txtVersao);
        txtVersao.setText(versao);

        edIPServer = findViewById(R.id.edtIPServer);
        btnSalvar = findViewById(R.id.btSalvar);
        btnSair = findViewById(R.id.btSair);
        rdComunicacao = findViewById(R.id.radioGroupCommunication);

        //Instancia o Banco de Dados
        BDHelper dao = new BDHelper(this);

        if(!TextUtils.isEmpty(dao.buscar()[1])){
            if(Integer.parseInt(dao.buscar()[1]) == 1) {
                edIPServer.setEnabled(false);
                // Obtém uma referência ao RadioButton que você deseja marcar como selecionado
                RadioButton radioButtonLocal = findViewById(R.id.radioButtonLocal);
                // Marca o RadioButton como selecionado
                radioButtonLocal.setChecked(true);
            }
            else if(Integer.parseInt(dao.buscar()[1]) == 2) {
                edIPServer.setEnabled(true);
                // Obtém uma referência ao RadioButton que você deseja marcar como selecionado
                RadioButton radioButtonServer = findViewById(R.id.radioButtonServer);
                // Marca o RadioButton como selecionado
                radioButtonServer.setChecked(true);
                if(!TextUtils.isEmpty(dao.buscar()[0]))
                    edIPServer.setText(dao.buscar()[0]);
            }
        }
        else
            edIPServer.setEnabled(false);

        btnSalvar.setOnClickListener(v -> {
            String dados = edIPServer.getText().toString();
            // Obtém o ID do botão de opção selecionado no RadioGroup
            int selectedId = rdComunicacao.getCheckedRadioButtonId();
            // Verifica se algum botão de opção foi selecionado
            if (selectedId != -1) {
                // Obtém o RadioButton selecionado com base no ID
                RadioButton radioButton = findViewById(selectedId);

                // Obtém o texto do RadioButton selecionado
                int selectedValue = Integer.parseInt(radioButton.getTag().toString());

                // Faça o que for necessário com os dados e o valor selecionado
                dao.deletar();
                dao.inserir(dados, selectedValue);
                AlertController.showDialog(this, getString(R.string.title_sucesso), getString(R.string.msg_sucesso));
            } else {
                // Nenhum botão de opção foi selecionado
                AlertController.showToast(this, getString(R.string.alert_radio));
            }
        });

        rdComunicacao.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // Verifica qual botão de opção foi selecionado
                if (checkedId != -1) {
                    RadioButton radioButton = findViewById(checkedId);
                    int selectedValue = Integer.parseInt(radioButton.getTag().toString());
                    if(selectedValue == 1)
                        edIPServer.setEnabled(false);
                    else if (selectedValue == 2)
                        edIPServer.setEnabled(true);
                }
            }
        });

        btnSair.setOnClickListener(v -> {
            if(TextUtils.isEmpty(dao.buscar()[1])){
                // Feche a ConfiguracaoActivity
                finish();
                System.exit(0);
            }
            else{
                // Crie uma intenção para abrir a nova Activity
                Intent intent = new Intent(this, LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                // Inicie a nova Activity
                startActivity(intent);
                // Feche a LoginActivity
                finish();
            }
        });
    }
}