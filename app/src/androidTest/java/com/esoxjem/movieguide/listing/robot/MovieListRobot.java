package com.esoxjem.movieguide.listing.robot;

import android.app.Activity;

import com.esoxjem.movieguide.listing.util.MovieListLoadingInstruction;

import static com.azimolabs.conditionwatcher.ConditionWatcher.waitForCondition;

/**
 * Created by Gintare on 3/13/2018.
 */

public class MovieListRobot extends BaseListRobot {

    public MovieListRobot waitForListToLoad(Activity activity) throws Exception {
        waitForCondition(new MovieListLoadingInstruction(activity));
        return this;
    }
}
