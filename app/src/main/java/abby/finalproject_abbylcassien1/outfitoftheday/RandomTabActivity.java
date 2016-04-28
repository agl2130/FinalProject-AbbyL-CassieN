package abby.finalproject_abbylcassien1.outfitoftheday;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.Firebase;

import abby.finalproject_abbylcassien1.R;

/**
 * Created by cassondranealon on 3/30/16.
 */
public class RandomTabActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Firebase userRef;
    private Firebase rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomtab);
        getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.btn_star);
        userRef = rootRef.child("users" + rootRef.getAuth().getUid());

        Intent intent = getIntent();
        String message = intent.getStringExtra(Random.OCCASION);
        final String occasion = message;

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        viewPager.setAdapter(new TabPagerAdapter(userRef.child("clothing")));
        tabLayout.setupWithViewPager(viewPager);
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

//random  generator
//    private Person getRandomPerson() {
//        int num = (int) (Math.random() * 3);
//        if (num ==0) {
//            return new Person("Stuart", "The Musical One", R.drawable.stuart);
//        }
//        else if (num == 1) {
//            return new Person("Kevin", "The Leader", R.drawable.kevin);
//        }
//        else
//            return new Person("Bob", "The One With the Teddy Bear", R.drawable.bob);
//    }