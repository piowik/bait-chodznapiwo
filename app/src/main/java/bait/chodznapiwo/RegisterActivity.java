package bait.chodznapiwo;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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


public class RegisterActivity extends AppCompatActivity {

    private final String TAG = RegisterActivity.class.getSimpleName();
    private EditText mInputLogin, mInputName, mInputEmail, mInputPassword, mInputPhone;
    private TextInputLayout mInputLayoutLogin, mInputLayoutName, mInputLayoutEmail, mInputLayoutPassword, mInputLayoutPhone;
    private Button mRegisterButton;

    private Button mFireButt;

    public RegisterActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mInputLayoutLogin = (TextInputLayout) findViewById(R.id.input_layout_login);
        mInputLayoutName = (TextInputLayout) findViewById(R.id.input_layout_name);
        mInputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_email);
        mInputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        mInputLayoutPhone = (TextInputLayout) findViewById(R.id.input_layout_phone);
        mInputName = (EditText) findViewById(R.id.input_name);
        mRegisterButton = (Button) findViewById(R.id.buttonRegister);
        mInputLogin = (EditText) findViewById(R.id.input_login);
        mInputEmail = (EditText) findViewById(R.id.input_email);
        mInputPassword = (EditText) findViewById(R.id.input_password);
        mInputPhone = (EditText) findViewById(R.id.input_phone);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateName();
                validateEmail();
                validatePassword();

                String login = mInputLogin.getText().toString();
                String name = mInputName.getText().toString();
                String email = mInputEmail.getText().toString();
                String password = mInputPassword.getText().toString();
                String phone = mInputPhone.getText().toString();
                String token = FirebaseInstanceId.getInstance().getToken();

                Log.d("login", login);
                Log.d("name", name);
                Log.d("email", email);
                Log.d("password", password);
                Log.d("phone", phone);
                Log.d("token", token);

                register(login, name, password, email, phone, token);

            }
        });

        mFireButt = (Button) findViewById(R.id.button2);
        mFireButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get token
                String token = FirebaseInstanceId.getInstance().getToken();

                // Log and toast
                Log.d(TAG, "Token: " + token);
                Toast.makeText(RegisterActivity.this, token, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * logging in user, http post request
     */
    private void register(final String user, final String name, final String password, final String email, final String phone, final String token) {
        StringRequest strReq = new StringRequest(Request.Method.POST,
                Networking.REGISTER, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                Log.e(TAG, "response: " + response);

                try {
                    JSONObject obj = new JSONObject(response);

                    if (!obj.getBoolean("error")) {
                        JSONObject userObj = obj.getJSONObject("user");

                        User loggedUser = new User(Integer.parseInt(userObj.getString("id")),
                                userObj.getString("name"),
                                userObj.getString("user"),
                                userObj.getString("email"),
                                userObj.getString("token"));
                        AppController.getInstance().getPrefManager().storeUser(loggedUser);
                        Toast.makeText(RegisterActivity.this, "Success!", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        if (obj.getInt("error_code") == 2) {
                            mInputLayoutName.setError("User already exists");
                            requestFocus(mInputLayoutLogin);
                        } else
                            Toast.makeText(getApplicationContext(), "" + obj.getString("message"), Toast.LENGTH_LONG).show();
                    }
                } catch (JSONException e) {
                    Log.e(TAG, "json parsing error: " + e.getMessage());
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse networkResponse = error.networkResponse;
                Log.e(TAG, "Volley error: " + error.getMessage() + ", code: " + networkResponse);

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("user", user);
                params.put("name", name);
                params.put("password", password);
                params.put("email", email);
                params.put("tel", phone);
                params.put("token", token);
                Log.e(TAG, "params: " + params.toString());
                return params;
            }
        };

        //Adding request to request queue
        AppController.getInstance().addToRequestQueue(strReq);
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validateName() {
        String nameString = mInputName.getText().toString().trim().toLowerCase();
        if (nameString.isEmpty()) {
            mInputLayoutName.setError("ERR:name cannot be empty");
            requestFocus(mInputName);
            return false;
        } else if (nameString.contains("bot") || nameString.contains("admin")) {
            mInputLayoutName.setError("ERR:username invalid");
            requestFocus(mInputName);
            return false;
        } else
            mInputLayoutName.setError(null);
        return true;
    }

    private boolean validatePassword() {
        String pwString = mInputPassword.getText().toString().trim().toLowerCase();
        if (pwString.isEmpty()) {
            mInputLayoutPassword.setError("ERR:password cannot be empty");
            requestFocus(mInputName);
            return false;
        } else mInputLayoutPassword.setError(null);
        return true;
    }

    // Validating email
    private boolean validateEmail() {
        String email = mInputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            mInputLayoutEmail.setError("ERR:e-mail address is invalid");
            requestFocus(mInputEmail);
            return false;
        } else mInputLayoutEmail.setError(null);
        return true;
    }
}