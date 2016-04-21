package abby.finalproject_abbylcassien1.walkincloset;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import abby.finalproject_abbylcassien1.Load.Clothing;
import abby.finalproject_abbylcassien1.R;

/**
 * Created by cassondranealon on 4/20/16.
 */
public class CardViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView clothingName;
    private TextView clothingInfo;
    private ImageView clothingPhoto;
    private Context context;

    public CardViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        clothingName = (TextView) itemView.findViewById(R.id.name);
        clothingInfo = (TextView) itemView.findViewById(R.id.info);
        //  clothingPhoto = (ImageView) itemView.findViewById(R.id.photo);
        this.context = context;
    }

    public void bind(Clothing clothingObject) {
        clothingName.setText(clothingObject.name);
        clothingInfo.setText(clothingObject.info);
        //clothingPhoto.setText(clothingObject.photo);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, clothingName.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}