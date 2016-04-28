package abby.finalproject_abbylcassien1.walkincloset;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.List;

import abby.finalproject_abbylcassien1.Load.Clothing;
import abby.finalproject_abbylcassien1.R;

/**
 * Created by cassondranealon on 4/20/16.
 */
public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private List<Clothing> clothing;
    private Context context;

    public CardAdapter(Firebase clothingRef, Context context, final String type) {
        this.context = context;
        clothing = new ArrayList<>();
        clothingRef.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Clothing clothingObject = dataSnapshot.getValue(Clothing.class);
                if (type.equals("top") && clothingObject.isTop()) {
                    clothing.add(clothingObject);
                    notifyDataSetChanged();
                }
                if (type.equals("bottoms") && clothingObject.isBottom()) {
                    clothing.add(clothingObject);
                    notifyDataSetChanged();
                }
                if (type.equals("jacket") && clothingObject.isJacket()) {
                    clothing.add(clothingObject);
                    notifyDataSetChanged();
                }
                if (type.equals("shoes") && clothingObject.isShoes()) {
                    clothing.add(clothingObject);
                    notifyDataSetChanged();
                }
                if (type.equals("accessories") && clothingObject.isAccessories()) {
                    clothing.add(clothingObject);
                    notifyDataSetChanged();
                }
                if (type.equals("other") && clothingObject.isOthers()) {
                    clothing.add(clothingObject);
                    notifyDataSetChanged();
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Clothing clothingObject = dataSnapshot.getValue(Clothing.class);
                clothing.remove(clothingObject);
                notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_tops, parent, false);
        return new CardViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        Clothing clothingObject = clothing.get(position);
        holder.bind(clothingObject);
    }

    @Override
    public int getItemCount() {
        return clothing.size();
    }
}