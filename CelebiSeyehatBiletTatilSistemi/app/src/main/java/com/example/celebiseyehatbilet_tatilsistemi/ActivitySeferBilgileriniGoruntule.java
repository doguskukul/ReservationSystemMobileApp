package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivitySeferBilgileriniGoruntule extends AppCompatActivity {
    TextView textViewKalkisZamani,textViewVarisZamani,textViewSeferNo,textViewKalkisYeri,textViewVarisYeri,textViewUlasimTipi,textViewFiyat,textViewKapasite,textViewBosKoltukSayisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sefer_bilgilerini_goruntule);
        textViewKalkisZamani=(TextView) this.findViewById(R.id.textKalkisZamani);
        textViewVarisZamani=(TextView) this.findViewById(R.id.textVarisZamani);
        textViewSeferNo=(TextView) this.findViewById(R.id.textSeferNo);
        textViewKalkisYeri=(TextView) this.findViewById(R.id.textKalkisYeri);
        textViewVarisYeri=(TextView) this.findViewById(R.id.textVarisYeri);
        textViewUlasimTipi=(TextView) this.findViewById(R.id.textUlasimTipi);
        textViewFiyat=(TextView) this.findViewById(R.id.textFiyat);
        textViewKapasite=(TextView) this.findViewById(R.id.textKapasite);
        textViewBosKoltukSayisi=(TextView) this.findViewById(R.id.textBosKoltukSayisi);
        Intent intentSeferDetaylari=getIntent();
        String kalkisZamani=intentSeferDetaylari.getStringExtra("kalkisZamani");
        String varisZamani=intentSeferDetaylari.getStringExtra("varisZamani");
        String seferNo=intentSeferDetaylari.getStringExtra("seferNo");
        String fiyat=intentSeferDetaylari.getStringExtra("fiyat");
        String kapasite=intentSeferDetaylari.getStringExtra("kapasite");
        String bosKoltukSayisi=intentSeferDetaylari.getStringExtra("bosKoltukSayisi");
        String kalkisYeri=intentSeferDetaylari.getStringExtra("kalkisYeri");
        String varisYeri=intentSeferDetaylari.getStringExtra("varisYeri");
        String ulasimTipi=intentSeferDetaylari.getStringExtra("ulasimTipi");
        textViewKalkisZamani.setText(kalkisZamani);
        textViewVarisZamani.setText(varisZamani);
        textViewSeferNo.setText(seferNo);
        textViewFiyat.setText(fiyat);
        textViewKapasite.setText(kapasite);
        textViewBosKoltukSayisi.setText(bosKoltukSayisi);
        textViewKalkisYeri.setText(kalkisYeri);
        textViewVarisYeri.setText(varisYeri);
        textViewUlasimTipi.setText(ulasimTipi);
    }
}
