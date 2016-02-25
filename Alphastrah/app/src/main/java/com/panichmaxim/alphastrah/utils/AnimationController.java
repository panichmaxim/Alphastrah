package com.panichmaxim.alphastrah.utils;

import android.support.v4.app.FragmentTransaction;
import com.panichmaxim.alphastrah.R;

public class AnimationController {
    public static void makeTransaction(FragmentTransaction transaction) {
        transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_in_right);
        transaction.commit();
    }
}
