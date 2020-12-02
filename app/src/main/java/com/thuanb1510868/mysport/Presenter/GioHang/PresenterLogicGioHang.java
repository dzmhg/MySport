package com.thuanb1510868.mysport.Presenter.GioHang;

import android.content.Context;

import com.thuanb1510868.mysport.Model.GioHang.ModelGioHang;
import com.thuanb1510868.mysport.Model.ObjectClass.SanPham;
import com.thuanb1510868.mysport.View.GioHang.ViewGioHang;

import java.util.List;

public class PresenterLogicGioHang implements IPresenterGioHang {

    ModelGioHang modelGioHang;
    ViewGioHang viewGioHang;

    public PresenterLogicGioHang(ViewGioHang viewGioHang){
        modelGioHang = new ModelGioHang();
        this.viewGioHang = viewGioHang;
    }

    @Override
    public void LayDanhSachSanPhamTrongGioHang(Context context) {
        modelGioHang.MoKetNoiSQL(context);
        List<SanPham> sanPhamList = modelGioHang.LayDanhSachSanPhamTrongGioHang();
        if(sanPhamList.size() > 0){
            viewGioHang.HienThiDanhSachSanPhamTrongGioHang(sanPhamList);
        }
    }
}
