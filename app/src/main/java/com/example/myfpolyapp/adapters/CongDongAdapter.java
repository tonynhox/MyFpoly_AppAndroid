package com.example.myfpolyapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myfpolyapp.R;
import com.example.myfpolyapp.models.GiangVienModel;

import java.util.List;

public class CongDongAdapter  extends RecyclerView.Adapter<CongDongAdapter.CongDongViewHolder> {
    private List<GiangVienModel> giangVienList;

    public CongDongAdapter(List<GiangVienModel> giangVienList) {
        this.giangVienList = giangVienList;
    }

    @NonNull
    @Override
    public CongDongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_congdong, parent, false);
        return new CongDongViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CongDongViewHolder holder, int position) {
        GiangVienModel giangVien = giangVienList.get(position);
        holder.ownerNameTextView.setText(giangVien.getName());
        holder.postTitleTextView.setText(giangVien.getTitle());
        holder.postContentTextView.setText(giangVien.getContent());
        holder.createdAtTextView.setText(giangVien.getCreated_at());
         Glide.with(holder.itemView.getContext()).load(giangVien.getImage()).into(holder.avatarImageView);
    }

    @Override
    public int getItemCount() {
        return giangVienList.size();
    }

    public static class CongDongViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarImageView;
        TextView ownerNameTextView;
        TextView postTitleTextView;
        TextView postContentTextView;
        TextView createdAtTextView;

        public CongDongViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarImageView = itemView.findViewById(R.id.avatarImageView);
            ownerNameTextView = itemView.findViewById(R.id.ownerNameTextView);
            postTitleTextView = itemView.findViewById(R.id.postTitleTextView);
            postContentTextView = itemView.findViewById(R.id.postContentTextView);
            createdAtTextView = itemView.findViewById(R.id.createdAtTextView);
        }
    }
}
