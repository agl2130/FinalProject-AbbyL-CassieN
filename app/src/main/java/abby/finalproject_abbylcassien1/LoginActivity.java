package abby.finalproject_abbylcassien1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

/**
 * Created by cassondranealon on 3/23/16.
 */
public class LoginActivity extends AppCompatActivity {

    private Firebase myFirebaseRef;
    private EditText emailEditText;
    private EditText passwordEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Log in");

        myFirebaseRef = new Firebase("https://abbyandcassie.firebaseio.com/");
        emailEditText = (EditText) findViewById(R.id.edit_text_email);
        passwordEditText = (EditText) findViewById(R.id.edit_text_password);
    }

    public void logIn(View view) {
        String email = this.emailEditText.getText().toString();
        String password = this.passwordEditText.getText().toString();

        myFirebaseRef.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                Toast.makeText(LoginActivity.this, "You are logged in!", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                Toast.makeText(LoginActivity.this, "Unable to Log in : " + firebaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void SignUp(View view) {
        String email = this.emailEditText.getText().toString();
        String password = this.passwordEditText.getText().toString();
        myFirebaseRef.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                Toast.makeText(LoginActivity.this, "Successfully created user account with uid: " + result.get("uid"), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                Toast.makeText(LoginActivity.this, "Unable to sign up: " + firebaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

}