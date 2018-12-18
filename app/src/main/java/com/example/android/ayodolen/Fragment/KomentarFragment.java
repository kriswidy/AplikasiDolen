package com.example.android.ayodolen.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.ayodolen.Adapter.RecyclerAdapterKomentar;
import com.example.android.ayodolen.Model.Komentar;
import com.example.android.ayodolen.Model.KomentarResponse;
import com.example.android.ayodolen.R;
import com.example.android.ayodolen.Rest.ApiClient;
import com.example.android.ayodolen.Rest.ApiInterface;
import com.example.android.ayodolen.Session.SessionManagement;
import com.google.android.gms.common.api.Api;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KomentarFragment extends Fragment {
    private String idWisata;
    private static final String ARG_TITLE = "title";

    private ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerAdapterKomentar mAdapter;
    private List<Komentar> mKomentar = new ArrayList<>();

    EditText edtkomentar;
    Button btnKomen;

    public static KomentarFragment newInstance(String title){
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);

        KomentarFragment fragment = new KomentarFragment();
        fragment.setArguments(args);
        return fragment;

    }

    public KomentarFragment() {
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
        View view = inflater.inflate(R.layout.fragment_komentar,container,false);

        mRecyclerView = view.findViewById(R.id.rv_komentar);
//        TextView test = view.findViewById(R.id.fragkomen);

//        test.setText(idWisata);

        final SessionManagement s1 = new SessionManagement(getContext());
        edtkomentar = view.findViewById(R.id.text_komentar);
        btnKomen = view.findViewById(R.id.btnKomen);

        btnKomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData(s1.getKeyId());
                edtkomentar.setText("");




            }
        });

        LoadData();
        return view;
    }

    public void LoadData(){
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<KomentarResponse> getKomentar = mApiInterface.getKomentar(idWisata);
        getKomentar.enqueue(new Callback<KomentarResponse>() {
            @Override
            public void onResponse(Call<KomentarResponse> call, Response<KomentarResponse> response) {
                mKomentar = response.body().getKomentarList();

                mAdapter = new RecyclerAdapterKomentar(mKomentar,getContext());
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecyclerView.setAdapter(mAdapter);

            }

            @Override
            public void onFailure(Call<KomentarResponse> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });

    }

    public void insertData(String idUser){
        DateFormat df = new SimpleDateFormat("dd MMM yyyy");
        String date = df.format(Calendar.getInstance().getTime());
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<KomentarResponse> tambahKomentar = mApiInterface.tambahKomentar(idWisata,idUser,edtkomentar.getText().toString(),date);
        tambahKomentar.enqueue(new Callback<KomentarResponse>() {
            @Override
            public void onResponse(Call<KomentarResponse> call, Response<KomentarResponse> response) {
                if(response.body().getStatus().equals("sukses")){
                    Toast.makeText(getActivity(),"Berhasil Menambahkan Komentar",Toast.LENGTH_SHORT).show();
                    LoadData();

                }else{
                    Toast.makeText(getActivity(),"Gagal Menambahkan Komentar",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<KomentarResponse> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }


}
