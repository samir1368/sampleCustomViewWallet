package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.fragment.WalletFragment;
import com.example.myapplication.interfaces.WalletClickListener;
import com.example.myapplication.model.Wallet;

import java.util.ArrayList;


public class WalletAdapter extends FragmentStatePagerAdapter {

    private Context context; // context always is necessary, I don't remove it
    private WalletClickListener listener = null;
    private ArrayList<Wallet> walletList = new ArrayList<>();
    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        Object obj = super.instantiateItem(container, position);
        return obj;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        if (object != null) {
            return ((Fragment) object).getView() == view;
        } else {
            return false;
        }
    }

    public WalletAdapter(FragmentManager fm, Context context, ArrayList<Wallet> walletList) {
        super(fm);
        this.context = context;
        this.walletList = walletList;

    }

    @Override
    public int getItemPosition(Object object) {
        // Causes adapter to reload all Fragments when
        // notifyDataSetChanged is called
        return POSITION_NONE;
    }

    @Override
    public Fragment getItem(int position) {
           return WalletFragment.newInstance(walletList,listener,position);


    }

    public void setListener(WalletClickListener listener) {
        this.listener = listener;
    }
    @Override
    public int getCount() {
        return walletList.size();

    }

}

