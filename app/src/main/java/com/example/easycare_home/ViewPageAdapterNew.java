package com.example.easycare_home;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPageAdapterNew extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> FragmentListTitles = new ArrayList<>();
    public ViewPageAdapterNew(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new SignUp_Fragment();
                break;
            case 1:
                fragment = new SignIn_Fragment();
                break;

        }
        return fragment;
    }
    @Override
    public int getCount() {
        return FragmentListTitles.size();
    }
    public CharSequence getPageTitle (int position){
        switch (position){
            case 0:
                return "Signup";
            case 1:
                return "Signin";


        }
        return null;
    }

    public void AddFragment (Fragment fragment, String Title){
        fragmentList.add(fragment);
        FragmentListTitles.add(Title);
    }
}
