package com.esoxjem.movieguide.listing.util;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

/**
 * Created by Gintare on 3/15/2018.
 */

public class CustomMatcher {
    public static TypeSafeMatcher<View> listSize (int size) {
        return new TypeSafeMatcher<View>() {
            @Override
            public boolean matchesSafely (View view) {
                RecyclerView recyclerView = (RecyclerView) view;
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                return adapter.getItemCount() == size;
            }

            @Override
            public void describeTo (Description description) {
                description.appendText ("ListView should have " + size + " items");
            }
        };
    }
}
