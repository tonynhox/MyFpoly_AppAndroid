package com.example.myfpolyapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myfpolyapp.R;
import com.example.myfpolyapp.models.GiangVienModel;

import java.util.List;

public class GiangVienAdapter extends RecyclerView.Adapter<GiangVienAdapter.ViewHolder> {

    private List<GiangVienModel> giangvienList;
    private Context context;

    public GiangVienAdapter(List<GiangVienModel> giangvienList, Context context) {
        this.giangvienList = giangvienList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_giangvien, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GiangVienModel giangvien = giangvienList.get(position);

        // Bind data to views here
        holder.textViewName.setText(giangvien.getName());
        Glide.with(context)
                .load(giangvien.getImage()) // Pass the URL to the image
                .centerCrop()
                .into(holder.imageViewGiangvien);
        holder.buttonFollow.setText(giangvien.getStatus() == 1 ? "Following" : "Follow");

        // You can set click listeners for the button here if needed.
    }

    @Override
    public int getItemCount() {
        return giangvienList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewGiangvien;
        private TextView textViewName;
        private Button buttonFollow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewGiangvien = itemView.findViewById(R.id.imageViewGiangvien);
            textViewName = itemView.findViewById(R.id.textViewName);
            buttonFollow = itemView.findViewById(R.id.buttonFollow);
        }
    }
}
