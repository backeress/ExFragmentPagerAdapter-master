package com.sung.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sung.R;
import com.sung.fragment.FragmentOne;
import com.sung.fragment.FragmentThree;
import com.sung.fragment.FragmentTwo;

/**
 * Created by sung on 2017-11-02.
 */

public class FragmentViewPagerActivity extends AppCompatActivity {

    //프래그먼트 아이디
    enum emFRAGMENT_ID {
        ONE,
        TWO,
        THREE
    }

    //뷰페이저
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_fragment_viewpager);

        //레이아웃 뷰 인스턴스
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText("기본 프래그먼트 뷰페이저");
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        Button btnOne = (Button) findViewById(R.id.btnOne);
        Button btnTwo = (Button) findViewById(R.id.btnTwo);
        Button btnThree = (Button) findViewById(R.id.btnThree);


        //뷰페이저 아답터 생성 및 연동
        this.viewPager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        //뷰페이저 첫번째 선택
        this.viewPager.setCurrentItem(0);


        //버튼 클릭 이벤트 연결 및 태그 초기화
        btnOne.setOnClickListener(onClickListener);
        btnOne.setTag(emFRAGMENT_ID.ONE);
        btnTwo.setOnClickListener(onClickListener);
        btnTwo.setTag(emFRAGMENT_ID.TWO);
        btnThree.setOnClickListener(onClickListener);
        btnThree.setTag(emFRAGMENT_ID.THREE);





    }


    //버튼 이벤트 리스너
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //프래그먼트 아이디를 가져온다.
            emFRAGMENT_ID tag = (emFRAGMENT_ID) v.getTag();
            //프래그먼트에 아이디를 선택 한다.
            viewPager.setCurrentItem(tag.ordinal());
        }
    };


    //페이저 아답터
    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        //포지션의 프래그먼트 반환
        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new FragmentOne();
                case 1:
                    return new FragmentTwo();
                case 2:
                    return new FragmentThree();
                default:
                    return null;
            }
        }

        //프래그먼트 아이템 수
        @Override
        public int getCount() {
            return 3;
        }
    }
}
