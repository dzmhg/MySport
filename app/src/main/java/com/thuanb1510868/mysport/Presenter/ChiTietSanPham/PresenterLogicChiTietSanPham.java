package com.thuanb1510868.mysport.Presenter.ChiTietSanPham;

import android.content.Context;

import com.thuanb1510868.mysport.Model.ChiTietSanPham.ModelChiTietSanPham;
import com.thuanb1510868.mysport.Model.GioHang.ModelGioHang;
import com.thuanb1510868.mysport.Model.ObjectClass.DanhGia;
import com.thuanb1510868.mysport.Model.ObjectClass.SanPham;
import com.thuanb1510868.mysport.View.ChiTietSanPham.ViewChiTietSanPham;

import java.util.List;

public class PresenterLogicChiTietSanPham implements IPresenterChiTietSanPham {

    ViewChiTietSanPham viewChiTietSanPham;
    ModelChiTietSanPham modelChiTietSanPham;
    ModelGioHang modelGioHang;

    public PresenterLogicChiTietSanPham(){
        modelGioHang = new ModelGioHang();
    }

    public PresenterLogicChiTietSanPham(ViewChiTietSanPham viewChiTietSanPham){
        this.viewChiTietSanPham = viewChiTietSanPham;
        modelChiTietSanPham = new ModelChiTietSanPham();
        modelGioHang = new ModelGioHang();
    }

    @Override
    public void LayChiTietSanPham(int masp) {
        SanPham sanPham = modelChiTietSanPham.LayChiTietSanPham("LaySanPhamVsChitietTheoMaSP","CHITIETSANPHAM",masp);
        if(sanPham.getMASP() > 0){
            String[] linkhinhanh = sanPham.getANHNHO().split(",");
            viewChiTietSanPham.HienSliderSanPham(linkhinhanh);
            viewChiTietSanPham.HienChiTietSanPham(sanPham);
        }
    }

    @Override
    public void LayDanhSachDanhGiaTheoCuaSanPham(int masp, int limit) {
        List<DanhGia> danhGias = modelChiTietSanPham.LayDanhSachDanhGiaCuaSanPham(masp,limit);

        if(danhGias.size() >0){
            viewChiTietSanPham.HienThiDanhGia(danhGias);
        }
    }

    @Override
    public void ThemGioHang(SanPham sanPham, Context context) {
        modelGioHang.MoKetNoiSQL(context);
        boolean kiemtra = modelGioHang.ThemGioHang(sanPham);
        if (kiemtra){
            viewChiTietSanPham.ThemGioHangThanhCong();
        }else{
            viewChiTietSanPham.ThemGiohangThatBai();
        }
    }

    public int DemSanPhamCoTrongGioHang(Context context){
        modelGioHang.MoKetNoiSQL(context);
        List<SanPham> sanPhamList = modelGioHang.LayDanhSachSanPhamTrongGioHang();

        int dem = sanPhamList.size();

        return dem;
    }
}
