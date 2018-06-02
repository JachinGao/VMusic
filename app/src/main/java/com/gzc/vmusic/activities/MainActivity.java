package com.gzc.vmusic.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.gzc.vmusic.fragments.DiscoverFragment;
import com.gzc.vmusic.fragments.FriendsFragment;
import com.gzc.vmusic.fragments.MusicFragment;
import com.gzc.vmusic.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        final ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.check(R.id.actionbar_music);

        VMPagerAdapter vmPagerAdapter = new VMPagerAdapter(getSupportFragmentManager());
        vmPagerAdapter.addFragment(MusicFragment.newInstance());
        vmPagerAdapter.addFragment(DiscoverFragment.newInstance());
        vmPagerAdapter.addFragment(FriendsFragment.newInstance());
        viewPager.setAdapter(vmPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.actionbar_music);
                        break;
                    case 1:
                        radioGroup.check(R.id.actionbar_discover);
                        break;
                    case 2:
                        radioGroup.check(R.id.actionbar_friends);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.actionbar_music:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.actionbar_discover:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.actionbar_friends:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    static class VMPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> fragmentList = new ArrayList<>();

        public VMPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment) {
            fragmentList.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
