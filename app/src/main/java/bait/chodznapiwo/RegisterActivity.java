package bait.chodznapiwo;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

/**
 * Created by Piotrek on 25.11.2017.
 */


public class RegisterActivity extends AppCompatActivity {

    private final String TAG = RegisterActivity.class.getSimpleName();
    private EditText mInputLogin, mInputName, mInputEmail, mInputPassword;
    private TextInputLayout mInputLayoutLogin, mInputLayoutName, mInputLayoutEmail, mInputLayoutPassword;
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
        mInputName = (EditText) findViewById(R.id.input_name);
        mRegisterButton = (Button) findViewById(R.id.buttonRegister);
        mInputLogin = (EditText) findViewById(R.id.input_login);
        mInputEmail = (EditText) findViewById(R.id.input_email);
        mInputPassword = (EditText) findViewById(R.id.input_password);

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

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

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}