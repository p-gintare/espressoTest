package com.esoxjem.movieguide.listing.util;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import java.io.File;

/**
 * Created by Gintare on 3/15/2018.
 */

public class Helper {

    public static void cleanSharedPreferences() {
        File root = InstrumentationRegistry.getTargetContext().getFilesDir().getParentFile();
        String[] sharedPreferencesFileNames = new File(root, "shared_prefs").list();
        for (String fileName : sharedPreferencesFileNames) {
            InstrumentationRegistry
                .getTargetContext()
                .getSharedPreferences(
                    fileName.replace(".xml", ""), Context.MODE_PRIVATE
                )
                .edit()
                .clear()
                .commit();
        }
    }
}
