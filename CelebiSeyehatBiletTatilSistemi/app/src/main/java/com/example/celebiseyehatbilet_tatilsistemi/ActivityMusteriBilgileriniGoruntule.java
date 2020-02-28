package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityMusteriBilgileriniGoruntule extends AppCompatActivity {
    TextView textViewIsim,textViewSoyisim,textViewKimlikNo,textViewTelefonNo,textViewPuan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musteri_bilgilerini_goruntule);
        textViewIsim=(TextView) this.findViewById(R.id.textMusteriIsmi);
        textViewSoyisim=(TextView) this.findViewById(R.id.textMusteriSoyismi);
        textViewKimlikNo=(TextView) this.findViewById(R.id.textMusteriKimlikNo);
        textViewTelefonNo=(TextView) this.findViewById(R.id.textMusteriTelefonNo);
        textViewPuan=(TextView) this.findViewById(R.id.textMusteriPuani);
        Intent intentMusteriBilgileri=getIntent();
        String isim=intentMusteriBilgileri.getStringExtra("ad");
        String soyisim=intentMusteriBilgileri.getStringExtra("soyad");
        String kimlikNo=intentMusteriBilgileri.getStringExtra("kimlikNo");
        String telefonNo=intentMusteriBilgileri.getStringExtra("telefonNo");
        String puan=intentMusteriBilgileri.getStringExtra("puan");
        textViewIsim.setText(isim);
        textViewSoyisim.setText(soyisim);
        textViewKimlikNo.setText(kimlikNo);
        textViewTelefonNo.setText(telefonNo);
        textViewPuan.setText(puan);
    }
}
