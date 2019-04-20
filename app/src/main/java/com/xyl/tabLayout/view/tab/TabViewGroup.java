package com.xyl.tabLayout.view.tab;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xyl.tabLayout.R;


/**
 * TabViewGroup
 * Created by D on 2017/8/25.
 */
public class TabViewGroup extends RelativeLayout implements TabView {
    private Context mContext;
    private TextView mTvTitle, mTvNumber;
    private int mTextColor; // Title文字颜色
    private int mTextColorFocus; // Title文字颜色
    public TabViewGroup(Context context) {
        super(context);
        init(context);
    }
    public TabViewGroup(Context context,int mTextColor,int mTextColorFocus) {
        super(context);
        this.mTextColorFocus=mTextColorFocus;
        this.mTextColor=mTextColor;
        init(context);

    }

    public TabViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View root = LayoutInflater.from(context).inflate(R.layout.lib_pub_view_tab, this);
        mTvTitle = (TextView) root.findViewById(R.id.tv_title);
        mTvNumber = (TextView) root.findViewById(R.id.tv_number);
    }

    @Override
    public void setText(String text) {
        mTvTitle.setText(text);
    }

    @Override
    public void setPadding(int padding) {
        setPadding(padding, 0, padding, 0);
    }

    @Override
    public void setNumber(String text, int visibility) {
        mTvNumber.setText(text);
        mTvNumber.setVisibility(visibility);
    }

    @Override
    public void notifyData(boolean focus,int mTextColor,int mTextColorFocus) {
        int color=0;
        if (focus){
            color=ContextCompat.getColor(mContext,mTextColor);
        }else{
            color=ContextCompat.getColor(mContext,mTextColorFocus);
        }
//        mTvTitle.setTextColor(ContextCompat.getColor(mContext, focus ? R.color.colorAccent : R.color.colorPrimary));
        mTvTitle.setTextColor(color);

    }

    @Override
    public void onScroll(float factor) {

    }
}
