package abby.finalproject_abbylcassien1.outfitoftheday;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firebase.client.Firebase;

import abby.finalproject_abbylcassien1.R;

public class Random extends AppCompatActivity {

    private Firebase rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.btn_star);
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
