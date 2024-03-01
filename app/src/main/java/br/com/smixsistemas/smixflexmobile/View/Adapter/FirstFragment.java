package br.com.smixsistemas.smixflexmobile.View.Adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import br.com.smixsistemas.smixflexmobile.R;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        // Construtor padrão necessário
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar o layout do fragmento aqui
        return inflater.inflate(R.layout.fragment_first, container, false);
    }
}