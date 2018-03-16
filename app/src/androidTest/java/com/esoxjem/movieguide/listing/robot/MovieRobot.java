package com.esoxjem.movieguide.listing.robot;

import com.esoxjem.movieguide.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Gintare on 3/13/2018.
 */

public class MovieRobot {
    public MovieRobot setAsFavorite() {
        clickFavoriteButton();
        return this;
    }

    public MovieRobot deselectFavorite() {
        clickFavoriteButton();
        return this;
    }

    public MovieListRobot goBackToList() {
        pressBack();
        return new MovieListRobot();
    }

    private void clickFavoriteButton() {
        onView(withId(R.id.favorite)).perform(click());
    }
}
