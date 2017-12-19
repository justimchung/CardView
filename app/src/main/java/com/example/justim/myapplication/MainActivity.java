package com.example.justim.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager vpFragment = (ViewPager) findViewById(R.id.vpFragment);
        final ComicHouseFragmentPageAdapter adapter = new ComicHouseFragmentPageAdapter(getSupportFragmentManager());
        vpFragment.setAdapter(adapter);
        vpFragment.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 1) {
                    int index = vpFragment.getCurrentItem();
                    FavoriateComicItemFragment tabFragment = (FavoriateComicItemFragment) adapter.instantiateItem(vpFragment, index);
                    tabFragment.reflash();
                    RecyclerView rclist = (RecyclerView) tabFragment.getView().findViewById(R.id.list);
                    rclist.getAdapter().notifyDataSetChanged();
                }



            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(vpFragment);
    }
}
