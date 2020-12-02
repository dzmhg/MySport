package com.thuanb1510868.mysport.View.ChiTietSanPham;

import com.thuanb1510868.mysport.Model.ObjectClass.DanhGia;
import com.thuanb1510868.mysport.Model.ObjectClass.SanPham;

import java.util.List;

public interface ViewChiTietSanPham {
    void HienChiTietSanPham(SanPham sanPham);
    void HienSliderSanPham(String[] linkhinhsanpham);
    void HienThiDanhGia(List<DanhGia> danhGiaList);
    void ThemGioHangThanhCong();
    void ThemGiohangThatBai();
}
