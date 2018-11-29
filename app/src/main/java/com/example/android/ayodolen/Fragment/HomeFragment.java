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

import com.example.android.ayodolen.KategoriActivity;
import com.example.android.ayodolen.R;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

/**
 * Created by user on 27/11/2018.
 */

public class HomeFragment extends Fragment {
    FlipperLayout flipper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        flipper = view.findViewById(R.id.flipper);

        Button btna = view.findViewById(R.id.btnPantai);


        btna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KategoriActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        setLayout();

        return view;
    }



    private void setLayout(){
        String url [] = new String[]{
                "https://upload.wikimedia.org/wikipedia/commons/thumb/5/58/Malang_WEB.jpg/1200px-Malang_WEB.jpg",
                "https://pergimulu.com/wp-content/uploads/2017/03/Panduan-Tips-Pergi-Liburan-Ke-Malang-via-@candra_ea.jpg",
                "https://img.ayokuliah.id/uploads/2015/09/Politeknik-Negeri-Malang.jpg"

        };

        for(int i=0; i<3; i++){
            FlipperView fv = new FlipperView(getActivity().getBaseContext());
            fv.setImageUrl(url[i])
                    .setDescription("Image"+(i+1));
            flipper.addFlipperView(fv);
        }
    }


}
