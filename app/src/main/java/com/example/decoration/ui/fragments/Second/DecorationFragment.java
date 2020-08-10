package com.example.decoration.ui.fragments.Second;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.example.decoration.R;
import com.example.decoration.base.BaseMainFragment;
import com.example.decoration.ui.fragments.Third.CircleFragment;
/**
 * Created by fay on 20/8/1.
 */
public class DecorationFragment extends BaseMainFragment {
    public static DecorationFragment newInstance() {
        Bundle args = new Bundle();
        DecorationFragment fragment = new DecorationFragment();
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
        View view = inflater.inflate(R.layout.decorationfragment, container, false);
        return view;
    }
}
