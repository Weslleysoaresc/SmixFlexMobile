package br.com.smixsistemas.smixflexmobile.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.smixsistemas.smixflexmobile.R;

public class TabAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentTitleList = new ArrayList<>();
    private final List<String> fragmentIconList = new ArrayList<>();

    public TabAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public void addFragment(Fragment fragment, String title, String icon) {
        fragmentList.add(fragment);
        fragmentTitleList.add(title);
        fragmentIconList.add(icon);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitleList.get(position);
    }

    public View getTabView(int position, Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_item, null);
        TextView textViewIcon = view.findViewById(R.id.textViewIcon);
        TextView textViewTitle = view.findViewById(R.id.textViewTitle);

        // Define o ícone do Font Awesome
        String icon = fragmentIconList.get(position);
        textViewIcon.setText(icon);

        // Define o título da guia
        String title = fragmentTitleList.get(position);
        textViewTitle.setText(title);

        return view;
    }
}