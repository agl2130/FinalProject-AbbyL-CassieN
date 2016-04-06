package abby.finalproject_abbylcassien1.Load;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firebase.client.Firebase;

import abby.finalproject_abbylcassien1.MainActivity;
import abby.finalproject_abbylcassien1.R;

public class Load extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
    }

    public void takePhoto(View view) {
        //goes to camera but for now its going to add an item
        Intent intent = new Intent(this, AddClothes.class);
        startActivity(intent);
        Toast.makeText(Load.this, "Adding item!", Toast.LENGTH_SHORT).show();

    }

    public void importPhoto(View view) {
        //goes to my photos
    }

    private Firebase rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    //copy this to all the pages...
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            //this takes you back to home, but it makes you log back in!!!!!
            case R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            case R.id.log_out:
                rootRef.unauth();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
