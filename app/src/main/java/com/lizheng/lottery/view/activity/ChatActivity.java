package com.lizheng.lottery.view.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Spannable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.lizheng.lottery.R;
import com.lizheng.lottery.base.BaseActivity;
import com.lizheng.lottery.bean.ChatContentBean;
import com.lizheng.lottery.bean.TestBean;
import com.lizheng.lottery.utils.ActivityController;
import com.lizheng.lottery.utils.DateUtil;
import com.lizheng.lottery.view.adapter.ChatAdapter;
import com.sj.emoji.DefEmoticons;
import com.sj.emoji.EmojiBean;
import com.sj.emoji.EmojiDisplay;
import com.sj.emoji.EmojiSpan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

import sj.keyboard.XhsEmoticonsKeyBoard;
import sj.keyboard.adpater.EmoticonsAdapter;
import sj.keyboard.adpater.PageSetAdapter;
import sj.keyboard.data.EmoticonPageEntity;
import sj.keyboard.data.EmoticonPageSetEntity;
import sj.keyboard.interfaces.EmoticonClickListener;
import sj.keyboard.interfaces.EmoticonDisplayListener;
import sj.keyboard.interfaces.EmoticonFilter;
import sj.keyboard.interfaces.PageViewInstantiateListener;
import sj.keyboard.utils.EmoticonsKeyboardUtils;
import sj.keyboard.widget.EmoticonPageView;
import sj.keyboard.widget.FuncLayout;

