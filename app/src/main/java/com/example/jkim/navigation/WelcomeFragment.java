package com.example.jkim.navigation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class WelcomeFragment extends Fragment {

    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.welcome_fragment, container, false);
        return rootview;
    }
}
