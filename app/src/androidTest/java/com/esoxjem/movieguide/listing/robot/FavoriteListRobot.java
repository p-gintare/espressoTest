package com.esoxjem.movieguide.listing.robot;

import android.support.test.espresso.assertion.ViewAssertions;

import com.esoxjem.movieguide.R;
import com.esoxjem.movieguide.listing.util.CustomMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Gintare on 3/13/2018.
 */

public class FavoriteListRobot extends BaseListRobot{

    public void assertMoviesInListAreEqualTo(int number) {
        onView(allOf(withId(R.id.movies_listing)))
            .check(ViewAssertions.matches(CustomMatcher.listSize(number)));
    }
}
