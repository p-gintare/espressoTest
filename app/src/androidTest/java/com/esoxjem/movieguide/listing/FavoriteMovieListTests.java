package com.esoxjem.movieguide.listing;


import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.esoxjem.movieguide.listing.robot.FavoriteListRobot;
import com.esoxjem.movieguide.listing.robot.MovieListRobot;
import com.esoxjem.movieguide.listing.robot.MovieRobot;
import com.esoxjem.movieguide.listing.util.Helper;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class FavoriteMovieListTests {

    public MovieListRobot movieListRobot;
    public MovieRobot movieRobot;
    public FavoriteListRobot favoriteListRobot;
    public Activity mainActivity;

    @Rule
    public ActivityTestRule<MoviesListingActivity> moviesListingActivityTestRule =
            new ActivityTestRule<>(MoviesListingActivity.class,
                false, false);

    @Before
    public void InitApp() {
        Helper.cleanSharedPreferences();
        moviesListingActivityTestRule.launchActivity(null);
        movieListRobot = new MovieListRobot();
        mainActivity = moviesListingActivityTestRule.getActivity();
    }

    @Test
    public void I_can_set_movie_as_favorite_and_remove_it_from_favorite_list() throws Exception {
        String movieName = "Zootopia";

        movieRobot = movieListRobot
            .waitForListToLoad(mainActivity)
            .openMovieByName(movieName);

        movieListRobot = movieRobot
            .setAsFavorite()
            .goBackToList();

        favoriteListRobot = movieListRobot.sortByFavorite();
        favoriteListRobot.assertMoviesInListAreEqualTo(1);

        movieRobot = favoriteListRobot.openMovieByName(movieName);
        movieRobot
            .deselectFavorite()
            .goBackToList();

        favoriteListRobot
            .sortByMostPopular()
            .sortByFavorite();

        favoriteListRobot.assertMoviesInListAreEqualTo(0);
    }
}
