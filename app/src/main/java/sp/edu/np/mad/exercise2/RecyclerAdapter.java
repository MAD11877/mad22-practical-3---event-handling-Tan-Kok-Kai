package sp.edu.np.mad.exercise2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private ArrayList<User> usersList;
    private OnImageListener monImageListener;
    public RecyclerAdapter(ArrayList<User> usersList, OnImageListener onImageListener){
        this.usersList = usersList;
        this.monImageListener = onImageListener;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTxt;
        private TextView descTxt;
        private ImageView pfp;
        OnImageListener onImageListener;
        public MyViewHolder(final View view, OnImageListener onImageListener){
            super(view);
            nameTxt = view.findViewById(R.id.username2);
            descTxt = view.findViewById(R.id.description2);
            pfp = view.findViewById(R.id.userPic);
            this.onImageListener = onImageListener;
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onImageListener.onImageClick(getAdapterPosition());
        }
    }
    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false);
        return new MyViewHolder(itemview, monImageListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        String name = usersList.get(position).getName();
        holder.nameTxt.setText(name);
        String desc = usersList.get(position).getDescription();
        holder.descTxt.setText(desc);
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
    public interface OnImageListener{
        void onImageClick(int position);
    }
}
