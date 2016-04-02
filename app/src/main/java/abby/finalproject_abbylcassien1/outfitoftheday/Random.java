package abby.finalproject_abbylcassien1.outfitoftheday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import abby.finalproject_abbylcassien1.R;

public class Random extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
    }
//all are going to the same place right now

    public void casual(View view) {
        Intent intent = new Intent(this, RandomTabActivity.class);
        startActivity(intent);

        Toast.makeText(Random.this, "CASUAL", Toast.LENGTH_SHORT).show();
    }

    public void business(View view) {
        Intent intent = new Intent(this, RandomTabActivity.class);
        startActivity(intent);

        Toast.makeText(Random.this, "BUSNESS", Toast.LENGTH_SHORT).show();
    }

    public void nightOut(View view) {
        Intent intent = new Intent(this, RandomTabActivity.class);
        startActivity(intent);
        Toast.makeText(Random.this, "NIGHT OUT", Toast.LENGTH_SHORT).show();
    }

    public void surpriseMe(View view) {
        Intent intent = new Intent(this, RandomTabActivity.class);
        startActivity(intent);
        Toast.makeText(Random.this, "SURPRISE ME!", Toast.LENGTH_SHORT).show();
    }
}
