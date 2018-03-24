package com.lizheng.lottery.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseActivity;
import com.lizheng.lottery.utils.ActivityController;
import com.lizheng.lottery.utils.ButtomDialog;

public class FollowDetailActivity extends BaseActivity implements View.OnClickListener {
    private TextView tv_title;
    private ImageButton btn_back;
    private ImageButton btn_person;
    private ImageButton btn_menu;
    private Button btn_access;
    private Button btn_send_message;
    private Button btn_follow;
    private ButtomDialog buttomDialog;
    private boolean isFollowed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_detail);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }


    private void initView() {
        tv_title = findViewById(R.id.txt_title);
        btn_back = findViewById(R.id.btn_bcak);
        btn_menu = findViewById(R.id.btn_menu);
        btn_access = findViewById(R.id.btn_access);
        btn_send_message = findViewById(R.id.btn_send_message);
        btn_follow = findViewById(R.id.btn_follow);
        tv_title.setText("详情资料");
        btn_back.setVisibility(View.VISIBLE);
    }

    private void initData() {
        Intent intent = getIntent();
        isFollowed = intent.getBooleanExtra("isFollowed",false);
        btn_back.setOnClickListener(this);
        btn_menu.setOnClickListener(this);
        isFollowed(isFollowed);
    }

    private void isFollowed(boolean isFollowed) {
        if(isFollowed){
            btn_follow.setVisibility(View.GONE);
            btn_access.setVisibility(View.VISIBLE);
            btn_send_message.setVisibility(View.VISIBLE);
            btn_menu.setVisibility(View.VISIBLE);
            btn_access.setOnClickListener(this);
            btn_send_message.setOnClickListener(this);
        }else{
            btn_follow.setVisibility(View.VISIBLE);
            btn_access.setVisibility(View.GONE);
            btn_menu.setVisibility(View.GONE);
            btn_send_message.setVisibility(View.GONE);
            btn_follow.setOnClickListener(this);
        }
    }

    /**
     * 点击事件回调
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_bcak:
                finish();
                ActivityController.removeActivity(this);
                break;
            case R.id.btn_menu:
                buttomDialog = new ButtomDialog(this, R.style.BottomDialog);
                buttomDialog.show();
                buttomDialog.setOnDismissClickListener(new ButtomDialog.OnDismissClickListener() {
                    @Override
                    public void onClick(View view) {
                        isFollowed(false);
                        buttomDialog.dismiss();
                    }
                });
                break;
            case R.id.btn_send_message:
                Intent intentSend = new Intent(this,ChatActivity.class);
                startActivity(intentSend);
                finish();
                ActivityController.removeActivity(this);
                break;
            case R.id.btn_follow:
                isFollowed(true);
                break;
            case R.id.btn_access:
                Intent intentAccess = new Intent(this,GameActivity.class);
                startActivity(intentAccess);
                finish();
                ActivityController.removeActivity(this);
                break;
            default:
                break;
        }
    }
}
