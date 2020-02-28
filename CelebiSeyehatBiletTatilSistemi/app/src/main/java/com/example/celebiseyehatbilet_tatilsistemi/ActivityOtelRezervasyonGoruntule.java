package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class ActivityOtelRezervasyonGoruntule extends AppCompatActivity {
    private VeriTabani vt;
    RecyclerView recyclerView;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otel_rezervasyon_goruntule);
        vt = new VeriTabani(this);
        ArrayList<VeritabanıRezervasyonBilgisi> rezervasyonBilgisileri = new VeriTabanidao().tumRezervasyonlar(vt);
        ArrayList<VeritabanıRezervasyonBilgisi> rezBilgileri = new ArrayList<>();
        Intent iRez = getIntent();
        String otelAdi_rez = iRez.getStringExtra("otelAdi_rez");
        for(VeritabanıRezervasyonBilgisi aRezervasyonBilgisi : rezervasyonBilgisileri){
            if(aRezervasyonBilgisi.getOtelIsmi().compareTo(otelAdi_rez)==0){
                rezBilgileri.add(aRezervasyonBilgisi);
            }
        }
        recyclerView = this.findViewById(R.id.recyclerViewRezervasyon);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AdapterRezervasyon adapterRezervasyon = new AdapterRezervasyon(rezBilgileri,context);
        recyclerView.setAdapter(adapterRezervasyon);

    }
}
