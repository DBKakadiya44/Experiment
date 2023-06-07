package com.example.experiment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.experiment.databinding.ActivityOtherBinding;
import com.google.android.material.tabs.TabLayout;

public class OtherActivity extends AppCompatActivity {

    ActivityOtherBinding binding;
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        FragmentAdapter adapter=new FragmentAdapter(getSupportFragmentManager());
        Fragment fragmentOne=new Fragment();
        adapter.addFragment(new Fragment_One(),"Tab-1");
        adapter.addFragment(new Fragment_Two(),"Tab-2");
        adapter.addFragment(new Fragment_Three(),"Tab-3");
        viewPager=findViewById(R.id.view_pager);
        viewPager.setAdapter(adapter);
        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}