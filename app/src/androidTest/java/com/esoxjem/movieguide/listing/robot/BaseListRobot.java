package com.esoxjem.movieguide.listing.robot;

import com.esoxjem.movieguide.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Gintare on 3/14/2018.
 */

public class BaseListRobot {

    public MovieRobot openMovieByName(String name) {
        onView(allOf(withId(R.id.movie_name), withText(name))).perform(click());
        return new MovieRobot();
    }

    public FavoriteListRobot sortByFavorite() {
        sortBy(R.id.favorites);
        return new FavoriteListRobot();
    }

    public MovieListRobot sortByMostPopular() {
        sortBy(R.id.most_popular);
        return new MovieListRobot();
    }

    private void sortBy(int id) {
        onView(withId(R.id.action_sort)).perform(click());
        onView(withId(id)).perform(click());
    }
}
