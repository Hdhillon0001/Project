package com.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.project.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private User user;
    private Context context;
    private List<User> userList;


    public class ViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView tvName, tvEmail;
        CardView cardView;


        ViewHolder(View view) {
            super(view);

            tvName = view.findViewById(R.id.tvName);
            tvEmail = view.findViewById(R.id.tvEmail);
            cardView = view.findViewById(R.id.cardView);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    user = userList.get(getAdapterPosition());
                    Intent i = new Intent(context, HireActivity.class);
                    i.putExtra("userid", user.getUserId());
                    i.putExtra("name", user.getName());
                    context.startActivity(i);
                }
            });


        }


    }

    public UserAdapter(Context mContext, List<User> userList) {
        this.context = mContext;
        this.userList = userList;

    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_babysitter, parent, false);


        return new UserAdapter.ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final UserAdapter.ViewHolder holder, final int position) {

        user = userList.get(position);
        holder.tvName.setText(user.getName());
        holder.tvEmail.setText(user.getEmail());


    }

    @Override
    public int getItemCount() {
        return userList.size();
    }


}