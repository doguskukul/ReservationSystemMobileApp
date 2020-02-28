package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ActivityOtelBilgileriniGoruntule extends AppCompatActivity {
    TextView textViewOtelIsmi,textViewBolge,textViewFiyat,textViewPuan,textViewBosYerSayisi,textViewYildizSayisi,textViewKabulBaslangic,textViewKabulBitis,textViewKapasite;
    Button buttonRez;
    ArrayList<Otel> oteller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otel_bilgilerini_goruntule);
        Intent intentOtelBilgileri=getIntent();
        oteller=(ArrayList<Otel>) intentOtelBilgileri.getSerializableExtra("oteller");
        int count = intentOtelBilgileri.getExtras().getInt("otelNo");
        textViewOtelIsmi = this.findViewById(R.id.textView_OtelIsmi);
        textViewBolge = this.findViewById(R.id.textView_Bolge);
        textViewFiyat = this.findViewById(R.id.textView_Fiyat);
        textViewPuan = this.findViewById(R.id.textView_Puan);
        textViewKabulBaslangic = this.findViewById(R.id.textView_KabulBaslangıc);
        textViewKabulBitis = this.findViewById(R.id.textView_KabulBitis);
        textViewYildizSayisi = this.findViewById(R.id.textView_YildizSayisi);
        textViewKapasite = this.findViewById(R.id.textView_Kapasite);
        textViewBosYerSayisi = this.findViewById(R.id.textView_BosYer);
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date kabulBaslangıc =oteller.get(count).kabulTarihiBaslangiciAl();
        String zamanBaslangıc=dateFormat.format(kabulBaslangıc);
        Date kabulBitis = oteller.get(count).kabulTarihiBitisiAl();
        String zamanBitis = dateFormat.format(kabulBitis);
        textViewOtelIsmi.setText(oteller.get(count).isimAl());
        textViewBolge.setText(oteller.get(count).bolgeAl());
        textViewFiyat.setText(Integer.toString(oteller.get(count).fiyatAl()));
        textViewPuan.setText(Integer.toString(oteller.get(count).puanAl()));
        textViewKapasite.setText(Integer.toString(oteller.get(count).kapasiteAl()));
        textViewYildizSayisi.setText(Integer.toString(oteller.get(count).yildizSayisiAl()));
        textViewKabulBaslangic.setText(zamanBaslangıc);
        textViewKabulBitis.setText(zamanBitis);
        textViewBosYerSayisi.setText(Integer.toString(oteller.get(count).bosYerSayisiAl()));
        buttonRez = this.findViewById(R.id.buttonRezervasyonListele);
        buttonRez.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent iRez = new Intent(ActivityOtelBilgileriniGoruntule.this,ActivityOtelRezervasyonGoruntule.class);
                iRez.putExtra("otelAdi_rez",textViewOtelIsmi.getText().toString());
                startActivity(iRez);
            }
        });
    }
}
