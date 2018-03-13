package com.lizheng.lottery.view.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseActivity;
import com.lizheng.lottery.base.BaseFragment;
import com.lizheng.lottery.view.fragment.FindFragment;
import com.lizheng.lottery.view.fragment.FollowFragment;
import com.lizheng.lottery.view.fragment.PersonFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private FrameLayout frameLayout;
    private RadioGroup mRadioGroup;
    private ArrayList<BaseFragment> mFragments;
    private int position = 0;
    private TextView titleTxt;
    /**
     * 缓存的fragment
     */
    private BaseFragment tempFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();
    }

    private void initView() {
        mRadioGroup = findViewById(R.id.rg_main);
        frameLayout = findViewById(R.id.frameLayout);
        titleTxt = findViewById(R.id.txt_title);
    }
    private void initData() {
        mFragments = new ArrayList<>();
        mFragments.add(new FollowFragment());
        mFragments.add(new FindFragment());
        mFragments.add(new PersonFragment());

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.rb_follow: //已关注
                        position = 0;
                        titleTxt.setText("已关注");
                        break;
                    case R.id.rb_find: //发现
                        position = 1;
                        titleTxt.setText("发现");
                        break;
                    case R.id.rb_person: //个人
                        position = 2;
                        titleTxt.setText("我");
                        break;
                    default:
                        position = 0;
                        break;
                }
                BaseFragment baseFragment = getFragment(position);

                switchFragemnt(tempFragment,baseFragment);
            }
        });
        mRadioGroup.check(R.id.rb_follow);
    }

    /**
     * 切换Fragment
     * @param tempFragment
     * @param baseFragment
     */
    private void switchFragemnt(BaseFragment fromFragment, BaseFragment nextFragment) {
        if(tempFragment != nextFragment) {
            tempFragment = nextFragment;
            if (nextFragment != null) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                if (!nextFragment.isAdded()) {
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.add(R.id.frameLayout, nextFragment).commit();
                } else {
                    if (fromFragment != null) {
                        transaction.hide(fromFragment);
                    }
                    transaction.show(nextFragment).commit();
                }
            }
        }

    }

    /**
     * 获取指定位置fragment
     * @param position
     * @return
     */
    private BaseFragment getFragment(int position) {
        if(mFragments != null && mFragments.size()>0){
            BaseFragment baseFragment = mFragments.get(position);
            return baseFragment;
        }
        return null;
    }

}
