package com.thuanb1510868.mysport.Presenter.DanhGia;

import android.view.View;
import android.widget.ProgressBar;

import com.thuanb1510868.mysport.Model.DanhGia.ModelDanhGia;
import com.thuanb1510868.mysport.Model.ObjectClass.DanhGia;
import com.thuanb1510868.mysport.View.DanhGia.ViewDanhGia;

import java.util.List;

public class PresenterLogicDanhGia implements IPresenterDanhGia {

    ViewDanhGia viewDanhGia;
    ModelDanhGia modelDanhGia;

    public PresenterLogicDanhGia(ViewDanhGia viewDanhGia){
        this.viewDanhGia = viewDanhGia;
        modelDanhGia = new ModelDanhGia();
    }

    @Override
    public void ThemDanhGia(DanhGia danhGia) {
        boolean kiemtra = modelDanhGia.ThemDanhGia(danhGia);
        if (kiemtra){
            viewDanhGia.DanhGiaThanhCong();
        }else{
            viewDanhGia.DanhGiaThatBai();
        }
    }

    @Override
    public void LayDanhSachDanhGiaCuaSanPham(int masp, int limit, ProgressBar progressBar) {
        progressBar.setVisibility(View.VISIBLE);
        List<DanhGia> danhGiaList = modelDanhGia.LayDanhSachDanhGiaCuaSanPham(masp,limit);

        if (danhGiaList.size() > 0){
            progressBar.setVisibility(View.GONE);
            viewDanhGia.HienThiDanhSachDanhGiaTheoSanPham(danhGiaList);
        }
    }
}
