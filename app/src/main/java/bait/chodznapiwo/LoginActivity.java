package bait.chodznapiwo;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Piotrek on 25.11.2017.
 */

public class LoginActivity extends AppCompatActivity {
    private final String TAG = RegisterActivity.class.getSimpleName();
    private EditText mInputLogin, mInputPassword;
    private TextInputLayout mInputLayoutLogin, mInputLayoutPassword;
    private Button mLoginButton;

    public LoginActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mInputLayoutLogin = (TextInputLayout) findViewById(R.id.input_layout_login);
        mInputLayoutPassword = (TextInputLayout) findViewById(R.id.input_layout_password);
        mInputLogin = (EditText) findViewById(R.id.input_login);
        mLoginButton = (Button) findViewById(R.id.buttonLogin);

        mInputPassword = (EditText) findViewById(R.id.input_password);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
