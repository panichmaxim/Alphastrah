package com.panichmaxim.alphastrah;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.widget.EditText;

import com.panichmaxim.alphastrah.ui.activity.LoginActivity;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void incorrect_password() {
        onView(withId(R.id.email)).perform(typeText("test_mobile128@mail.ru"));
        onView(withId(R.id.password)).perform(typeText("125"));
        closeSoftKeyboard();
        onView(withId(R.id.email_sign_in_button)).perform(click());
        onView(withId(R.id.password)).check(matches(withError(mActivityRule.getActivity().getString(R.string.error_invalid_password))));
    }

    @Test
    public void incorrect_emal() {
        onView(withId(R.id.email)).perform(typeText("test_mobilemail.ru"));
        onView(withId(R.id.password)).perform(typeText("123456"));
        closeSoftKeyboard();
        onView(withId(R.id.email_sign_in_button)).perform(click());
        onView(withId(R.id.email)).check(matches(withError(mActivityRule.getActivity().getString(R.string.error_invalid_email))));
    }

    @Test
    public void login() {
        onView(withId(R.id.email)).perform(typeText("test_mobile128@mail.ru"));
        onView(withId(R.id.password)).perform(typeText("123456"));
        closeSoftKeyboard();
        onView(withId(R.id.email_sign_in_button)).perform(click());
        intended(toPackage("com.panichmaxim.alphastrah.ui.activity"));
        // TODO check activity open?
    }

    private static Matcher<View> withError(final String expected) {
        return new TypeSafeMatcher<View>() {

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof EditText)) {
                    return false;
                }
                EditText editText = (EditText) view;
                return editText.getError().toString().equals(expected);
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

}