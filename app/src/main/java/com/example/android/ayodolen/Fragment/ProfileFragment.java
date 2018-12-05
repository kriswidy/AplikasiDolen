package com.example.android.ayodolen.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.ayodolen.MainActivity;
import com.example.android.ayodolen.R;

/**
 * Created by user on 27/11/2018.
 */

public class ProfileFragment extends Fragment {

    View v;
    Button btnLogout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btnLogout = view.findViewById(R.id.btnKeluar);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent log = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(log);

                getActivity().finish();
            }
        });
        return view;

    }
}
