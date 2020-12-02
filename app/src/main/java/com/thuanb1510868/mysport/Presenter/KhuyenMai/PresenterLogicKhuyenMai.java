package com.thuanb1510868.mysport.Presenter.KhuyenMai;

import com.thuanb1510868.mysport.Model.KhuyenMai.ModelKhuyenMai;
import com.thuanb1510868.mysport.Model.ObjectClass.KhuyenMai;
import com.thuanb1510868.mysport.View.TrangChu.ViewKhuyenMai;

import java.util.List;

public class PresenterLogicKhuyenMai implements IPresenterKhuyenMai {

    ViewKhuyenMai viewKhuyenMai;
    ModelKhuyenMai modelKhuyenMai;

    public PresenterLogicKhuyenMai(ViewKhuyenMai viewKhuyenMai){
        this.viewKhuyenMai = viewKhuyenMai;
        modelKhuyenMai = new ModelKhuyenMai();
    }

    @Override
    public void LayDanhSachKhuyenMai() {
        List<KhuyenMai> khuyenMaiList = modelKhuyenMai.LayDanhSachSanPhamTheoMaLoai("LayDanhSachKhuyenMai","DANHSACHKHUYENMAI");
        if(khuyenMaiList.size() > 0){
            viewKhuyenMai.HienThiDanhSachKhuyenMai(khuyenMaiList);
        }
    }
}
