package com.example.myapplication.fragment;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.interfaces.WalletClickListener;
import com.example.myapplication.model.Wallet;

import java.util.ArrayList;
import java.util.List;

public class WalletFragment extends Fragment {
    private List<Wallet> walletList = new ArrayList<>();
    Context context;
    ImageView walletBackground;
    int position;
    WalletClickListener clickListener;

    public static WalletFragment newInstance(List<Wallet> list, WalletClickListener listener, int position) {

        WalletFragment fragment = new WalletFragment();
        fragment.walletList = list;
       fragment.clickListener =listener;
       fragment.position=position;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.fragment_wallet, container, false);
        context = getContext();
        view.setRotationY(180);
        walletBackground = view.findViewById(R.id.wallet);
            walletBackground.setBackgroundResource(R.drawable.test);//we can use walletList
            walletBackground.setOnClickListener(view1 -> clickListener.walletItemClicked(position));

        return view;
    }

}