package com.example.roomwithjavarx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomwithjavarx.room.User;

import java.util.List;

public class recycle_adapter extends RecyclerView.Adapter<recycle_adapter.viewHodeler> {
    private List<User> users ;

    public recycle_adapter(List<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public viewHodeler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            vh = new viewHodeler(v);

        return (viewHodeler) vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHodeler holder, int position) {

        holder.username.setText(users.get(position).getUserName());
        holder.phone.setText(users.get(position).getPhone());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class viewHodeler extends RecyclerView.ViewHolder {
        TextView username;
        TextView phone;

        public viewHodeler(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.user_id);
            phone = itemView.findViewById(R.id.userphone_id);
        }
    }
}
