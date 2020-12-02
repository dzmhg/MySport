package com.thuanb1510868.mysport.Model.ThanhToan;

import android.util.Log;

import com.thuanb1510868.mysport.Connectinternet.DownloadJSON;
import com.thuanb1510868.mysport.Model.ObjectClass.ChiTietHoaDon;
import com.thuanb1510868.mysport.Model.ObjectClass.HoaDon;
import com.thuanb1510868.mysport.View.TrangChu.TrangChuActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ModelThanhToan {

    public boolean ThemHoaDon(HoaDon hoaDon){
        String duongdan = TrangChuActivity.SERVER_NAME;
        boolean kiemtra = false;
        List<HashMap<String, String>> attrs = new ArrayList<>();

        HashMap<String, String> hsHam = new HashMap<>();
        hsHam.put("ham","ThemHoaDon");

        List<ChiTietHoaDon> chiTietHoaDonList = hoaDon.getChiTietHoaDonList();

        String chuoijson = "{\"DANHSACHSANPHAM\" :[ ";
        for (int i=0; i<chiTietHoaDonList.size();i++){
            chuoijson += "{";
            chuoijson += "\"masp\" : " + chiTietHoaDonList.get(i).getMaSP() + ",";
            chuoijson += "\"soluong\" : " + chiTietHoaDonList.get(i).getSoLuong();

            if(i==chiTietHoaDonList.size() -1 ){
                chuoijson += "}";
            }else{
                chuoijson += "},";
            }

        }

        chuoijson += "]}";

        HashMap<String, String> hsDanhSachSanPham = new HashMap<>();
        hsDanhSachSanPham.put("danhsachsanpham",chuoijson);

        HashMap<String, String> hsTenNguoiNhan = new HashMap<>();
        hsTenNguoiNhan.put("tennguoinhan",hoaDon.getTenNguoiNhan());

        HashMap<String, String> hsSoDT = new HashMap<>();
        hsSoDT.put("sodt", String.valueOf(hoaDon.getSoDT()));

        HashMap<String, String> hsDiaChi = new HashMap<>();
        hsDiaChi.put("diachi", hoaDon.getDiaChi());

        HashMap<String, String> hsChuyenKhoan = new HashMap<>();
        hsChuyenKhoan.put("chuyenkhoan", String.valueOf(hoaDon.getChuyenKhoan()));

        attrs.add(hsHam);
        attrs.add(hsDanhSachSanPham);
        attrs.add(hsTenNguoiNhan);
        attrs.add(hsSoDT);
        attrs.add(hsDiaChi);
        attrs.add(hsChuyenKhoan);

        DownloadJSON downloadJSON = new DownloadJSON(duongdan,attrs);
        downloadJSON.execute();

        try {
            String dulieuJSON = downloadJSON.get();
            JSONObject jsonObject = new JSONObject(dulieuJSON);
            String ketqua = jsonObject.getString("ketqua");
            Log.d("kiemtra",ketqua);
            if(ketqua.equals("true")){
                kiemtra = true;
            }else{
                kiemtra = false;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return kiemtra;
    }

}
