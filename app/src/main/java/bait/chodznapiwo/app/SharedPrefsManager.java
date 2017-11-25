package bait.chodznapiwo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import bait.chodznapiwo.model.User;

/**
 * Created by Piotrek on 25.11.2017.
 */

public class SharedPrefsManager {
    // do debugowania
    private String TAG = SharedPrefsManager.class.getSimpleName();

    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    // gdzie sa trzymane
    private static final String PREF_NAME = "bait_piwo";

    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_EMAIL = "user_email";
    private static final String KEY_USER_LOGIN = "user_login";
    private static final String KEY_USER_TOKEN = "user_token";

    // Constructor
    public SharedPrefsManager(Context context) {
        // 0=PRIVATE_MODE
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        mEditor = mSharedPreferences.edit();
    }


    public void storeUser(User user) {
        mEditor.putInt(KEY_USER_ID, user.getId());
        mEditor.putString(KEY_USER_NAME, user.getName());
        mEditor.putString(KEY_USER_LOGIN, user.getLogin());
        mEditor.putString(KEY_USER_EMAIL, user.getEmail());
        mEditor.putString(KEY_USER_TOKEN, user.getToken());
        mEditor.commit();
        Log.e(TAG, "User is stored in shared preferences. " + user.getName() + ", " + user.getEmail());
    }

    public User getUser() {
        if (mSharedPreferences.getInt(KEY_USER_ID, -1) != -1) {
            String name, login, token, email;
            int id;
            id = mSharedPreferences.getInt(KEY_USER_ID, -1);
            name = mSharedPreferences.getString(KEY_USER_NAME, null);
            email = mSharedPreferences.getString(KEY_USER_EMAIL, null);
            token= mSharedPreferences.getString(KEY_USER_TOKEN, null);
            login= mSharedPreferences.getString(KEY_USER_LOGIN, null);
            return new User(id, name, login, email, token);
        }
        return null;
    }
}
