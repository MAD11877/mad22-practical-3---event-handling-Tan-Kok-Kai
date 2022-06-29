package sp.edu.np.mad.exercise2;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class myViewHolder extends RecyclerView.ViewHolder{
    TextView txt;
    TextView desc;
    ImageView image;
    public myViewHolder(View itemView) {
        super(itemView);
        txt = itemView.findViewById(R.id.nameText);
        desc = itemView.findViewById(R.id.descriptionText);
        image = itemView.findViewById(R.id.viewHolderImage);
    }

}
