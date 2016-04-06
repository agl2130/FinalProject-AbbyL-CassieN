package abby.finalproject_abbylcassien1.Load;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.firebase.client.Firebase;

import abby.finalproject_abbylcassien1.R;

public class AddClothes extends AppCompatActivity {
    private Firebase rootRef;
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;

    private EditText clothNameEditText;
    private EditText clothInfoEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothes);
    }
}
