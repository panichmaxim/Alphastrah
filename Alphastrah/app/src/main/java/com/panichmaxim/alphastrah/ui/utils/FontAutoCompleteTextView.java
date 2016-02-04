package com.panichmaxim.alphastrah.ui.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class FontAutoCompleteTextView extends AutoCompleteTextView {
    public FontAutoCompleteTextView(Context context) {
        super(context);
        setFont(context);
    }

    public FontAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public FontAutoCompleteTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setFont(context);
    }

    private void setFont(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Medium.ttf"));
    }
}
