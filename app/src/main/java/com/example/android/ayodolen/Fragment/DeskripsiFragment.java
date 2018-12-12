package com.example.android.ayodolen.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.ayodolen.R;


public class DeskripsiFragment extends Fragment {
    private String idWisata;
    private static final String ARG_TITLE = "title";

    public static DeskripsiFragment newInstance(String title){
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);

        DeskripsiFragment fragment = new DeskripsiFragment();
        fragment.setArguments(args);
        return fragment;

    }

    public DeskripsiFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getArguments();
        if (extras != null) {
            idWisata = extras.getString(ARG_TITLE);
        }
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deskripsi,container,false);

        TextView coba = view.findViewById(R.id.fragdesk);

        coba.setText(idWisata);


        return view;
    }
}
