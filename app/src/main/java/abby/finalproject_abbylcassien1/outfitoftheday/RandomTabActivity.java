package abby.finalproject_abbylcassien1.outfitoftheday;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import abby.finalproject_abbylcassien1.R;

/**
 * Created by cassondranealon on 3/30/16.
 */
public class RandomTabActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomtab);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        viewPager.setAdapter(new TabPagerAdapter());
        tabLayout.setupWithViewPager(viewPager);
    }
}