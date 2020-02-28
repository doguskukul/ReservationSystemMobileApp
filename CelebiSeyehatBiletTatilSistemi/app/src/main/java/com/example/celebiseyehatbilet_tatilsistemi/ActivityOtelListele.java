package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class ActivityOtelListele extends AppCompatActivity {
    RecyclerView recyclerView;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otel_listele);
        Intent intentOtelListele=getIntent();
        final ArrayList<Otel> oteller=(ArrayList<Otel>) intentOtelListele.getSerializableExtra("oteller");
        String girisTarihi=intentOtelListele.getStringExtra("girisTarihi");
        String cikisTarihi=intentOtelListele.getStringExtra("cikisTarihi");
        String amac=intentOtelListele.getStringExtra("amac");
        recyclerView=(RecyclerView) this.findViewById(R.id.recyclerViewOtel);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AdapterOtel adapterOtel=new AdapterOtel(oteller,context,girisTarihi,cikisTarihi,amac);
        recyclerView.setAdapter(adapterOtel);
    }
}
