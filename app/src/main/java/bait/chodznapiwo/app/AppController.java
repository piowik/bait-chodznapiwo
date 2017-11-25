package bait.chodznapiwo.app;

import android.app.Application;

/**
 * Created by Piotrek on 25.11.2017.
 */

public class AppController extends Application {

    private static final String TAG = AppController.class
            .getSimpleName();
    private static AppController mInstance;
    private SharedPrefsManager mPrefManager;


    public static synchronized AppController getInstance() {
        return mInstance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public SharedPrefsManager getPrefManager() {
        if (mPrefManager == null) {
            mPrefManager = new SharedPrefsManager(this);
        }
        return mPrefManager;
    }

}
