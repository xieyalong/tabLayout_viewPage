package com.xyl.tabLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.xyl.tabLayout.view.btb.BottomThirdBar;

import java.util.Arrays;

public class BottomThirdBar_Activity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_third_bar);
        BottomThirdBar[] btbBars = new BottomThirdBar[]{
                findViewById(R.id.btb_bar0),
                findViewById(R.id.btb_bar1),
                findViewById(R.id.btb_bar2),
                findViewById(R.id.btb_bar3)};
        btbBars[0].create(Arrays.asList(
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_SHARE, R.mipmap.ic_launcher,"分享"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_DOWNLOAD, R.mipmap.ic_launcher, "下载")),
                new BottomThirdBar.OnClickListener() {
                    @Override
                    public void onClick(int position, BottomThirdBar.Item item) {

                    }
                });
        btbBars[1].create(Arrays.asList(
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_SHARE, R.mipmap.ic_launcher, "分享"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_DOWNLOAD, R.mipmap.ic_launcher, "下载"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_MOVE, R.mipmap.ic_launcher,"移动")
        ), new BottomThirdBar.OnClickListener() {
            @Override
            public void onClick(int position, BottomThirdBar.Item item) {

            }
        });
        btbBars[2].create(Arrays.asList(
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_SHARE, R.mipmap.ic_launcher, "分享"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_DOWNLOAD, R.mipmap.ic_launcher, "下载"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_MOVE, R.mipmap.ic_launcher,"移动"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_DELETE, R.mipmap.ic_launcher, "删除"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_RENAME, R.mipmap.ic_launcher, "重命名"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.mipmap.ic_launcher,"详情")),
                new BottomThirdBar.OnClickListener() {
                    @Override
                    public void onClick(int position, BottomThirdBar.Item item) {

                    }
                });
        btbBars[3].create(Arrays.asList(
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.mipmap.ic_launcher, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.mipmap.ic_launcher, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.mipmap.ic_launcher, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.mipmap.ic_launcher, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.mipmap.ic_launcher, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.mipmap.ic_launcher, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.mipmap.ic_launcher, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.mipmap.ic_launcher, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.mipmap.ic_launcher, "标签"),
                new BottomThirdBar.Item(BottomThirdBar.Item.TYPE_INFO, R.mipmap.ic_launcher, "标签")),
                new BottomThirdBar.OnClickListener() {
                    @Override
                    public void onClick(int position, BottomThirdBar.Item item) {

                    }
                });
    }

}
