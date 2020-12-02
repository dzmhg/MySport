package com.thuanb1510868.mysport.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.thuanb1510868.mysport.Model.ObjectClass.ThuongHieu;
import com.thuanb1510868.mysport.R;

import java.util.List;

public class AdapterThuongHieuLonTheThao extends RecyclerView.Adapter<AdapterThuongHieuLonTheThao.ViewHolderThuongHieuLon> {

    Context context;
    List<ThuongHieu> thuongHieus;

    public AdapterThuongHieuLonTheThao(Context context, List<ThuongHieu> thuongHieus) {
        this.context = context;
        this.thuongHieus = thuongHieus;
    }

    public class ViewHolderThuongHieuLon extends RecyclerView.ViewHolder {
        ImageView imLogoThuongHieuLon;

        public ViewHolderThuongHieuLon(View itemView) {
            super(itemView);

            imLogoThuongHieuLon = (ImageView) itemView.findViewById(R.id.imLogoTopThuongHieuLon);
        }
    }

    @NonNull
    @Override
    public ViewHolderThuongHieuLon onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout_recycler_topthuonghieulon_thethao, parent, false);

        ViewHolderThuongHieuLon viewHolderThuongHieuLon = new ViewHolderThuongHieuLon(view);

        return viewHolderThuongHieuLon;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderThuongHieuLon holder, int position) {
        ThuongHieu thuongHieu = thuongHieus.get(position);
      //  Picasso.get().load(thuongHieu.getHINHTHUONGHIEU()).resize(120, 120).into(holder.imHinhThuongHieu, new Callback() {

        Picasso.get().load(thuongHieu.getHINHTHUONGHIEU()).resize(180,90).centerInside().into(holder.imLogoThuongHieuLon);
    }

    @Override
    public int getItemCount() {
        return thuongHieus.size();
    }


}
