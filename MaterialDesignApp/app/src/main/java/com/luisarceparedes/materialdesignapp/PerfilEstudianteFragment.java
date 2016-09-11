package com.luisarceparedes.materialdesignapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luisarceparedes.materialdesignapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilEstudianteFragment extends Fragment {


    public PerfilEstudianteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_perfil_estudiante, container, false);
    }

}
