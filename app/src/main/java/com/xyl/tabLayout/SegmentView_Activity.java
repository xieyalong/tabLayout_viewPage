package com.xyl.tabLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.xyl.tabLayout.view.SegmentView;

import java.util.Arrays;

public class SegmentView_Activity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segment_view);
        SegmentView svTab0 = (SegmentView) findViewById(R.id.sv_tab0);
        svTab0.setTitles(Arrays.asList("标签一", "标签二"));
    }
}
