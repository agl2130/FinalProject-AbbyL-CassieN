package abby.finalproject_abbylcassien1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by aglee on 3/29/16.
 */
public class ClothesViewHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    public TextView nameTextView;
    public ImageView clothesPicImageView;
    public Context context;


    public ClothesViewHolder(View itemView, Context context) {
        super(itemView);
        this.cardView = (CardView) itemView.findViewById(R.id.card_view);
        this.nameTextView = (TextView) itemView.findViewById(R.id.name);
    //    this.clothesPicImageView = (ImageView) itemView.findViewById(R.id.clothes_pic);
        this.context = context;
    }


    public void bind(final Clothes clothes) {
        this.nameTextView.setText(clothes.name);
        this.clothesPicImageView.setImageResource(clothes.photoId);
        cardView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(context, WalkInCloset.class);
                intent.putExtra("name", clothes.name);
                intent.putExtra("photo", clothes.photoId);
                context.startActivity(intent);
            }
        });
    }
}
