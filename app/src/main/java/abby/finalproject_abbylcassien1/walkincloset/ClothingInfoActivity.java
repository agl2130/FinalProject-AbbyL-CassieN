package abby.finalproject_abbylcassien1.walkincloset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;

import abby.finalproject_abbylcassien1.R;

public class ClothingInfoActivity extends AppCompatActivity {
    public String info;
    public String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_info);

        Intent intent = getIntent();
        name = intent.getStringExtra(BundleKey.NAME);
        info = intent.getStringExtra(BundleKey.INFO);
        int drawableId = intent.getIntExtra(BundleKey.KEY2, 0);
        ImageView imageView = (ImageView) findViewById(R.id.prin_pic2);
        imageView.setImageResource(drawableId);
        fireEditText = (EditText) findViewById(R.id.info2);
        fireEditText.setText(message);


    }
}
