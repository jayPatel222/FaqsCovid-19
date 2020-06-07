package com.example.faqscovid_19;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class faqsFragment extends Fragment {

    String[] topics;
    String[] questions_topic_1;
    String[] questions_topic_2;
    String[] answers_topic_1;
    String[] answers_topic_2;

    LinkedHashMap<String, String> answers_1 = new LinkedHashMap<>();
    LinkedHashMap<String, String> answers_2 = new LinkedHashMap<>();
    List<String[]> questions = new ArrayList<>();
    List<LinkedHashMap<String, String>> data = new ArrayList<>();

    View viewLocal;
    ExpandableListView myExpandable;
    ExpandableTextViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        viewLocal = inflater.inflate(R.layout.fragment_faq, container, false);

        myExpandable = viewLocal.findViewById(R.id.faq_expandable_textView);
        adapter = new ExpandableTextViewAdapter(getContext());
        myExpandable.setAdapter(adapter);

        return viewLocal;
    }
}