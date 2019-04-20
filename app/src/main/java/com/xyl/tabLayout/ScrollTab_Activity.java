package com.xyl.tabLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xyl.tabLayout.view.tab.ScrollTab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScrollTab_Activity extends FragmentActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_tab);
        //第一个viewpage布局
        ScrollTab[] scrollTab0 = new ScrollTab[]{
                (ScrollTab) findViewById(R.id.stab_tab00),
                (ScrollTab) findViewById(R.id.stab_tab01),
                (ScrollTab) findViewById(R.id.stab_tab02)};
        ViewPager pager0 = (ViewPager) findViewById(R.id.pager0);
        initScrollTab(scrollTab0, pager0, Arrays.asList("Kitkat", "Lollipop", "M"));

        //第二个viewpage布局
        ScrollTab[] scrollTab1 = new ScrollTab[]{
                (ScrollTab) findViewById(R.id.stab_tab10),
                (ScrollTab) findViewById(R.id.stab_tab11),
                (ScrollTab) findViewById(R.id.stab_tab12)};
        ViewPager pager1 = (ViewPager) findViewById(R.id.pager1);
        initScrollTab(scrollTab1, pager1, Arrays.asList("Peach", "Lemon", "Watermelon", "Pear", "Avocado",
                "Banana", "Grape", "Apricot", "Orange", "Kumquat"));
    }

    private void initScrollTab(ScrollTab[] tabs, final ViewPager pager, List<String> titles) {
        final ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            TabFragment fragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", i);
            fragment.setArguments(bundle);
            fragments.add(fragment);
        }
        FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return fragments.get(arg0);
            }
        };
        pager.setOffscreenPageLimit(titles.size() - 1);
        pager.setAdapter(fragmentPagerAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        for (ScrollTab tab : tabs) {
            tab.setTitles(titles);
            //title上的红点数字
            tab.setNumber(1, "90", View.VISIBLE);
            tab.setViewPager(pager);
            tab.setOnTabListener(new ScrollTab.OnTabListener() {
                @Override
                public void onChange(int index, View v) {
                    pager.setCurrentItem(index, true);
                }
            });
        }
    }



    public static class TabFragment extends Fragment {
        private View rootView;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            super.onCreateView(inflater, container, savedInstanceState);
            if (rootView == null) {
                rootView = new TextView(getActivity());
            } else {
                if (rootView.getParent() != null) {
                    ((ViewGroup) rootView.getParent()).removeView(rootView);
                }
            }

            TextView tvContent = (TextView) rootView;
            tvContent.setGravity(Gravity.CENTER);
            tvContent.setText("viewPage="+(getArguments() != null ? "" + getArguments().getInt("index") : ""));
            return rootView;
        }


    }
}
