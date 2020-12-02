package com.thuanb1510868.mysport.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.thuanb1510868.mysport.View.TrangChu.Fragment.FragmentChuongTrinhKhuyenMai;
import com.thuanb1510868.mysport.View.TrangChu.Fragment.FragmentNoiBat;
import com.thuanb1510868.mysport.View.TrangChu.Fragment.FragmentTheThao;
import com.thuanb1510868.mysport.View.TrangChu.Fragment.FragmentThuongHieu;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> listFragment = new ArrayList<Fragment>();
    List<String> titleFragment = new ArrayList<String>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        listFragment.add(new FragmentTheThao());
        listFragment.add(new FragmentNoiBat());
        listFragment.add(new FragmentChuongTrinhKhuyenMai());
        listFragment.add(new FragmentThuongHieu());

        titleFragment.add("Đồ Thể Thao");
        titleFragment.add("Nổi Bật");
        titleFragment.add("Chương Trình Khuyến Mãi");
        titleFragment.add("Thương Hiệu");

    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }


    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleFragment.get(position);
    }
}

