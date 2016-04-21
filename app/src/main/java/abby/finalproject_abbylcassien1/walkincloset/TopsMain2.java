package abby.finalproject_abbylcassien1.walkincloset;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.Firebase;

import java.util.List;

import abby.finalproject_abbylcassien1.MainActivity;
import abby.finalproject_abbylcassien1.R;

public class TopsMain2 extends AppCompatActivity {

    private Firebase rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;
    private List<TopsInCloset> tops;
    private CardAdapter cardAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tops_main2);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardAdapter = new CardAdapter(tops, this);
        //calling the list of minions, and the context...to randomize.
        recyclerView.setAdapter(cardAdapter);
    }

    //the list of all the information
    // ...which is given to the Adapter
    //...which is given to the Recycler View - knows how to populate info
//    private void initialData() {
//        tops = new ArrayList<>();
//
//
//            tops.add(new
//
//            TopsInCloset("Shirt1","yellow",R.drawable.business4)
//
//            );
//            tops.add(new
//
//            TopsInCloset("Shirt2","awesome",R.drawable.business5)
//
//            );
//            tops.add(new
//
//            TopsInCloset("Shirt3","orange tye-dye",R.drawable.busness2)
//
//            );
//            tops.add(new
//
//            TopsInCloset("Shirt4","fourth",R.drawable.supriseme3)
//
//            );
//        }
//

    //random person generator
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
