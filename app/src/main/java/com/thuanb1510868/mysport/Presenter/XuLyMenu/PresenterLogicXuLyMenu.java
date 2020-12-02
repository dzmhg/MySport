package com.thuanb1510868.mysport.Presenter.XuLyMenu;

import android.util.Log;

import com.facebook.AccessToken;
import com.thuanb1510868.mysport.Connectinternet.DownloadJSON;
import com.thuanb1510868.mysport.Model.DangNhap_DangKy.ModelDangNhap;
import com.thuanb1510868.mysport.Model.ObjectClass.LoaiSanPham;
import com.thuanb1510868.mysport.Model.XuLyMenu.XuLyJSONMenu;
import com.thuanb1510868.mysport.View.TrangChu.TrangChuActivity;
import com.thuanb1510868.mysport.View.TrangChu.ViewXuLyMenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

//import com.facebook.AccessToken;

public class PresenterLogicXuLyMenu implements IPresenterXuLyMenu {

    ViewXuLyMenu viewXuLyMenu;
    String tennguoidung = "";


    public PresenterLogicXuLyMenu(ViewXuLyMenu viewXuLyMenu){
        this.viewXuLyMenu = viewXuLyMenu;
    }

    @Override
    public void LayDanhSachMenu() {
        List<LoaiSanPham> loaiSanPhamList;
        String dataJSON = "";
        List<HashMap<String, String>> attrs = new ArrayList<>();

        //Lấy bằng phương thức get
        //String duongdan = "http://192.168.1.35:81/petsv/api/loaisanpham.php?maloaicha=0";

        //DownloadJSON downloadJSON = new DownloadJSON(duongdan);
        // end phương thức get

        //Lấy bằng phương thức post
        String duongdan = TrangChuActivity.SERVER_NAME;

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham", "LayDanhSachMenu");
//
        HashMap<String, String> hsMaLoaiCha = new HashMap<>();
        hsMaLoaiCha.put("maloaicha", "0");
//
        attrs.add(hsMaLoaiCha);
        attrs.add(hsHam);

        DownloadJSON downloadJSON = new DownloadJSON(duongdan, attrs);
        //end phương thức post
        downloadJSON.execute();

        try {
            dataJSON = downloadJSON.get();
            XuLyJSONMenu xuLyJSONMenu = new XuLyJSONMenu();
//            xuLyJSONMenu.ParserJSONMenu(dataJSON);
            loaiSanPhamList = xuLyJSONMenu.ParserJSONMenu(dataJSON);
            Log.d("^_^ :",loaiSanPhamList.toString());
            viewXuLyMenu.HienThiDanhSachMenu(loaiSanPhamList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    @Override
    public AccessToken LayTokenDungFacebook() {
        ModelDangNhap modelDangNhap = new ModelDangNhap();
        AccessToken accessToken = modelDangNhap.LayTokenFacebookHienTai();
        return accessToken;
    }

}
