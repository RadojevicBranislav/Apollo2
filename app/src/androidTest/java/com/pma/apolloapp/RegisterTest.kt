package com.pma.apolloapp


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class RegisterTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(SplashScreen::class.java)

    @Test
    fun registerTest() {
        val materialTextView = onView(
            allOf(
                withId(R.id.textView), withText("Don't have an account? Register."),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        materialTextView.perform(click())

        val appCompatEditText = onView(
            allOf(
                withId(R.id.editTextTextEmailAddress),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText.perform(replaceText("test1234@gmail.com"), closeSoftKeyboard())

        val appCompatEditText2 = onView(
            allOf(
                withId(R.id.editTextTextPassword),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText2.perform(replaceText("test123"), closeSoftKeyboard())

        val appCompatEditText3 = onView(
            allOf(
                withId(R.id.editTextTextPassword2),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatEditText3.perform(replaceText("test123"), closeSoftKeyboard())

        val materialButton = onView(
            allOf(
                withId(R.id.button), withText("REGISTER"),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    4
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val appCompatEditText4 = onView(
            allOf(
                withId(R.id.editTextTextEmailAddress),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        appCompatEditText4.perform(replaceText("test1234@gmail.com"), closeSoftKeyboard())

        val appCompatEditText5 = onView(
            allOf(
                withId(R.id.editTextTextPassword),
                childAtPosition(
                    childAtPosition(
                        withId(android.R.id.content),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatEditText5.perform(replaceText("test123"), closeSoftKeyboard())

        val bottomNavigationItemView = onView(
            allOf(
                withId(R.id.profile), withContentDescription("About"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottomNavigationView),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView.perform(click())

        val materialTextView2 = onView(
            allOf(
                withId(R.id.textView3), withText("English"),
                childAtPosition(
                    allOf(
                        withId(R.id.app),
                        childAtPosition(
                            withId(R.id.frame_layout),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialTextView2.perform(click())

        val materialTextView3 = onView(
            allOf(
                withId(R.id.textView2), withText("Srpski"),
                childAtPosition(
                    allOf(
                        withId(R.id.app),
                        childAtPosition(
                            withId(R.id.frame_layout),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialTextView3.perform(click())

        val materialTextView4 = onView(
            allOf(
                withId(R.id.textView3), withText("English"),
                childAtPosition(
                    allOf(
                        withId(R.id.app),
                        childAtPosition(
                            withId(R.id.frame_layout),
                            0
                        )
                    ),
                    3
                ),
                isDisplayed()
            )
        )
        materialTextView4.perform(click())

        val bottomNavigationItemView2 = onView(
            allOf(
                withId(R.id.logout), withContentDescription("Log Out"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottomNavigationView),
                        0
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        bottomNavigationItemView2.perform(click())
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
