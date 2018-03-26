package com.lizheng.lottery.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseActivity;
import com.lizheng.lottery.view.adapter.GameFragmentAdapter;
import com.lizheng.lottery.view.fragment.game.FirstGameFramgment;
import com.lizheng.lottery.view.fragment.game.SecondGameFragment;
import com.lizheng.lottery.view.fragment.game.ThirdGameFragment;

import java.util.ArrayList;

public class PopupWindowActivity extends BaseActivity implements View.OnClickListener,FirstGameFramgment.FragmentInteraction,ThirdGameFragment.FragmentInteraction,SecondGameFragment.FragmentInteraction {
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        initView();
        initData();

    }

    private void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new FirstGameFramgment());
        mFragments.add(new SecondGameFragment());
        mFragments.add(new ThirdGameFragment());
        mViewPager.setAdapter(new GameFragmentAdapter(getSupportFragmentManager(),mFragments));
    }

    private void initView() {
        mViewPager = findViewById(R.id.viewpager_game);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        finish();
        return true;
    }

    @Override
    public void onClick(View view) {

    }
    /**
     * FirstGameFramgment返回数据的回调
     * @param position
     */
    @Override
    public void OnFirstGameItemClick(int position) {

    }
    /**
     * ThirdGameFramgment返回数据的回调
     * @param position
     */

    @Override
    public void OnThirdGameItemClick(int position) {

    }
    /**
     * SecondGameFramgment返回数据的回调
     * @param position
     */
    @Override
    public void OnSecondGameItemClick(int position) {

    }
}
