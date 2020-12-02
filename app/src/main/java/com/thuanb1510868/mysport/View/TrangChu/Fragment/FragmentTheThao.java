package com.thuanb1510868.mysport.View.TrangChu.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.thuanb1510868.mysport.Adapter.AdapterTheThao;
import com.thuanb1510868.mysport.Adapter.AdapterThuongHieuLonTheThao;
import com.thuanb1510868.mysport.Adapter.AdapterTopAoTheThao;
import com.thuanb1510868.mysport.Model.ObjectClass.SanPham;
import com.thuanb1510868.mysport.Model.ObjectClass.TheThao;
import com.thuanb1510868.mysport.Model.ObjectClass.ThuongHieu;
import com.thuanb1510868.mysport.Presenter.TrangChu_TheThao.PresenterLogicTheThao;
import com.thuanb1510868.mysport.R;
import com.thuanb1510868.mysport.View.TrangChu.ViewTheThao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FragmentTheThao extends Fragment implements ViewTheThao {
    RecyclerView recyclerView, recyclerTopCacThuongHieuLon, recyclerHangMoiVe;
    List<TheThao> theThaoList;
    PresenterLogicTheThao presenterLogicTheThao;
    ImageView imSanPham1,imSanPham2,imSanPham3;
    TextView txtSanPham1,txtSanPham2,txtSanPham3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_thethao, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerTheThao);
        recyclerTopCacThuongHieuLon = (RecyclerView) view.findViewById(R.id.recylerTopCacThuongHieuLon);
        recyclerHangMoiVe = (RecyclerView) view.findViewById(R.id.recylerHangMoiVe);

        imSanPham1 = (ImageView) view.findViewById(R.id.imSanPham1);
        imSanPham2 = (ImageView) view.findViewById(R.id.imSanPham2);
        imSanPham3 = (ImageView) view.findViewById(R.id.imSanPham3);

        txtSanPham1 = (TextView) view.findViewById(R.id.txtSanPham1);
        txtSanPham2 = (TextView) view.findViewById(R.id.txtSanPham2);
        txtSanPham3 = (TextView) view.findViewById(R.id.txtSanPham3);

        presenterLogicTheThao = new PresenterLogicTheThao(this);

        theThaoList = new ArrayList<>();

        presenterLogicTheThao.LayDanhSachTheThao();
        presenterLogicTheThao.LayDanhSachLogoThuongHieu();
        presenterLogicTheThao.LayDanhSachSanPhamMoi();

        return view;
    }

    @Override
    public void HienThiDanhSach(List<TheThao> theThaos) {

        theThaoList = theThaos;

        AdapterTheThao adapterTheThao = new AdapterTheThao(getContext(), theThaoList);//teclass.this
        // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterTheThao);

        adapterTheThao.notifyDataSetChanged();


    }

    @Override
    public void HienThiLogoThuongHieu(List<ThuongHieu> thuongHieus) {
        AdapterThuongHieuLonTheThao adapterThuongHieuLonTheThao = new AdapterThuongHieuLonTheThao(getContext(), thuongHieus);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.HORIZONTAL, false);

        recyclerTopCacThuongHieuLon.setLayoutManager(layoutManager);
        recyclerTopCacThuongHieuLon.setAdapter(adapterThuongHieuLonTheThao);
        adapterThuongHieuLonTheThao.notifyDataSetChanged();
    }

    @Override
    public void LoiLayDuLieu() {

    }

    @Override
    public void HienThiSanPhamMoiVe(List<SanPham> sanPhams) {
        AdapterTopAoTheThao adapterTopAoTheThao = new AdapterTopAoTheThao(getContext(), R.layout.custom_layout_topaoquan, sanPhams);
        RecyclerView.LayoutManager layoutManagerTop = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerHangMoiVe.setLayoutManager(layoutManagerTop);
        recyclerHangMoiVe.setAdapter(adapterTopAoTheThao);

        adapterTopAoTheThao.notifyDataSetChanged();

        Random random = new Random();
        int vitri = random.nextInt(sanPhams.size());

        // Picasso.get().load(thuongHieu.getHINHTHUONGHIEU()).resize(180,90).centerInside().into(holder.imLogoThuongHieuLon);
        Picasso.get().load(sanPhams.get(vitri).getANHLON()).fit().centerInside().into(imSanPham1);
        txtSanPham1.setText(sanPhams.get(vitri).getTENSP());

        int vitri1 = random.nextInt(sanPhams.size());
        Picasso.get().load(sanPhams.get(vitri1).getANHLON()).fit().centerInside().into(imSanPham2);
        txtSanPham2.setText(sanPhams.get(vitri1).getTENSP());

        int vitri2 = random.nextInt(sanPhams.size());
        Picasso.get().load(sanPhams.get(vitri2).getANHLON()).fit().centerInside().into(imSanPham3);
        txtSanPham3.setText(sanPhams.get(vitri2).getTENSP());
    }
}
