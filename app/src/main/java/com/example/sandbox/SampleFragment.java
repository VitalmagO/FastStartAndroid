package com.example.sandbox;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SampleFragment extends Fragment {
    private static final String ARG_NAME = "arg_name";
    private static final String ARG_COLOR = "arg_color";

    private String mName;
    private int mColor;
    private TextView mTextView;

    public static SampleFragment newInstance(String name, int color) {  //Передаем строку текста для TextView и цвет, которым красим корневой лейаут
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putInt(ARG_COLOR, color);
        SampleFragment fragment = new SampleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) { //Достаем значения
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            mName = args.getString(ARG_NAME);
            mColor = args.getInt(ARG_COLOR);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_sample, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) { //Применяем значения
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.tv_sample);
        mTextView.setText(mName);
        view.setBackgroundColor(mColor);
    }
}
