package abby.finalproject_abbylcassien1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by aglee on 3/29/16.
 */
public class ClothesAdapter extends RecyclerView.Adapter<ClothesViewHolder> {
    private List<Clothes> clothes;
    private Context context;

    public ClothesAdapter(final List<Clothes> clothes, Context context) {
        this.clothes = clothes;
        this.context = context;
    }

    @Override
    public ClothesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_clothes_card_view, parent, false);
        return new ClothesViewHolder(view, context);

    }

    @Override
    public void onBindViewHolder(ClothesViewHolder holder, int position) {
        Clothes cloth = clothes.get(position);
        holder.bind(cloth);
        holder.nameTextView.setText(cloth.name);
        holder.clothesPicImageView.setImageResource(cloth.photoId);


    }

    @Override
    public int getItemCount() {
        return clothes.size();
    }

}

