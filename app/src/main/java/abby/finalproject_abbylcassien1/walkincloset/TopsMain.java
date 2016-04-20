package abby.finalproject_abbylcassien1.walkincloset;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import abby.finalproject_abbylcassien1.R;

/**
 * Created by cassondranealon on 4/20/16.
 */
public class TopsMain extends AppCompatActivity {

    private List<TopsInCloset> tops;
    private CardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardAdapter = new CardAdapter(tops, this);
        //calling the list of minions, and the context...to randomize.
        recyclerView.setAdapter(cardAdapter);
    }

    //the list of all the information
    // ...which is given to the Adapter
    //...which is given to the Recycler View - knows how to populate info
    private void initialData() {
        tops = new ArrayList<>();
        tops.add(new TopsInCloset("Stuart", "The Musical One", R.drawable.business4));
        tops.add(new TopsInCloset("Kevin", "The Leader", R.drawable.business5));
        tops.add(new TopsInCloset("Bob", "The One With the Teddy Bear", R.drawable.busness2));
    }

//    //makes the add button
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    //to make the button do something

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch(item.getItemId())
//        {
//            case R.id.add:
//                minions.add(getRandomPerson());
//                cardAdapter.notifyDataSetChanged();
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

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
}
