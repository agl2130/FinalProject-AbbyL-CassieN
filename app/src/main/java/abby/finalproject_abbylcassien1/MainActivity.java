package abby.finalproject_abbylcassien1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

import abby.finalproject_abbylcassien1.outfitoftheday.Random;

public class MainActivity extends AppCompatActivity {
    private Firebase rootRef;
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;
    private TextView userName;

    private EditText keyEditText;
    private EditText valueEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keyEditText = (EditText) findViewById(R.id.edit_text_email);
        valueEditText = (EditText) findViewById(R.id.edit_text_password);
//
        userName = (TextView) findViewById(R.id.userName);

        Firebase.setAndroidContext(this);
        rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");


//        if (rootRef.getAuth().getProviderData().get("email") != null) {
//            userName.setText(rootRef.getAuth().getProviderData().get("email").toString());
//        }

        //just in case the user is logged out, do something about it
        authStateListener = new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    //user information and their id numbers
                    userRef = rootRef.child("users/" + authData.getUid());
                } else {
                    //otherwise...sorry you have to log in before you can come back
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        rootRef.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        rootRef.removeAuthStateListener(authStateListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_out:
                rootRef.unauth();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void random(View view) {
        Intent intent = new Intent(this, Random.class);

        startActivity(intent);
    }

    public void load(View view) {
        Intent intent = new Intent(this, Load.class);

        startActivity(intent);
    }

    public void myCloset(View view) {
        Intent intent = new Intent(this, MyCloset.class);

        startActivity(intent);
    }
}
