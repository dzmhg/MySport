package com.thuanb1510868.mysport.Presenter.DanhGia;

import android.widget.ProgressBar;

import com.thuanb1510868.mysport.Model.ObjectClass.DanhGia;

public interface IPresenterDanhGia {
    void ThemDanhGia(DanhGia danhGia);
    void LayDanhSachDanhGiaCuaSanPham(int masp, int limit, ProgressBar progressBar);
}
