package com.lizheng.lottery.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseActivity;
import com.lizheng.lottery.utils.ActivityController;


public class GameActivity extends BaseActivity implements View.OnClickListener{

    private Button btn_cathectic;
    private Button btn_send_message;
    private ImageButton btn_back;
    private ImageButton btn_person;
    private TextView tv_title;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    private void initView() {
        btn_cathectic = findViewById(R.id.btn_cathectic);
        btn_send_message = findViewById(R.id.btn_game_send_message);
        btn_back = findViewById(R.id.btn_bcak);
        btn_person = findViewById(R.id.btn_person);
        tv_title = findViewById(R.id.txt_title);

        btn_back.setVisibility(View.VISIBLE);
        btn_person.setVisibility(View.VISIBLE);
    }

    private void initData() {
        btn_person.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        btn_cathectic.setOnClickListener(this);
        btn_send_message.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_bcak:
                finish();
                ActivityController.removeActivity(this);
                break;
            case R.id.btn_person:
                Intent intentPerson = new Intent(this,FollowDetailActivity.class);
                intentPerson.putExtra("isFollowed",true);
                startActivity(intentPerson);
                break;
            case R.id.btn_cathectic:
                Intent intentPopupWindow = new Intent(this,PopupWindowActivity.class);
                startActivity(intentPopupWindow);
                break;
            case R.id.btn_game_send_message:
                Intent intent = new Intent(this,ChatActivity.class);
                startActivity(intent);
                finish();
                ActivityController.removeActivity(this);
                break;
            default:
                break;
        }
    }
}
