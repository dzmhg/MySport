package com.thuanb1510868.mysport.View.TrangChu;

import com.thuanb1510868.mysport.Model.ObjectClass.SanPham;
import com.thuanb1510868.mysport.Model.ObjectClass.TheThao;
import com.thuanb1510868.mysport.Model.ObjectClass.ThuongHieu;

import java.util.List;

public interface ViewTheThao {
    void HienThiDanhSach(List<TheThao> linhKiens);
    void HienThiLogoThuongHieu(List<ThuongHieu> thuongHieus);
    void LoiLayDuLieu();
    void HienThiSanPhamMoiVe(List<SanPham> sanPhams);


}
