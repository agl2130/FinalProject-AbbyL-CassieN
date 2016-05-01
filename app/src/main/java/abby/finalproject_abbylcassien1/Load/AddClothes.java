package abby.finalproject_abbylcassien1.Load;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;

import abby.finalproject_abbylcassien1.LoginActivity;
import abby.finalproject_abbylcassien1.R;

public class AddClothes extends AppCompatActivity {
    private Firebase rootRef;
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;

    private EditText clothNameEditText;
    private EditText clothInfoEditText;
    private ImageView image;

    private CheckBox checkboxTop;
    private CheckBox checkboxBottom;
    private CheckBox checkboxShoes;
    private CheckBox checkboxAccessories;
    private CheckBox checkboxJackets;
    private CheckBox checkboxOthers;

    private CheckBox checkboxCasual;
    private CheckBox checkboxBusiness;
    private CheckBox checkboxNightOut;

    private boolean t;
    private boolean b;
    private boolean s;
    private boolean a;
    private boolean j;
    private boolean o;
    private boolean c;
    private boolean bu;
    private boolean n;

    private Uri imageString;
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothes);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.btn_star);

        clothNameEditText = (EditText) findViewById(R.id.clothesEditName);
        clothInfoEditText = (EditText) findViewById(R.id.clothesEditInfo);
        checkboxTop = (CheckBox) findViewById(R.id.checkboxTop);
        checkboxBottom = (CheckBox) findViewById(R.id.checkboxBottom);
        checkboxShoes = (CheckBox) findViewById(R.id.checkboxShoes);
        checkboxAccessories = (CheckBox) findViewById(R.id.checkboxAccessories);
        checkboxJackets = (CheckBox) findViewById(R.id.checkboxJackets);
        checkboxOthers = (CheckBox) findViewById(R.id.checkboxOthers);
        checkboxCasual = (CheckBox) findViewById(R.id.checkboxCasual);
        checkboxBusiness = (CheckBox) findViewById(R.id.checkboxBusiness);
        checkboxNightOut = (CheckBox) findViewById(R.id.checkboxNightOut);


        Intent intent = getIntent();

        image = (ImageView) findViewById(R.id.addedImage);

        try {
            imageString = intent.getParcelableExtra(Load.EXTRA_IMAGE);
            Log.e("get", imageString.toString());
            decodeUri(imageString);

        } catch (Exception e) {
            e.printStackTrace();
        }


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
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void decodeUri(Uri uri) throws FileNotFoundException {
//        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = 1;

        Bitmap image2 = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, bmOptions);
        image.setImageBitmap(image2);
    }


    public void addToCloset(View view) {
        String byteString = bitmapToByteString(((BitmapDrawable) image.getDrawable()).getBitmap());
        t = checkboxTop.isChecked();
        b = checkboxBottom.isChecked();
        s = checkboxShoes.isChecked();
        a = checkboxAccessories.isChecked();
        j = checkboxJackets.isChecked();
        o = checkboxOthers.isChecked();
        c = checkboxCasual.isChecked();
        bu = checkboxBusiness.isChecked();
        n = checkboxNightOut.isChecked();
        Clothing clothing = new Clothing(clothNameEditText.getText().toString(), clothInfoEditText.getText().toString(), byteString, t, b, s, a, j, o, c, bu, n);
        userRef.child("clothing").push().setValue(clothing);
        finish();
    }

    private String bitmapToByteString(Bitmap bitmap) {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteStream);
        byte[] byteArray = byteStream.toByteArray();
        return Base64.encodeToString(byteArray, Base64.DEFAULT);
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