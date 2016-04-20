package abby.finalproject_abbylcassien1.walkincloset;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import abby.finalproject_abbylcassien1.R;

/**
 * Created by cassondranealon on 4/20/16.
 */
public class CardViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView topsName;
    private TextView topsInfo;
    private ImageView topsPhoto;
    private Context context;

    public CardViewHolder(View itemView, final Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view);
        topsName = (TextView) itemView.findViewById(R.id.name);
        topsInfo = (TextView) itemView.findViewById(R.id.info);
        topsPhoto = (ImageView) itemView.findViewById(R.id.photo);
        this.context = context;
    }

    public void bind(TopsInCloset tops) {
        topsName.setText(tops.name);
        topsInfo.setText(tops.info);
        topsPhoto.setImageResource(tops.photo);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, topsName.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}