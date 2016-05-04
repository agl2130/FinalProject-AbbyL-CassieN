package abby.finalproject_abbylcassien1.walkincloset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.firebase.client.Firebase;

import abby.finalproject_abbylcassien1.CalendarActivity;
import abby.finalproject_abbylcassien1.R;

public class WalkInCloset extends AppCompatActivity {

    public final static String TYPE = "type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_in_closet);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.btn_star);
    }

    public void top(View view) {
        Intent intent = new Intent(this, ClothesViewActivity.class);
        String message = "top";
        intent.putExtra(TYPE, message);
        startActivity(intent);
    }

    public void bottom(View view) {
        Intent intent = new Intent(this, ClothesViewActivity.class);
        String message = "bottoms";
        intent.putExtra(TYPE, message);
        startActivity(intent);
    }

    public void shoes(View view) {
        Intent intent = new Intent(this, ClothesViewActivity.class);
        String message = "shoes";
        intent.putExtra(TYPE, message);
        startActivity(intent);
    }

    public void jacket(View view) {
        Intent intent = new Intent(this, ClothesViewActivity.class);
        String message = "jacket";
        intent.putExtra(TYPE, message);
        startActivity(intent);
    }

    public void access(View view) {
        Intent intent = new Intent(this, ClothesViewActivity.class);
        String message = "accessories";
        intent.putExtra(TYPE, message);
        startActivity(intent);
    }

    public void other(View view) {
        Intent intent = new Intent(this, ClothesViewActivity.class);
        String message = "other";
        intent.putExtra(TYPE, message);
        startActivity(intent);
    }

    private Firebase rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");

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
