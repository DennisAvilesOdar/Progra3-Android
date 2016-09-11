package com.luisarceparedes.iniciodesesion;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisarceparedes.iniciodesesion.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MisDatos extends Fragment {


    public MisDatos() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mis_datos, container, false);
    }

}
