package abby.finalproject_abbylcassien1.walkincloset;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.Firebase;

import abby.finalproject_abbylcassien1.R;

public class ClothingInfoActivity extends AppCompatActivity {
    public String info;
    public String name;
    public String photo;
    private Firebase rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");

    private TextView textView;
    private TextView textViewInfo;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_info);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.btn_star);

        Intent intent = getIntent();
        name = intent.getStringExtra(BundleKey.NAME);
        info = intent.getStringExtra(BundleKey.INFO);
        textView = (TextView) findViewById(R.id.loadedClothesNameText);
        textViewInfo = (TextView) findViewById(R.id.loadedClothesInfoText);
        textView.setText(name);
        textViewInfo.setText(info);
        imageView = (ImageView) findViewById(R.id.loadedImage);
        imageView.setImageBitmap(byteStringToBitmap(BundleKey.PHOTO));




    }

    private Bitmap byteStringToBitmap(String byteString) {
        byte[] imageAsBytes = Base64.decode(byteString.getBytes(), Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length);
    }
}
