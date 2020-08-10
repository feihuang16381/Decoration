package com.example.decoration.ui.fragments.First;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.example.decoration.R;
import com.example.decoration.adapter.PagerFragmentAdapter;
import com.example.decoration.base.BaseMainFragment;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import scut.carson_ho.searchview.SearchView;


/**
 * Created by fay on 20/8/1.
 */
public class ViewPagerFragment extends BaseMainFragment {
    private TabLayout mTab;
    private ViewPager mViewPager;
    private SearchView searchView;

    public static ViewPagerFragment newInstance() {

        Bundle args = new Bundle();

        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_pager, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
      //  searchView = (SearchView) view.findViewById(R.id.search_view);
        mTab = (TabLayout) view.findViewById(R.id.tab);
        mViewPager = (ViewPager) view.findViewById(R.id.viewPager);

        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());
        mTab.addTab(mTab.newTab());

        mViewPager.setAdapter(new PagerFragmentAdapter(getChildFragmentManager(),
                "关注","推荐", "艺术漆",
                "3D案例","客厅"));
        mTab.setupWithViewPager(mViewPager);
    }

    @Override
    public int getLayoutId() {
     //   initView(view);
        return R.layout.fragment_first_pager;
    }
}
