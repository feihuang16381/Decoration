package com.example.decoration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.decoration.base.BaseMainFragment;
import com.example.decoration.ui.fragments.First.FirstPageFragment;
import com.example.decoration.ui.fragments.Fourth.PersonFragment;
import com.example.decoration.ui.fragments.Second.DecorationFragment;
import com.example.decoration.ui.fragments.Third.CircleFragment;
import com.example.decoration.ui.view.BottomBar;
import com.example.decoration.ui.view.BottomBarTab;
import com.next.easynavigation.view.EasyNavigationBar;

import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportFragment;
/**
 * Created by fay on 20/8/1.
 */
public class MainActivity extends SupportActivity implements BaseMainFragment.OnBackToFirstListener {
    public static final int FIRST = 0;
    public static final int SECOND = 1;
    public static final int THIRD = 2;
    public static final int FOURTH = 3;
    public static final int FIFTH = 4;
    private EasyNavigationBar navigationBar;
    private String[] tabText = {"首页", "装饰","圈子", "我的"};
    //未选中icon
    private int[] normalIcon = {R.mipmap.firstpage, R.mipmap.deco, R.mipmap.circle, R.mipmap.mi};
    //选中时icon
    private int[] selectIcon = {R.mipmap.firstpage2, R.mipmap.deco2, R.mipmap.circle2, R.mipmap.mi2};
    private SupportFragment[] mFragments = new SupportFragment[4];


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportFragment firstFragment = findFragment(FirstPageFragment.class);
        if (firstFragment == null) {
            mFragments[FIRST] = FirstPageFragment.newInstance();
            mFragments[SECOND] = PersonFragment.newInstance();
            mFragments[THIRD] = DecorationFragment.newInstance();
            mFragments[FOURTH] = CircleFragment.newInstance();


            loadMultipleRootFragment(R.id.fl_container, FIRST,
                    mFragments[FIRST],
                    mFragments[SECOND],
                    mFragments[THIRD],
                    mFragments[FOURTH]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题

            // 这里我们需要拿到mFragments的引用
            mFragments[FIRST] = firstFragment;
            mFragments[SECOND] = findFragment(PersonFragment.class);
            mFragments[THIRD] = findFragment(DecorationFragment.class);
            mFragments[FOURTH] = findFragment(CircleFragment.class);
        }
        initView();
    }

    private void initView() {
        /*mBottomBar = (BottomBar) findViewById(R.id.bottomBar);
        mBottomBar.addItem(new BottomBarTab(this, R.drawable.ic_message_white_24dp))
                .addItem(new BottomBarTab(this, R.drawable.ic_record_voice_over))
                .addItem(new BottomBarTab(this, R.drawable.ic_chrome_reader_mode))
                .addItem(new BottomBarTab(this, R.drawable.ic_notifications))
                .addItem(new BottomBarTab(this,R.drawable.ic_account_circle_white_24dp));

        mBottomBar.setOnTabSelectedListener(new BottomBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, int prePosition) {
                showHideFragment(mFragments[position], mFragments[prePosition]);
            }
            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });*/
          navigationBar= findViewById(R.id.bottomBar);

        navigationBar.defaultSetting()  //恢复默认配置、可用于重绘导航栏
                .titleItems(tabText)      //  Tab文字集合  只传文字则只显示文字
                .normalIconItems(normalIcon)   //  Tab未选中图标集合
                .selectIconItems(selectIcon)   //  Tab选中图标集合
                .fragmentList(null)       //  fragment集合
                .fragmentManager(getSupportFragmentManager())
                .iconSize(20)     //Tab图标大小
                .tabTextSize(10)   //Tab文字大小
                .tabTextTop(2)     //Tab文字距Tab图标的距离
                .normalTextColor(Color.parseColor("#666666"))   //Tab未选中时字体颜色
                .selectTextColor(Color.parseColor("#1296db"))   //Tab选中时字体颜色
                .scaleType(ImageView.ScaleType.CENTER_INSIDE)  //同 ImageView的ScaleType
                .navigationBackground(Color.parseColor("#FFFFFF"))   //导航栏背景色
                .setOnTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabSelectEvent(View view, int position) {
                        //Tab点击事件  return true 页面不会切换
                        showHideFragment(mFragments[position]);
                        return false;
                    }

                    @Override
                    public boolean onTabReSelectEvent(View view, int position) {
                        //Tab重复点击事件
                        return false;
                    }
                })
                .smoothScroll(false)  //点击Tab  Viewpager切换是否有动画
                .canScroll(true)    //Viewpager能否左右滑动
                .mode(EasyNavigationBar.NavigationMode.MODE_ADD)   //默认MODE_NORMAL 普通模式  //MODE_ADD 带加号模式
                .centerTextStr("")
                .centerImageRes(R.mipmap.add)
                .centerIconSize(36)    //中间加号图片的大小
                .centerLayoutHeight(36)   //包含加号的布局高度 背景透明  所以加号看起来突出一块
                .navigationHeight(60)  //导航栏高度
                .lineHeight(10)         //分割线高度  默认1px
                .lineColor(Color.parseColor("#ff0000"))
                .centerLayoutRule(EasyNavigationBar.RULE_BOTTOM) //RULE_CENTER 加号居中addLayoutHeight调节位置 EasyNavigationBar.RULE_BOTTOM 加号在导航栏靠下
                .centerLayoutBottomMargin(0)   //加号到底部的距离
                .hasPadding(true)    //true ViewPager布局在导航栏之上 false有重叠
                .hintPointLeft(-3)  //调节提示红点的位置hintPointLeft hintPointTop（看文档说明）
                .hintPointTop(-3)
                .hintPointSize(6)    //提示红点的大小
                .msgPointLeft(-10)  //调节数字消息的位置msgPointLeft msgPointTop（看文档说明）
                .msgPointTop(-10)
                .msgPointTextSize(9)  //数字消息中字体大小
                .msgPointSize(18)    //数字消息红色背景的大小
                .centerAlignBottom(true)  //加号是否同Tab文字底部对齐  RULE_BOTTOM时有效；
                .centerTextTopMargin(0)  //加号文字距离加号图片的距离
                .centerTextSize(15)      //加号文字大小
                .centerNormalTextColor(Color.parseColor("#ff0000"))    //加号文字未选中时字体颜色
                .centerSelectTextColor(Color.parseColor("#00ff00"))    //加号文字选中时字体颜色
                .setMsgPointColor(Color.BLUE) //数字消息、红点背景颜色
                .setMsgPointMoreRadius(5) //消息99+角度半径
                .setMsgPointMoreWidth(50)  //消息99+宽度
                .setMsgPointMoreHeight(40)  //消息99+高度
                .textSizeType(EasyNavigationBar.TextSizeType.TYPE_DP)  //字体单位 建议使用DP  可切换SP
                .setOnTabLoadListener(new EasyNavigationBar.OnTabLoadListener() { //Tab加载完毕回调
                    @Override
                    public void onTabLoadCompleteEvent() {

                        navigationBar.setHintPoint(4, true);
                    }
                })
                //.setupWithViewPager() ViewPager或ViewPager2
                .build();
    }

    @Override
    public void onBackPressedSupport() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            pop();
        } else {
            ActivityCompat.finishAfterTransition(this);
        }
    }

    @Override
    public void onBackToFirstFragment() {
       // mBottomBar.setCurrentItem(0);
    }


}

