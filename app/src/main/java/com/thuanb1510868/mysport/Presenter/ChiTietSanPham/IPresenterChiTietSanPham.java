package com.thuanb1510868.mysport.Presenter.ChiTietSanPham;

import android.content.Context;

import com.thuanb1510868.mysport.Model.ObjectClass.SanPham;

public interface IPresenterChiTietSanPham {
    void LayChiTietSanPham(int masp);
    void LayDanhSachDanhGiaTheoCuaSanPham(int masp, int limit);
    void ThemGioHang(SanPham sanPham, Context context);
}
