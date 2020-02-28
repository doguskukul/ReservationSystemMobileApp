package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class ActivityRezervasyonSil extends AppCompatActivity {
    EditText editText_KimlikNo;
    Button buttonOteldenSil,buttonSeferdenSil,buttonAnasayfa;
    private VeriTabani vt;
    Context context=this;
    ArrayList<VeritabanıRezervasyonBilgisi> rezervasyonBilgileri;
    ArrayList<VeritabanıSeferBilgisi> seferBilgileri;
    ArrayList<Otel> oteller;
    ArrayList<Sefer> seferler;
    int countSefer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rezervasyon_sil);
        vt = new VeriTabani(this);
        rezervasyonBilgileri = new VeriTabanidao().tumRezervasyonlar(vt);
        editText_KimlikNo = this.findViewById(R.id.editText_RezSilKimlikNo);
        buttonSeferdenSil = this.findViewById(R.id.button_RezSilSeferden);
        buttonOteldenSil = this.findViewById(R.id.button_RezSilOtelden);
        buttonAnasayfa = this.findViewById(R.id.buttonAnasayfa_rezSil);
        Intent intentRezervasyonSil = getIntent();
        oteller=(ArrayList<Otel>) intentRezervasyonSil.getSerializableExtra("oteller");
        seferBilgileri = new VeriTabanidao().tumSeferler(vt);
        seferler=(ArrayList<Sefer>) intentRezervasyonSil.getSerializableExtra("seferler");
        buttonSeferdenSil.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                int val=0;
                for (VeritabanıSeferBilgisi aSeferBilgisi:seferBilgileri){
                    if(aSeferBilgisi.getKimlikNo().equals(editText_KimlikNo.getText().toString())){
                        countSefer = aSeferBilgisi.getSeferCount();
                        new VeriTabanidao().seferdenRezervasyonSil(vt,editText_KimlikNo.getText().toString());
                        for(VeritabanıSeferBilgisi aVeritabanıSeferBilgisi: seferBilgileri){
                            if(aVeritabanıSeferBilgisi.getSeferCount()==aSeferBilgisi.getSeferCount()){
                                new VeriTabanidao().seferGuncelle(vt,aVeritabanıSeferBilgisi.getSeferCount(),(aVeritabanıSeferBilgisi.getBosKoltuk()+1));
                            }
                        }
                        Toast.makeText(getApplicationContext(),"Müşteri rezervasyonu silindi.",Toast.LENGTH_SHORT).show();
                        val=1;
                    }
                }
                if(val==0) {
                    Toast.makeText(getApplicationContext( ), "Girilen kimlik numarasına ait rezervasyon bulunamadı.", Toast.LENGTH_SHORT).show( );
                }
            }
        });

        buttonOteldenSil.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                String text = editText_KimlikNo.getText().toString();
                int val=0;
                for (VeritabanıRezervasyonBilgisi rezBil: rezervasyonBilgileri){
                    if(text.compareTo(rezBil.getKimlikNo())==0){
                        new VeriTabanidao().oteldenRezervasyonSil(vt,text);
                        for (VeritabanıRezervasyonBilgisi aVeritabanıRezervasyonBilgisi : rezervasyonBilgileri){
                            if(aVeritabanıRezervasyonBilgisi.getOtelIsmi().compareTo(rezBil.getOtelIsmi())==0){
                                new VeriTabanidao().rezervasyonGuncelle(vt,aVeritabanıRezervasyonBilgisi.getOtelIsmi(),aVeritabanıRezervasyonBilgisi.getBosYer()+1);
                            }
                        }
                        Toast.makeText(getApplicationContext(),"Müşteri rezervasyonu silindi.",Toast.LENGTH_SHORT).show();
                        val=1;
                    }
                }
                if(val==0) {
                    Toast.makeText(getApplicationContext( ), "Girilen kimlik numarasına ait rezervasyon bulunamadı.", Toast.LENGTH_SHORT).show( );
                }
            }
        });
        buttonAnasayfa.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intentAnasayfa = new Intent(ActivityRezervasyonSil.this,MainActivity.class);
                startActivity(intentAnasayfa);
            }
        });
    }
}
