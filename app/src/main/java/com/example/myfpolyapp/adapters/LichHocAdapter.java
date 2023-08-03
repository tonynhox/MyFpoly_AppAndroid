package com.example.myfpolyapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpolyapp.R;
import com.example.myfpolyapp.models.LichHocModel;

import java.util.List;

public class LichHocAdapter extends RecyclerView.Adapter<LichHocAdapter.LichHocViewHolder> {

    private List<LichHocModel> lichHocList;

    public LichHocAdapter(List<LichHocModel> lichHocList) {
        this.lichHocList = lichHocList;
    }

    @NonNull
    @Override
    public LichHocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lichhoc, parent, false);
        return new LichHocViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LichHocViewHolder holder, int position) {
        LichHocModel lichHoc = lichHocList.get(position);
        holder.bind(lichHoc);
    }

    @Override
    public int getItemCount() {
        return lichHocList.size();
    }

    static class LichHocViewHolder extends RecyclerView.ViewHolder {

        private TextView textNgay;
        private TextView textGiangDuong;
        private TextView textPhong;
        private TextView textMaMon;
        private TextView textTenMon;
        private TextView textCaHoc;
        private TextView textTenGiangVien;

        public LichHocViewHolder(@NonNull View itemView) {
            super(itemView);
            textNgay = itemView.findViewById(R.id.textNgay);
            textGiangDuong = itemView.findViewById(R.id.textGiangDuong);
            textPhong = itemView.findViewById(R.id.textPhong);
            textMaMon = itemView.findViewById(R.id.textMaMon);
            textTenMon = itemView.findViewById(R.id.textTenMon);
            textCaHoc = itemView.findViewById(R.id.textCaHoc);
            textTenGiangVien = itemView.findViewById(R.id.textTenGiangVien);
        }

        public void bind(LichHocModel lichHoc) {
            textNgay.setText(lichHoc.getNgay());
            textGiangDuong.setText(lichHoc.getGiangDuong());
            textPhong.setText(lichHoc.getPhong());
            textMaMon.setText(lichHoc.getMaMon());
            textTenMon.setText(lichHoc.getTenMon());
            textCaHoc.setText(lichHoc.getCaHoc());
            textTenGiangVien.setText(lichHoc.getTenGiangVien());

            // Bind the status field
//            String statusText = "Status: " + lichHoc.getStatus();
//            textStatus.setText(statusText);
        }
    }
}

