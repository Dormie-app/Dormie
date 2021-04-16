package com.example.dormieapp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseFile;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private Context context;
    private List<UserAttributes> users;

    public UserAdapter(Context context, List<UserAttributes> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ViewHolder holder, int position) {
     UserAttributes user = users.get(position);
        holder.bind(user);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView aboutMe;
        private TextView hall;
        private TextView rating;
        private ImageView ivprofilePic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.studentName);
            aboutMe = itemView.findViewById(R.id.aboutMe);
            hall = itemView.findViewById(R.id.hallPref);
            rating = itemView.findViewById(R.id.rating);
            ivprofilePic = itemView.findViewById(R.id.profilePic);
        }

        @SuppressLint("SetTextI18n")
        public void bind(UserAttributes user) {
            name.setText(user.getKeyName());
            aboutMe.setText(user.getKeyDescription());
            hall.setText(user.getKeyHousing());
            rating.setText(Double.toString(Math.floor(Math.random()*10)+1));
            ParseFile profilePic = user.getKeyPic();
            if(profilePic != null){
                Glide.with(context).load(profilePic.getUrl()).into(ivprofilePic);
            }
        }
    }
}
