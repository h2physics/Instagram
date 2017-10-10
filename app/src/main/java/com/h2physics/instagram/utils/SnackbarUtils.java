package com.h2physics.instagram.utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by YukiNoHara on 10/10/2017.
 */

public class SnackbarUtils {
    public static Snackbar getInstance(View view, String message){
        return Snackbar.make(view, message, Snackbar.LENGTH_LONG);
    }
}
