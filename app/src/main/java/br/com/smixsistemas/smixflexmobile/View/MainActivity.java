package br.com.smixsistemas.smixflexmobile.View;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import br.com.smixsistemas.smixflexmobile.R;
import br.com.smixsistemas.smixflexmobile.View.Adapter.FirstFragment;
import br.com.smixsistemas.smixflexmobile.View.Adapter.TabAdapter;

public class MainActivity extends AppCompatActivity {

    public Button btnMenu01,btnMenu02,btnMenu03,btnMenu04,btnMenu05,btnMenu06;
    public TabLayout tabLayout;
    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        adapter.addFragment(new FirstFragment(), "Início", "\uf015");
        adapter.addFragment(new FirstFragment(), "Agenda", "\uf073");
        adapter.addFragment(new FirstFragment(), "Financeiro", "\uf155");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        // Define os ícones para as guias
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                View tabView = adapter.getTabView(i, this);
                tab.setCustomView(tabView);
            }
        }

        btnMenu01 = findViewById(R.id.btnMenu01);
        btnMenu01.setTypeface(font);
        btnMenu01.setText("\uf07a  PEDIDO");
        btnMenu01.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

        btnMenu02 = findViewById(R.id.btnMenu02);
        btnMenu02.setTypeface(font);
        btnMenu02.setText("\uf044  ORÇAMENTO");
        btnMenu02.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

        btnMenu03 = findViewById(R.id.btnMenu03);
        btnMenu03.setTypeface(font);
        btnMenu03.setText("\uF017  ORDEM DE SERVIÇO");
        btnMenu03.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

        btnMenu04 = findViewById(R.id.btnMenu04);
        btnMenu04.setTypeface(font);
        btnMenu04.setText("\uF080  RELATÓRIO");
        btnMenu04.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

        btnMenu05 = findViewById(R.id.btnMenu05);
        btnMenu05.setTypeface(font);
        btnMenu05.setText("\uf234  CLIENTE");
        btnMenu05.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);

        btnMenu06 = findViewById(R.id.btnMenu06);
        btnMenu06.setTypeface(font);
        btnMenu06.setText("\uf08b  SAIR");
        btnMenu06.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);


        btnMenu06.setOnClickListener(view -> {
            // Crie uma intenção para abrir a nova Activity
            Intent intent = new Intent(this, LoginActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            // Inicie a nova Activity
            startActivity(intent);
            // Feche a LoginActivity
            finish();
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}