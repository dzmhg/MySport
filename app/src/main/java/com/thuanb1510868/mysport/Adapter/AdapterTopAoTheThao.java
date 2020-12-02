package com.thuanb1510868.mysport.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.thuanb1510868.mysport.Model.ObjectClass.ChiTietKhuyenMai;
import com.thuanb1510868.mysport.Model.ObjectClass.SanPham;
import com.thuanb1510868.mysport.R;
import com.thuanb1510868.mysport.View.ChiTietSanPham.ChiTietSanPhamActivity;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

public class AdapterTopAoTheThao extends RecyclerView.Adapter<AdapterTopAoTheThao.ViewHolderTopAo> {

    Context context;
    List<SanPham> sanPhamList;
    int layout;

    public AdapterTopAoTheThao(Context context, int layout, List<SanPham> sanPhamList) {
        this.context = context;
        this.sanPhamList = sanPhamList;
        this.layout = layout;
    }

    public class ViewHolderTopAo extends RecyclerView.ViewHolder  {
        ImageView imHinhSanPham;
        TextView txtTenSP, txtGiaTien, txtGiamGia;
        CardView cardView;

        public ViewHolderTopAo(View itemView) {
            super(itemView);

            imHinhSanPham = (ImageView) itemView.findViewById(R.id.imTopAoTheThao);
            txtTenSP = (TextView) itemView.findViewById(R.id.txtTieuDeTopAoTheThao);
            txtGiaTien = (TextView) itemView.findViewById(R.id.txtGiaTheThao);
            txtGiamGia = (TextView) itemView.findViewById(R.id.txtGiamGiaTheThao);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
        }
    }

    @Override
    public ViewHolderTopAo onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(layout, parent, false);

        ViewHolderTopAo viewHolderTopAo = new ViewHolderTopAo(view);

        return viewHolderTopAo;
    }

    @Override
    public void onBindViewHolder(ViewHolderTopAo holder, int position) {
        SanPham sanPham = sanPhamList.get(position);
        Log.d("hinhsanpham", sanPham.getANHLON());
        Picasso.get().load(sanPham.getANHLON()).resize(240, 240).centerInside().into(holder.imHinhSanPham);
        holder.txtTenSP.setText(sanPham.getTENSP());

        ChiTietKhuyenMai chiTietKhuyenMai = sanPham.getChiTietKhuyenMai();
        int giatien = sanPham.getGIA();

        if(chiTietKhuyenMai !=null) {
            int phantramkm = chiTietKhuyenMai.getPHANTRAMKM();

            NumberFormat numberFormat = new DecimalFormat("####,###");
            String gia = numberFormat.format(giatien);
            Log.d("giasanpham", gia);
            //holder.txtGiamGia.setVisibility(View.VISIBLE);
            //holder.txtGiamGia.setPaintFlags(holder.txtGiamGia.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.txtGiaTien.setText(gia + " VNĐ ");
           // holder.cardView.setTag(sanPham.getMASP());
           // giatien = giatien * phantramkm/100;


        }

        NumberFormat numberFormat = new DecimalFormat("###,###");
        //String gia = numberFormat.format(sanPham.getGIA()).toString();
        String gia = numberFormat.format(giatien);
        holder.txtGiaTien.setText(gia + " VNĐ");
        holder.cardView.setTag(sanPham.getMASP());

        //holder.cardView.setTag(sanPham.getMASP());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ){
                Intent iChitietsanpham = new Intent(context, ChiTietSanPhamActivity.class);
                iChitietsanpham.putExtra("masp", (int)v.getTag());
                context.startActivity(iChitietsanpham);
            }
        });

    }

    @Override
    public int getItemCount() {
        return sanPhamList.size();
    }

}
