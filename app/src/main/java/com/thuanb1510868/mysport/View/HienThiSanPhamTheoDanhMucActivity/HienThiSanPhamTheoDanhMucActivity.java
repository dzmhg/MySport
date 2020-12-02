package com.thuanb1510868.mysport.View.HienThiSanPhamTheoDanhMucActivity;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thuanb1510868.mysport.Adapter.AdapterTopAoTheThao;
import com.thuanb1510868.mysport.Model.ObjectClass.ILoadMore;
import com.thuanb1510868.mysport.Model.ObjectClass.LoadMoreScroll;
import com.thuanb1510868.mysport.Model.ObjectClass.SanPham;
import com.thuanb1510868.mysport.Presenter.HienThiSanPhamTheoDanhMuc.PresenterLogicHienThiSanPhamTheoDanhMuc;
import com.thuanb1510868.mysport.R;
import com.thuanb1510868.mysport.View.TrangChu.ViewHienThiSanPhamTheoDanhMuc;

import java.util.List;
//import android.widget.Toolbar;

public class HienThiSanPhamTheoDanhMucActivity extends Fragment implements ViewHienThiSanPhamTheoDanhMuc, View.OnClickListener, ILoadMore {

    RecyclerView recyclerView;
    Button btnThayDoiTrangThaiRecycler;
    ProgressBar progressBar;
    boolean danggrid = true;
    RecyclerView.LayoutManager layoutManager;
    PresenterLogicHienThiSanPhamTheoDanhMuc sanPhamTheoDanhMuc;
    AdapterTopAoTheThao adapterTopAoTheThao;

    int masp;
    boolean kiemtra;
    Toolbar toolbar;
    List<SanPham> sanPhamList1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_hienthisanphamtheodanhmuc,container,false);

        setHasOptionsMenu(false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycleViewHienThiSanPhamTheoDanhMuc);
        btnThayDoiTrangThaiRecycler = (Button) view.findViewById(R.id.btnThayDoiTrangThaiRecycler);
        toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);

        Bundle bundle = getArguments();
        masp = bundle.getInt("MALOAI",0);
        String tensanpham = bundle.getString("TENLOAI");
        kiemtra = bundle.getBoolean("KIEMTRA",false);

        sanPhamTheoDanhMuc = new PresenterLogicHienThiSanPhamTheoDanhMuc(this);
        sanPhamTheoDanhMuc.LayDanhSachSanPhamTheoMaLoai(masp,kiemtra);

        btnThayDoiTrangThaiRecycler.setOnClickListener(this);

        toolbar.setTitle(tensanpham);


        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().popBackStack("TrangChuActivity", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menutrangchu,menu);
    }


    @Override
    public void HienThiDanhSachSanPham(List<SanPham> sanPhamList) {
        sanPhamList1 = sanPhamList;
        if (danggrid) {
            layoutManager = new GridLayoutManager(getContext(), 2);
            adapterTopAoTheThao = new AdapterTopAoTheThao(getContext(), R.layout.custom_layout_topaoquan, sanPhamList1);

        }else {
            layoutManager = new LinearLayoutManager(getContext());
            adapterTopAoTheThao = new AdapterTopAoTheThao(getContext(), R.layout.custom_layout_list_topaovaquan, sanPhamList1);

        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterTopAoTheThao);
        recyclerView.addOnScrollListener(new LoadMoreScroll(layoutManager, this));
        adapterTopAoTheThao.notifyDataSetChanged();
    }

    @Override
    public void LoiHienThiDanhSachSanPham() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.btnThayDoiTrangThaiRecycler:
                danggrid = !danggrid;
                sanPhamTheoDanhMuc.LayDanhSachSanPhamTheoMaLoai(masp,kiemtra);
                ;break;
        }
    }

    @Override
    public void LoadMore(int tongitem) {
        List<SanPham> listsanPhamsLoadMore = sanPhamTheoDanhMuc.LayDanhSachSanPhamTheoMaLoaiLoadMore(masp,kiemtra,tongitem,progressBar);
        sanPhamList1.addAll(listsanPhamsLoadMore);
        adapterTopAoTheThao.notifyDataSetChanged();

    }
}

