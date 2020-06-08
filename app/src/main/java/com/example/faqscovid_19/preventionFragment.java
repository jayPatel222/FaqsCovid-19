package com.example.faqscovid_19;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class preventionFragment extends Fragment {

    View viewLocal;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Toolbar toolbar = Objects.requireNonNull(getActivity()).findViewById(R.id.toolbar);
        TextView toolbarTitle = toolbar.findViewById(R.id.toolbar_title);
        getActivity().setTitle(null);
        toolbarTitle.setText(R.string.prevention);

        viewLocal = inflater.inflate(R.layout.fragment_preventions, container, false);

        return viewLocal;
    }
}

