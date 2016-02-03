package com.panichmaxim.alphastrah.ui.utils;
import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;

public class FontTextInputLayout extends TextInputLayout {
    public FontTextInputLayout(Context context) {
        super(context);
        setFont(context);
    }

    public FontTextInputLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public FontTextInputLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont(context);
    }

    private void setFont(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf"));
    }
}
