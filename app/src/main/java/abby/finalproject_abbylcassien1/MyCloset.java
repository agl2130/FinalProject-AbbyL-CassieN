package abby.finalproject_abbylcassien1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

import abby.finalproject_abbylcassien1.walkincloset.WalkInCloset;

public class MyCloset extends AppCompatActivity {
    private Firebase rootRef;
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_closet);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.btn_star);

        Firebase.setAndroidContext(this);
        rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");
        authStateListener = new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    userRef = rootRef.child("users/" + authData.getUid());
                } else {
                    Intent intent = new Intent(MyCloset.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
    }

    public void suitcase(View view) {
        Toast.makeText(MyCloset.this, "Goes to Suitcase", Toast.LENGTH_SHORT).show();
    }

    public void favorite(View view) {
        Toast.makeText(MyCloset.this, "Goes to Favorites", Toast.LENGTH_SHORT).show();
    }

    public void walkIn(View view) {
        Intent intent = new Intent(this, WalkInCloset.class);
        startActivity(intent);
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
            case R.id.calendar:
                Intent intent = new Intent(this, CalendarActivity.class);
                startActivity(intent);
                return true;
            case R.id.log_out:
                rootRef.unauth();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}