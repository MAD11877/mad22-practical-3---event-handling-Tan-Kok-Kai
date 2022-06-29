package sp.edu.np.mad.exercise2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdaptor extends RecyclerView.Adapter<myViewHolder> {
    ArrayList<User> data;

    public myAdaptor(ArrayList<User> input) {
        data = input;
    }

    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.viewholder, parent, false);
        return new myViewHolder(item);
    }
    public void onBindViewHolder(myViewHolder holder, int position){
        User s = data.get(position);
        holder.txt.setText(s.getName());
        holder.desc.setText(s.getDescription());
    }
    public int getItemCount(){
        return data.size();
    }
}
