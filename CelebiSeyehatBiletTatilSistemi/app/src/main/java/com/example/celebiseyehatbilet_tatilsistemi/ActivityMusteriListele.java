package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class ActivityMusteriListele extends AppCompatActivity {
    RecyclerView recyclerView;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteri_listele);
        Intent intentMusteriler=getIntent();
        final ArrayList<Musteri> musteriler = (ArrayList<Musteri>) intentMusteriler.getSerializableExtra("musteriler");
        recyclerView = this.findViewById(R.id.recyclerViewMusteri);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AdapterMusteri adapterMusteri = new AdapterMusteri(musteriler,context);
        recyclerView.setAdapter(adapterMusteri);

    }
}
