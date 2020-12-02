package com.thuanb1510868.mysport.Presenter.TrangChu_TheThao;

import com.thuanb1510868.mysport.Model.ObjectClass.SanPham;
import com.thuanb1510868.mysport.Model.ObjectClass.TheThao;
import com.thuanb1510868.mysport.Model.ObjectClass.ThuongHieu;
import com.thuanb1510868.mysport.Model.TrangChu_TheThao.ModelTheThao;
import com.thuanb1510868.mysport.View.TrangChu.ViewTheThao;

import java.util.ArrayList;
import java.util.List;

public class PresenterLogicTheThao implements IPresenterTheThao {

    ViewTheThao viewTheThao;
    ModelTheThao modelTheThao;

    public PresenterLogicTheThao(ViewTheThao viewTheThao) {
        this.viewTheThao = viewTheThao;
        modelTheThao = new ModelTheThao();
    }

    @Override
    public void LayDanhSachTheThao() {
        List<TheThao> theThaos = new ArrayList<>();

        List<ThuongHieu> thuongHieuList = modelTheThao.LayDanhSachThuongHieuLon("LayDanhSachCacThuongHieuLon", "DANHSACHTHUONGHIEU");

        List<SanPham> sanPhamList = modelTheThao.LayDanhSachSanPhamTOP("LayDanhSachTopAoVaQuan", "TOPAOVAQUAN");

        TheThao theThao = new TheThao();
        theThao.setThuongHieus(thuongHieuList);
        theThao.setSanPhams(sanPhamList);

        theThao.setTennoibat("Thương hiệu lớn");
        theThao.setTentopnoibat("Top nổi bật");
        theThao.setThuonghieu(true);
        theThaos.add(theThao);

        List<SanPham> phukienList = modelTheThao.LayDanhSachSanPhamTOP("LayDanhSachTopPhuKien", "TOPPHUKIEN");
        List<ThuongHieu> topphukienList = modelTheThao.LayDanhSachThuongHieuLon("LayDanhSachPhuKien", "DANHSACHPHUKIEN");

        TheThao theThao1 = new TheThao();
        theThao1.setThuongHieus(topphukienList);
        theThao1.setSanPhams(phukienList);
        theThao1.setTennoibat("Phụ kiện");
        theThao1.setTentopnoibat("Top phụ kiện");
        theThao1.setThuonghieu(false);
        theThaos.add(theThao1);

        List<SanPham> tienichList = modelTheThao.LayDanhSachSanPhamTOP("LayTopTienIch", "TOPTIENICH");
        List<ThuongHieu> toptienichList = modelTheThao.LayDanhSachThuongHieuLon("LayDanhSachTienIch", "DANHSACHTIENICH");

        TheThao theThao2 = new TheThao();
        theThao2.setThuongHieus(toptienichList);
        theThao2.setSanPhams(tienichList);
        theThao2.setTennoibat("Tiện ích");
        theThao2.setTentopnoibat("Top phụ kiện");
        theThao2.setThuonghieu(false);
        theThaos.add(theThao2);

        if (thuongHieuList.size() > 0 && sanPhamList.size() > 0) {
            viewTheThao.HienThiDanhSach(theThaos);
        }
    }

    @Override
    public void LayDanhSachLogoThuongHieu() {
        List<ThuongHieu> thuongHieuList = modelTheThao.LayDanhSachThuongHieuLon("LayLogoThuongHieuLon", "DANHSACHTHUONGHIEU");
        if (thuongHieuList.size() >0) {
            viewTheThao.HienThiLogoThuongHieu(thuongHieuList);
        }else {
            viewTheThao.LoiLayDuLieu();
        }

    }

    @Override
    public void LayDanhSachSanPhamMoi() {
        List<SanPham> sanPhamList = modelTheThao.LayDanhSachSanPhamTOP("LayDanhSachSanPhamMoi", "DANHSACHSANPHAMMOIVE");
        if (sanPhamList.size() > 0) {
            viewTheThao.HienThiSanPhamMoiVe(sanPhamList);
        }else {
            viewTheThao.LoiLayDuLieu();
        }
    }
}
