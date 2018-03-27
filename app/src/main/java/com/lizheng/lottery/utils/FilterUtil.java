package com.lizheng.lottery.utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

import com.sj.emoji.EmojiDisplay;

import sj.keyboard.utils.EmoticonsKeyboardUtils;

/**
 * Created by lizheng on 2018/3/27.
 */

public class FilterUtil {
    /**
     * 表情显示在TextView的转化步骤
     * @param tv_content
     * @param content
     */
    public static void spannableEmoticonFilter(TextView tv_content, String content) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(content);

        Spannable spannable = EmojiDisplay.spannableFilter(tv_content.getContext(),
                spannableStringBuilder,
                content,
                EmoticonsKeyboardUtils.getFontHeight(tv_content));

        tv_content.setText(spannable);
    }
}
