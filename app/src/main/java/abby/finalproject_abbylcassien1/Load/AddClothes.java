package abby.finalproject_abbylcassien1.Load;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;

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

    private String imageString;


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

//
        Intent intent = getIntent();
        imageString = intent.getStringExtra(Load.EXTRA_IMAGE);

        image = (ImageView) findViewById(R.id.addedImage);
//        image.setImageResource(drawableId);

        t = checkboxTop.isChecked();
        b = checkboxBottom.isChecked();
        s = checkboxShoes.isChecked();
        a = checkboxAccessories.isChecked();
        j = checkboxJackets.isChecked();
        o = checkboxOthers.isChecked();
        c = checkboxCasual.isChecked();
        bu = checkboxBusiness.isChecked();
        n = checkboxNightOut.isChecked();

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

    private void setPic() {
        int targetW = image.getWidth();
        int targetH = image.getHeight();

        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imageString, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        int scalefactor = Math.min(photoW / targetW, photoH / targetH);

        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scalefactor;

        Bitmap bitmap = BitmapFactory.decodeFile(imageString, bmOptions);
        image.setImageBitmap(bitmap);
    }
//
//    public void decodeUri(Uri uri) throws FileNotFoundException{
//        int targetW = imageView.getWidth();
//        int targetH = imageView.getHeight();
//
//        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//
//        bmOptions.inJustDecodeBounds=true;
//        BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null,bmOptions);
//        int photoW =bmOptions.outWidth;
//        int photoH =bmOptions.outHeight;
//
//        int scaleFactor = Math.min(photoW/targetW, photoH/targetH );
//
//        bmOptions.inJustDecodeBounds=false;
//        bmOptions.inSampleSize=scaleFactor;
//
//        Bitmap image = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), null, bmOptions);
//        imageView.setImageBitmap(image);
//
//    }


    public void addToCloset(View view) {
        Clothing clothing = new Clothing(clothNameEditText.getText().toString(), clothInfoEditText.getText().toString());
        userRef.child("clothing").push().setValue(clothing);
        finish();
    }

    public void onDataChange(DataSnapshot snapshot) {
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