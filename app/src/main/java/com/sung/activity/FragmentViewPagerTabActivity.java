package com.sung.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sung.R;
import com.sung.fragment.FragmentOne;
import com.sung.fragment.FragmentThree;
import com.sung.fragment.FragmentTwo;
import com.sung.lib.adapter.ExFragmentPagerAdapter;

/**
 * Created by sung on 2017-11-02.
 */

public class FragmentViewPagerTabActivity extends AppCompatActivity {


    //뷰페이저
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fragment_viewpager_tab);


        //레이아웃 뷰 인스턴스
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText("프래그먼트 뷰페이저 탭");
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);



        //탭
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //탭/뷰페이저 변경 이벤트 연동
        this.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //탭 변경 이벤트
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //뷰페이저 아답터 생성
        ExFragmentPagerAdapter viewPagerAdapter = new ExFragmentPagerAdapter(getSupportFragmentManager());

        //프래그먼트 추가
        viewPagerAdapter.addItem(new FragmentOne(), "일");
        viewPagerAdapter.addItem(new FragmentTwo(), "이");
        viewPagerAdapter.addItem(new FragmentThree(), "삼");

        //뷰페이저 아덥터 연동
        this.viewPager.setAdapter(viewPagerAdapter);
        //뷰페이저 첫번째 선택
        this.viewPager.setCurrentItem(0);


    }

}