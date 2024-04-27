package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.interfaces.WalletClickListener;
import com.example.myapplication.model.Wallet;
import com.example.myapplication.util.CustomWalletViewPager;
import com.example.myapplication.R;
import com.example.myapplication.adapter.WalletAdapter;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements WalletClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomWalletViewPager myWalletViewPager = findViewById(R.id.kk_pager);
        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.minus);


        ArrayList<Wallet> myWallets = getWallets();
        WalletAdapter adapter = new WalletAdapter(getSupportFragmentManager(), getApplicationContext(), myWallets);
        adapter.setListener(this);
        myWalletViewPager.setAdapter(adapter);
        myWalletViewPager.setAnimationEnabled(true);
        myWalletViewPager.setFadeEnabled(true);
        myWalletViewPager.setFadeFactor(0.6f);
        myWalletViewPager.setPadding(30, 10, 30, 10);//custom padding

        plus.setOnClickListener(view -> {
            if (myWalletViewPager.getCurrentItem() < myWallets.size())
                myWalletViewPager.setCurrentItem(myWalletViewPager.getCurrentItem() + 1);
            Toast.makeText(getApplicationContext(), "item : " + myWalletViewPager.getCurrentItem(), Toast.LENGTH_SHORT).show();
        });

        minus.setOnClickListener(view -> {
            if (myWalletViewPager.getCurrentItem() > 0)
                myWalletViewPager.setCurrentItem(myWalletViewPager.getCurrentItem() - 1);
            Toast.makeText(getApplicationContext(), "item :  " + myWalletViewPager.getCurrentItem(), Toast.LENGTH_SHORT).show();
        });

        myWalletViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(getApplicationContext(), "scroll item  :  " + myWalletViewPager.getCurrentItem(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private ArrayList<Wallet> getWallets(){
        ArrayList<Wallet> sampleItem =new ArrayList<>();
        sampleItem.add(new Wallet());
        sampleItem.add(new Wallet());
        sampleItem.add(new Wallet());
        sampleItem.add(new Wallet());
        sampleItem.add(new Wallet());
        return sampleItem;
    }
    @Override
    public void walletItemClicked(int position) {
        Toast.makeText(getApplicationContext(), "Clicked item" + position, Toast.LENGTH_SHORT).show();
    }
}