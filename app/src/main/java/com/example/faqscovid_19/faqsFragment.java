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

        topics = Objects.requireNonNull(getActivity()).getResources().getStringArray(R.array.faq_topics);
        questions_topic_1 = Objects.requireNonNull(getActivity()).getResources().getStringArray(R.array.faq_questions_topic_1);
        questions_topic_2 = Objects.requireNonNull(getActivity()).getResources().getStringArray(R.array.fq_questions_topic_2);
        answers_topic_1 = Objects.requireNonNull(getActivity()).getResources().getStringArray(R.array.faq_answers_topic_1);
        answers_topic_2 = Objects.requireNonNull(getActivity()).getResources().getStringArray(R.array.faq_answers_topic_2);

        questions.add(questions_topic_1);
        questions.add(questions_topic_2);
        answers_1.put(questions_topic_1[0], answers_topic_1[0]);
        answers_1.put(questions_topic_1[1], answers_topic_1[1]);
        answers_2.put(questions_topic_2[0], answers_topic_2[0]);
        answers_2.put(questions_topic_2[1], answers_topic_2[1]);
        answers_2.put(questions_topic_2[2], answers_topic_2[2]);

        data.add(answers_1);
        data.add(answers_2);

        myExpandable = viewLocal.findViewById(R.id.faq_expandable_textView);
        adapter = new ExpandableTextViewAdapter(getContext());
        myExpandable.setAdapter(adapter);

        return viewLocal;
    }
}