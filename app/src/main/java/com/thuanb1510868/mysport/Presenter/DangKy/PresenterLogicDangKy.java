package com.thuanb1510868.mysport.Presenter.DangKy;

import com.thuanb1510868.mysport.Model.DangNhap_DangKy.ModelDangKy;
import com.thuanb1510868.mysport.Model.ObjectClass.NhanVien;
import com.thuanb1510868.mysport.View.DangNhap_DangKy.ViewDangKy;

public class PresenterLogicDangKy implements IPresenterDangKy{
    ViewDangKy viewDangKy;
    ModelDangKy modelDangKy;

    public PresenterLogicDangKy(ViewDangKy viewDangKy) {
        this.viewDangKy = viewDangKy;
        modelDangKy = new ModelDangKy();
    }

    @Override
    public void ThucHienDangKy(NhanVien nhanvien) {
       // modelDangKy.DangKyThanhVien(nhanvien);
        boolean kiemtra = modelDangKy.DangKyThanhVien(nhanvien);
        if (kiemtra) {
            viewDangKy.DangKyThanhCong();
        }else {
            viewDangKy.DangKyThatBai();
        }
    }
}
