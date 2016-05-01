package abby.finalproject_abbylcassien1.walkincloset;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

import abby.finalproject_abbylcassien1.LoginActivity;
import abby.finalproject_abbylcassien1.R;

public class ClothingInfoActivity extends AppCompatActivity {
    public String info;
    public String name;
    public String photo;
    private Firebase rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;
    private TextView textView;
    private TextView textViewInfo;
    private ImageView imageView;
    private String imageFileName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_info);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.btn_star);

        Intent intent = getIntent();
        name = intent.getStringExtra(BundleKey.NAME);
        info = intent.getStringExtra(BundleKey.INFO);
        photo = intent.getStringExtra(BundleKey.PHOTO);
        textView = (TextView) findViewById(R.id.loadedClothesNameText);
        textViewInfo = (TextView) findViewById(R.id.loadedClothesInfoText);
        textView.setText(name);
        textViewInfo.setText(info);
        imageView = (ImageView) findViewById(R.id.loadedImage);
        imageView.setImageBitmap(byteStringToBitmap(photo));


        authStateListener = new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    //user information and their id numbers
                    userRef = rootRef.child("users/" + authData.getUid());
                } else {
                    //otherwise...sorry you have to log in before you can come back
                    Intent intent = new Intent(ClothingInfoActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };

//        userRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                imageFileName = dataSnapshot.getValue())
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
    }

    public void addtoFavorite(View view) {
        Toast.makeText(ClothingInfoActivity.this, "Adds to Favorites", Toast.LENGTH_SHORT).show();
    }

    public void addtoSuitcase(View view) {
        Toast.makeText(ClothingInfoActivity.this, "Adds to Suitcase", Toast.LENGTH_SHORT).show();
    }

    public void delete(View view) {
        Toast.makeText(ClothingInfoActivity.this, "Deletes the Item", Toast.LENGTH_SHORT).show();
//        userRef.child("clothing").child(imageFileName).removeValue();
//        Intent intent = new Intent(this, WalkInCloset.class);
//        startActivity(intent);
    }


    private Bitmap byteStringToBitmap(String byteString) {
        byte[] imageAsBytes = Base64.decode(byteString.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
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
