package com.example.decoration.ui.fragments.First;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.example.decoration.R;
import com.example.decoration.base.BaseMainFragment;
/**
 * Created by fay on 20/8/1.
 */
public class FirstPageFragment extends BaseMainFragment {
    @Override
    public int getLayoutId() {
        return 0;
    }
    public static FirstPageFragment newInstance() {
        Bundle args = new Bundle();
        FirstPageFragment fragment = new FirstPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firstpagefragment, container, false);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (findChildFragment(ViewPagerFragment.class) == null) {
            loadRootFragment(R.id.fl_second_container, ViewPagerFragment.newInstance());
        }
    }


}
