package abby.finalproject_abbylcassien1.outfitoftheday;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

import abby.finalproject_abbylcassien1.R;

/**
 * Created by cassondranealon on 3/30/16.
 */
public class ViewShoes extends FrameLayout {

    private TextView textView;

    public ViewShoes(Context context) {
        super(context);
        init();
    }

    public ViewShoes(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ViewShoes(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(21)
    public ViewShoes(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.randomshoes, this);
        textView = (TextView) findViewById(R.id.text_shoes);
        textView.setText("Here are your shoes!");
    }
}
