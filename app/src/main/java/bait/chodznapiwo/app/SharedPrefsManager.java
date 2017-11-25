package bait.chodznapiwo.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

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

    // Constructor
    public SharedPrefsManager(Context context) {
        // 0=PRIVATE_MODE
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, 0);
        mEditor = mSharedPreferences.edit();
    }


    /*public void storeUser(User user) {
        mEditor.putString(KEY_USER_ID, user.getId());
        mEditor.putString(KEY_USER_NAME, user.getName());
        mEditor.commit();
        Log.e(TAG, "User is stored in shared preferences. " + user.getName() + ", " + user.getEmail());
    }

    public User getUser() {
        if (mSharedPreferences.getString(KEY_USER_ID, null) != null) {
            String id, name;
            id = mSharedPreferences.getString(KEY_USER_ID, null);
            name = mSharedPreferences.getString(KEY_USER_NAME, null);
            return new User(id, name);
        }
        return null;
    }*/
}