public class ChatActivity extends BaseActivity implements View.OnClickListener {
    private ImageButton btn_back;
    private ImageButton btn_person;
    private TextView tv_title;
    private XhsEmoticonsKeyBoard ek_bar;
    private ChatAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private List<ChatContentBean> chatContentList;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initData();
    }

    private void initView() {
        btn_back = findViewById(R.id.btn_bcak);
        btn_person = findViewById(R.id.btn_person);
        tv_title = findViewById(R.id.txt_title);
        //初始化键盘View
        ek_bar = findViewById(R.id.ek_bar);


        btn_back.setVisibility(View.VISIBLE);
        btn_person.setVisibility(View.VISIBLE);

        //初始化RecyclerView
        mRecyclerView = findViewById(R.id.rv_chat);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    private void initData() {
        //获取当前时间
        date = DateUtil.getSystemDate();

        chatContentList = new ArrayList<>();
        //测试数据
        initChatContent();

        mAdapter = new ChatAdapter(chatContentList,this);
        mRecyclerView.setAdapter(mAdapter);

        ArrayList<EmojiBean> emojiArray = new ArrayList<>();
        Collections.addAll(emojiArray, DefEmoticons.sEmojiArray);
        btn_person.setOnClickListener(this);
        btn_back.setOnClickListener(this);
        final EmoticonClickListener emoticonClickListener = new EmoticonClickListener() {
            @Override
            public void onEmoticonClick(Object o, int actionType, boolean isDelBtn) {
                if (isDelBtn) {
                    int action = KeyEvent.ACTION_DOWN;
                    int code = KeyEvent.KEYCODE_DEL;
                    KeyEvent event = new KeyEvent(action, code);
                    ek_bar.getEtChat().onKeyDown(KeyEvent.KEYCODE_DEL, event);
                } else {
                    if (o == null) {
                        return;
                    }
                    String content = null;
                    if (o instanceof EmojiBean) {
                        content = ((EmojiBean) o).emoji;
                    }
                    int index = ek_bar.getEtChat().getSelectionStart();
                    Editable editable = ek_bar.getEtChat().getText();
                    editable.insert(index, content);
                }
            }
        };
        final EmoticonDisplayListener emoticonDisplayListener = new EmoticonDisplayListener() {
            @Override
            public void onBindView(int i, ViewGroup viewGroup, EmoticonsAdapter.ViewHolder viewHolder, Object object, final boolean isDelBtn) {
                final EmojiBean emojiBean = (EmojiBean) object;
                if (emojiBean == null && !isDelBtn) {
                    return;
                }

                viewHolder.ly_root.setBackgroundResource(com.keyboard.view.R.drawable.bg_emoticon);

                if (isDelBtn) {
                    viewHolder.iv_emoticon.setImageResource(R.mipmap.icon_del);
                } else {
                    viewHolder.iv_emoticon.setImageResource(emojiBean.icon);
                }

                viewHolder.rootView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        emoticonClickListener.onEmoticonClick(emojiBean, 0, isDelBtn);
                    }
                });
            }
        };
        PageViewInstantiateListener pageViewInstantiateListener = new PageViewInstantiateListener<EmoticonPageEntity>() {
            @Override
            public View instantiateItem(ViewGroup viewGroup, int i, EmoticonPageEntity pageEntity) {
                if (pageEntity.getRootView() == null) {
                    EmoticonPageView pageView = new EmoticonPageView(viewGroup.getContext());
                    pageView.setNumColumns(pageEntity.getRow());
                    pageEntity.setRootView(pageView);
                    try {
                        EmoticonsAdapter adapter = new EmoticonsAdapter(viewGroup.getContext(), pageEntity, null);
                        // emoticon instantiate
                        adapter.setOnDisPlayListener(emoticonDisplayListener);
                        pageView.getEmoticonsGridView().setAdapter(adapter);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return pageEntity.getRootView();
            }
        };
        EmoticonPageSetEntity xhsPageSetEntity
                = new EmoticonPageSetEntity.Builder()
                .setLine(3)
                .setRow(7)
                .setEmoticonList(emojiArray)
                .setIPageViewInstantiateItem(pageViewInstantiateListener)
                .setShowDelBtn(EmoticonPageEntity.DelBtnStatus.LAST)
                .setIconUri(R.mipmap.icon_add)
                .build();

        PageSetAdapter pageSetAdapter = new PageSetAdapter();
        pageSetAdapter.add(xhsPageSetEntity);
        ek_bar.setAdapter(pageSetAdapter);

        // add a filter
        ek_bar.getEtChat().addEmoticonFilter(new EmojiFilter());

        //设置聊天下拉表情框拓展功能（仿微信+符号功能区）
        ek_bar.addFuncView(new SimpleAppsGridView(this));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_bcak:
                finish();
                ActivityController.removeActivity(this);
                break;
            case R.id.btn_person:
                Intent intent = new Intent(this,FollowDetailActivity.class);
                intent.putExtra("isFollowed",true);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    class EmojiFilter extends EmoticonFilter {

        private int emojiSize = -1;

        @Override
        public void filter(EditText editText, CharSequence text, int start, int lengthBefore, int lengthAfter) {
            emojiSize = emojiSize == -1 ? EmoticonsKeyboardUtils.getFontHeight(editText) : emojiSize;
            clearSpan(editText.getText(), start, text.toString().length());
            Matcher m = EmojiDisplay.getMatcher(text.toString().substring(start, text.toString().length()));
            if (m != null) {
                while (m.find()) {
                    String emojiHex = Integer.toHexString(Character.codePointAt(m.group(), 0));
                    EmojiDisplay.emojiDisplay(editText.getContext(), editText.getText(), emojiHex, emojiSize, start + m.start(), start + m.end());
                }
            }
        }
        private void clearSpan(Spannable spannable, int start, int end) {
            if (start == end) {
                return;
            }
            EmojiSpan[] oldSpans = spannable.getSpans(start, end, EmojiSpan.class);
            for (int i = 0; i < oldSpans.length; i++) {
                spannable.removeSpan(oldSpans[i]);
            }
        }
    }
private void initChatContent(){
        ChatContentBean contentBean1 = new ChatContentBean("在吗？",ChatContentBean.TYPE_RECEIVED,date);
        chatContentList.add(contentBean1);
        ChatContentBean contentBean2 = new ChatContentBean("在的",ChatContentBean.TYPE_SEND,date);
        chatContentList.add(contentBean2);
        ChatContentBean contentBean3 = new ChatContentBean("去图书馆吗？",ChatContentBean.TYPE_RECEIVED,date);
        chatContentList.add(contentBean3);
        ChatContentBean contentBean4 = new ChatContentBean("不去",ChatContentBean.TYPE_SEND,date);
        chatContentList.add(contentBean4);

}

}
