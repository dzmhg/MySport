package com.thuanb1510868.mysport.View.DanhGia;

import com.thuanb1510868.mysport.Model.ObjectClass.DanhGia;

import java.util.List;

public interface ViewDanhGia {
    void DanhGiaThanhCong();
    void DanhGiaThatBai();
    void HienThiDanhSachDanhGiaTheoSanPham(List<DanhGia> danhGiaList);
}
