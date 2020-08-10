package com.example.decoration.ui.fragments.Third;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.decoration.R;
import com.example.decoration.base.BaseMainFragment;
import com.example.decoration.ui.fragments.Fourth.PersonFragment;
/**
 * Created by fay on 20/8/1.
 */
public class CircleFragment extends BaseMainFragment {
    public static CircleFragment newInstance() {
        Bundle args = new Bundle();
        CircleFragment fragment = new CircleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.circlefragment, container, false);
        return view;
    }
}
