package com.gzc.vmusic.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gzc.vmusic.R;

/**
 * Created by Gaozhaochen on 2017/3/6.
 */

public class DiscoverFragment extends BaseFragment {
    public static DiscoverFragment newInstance() {
        return new DiscoverFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragment_main_discover, container, false);
        return layout;
    }
}
