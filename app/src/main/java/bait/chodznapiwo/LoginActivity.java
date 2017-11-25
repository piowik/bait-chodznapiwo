package bait.chodznapiwo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.firebase.iid.FirebaseInstanceId;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import bait.chodznapiwo.app.AppController;
import bait.chodznapiwo.app.Networking;
import bait.chodznapiwo.model.User;

/**
 * Created by Piotrek on 25.11.2017.
 */

public class LoginActivity extends AppCompatActivity {
    private final String TAG = RegisterActivity.class.getSimpleName();
    private EditText mInputLogin, mInputPassword;
    private TextInputLayout mInputLayoutLogin, mInputLayoutPassword;
    private Button mLoginButton, mRegisterButton, mSkipButton;

    public LoginActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mInputLayoutLogin = (TextInputLayout) findViewById(R.id.input_layout_login);
        mInputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        mInputLogin = (EditText) findViewById(R.id.input_login);
        mLoginButton = (Button) findViewById(R.id.buttonLogin);
        mRegisterButton = (Button) findViewById(R.id.buttonRegister);
        mSkipButton = (Button) findViewById(R.id.button3);

        mInputPassword = (EditText) findViewById(R.id.input_password);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateName()) return;
                if (!validatePassword()) return;
                mLoginButton.setEnabled(false);
                login(mInputLogin.getText().toString(), mInputPassword.getText().toString());
            }
        });
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            }
        });
        mSkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }


    private void login(final String name, final String password) {
        StringRequest strReq = new StringRequest(Request.Method.POST,
                Networking.LOGIN, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "response: " + response);

                try {
                    JSONObject obj = new JSONObject(response);

                    if (!obj.getBoolean("error")) {
                        JSONObject userObj = obj.getJSONObject("user");
                        User user = new User(Integer.parseInt(userObj.getString("id")),
                                userObj.getString("name"),
                                userObj.getString("user"),
                                userObj.getString("email"),
                                userObj.getString("token"));
                        AppController.getInstance().getPrefManager().storeUser(user);
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        finish();
                    } else {
                        if (obj.getInt("error_code") == 1) {
                            mInputLayoutPassword.setError("Wrong password");
                            requestFocus(mInputPassword);
                        }
                        if (obj.getInt("error_code") == 3) {
                            mInputLayoutLogin.setError("User not found.");
                            requestFocus(mInputLogin);
                        }
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "json parsing error: " + e.getMessage());
                }
                mLoginButton.setEnabled(true);

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse networkResponse = error.networkResponse;
                Log.e(TAG, "Volley error: " + error.getMessage() + ", code: " + networkResponse);
                mLoginButton.setEnabled(true);

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                params.put("password", password);
                params.put("token", FirebaseInstanceId.getInstance().getToken());
                Log.e(TAG, "params: " + params.toString());
                return params;
            }
        };
        AppController.getInstance().addToRequestQueue(strReq);
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }


    private boolean validateName() {
        String nameString = mInputLogin.getText().toString().trim().toLowerCase();
        if (nameString.isEmpty()) {
            mInputLayoutLogin.setError("ERR:name cannot be empty");
            requestFocus(mInputLogin);
            return false;
        } else
            mInputLayoutLogin.setError(null);
        return true;
    }

    private boolean validatePassword() {
        String pwString = mInputPassword.getText().toString().trim().toLowerCase();
        if (pwString.isEmpty()) {
            mInputLayoutPassword.setError("ERR:password cannot be empty");
            requestFocus(mInputPassword);
            return false;
        } else mInputLayoutPassword.setError(null);
        return true;
    }

}
