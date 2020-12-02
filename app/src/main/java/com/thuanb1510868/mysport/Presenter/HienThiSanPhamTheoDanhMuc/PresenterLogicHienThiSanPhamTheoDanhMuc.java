package com.thuanb1510868.mysport.Presenter.HienThiSanPhamTheoDanhMuc;

import android.view.View;
import android.widget.ProgressBar;

import com.thuanb1510868.mysport.Model.HienThiSanPhamTheoDanhMuc.ModelHienThiSanPhamTheoDanhMuc;
import com.thuanb1510868.mysport.Model.ObjectClass.SanPham;
import com.thuanb1510868.mysport.View.TrangChu.ViewHienThiSanPhamTheoDanhMuc;

import java.util.ArrayList;
import java.util.List;

public class PresenterLogicHienThiSanPhamTheoDanhMuc implements IPresenterHienThiSanPhamTheoDanhMuc {

    ViewHienThiSanPhamTheoDanhMuc viewHienThiSanPhamTheoDanhMuc;
    ModelHienThiSanPhamTheoDanhMuc modelHienThiSanPhamTheoDanhMuc;

    public PresenterLogicHienThiSanPhamTheoDanhMuc(ViewHienThiSanPhamTheoDanhMuc viewHienThiSanPhamTheoDanhMuc){

        this.viewHienThiSanPhamTheoDanhMuc = viewHienThiSanPhamTheoDanhMuc;
        modelHienThiSanPhamTheoDanhMuc = new ModelHienThiSanPhamTheoDanhMuc();
    }

    @Override
    public void LayDanhSachSanPhamTheoMaLoai(int masp, boolean kiemtra) {
        List<SanPham> sanPhamList = new ArrayList<>();
        if(kiemtra){
            sanPhamList = modelHienThiSanPhamTheoDanhMuc.LayDanhSachSanPhamTheoMaLoai(masp,"DANHSACHSANPHAM","LayDanhSachSanPhamTheoMaThuongHieu",0);
        }else{
            sanPhamList = modelHienThiSanPhamTheoDanhMuc.LayDanhSachSanPhamTheoMaLoai(masp,"DANHSACHSANPHAM","LayDanhSachSanPhamTheoMaLoaiDanhMuc",0);
        }

        if(sanPhamList.size() > 0){
            viewHienThiSanPhamTheoDanhMuc.HienThiDanhSachSanPham(sanPhamList);
        }else{
            viewHienThiSanPhamTheoDanhMuc.LoiHienThiDanhSachSanPham();
        }

    }

    public List<SanPham> LayDanhSachSanPhamTheoMaLoaiLoadMore(int masp, boolean kiemtra, int limit, ProgressBar progressBar){
        progressBar.setVisibility(View.VISIBLE);
        List<SanPham> sanPhamList = new ArrayList<>();
        if(kiemtra){
            sanPhamList = modelHienThiSanPhamTheoDanhMuc.LayDanhSachSanPhamTheoMaLoai(masp,"DANHSACHSANPHAM","LayDanhSachSanPhamTheoMaThuongHieu",limit);
        }else{
            sanPhamList = modelHienThiSanPhamTheoDanhMuc.LayDanhSachSanPhamTheoMaLoai(masp,"DANHSACHSANPHAM","LayDanhSachSanPhamTheoMaLoaiDanhMuc",limit);
        }

        if(sanPhamList.size() != 0){
            progressBar.setVisibility(View.GONE);
        }

        return sanPhamList;
    }
}
