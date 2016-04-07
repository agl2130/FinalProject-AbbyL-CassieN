package abby.finalproject_abbylcassien1.Load;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

import abby.finalproject_abbylcassien1.LoginActivity;
import abby.finalproject_abbylcassien1.R;

public class AddClothes extends AppCompatActivity {
    private Firebase rootRef;
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;

    private EditText clothNameEditText;
    private EditText clothInfoEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothes);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.btn_star);

        clothNameEditText = (EditText) findViewById(R.id.clothesEditName);
        clothInfoEditText = (EditText) findViewById(R.id.clothesEditInfo);

        Firebase.setAndroidContext(this);
        rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");
        authStateListener = new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    // user is logged in
                    userRef = rootRef.child("users/" + authData.getUid());
                    return;
                } else {
                    // user is not logged in
                    Intent intent = new Intent(AddClothes.this, LoginActivity.class);
                    startActivity(intent);

                }
            }
        };
    }

    public void addToCloset(View view) {
        Clothing clothing = new Clothing(clothNameEditText.getText().toString(), clothInfoEditText.getText().toString());
        userRef.child("clothing").push().setValue(clothing);
        finish();
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


}