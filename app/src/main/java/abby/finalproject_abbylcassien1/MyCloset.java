package abby.finalproject_abbylcassien1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import abby.finalproject_abbylcassien1.walkincloset.WalkInCloset;

public class MyCloset extends AppCompatActivity {

//    private Firebase rootRef;
//    rootRef = new Firebase("https://abbyandcassie.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_closet);
    }

    public void suitcase(View view) {
    }

    public void favorite(View view) {
    }

    public void walkIn(View view) {
        Intent intent = new Intent(this, WalkInCloset.class);
        startActivity(intent);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.log_out:
//                rootRef.unauth();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

}
