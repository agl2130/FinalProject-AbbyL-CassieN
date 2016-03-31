package abby.finalproject_abbylcassien1.outfitoftheday;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cassondranealon on 3/30/16.
 */
public class TabPagerAdapter extends PagerAdapter {

    @Override
    //how many pages you will have
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "TOP";
            case 1:
                return "BOTTOM";
            case 2:
                return "SHOES";
            case 3:
                return "ACCESSORIES";
        }
        return null;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view;
        switch (position) {
            case 0:
                view = new ViewTop(container.getContext());
                break;
            case 1:
                view = new ViewBottom(container.getContext());
                break;
            case 2:
                view = new ViewShoes(container.getContext());
                break;
            case 3:
                view = new ViewAccessories(container.getContext());
                break;
            default:
                view = new View(container.getContext());
        }
        container.addView(view);
        return view;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }
}