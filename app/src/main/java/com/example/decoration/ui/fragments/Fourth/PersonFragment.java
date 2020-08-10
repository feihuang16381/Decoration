package com.example.decoration.ui.fragments.Fourth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.decoration.R;
import com.example.decoration.base.BaseBackFragment;
/**
 * Created by fay on 20/8/1.
 */
public class PersonFragment extends BaseBackFragment {
    public static PersonFragment newInstance() {
        Bundle args = new Bundle();
        PersonFragment fragment = new PersonFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personfragment, container, false);
        return view;
    }

}
