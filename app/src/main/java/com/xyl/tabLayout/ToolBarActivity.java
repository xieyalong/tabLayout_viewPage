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


import com.xyl.tabLayout.view.SegmentView;
import com.xyl.tabLayout.view.btb.BottomThirdBar;
import com.xyl.tabLayout.view.tab.ScrollTab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolBarActivity extends FragmentActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_ui_activity_toolbar);
        initBtBar();

        initSegment();

        ScrollTab[] scrollTab0 = new ScrollTab[]{(ScrollTab) findViewById(R.id.stab_tab00), (ScrollTab) findViewById(R.id.stab_tab01), (ScrollTab) findViewById(R.id.stab_tab02)};
        ScrollTab[] scrollTab1 = new ScrollTab[]{(ScrollTab) findViewById(R.id.stab_tab10), (ScrollTab) findViewById(R.id.stab_tab11), (ScrollTab) findViewById(R.id.stab_tab12)};
        ViewPager pager0 = (ViewPager) findViewById(R.id.pager0);
        ViewPager pager1 = (ViewPager) findViewById(R.id.pager1);
        initScrollTab(scrollTab0, pager0, Arrays.asList("Kitkat", "Lollipop", "M"));
        initScrollTab(scrollTab1, pager1, Arrays.asList("Peach", "Lemon", "Watermelon", "Pear", "Avocado",
                "Banana", "Grape", "Apricot", "Orange", "Kumquat"));
    }

    private void initBtBar() {
        BottomThirdBar[] btbBars = new BottomThirdBar[]{
                findViewById(R.id.btb_bar0),
                findViewById(R.id.btb_bar1),
                findViewById(R.id.btb_bar2),
                findViewById(R.id.btb_bar3)};
        btbBars[0].create(Arrays.asList(
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_SHARE, R.drawable.lib_pub_ic_btb_icon,"分享"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_DOWNLOAD, R.drawable.lib_pub_ic_btb_icon, "下载")),
                new BottomThirdBar.OnClickListener() {
                    @Override
                    public void onClick(int position, BottomThirdBar.Item item) {

                    }
                });
        btbBars[1].create(Arrays.asList(
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_SHARE, R.drawable.lib_pub_ic_btb_icon, "分享"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_DOWNLOAD, R.drawable.lib_pub_ic_btb_icon, "下载"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_MOVE, R.drawable.lib_pub_ic_btb_icon,"移动")
        ), new BottomThirdBar.OnClickListener() {
            @Override
            public void onClick(int position, BottomThirdBar.Item item) {

            }
        });
        btbBars[2].create(Arrays.asList(
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_SHARE, R.drawable.lib_pub_ic_btb_icon, "分享"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_DOWNLOAD, R.drawable.lib_pub_ic_btb_icon, "下载"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_MOVE, R.drawable.lib_pub_ic_btb_icon,"移动"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_DELETE, R.drawable.lib_pub_ic_btb_icon, "删除"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_RENAME, R.drawable.lib_pub_ic_btb_icon, "重命名"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon,"详情")),
                new BottomThirdBar.OnClickListener() {
                    @Override
                    public void onClick(int position, BottomThirdBar.Item item) {

                    }
                });
        btbBars[3].create(Arrays.asList(
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.drawable.lib_pub_ic_btb_icon, "标签")),
                new BottomThirdBar.OnClickListener() {
                    @Override
                    public void onClick(int position, BottomThirdBar.Item item) {

                    }
                });
    }

    private void initSegment() {
        SegmentView svTab0 = (SegmentView) findViewById(R.id.sv_tab0);
        svTab0.setTitles(Arrays.asList("标签一",
                "标签二"));
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
        pager.addOnPageChangeListener(this);
        for (ScrollTab tab : tabs) {
            tab.setTitles(titles);
            tab.setNumber(1, "9", View.VISIBLE);//Set the red dot
            tab.setViewPager(pager);
            tab.setOnTabListener(new ScrollTab.OnTabListener() {
                @Override
                public void onChange(int index, View v) {
                    pager.setCurrentItem(index, true);
                }
            });
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View view) {

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
            tvContent.setText(getArguments() != null ? "" + getArguments().getInt("index") : "");
            return rootView;
        }


    }
}
