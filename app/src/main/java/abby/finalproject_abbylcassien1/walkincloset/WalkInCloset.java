package abby.finalproject_abbylcassien1.walkincloset;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.List;

import abby.finalproject_abbylcassien1.R;

public class WalkInCloset extends AppCompatActivity {


    private List<Clothes> clothes;
    private ClothesAdapter clothesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_in_closet);

        initialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        clothesAdapter = new ClothesAdapter(clothes, this);
        recyclerView.setAdapter(clothesAdapter);

    }

    private void initialData() {
        clothes = new ArrayList<>();
        clothes.add(new Clothes("TOPS", "", R.drawable.quote));
        clothes.add(new Clothes("BOTTOMS", "", R.drawable.quote));
        clothes.add(new Clothes("SHOES", "", R.drawable.quote));
        clothes.add(new Clothes("ACCESSORIES", "", R.drawable.quote));
    }


    //Log out menu button
    private Firebase rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");

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
