package com.example.decoration.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.bryant.editlibrary.BSearchEdit;
import com.example.decoration.R;

import java.util.ArrayList;

import me.yokeyword.fragmentation.SupportFragment;
import scut.carson_ho.searchview.ICallBack;
import scut.carson_ho.searchview.SearchView;
import scut.carson_ho.searchview.bCallBack;


/**
 * 懒加载
 * Created by YoKeyword on 16/6/5.
 */
public abstract class BaseMainFragment extends SupportFragment {
    protected OnBackToFirstListener _mBackToFirstListener;
    private SearchView searchView;
    private  BSearchEdit bSearchEdit;
    private ArrayList<String> list;
    public abstract int getLayoutId();
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBackToFirstListener) {
            _mBackToFirstListener = (OnBackToFirstListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnBackToFirstListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.basefragment, container, false);
        int childLayId = getLayoutId();
        View  chidView =inflater.inflate(R.layout.basefragment, null, false);
     //   View chidView = LayoutInflater.from(this).inflate(childLayId,null);

       /* if(childLayId > 0){
            FrameLayout content = chidView.findViewById(R.id.base_fl_content);
            content.addView(chidView);
        }*/

      //  initview(chidView);
        return chidView;
    }
   /* public  void  initview(View view){
        searchView = (SearchView) view.findViewById(R.id.search_view);
        // 4. 设置点击键盘上的搜索按键后的操作（通过回调接口）
        // 参数 = 搜索框输入的内容
       *//* searchView.setOnClickSearch(new ICallBack() {
            @Override
            public void SearchAciton(String string) {
                System.out.println("我收到了" + string);
            }
        });*//*

       *//* // 5. 设置点击返回按键后的操作（通过回调接口）
        searchView.setOnClickBack(new bCallBack() {
            @Override
            public void BackAciton() {
                //finish();
            }
        });*//*

    }*/

    @Override
    public void onDetach() {
        super.onDetach();
        _mBackToFirstListener = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    /**
     * 处理回退事件
     *
     * @return
     */
    @Override
    public boolean onBackPressedSupport() {
        if (getChildFragmentManager().getBackStackEntryCount() > 1) {
            popChild();
        } else {
          /*  if (this instanceof ZhihuSecondFragment) {   // 如果是 第一个Fragment 则退出app
                _mActivity.finish();
            } else {                                    // 如果不是,则回到第一个Fragment
                _mBackToFirstListener.onBackToFirstFragment();
            }*/
        }
        return true;
    }

    public interface OnBackToFirstListener {
        void onBackToFirstFragment();
    }
}
