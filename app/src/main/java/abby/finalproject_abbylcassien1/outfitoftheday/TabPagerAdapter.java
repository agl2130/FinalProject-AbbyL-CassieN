package abby.finalproject_abbylcassien1.outfitoftheday;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.List;

import abby.finalproject_abbylcassien1.Load.Clothing;

/**
 * Created by cassondranealon on 3/30/16.
 */
public class TabPagerAdapter extends PagerAdapter {


    private List<Clothing> tops = new ArrayList<>();
    private List<Clothing> bottoms = new ArrayList<>();
    private List<Clothing> shoes = new ArrayList<>();
    private List<Clothing> accessories = new ArrayList<>();

    private ViewTop viewTop;
    private ViewBottom viewBottom;
    private ViewShoes viewShoes;
    private ViewAccessories viewAccessories;
    private Clothing pickedTop;


    public TabPagerAdapter(Firebase clothingRef, Context context) {
        viewTop = new ViewTop(context);
        viewBottom = new ViewBottom(context);
        viewShoes = new ViewShoes(context);
        viewAccessories = new ViewAccessories(context);


        clothingRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Clothing clothingObject = dataSnapshot.getValue(Clothing.class);
                if (clothingObject.isCasual()) {
                    if (clothingObject.isTop()) {
                        tops.add(clothingObject);
                        viewTop.init(tops.get((int) (tops.size() * Math.random())));
                    }
                    if (clothingObject.isBottom()) {
                        bottoms.add(clothingObject);
                        viewBottom.init(bottoms.get((int) (bottoms.size() * Math.random())));
                    }

                    if (clothingObject.isShoes()) {
                        shoes.add(clothingObject);
                        viewShoes.init(shoes.get((int) (shoes.size() * Math.random())));
                    }
                    if (clothingObject.isAccessories()) {
                        accessories.add(clothingObject);
                        viewAccessories.init(accessories.get((int) (accessories.size() * Math.random())));
                    }
                }
                if (clothingObject.isBusiness()) {
                    if (clothingObject.isTop()) {
                        tops.add(clothingObject);
                        viewTop.init(tops.get((int) (tops.size() * Math.random())));
                    }
                    if (clothingObject.isBottom()) {
                        bottoms.add(clothingObject);
                        viewBottom.init(bottoms.get((int) (bottoms.size() * Math.random())));
                    }

                    if (clothingObject.isShoes()) {
                        shoes.add(clothingObject);
                        viewShoes.init(shoes.get((int) (shoes.size() * Math.random())));
                    }
                    if (clothingObject.isAccessories()) {
                        accessories.add(clothingObject);
                        viewAccessories.init(accessories.get((int) (accessories.size() * Math.random())));
                    }
                }
                if (clothingObject.isNightOut()) {
                    if (clothingObject.isTop()) {
                        tops.add(clothingObject);
                        viewTop.init(tops.get((int) (tops.size() * Math.random())));
                    }
                    if (clothingObject.isBottom()) {
                        bottoms.add(clothingObject);
                        viewBottom.init(bottoms.get((int) (bottoms.size() * Math.random())));
                    }

                    if (clothingObject.isShoes()) {
                        shoes.add(clothingObject);
                        viewShoes.init(shoes.get((int) (shoes.size() * Math.random())));
                    }
                    if (clothingObject.isAccessories()) {
                        accessories.add(clothingObject);
                        viewAccessories.init(accessories.get((int) (accessories.size() * Math.random())));
                    }
                } else {
                    if (clothingObject.isTop()) {
                        tops.add(clothingObject);
                        viewTop.init(tops.get((int) (tops.size() * Math.random())));
                    }
                    if (clothingObject.isBottom()) {
                        bottoms.add(clothingObject);
                        viewBottom.init(bottoms.get((int) (bottoms.size() * Math.random())));
                    }

                    if (clothingObject.isShoes()) {
                        shoes.add(clothingObject);
                        viewShoes.init(shoes.get((int) (shoes.size() * Math.random())));
                    }
                    if (clothingObject.isAccessories()) {
                        accessories.add(clothingObject);
                        viewAccessories.init(accessories.get((int) (accessories.size() * Math.random())));
                    }
                }
            }


                                              @Override
                                              public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                                              @Override
                                              public void onChildRemoved(DataSnapshot dataSnapshot) {
                }

                                              @Override
                                              public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                                              @Override
                                              public void onCancelled(FirebaseError firebaseError) {

                                              }
            }

        );

    }

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
        switch (position) {
            case 0:
                container.addView(viewTop);
                return viewTop;
            case 1:
                container.addView(viewBottom);
                return viewBottom;
            case 2:
                container.addView(viewShoes);
                return viewShoes;
            case 3:
                container.addView(viewAccessories);
                return viewAccessories;
            default:
            }
        return null;
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
        }

    @Override
    public void destroyItem(final ViewGroup container, final int position,
                            final Object object) {
        container.removeView((View) object);
        }
    }