package com.h2physics.instagram.data.local;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by YukiNoHara on 10/7/2017.
 */

public class InstaLocalDataSource {
    private InstaLocalDataSource INSTANCE;
    private InstaDbHelper mHelper;

    private InstaLocalDataSource(@NonNull Context context){
        mHelper = new InstaDbHelper(context);
    }

    public InstaLocalDataSource getInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = new InstaLocalDataSource(context);
        }
        return INSTANCE;
    }
}
