package com.thuanb1510868.mysport.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanb1510868.mysport.Model.ObjectClass.TheThao;
import com.thuanb1510868.mysport.R;

import java.util.List;

public class AdapterTheThao extends RecyclerView.Adapter<AdapterTheThao.ViewHolderTheThao> {
    Context context;
    List<TheThao> theThaoList;

    public AdapterTheThao(Context context, List<TheThao> thuCungList) {
        this.context = context;
        this.theThaoList = thuCungList;
    }

    public class ViewHolderTheThao extends RecyclerView.ViewHolder {
        ImageView imHinhKhuyenMaiTheThao;
        RecyclerView recyclerViewThuongHieuLon, recyclerViewTopSanPham;
        TextView txtTieuDeSanPhamNoiBat, txtTopSanPhamNoiBat;

        public ViewHolderTheThao(View itemView) {
            super(itemView);

            recyclerViewThuongHieuLon = (RecyclerView) itemView.findViewById(R.id.recyclerThuongHieuLon);
            recyclerViewTopSanPham = (RecyclerView) itemView.findViewById(R.id.recyclerTopAoQuan);
            imHinhKhuyenMaiTheThao = (ImageView) itemView.findViewById(R.id.imKhuyenMaiTheThao);
            txtTopSanPhamNoiBat = (TextView) itemView.findViewById(R.id.txtTenSanPhamNoiBat);
            txtTieuDeSanPhamNoiBat = (TextView) itemView.findViewById(R.id.txtTenTopSanPhamNoiBat);

        }

    }

    @Override
    public ViewHolderTheThao onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout_recyclerview_thethao, parent, false);

        ViewHolderTheThao viewHolderTheThao = new ViewHolderTheThao(view);

        return viewHolderTheThao;
    }

    @Override
    public void onBindViewHolder(ViewHolderTheThao holder, int position) {

        TheThao theThao = theThaoList.get(position);

        holder.txtTieuDeSanPhamNoiBat.setText(theThao.getTennoibat().toString());
        holder.txtTopSanPhamNoiBat.setText(theThao.getTentopnoibat().toString());

        //Xu ly hien thi danh sach thuong hieu lon Recyclerview Thuong Hieu Lon
        AdapterThuongHieuLon adapterThuongHieuLon = new AdapterThuongHieuLon(context, theThao.getThuongHieus(), theThao.isThuonghieu());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(context, 3, GridLayoutManager.HORIZONTAL, false);

        holder.recyclerViewThuongHieuLon.setLayoutManager(layoutManager);

        holder.recyclerViewThuongHieuLon.setAdapter(adapterThuongHieuLon);
        adapterThuongHieuLon.notifyDataSetChanged();

        //Xu ly hien thi danh sach top san pham Recyclerview Top San Pham

        AdapterTopAoTheThao adapterTopAoTheThao = new AdapterTopAoTheThao(context, R.layout.custom_layout_topaoquan, theThao.getSanPhams());

        RecyclerView.LayoutManager layoutManagerTop = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);

        holder.recyclerViewTopSanPham.setLayoutManager(layoutManagerTop);
        holder.recyclerViewTopSanPham.setAdapter(adapterTopAoTheThao);
    }

    @Override
    public int getItemCount() {
        return theThaoList.size();
    }
}
