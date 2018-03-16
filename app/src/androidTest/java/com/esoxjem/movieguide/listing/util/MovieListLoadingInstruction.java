package com.esoxjem.movieguide.listing.util;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.azimolabs.conditionwatcher.Instruction;
import com.esoxjem.movieguide.R;

/**
 * Created by Gintare on 3/15/2018.
 */

public class MovieListLoadingInstruction extends Instruction {

    private Activity activity;

    public MovieListLoadingInstruction(Activity activity) {
        this.activity = activity;
    }

    @Override
    public String getDescription() {
        return "movie list loading";
    }

    @Override
    public boolean checkCondition() {
        RecyclerView moviesListing = activity.findViewById(R.id.movies_listing);
        return moviesListing != null && moviesListing.getVisibility() == View.VISIBLE;
    }
}
