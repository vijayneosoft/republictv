package com.neosoft.republictv.presentation.di.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Vijay on 30/8/19.
 */
@SuppressWarnings("JavaDoc")
@Module
public class ContextModule {

    private Context mContext;

    public ContextModule(Context context) {
        this.mContext = context;
    }

    /**
     * return the application context
     *
     * @return
     */
    @Provides
    Context provideContext() {
        return mContext;
    }
}
