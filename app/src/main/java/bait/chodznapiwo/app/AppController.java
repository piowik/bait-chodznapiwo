package bait.chodznapiwo.app;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

import bait.chodznapiwo.model.Event;

/**
 * Created by Piotrek on 25.11.2017.
 */

public class AppController extends Application {

    private RequestQueue mRequestQueue;
    private static final String TAG = AppController.class
            .getSimpleName();
    private static AppController mInstance;
    private SharedPrefsManager mPrefManager;

    public Event getActualEvent() {
        return mActualEvent;
    }

    public void setActualEvent(Event actualEvent) {
        mActualEvent = actualEvent;
    }

    private Event mActualEvent;


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


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }


    public <T> void addToRequestQueue(Request<T> req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
