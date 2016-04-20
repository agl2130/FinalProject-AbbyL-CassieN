package abby.finalproject_abbylcassien1.walkincloset;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import abby.finalproject_abbylcassien1.R;

/**
 * Created by cassondranealon on 4/20/16.
 */
public class CardAdapter extends RecyclerView.Adapter<CardViewHolder> {

    private List<TopsInCloset> tops;
    private Context context;

    public CardAdapter(List<TopsInCloset> tops, Context context) {
        this.tops = tops;
        this.context = context;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_tops, parent, false);
        return new CardViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        TopsInCloset top = tops.get(position);
        holder.bind(top);
    }

    @Override
    public int getItemCount() {
        return tops.size();
    }
}