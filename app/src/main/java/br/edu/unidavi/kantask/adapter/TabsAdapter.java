package br.edu.unidavi.kantask.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabsAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titles = new ArrayList<>();

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addTab(Fragment fragment, String tabTitle){
        this.fragments.add(fragment);
        this.titles.add(tabTitle);
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return this.titles.get(position);
    }
}
