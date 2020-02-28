package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ActivityOdemeYap extends AppCompatActivity {
    TextView textViewIsim,textViewSoyisim,textViewKimlikNo,textViewTelefonNo,textViewUlasimFirmasi,textViewKalkisYeri,textViewVarisYeri,textViewKalkisTarihi,textViewFiyat,textViewKoltukNo;
    CheckBox checkBoxNakit,checkBoxKrediKarti,checkBoxCek;
    Button buttonOdemeYap,buttonPuanKullanarakOdemeYap,buttonAnasayfa;
    Date tarih;
    String ulasimTipi;
    int fiyat,koltukNo,j;
    int puan=0;
    Boolean bosYerVarMi;
    private VeriTabani vt;
    Context context=this;
    ArrayList<Sefer> seferler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odeme_yap);
        vt = new VeriTabani(this);
        textViewIsim=(TextView) this.findViewById(R.id.textIsim);
        textViewSoyisim=(TextView) this.findViewById(R.id.textSoyisim);
        textViewKimlikNo=(TextView) this.findViewById(R.id.textKimlikNo);
        textViewTelefonNo=(TextView) this.findViewById(R.id.textTelefonNo);
        textViewUlasimFirmasi=(TextView) this.findViewById(R.id.textUlasimFirmasi);
        textViewKalkisYeri=(TextView) this.findViewById(R.id.textKalkisYeri);
        textViewVarisYeri=(TextView) this.findViewById(R.id.textVarisYeri);
        textViewKalkisTarihi=(TextView) this.findViewById(R.id.textKalkisTarihi);
        textViewFiyat=(TextView) this.findViewById(R.id.textFiyat);
        textViewKoltukNo=(TextView) this.findViewById(R.id.textKoltukNo);
        Intent intentOdemeYap=getIntent();
        seferler=(ArrayList<Sefer>) intentOdemeYap.getSerializableExtra("seferler");
        final String isim=intentOdemeYap.getStringExtra("isim");
        final String soyisim=intentOdemeYap.getStringExtra("soyisim");
        final String kimlikNo=intentOdemeYap.getStringExtra("kimlikNo");
        final String telefonNo=intentOdemeYap.getStringExtra("telefonNo");
        final ArrayList<Musteri> gelenMusteriListesi = new VeriTabanidao().tumMusteriler(vt);
        String kalkisTarihi=intentOdemeYap.getStringExtra("kalkisTarihi");
        String ulasimFirmasi=intentOdemeYap.getStringExtra("ulasimFirmasi");
        String kalkisYeri=intentOdemeYap.getStringExtra("kalkisYeri");
        String varisYeri=intentOdemeYap.getStringExtra("varisYeri");
        String kalkisSaati=intentOdemeYap.getStringExtra("kalkisSaati");
        textViewIsim.setText(isim);
        textViewSoyisim.setText(soyisim);
        textViewKimlikNo.setText(kimlikNo);
        textViewTelefonNo.setText(telefonNo);
        textViewUlasimFirmasi.setText(ulasimFirmasi);
        textViewKalkisYeri.setText(kalkisYeri);
        textViewVarisYeri.setText(varisYeri);
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        tarih=null;
        try {
            tarih=dateFormat.parse(kalkisTarihi);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        if(kalkisSaati.equals("10.00")){
            tarih.setHours(10);
            tarih.setMinutes(00);
            tarih.setSeconds(00);
        }
        else if(kalkisSaati.equals("23.00")){
            tarih.setHours(23);
            tarih.setMinutes(00);
            tarih.setSeconds(00);
        }
        SimpleDateFormat dateFormat2=new SimpleDateFormat("dd/MM/yyyy - HH.mm");
        String strTarih=dateFormat2.format(tarih);
        textViewKalkisTarihi.setText(strTarih);
        if(ulasimFirmasi.equals("YTUR Otobus Firmalari")){
            ulasimTipi="Otobus";
        }
        else if(ulasimFirmasi.equals("Ucan Turk Ozel Hava Yolu")){
            ulasimTipi="Ucak";
        }
        else if(ulasimFirmasi.equals("Devlet Demir Yollari")){
            ulasimTipi="Tren";
        }
        for(int i=0;i<252;i++){
            if(seferler.get(i).ulasimTipiAl().equals(ulasimTipi) && seferler.get(i).kalkisYeriAl().equals(kalkisYeri) && seferler.get(i).varisYeriAl().equals(varisYeri) && seferler.get(i).kalkisZamaniAl().getHours()==tarih.getHours() && seferler.get(i).kalkisZamaniAl().getDay()==tarih.getDay() && seferler.get(i).kalkisZamaniAl().getMonth()==tarih.getMonth() && seferler.get(i).kalkisZamaniAl().getYear()==tarih.getYear()){
                fiyat=seferler.get(i).fiyatAl();
                koltukNo=seferler.get(i).kapasiteAl()-seferler.get(i).bosKoltukSayisiAl()+1;
                j=i;
            }
        }
        textViewFiyat.setText(Integer.toString(fiyat));
        if(seferler.get(j).bosYerVarMi()==true){
            textViewKoltukNo.setText(Integer.toString(koltukNo));
            bosYerVarMi=true;
        }
        else{
            textViewKoltukNo.setText("Boş koltuk yok.");
            bosYerVarMi=false;
        }
        checkBoxNakit=(CheckBox) this.findViewById(R.id.checkBoxNakit);
        checkBoxKrediKarti=(CheckBox) this.findViewById(R.id.checkBoxKrediKarti);
        checkBoxCek=(CheckBox) this.findViewById(R.id.checkBoxCek);
        buttonOdemeYap=(Button) this.findViewById(R.id.buttonOdemeYap);
        buttonOdemeYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean uygunMu=true;
                if(checkBoxNakit.isChecked()==false && checkBoxKrediKarti.isChecked()==false && checkBoxCek.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"Ödeme türü seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if((checkBoxNakit.isChecked()==true && checkBoxKrediKarti.isChecked()==true) || (checkBoxNakit.isChecked()==true && checkBoxCek.isChecked()==true) || (checkBoxCek.isChecked()==true && checkBoxKrediKarti.isChecked()==true) || (checkBoxNakit.isChecked()==true && checkBoxKrediKarti.isChecked()==true && checkBoxCek.isChecked()==true)){
                    Toast.makeText(getApplicationContext(),"Sadece bir ödeme türü seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(uygunMu==true){
                    if(bosYerVarMi==true){
                        int musteriVarmı=0;
                        Musteri musteri=new Musteri(isim,soyisim,kimlikNo,telefonNo,puan);
                        for(Musteri aMusteri: gelenMusteriListesi){
                            if(aMusteri.kimlikNoAl().compareTo(kimlikNo)==0){
                                musteriVarmı=1;
                                musteri.puanDuzenle(aMusteri.puanAl());
                            }
                        }
                        seferler.get(j).yolcuEkle(musteri);
                        VeritabanıSeferBilgisi seferBilgisi = new VeritabanıSeferBilgisi(j,kimlikNo,seferler.get(j).bosKoltukSayisiAl());
                        new VeriTabanidao().seferEkle(vt,seferBilgisi);

                        if(seferler.get(j).ulasimTipiAl().equals("Otobus")){
                            int eklenecekPuan = fiyat/100+1;
                            musteri.puanEkle(eklenecekPuan);
                            Log.e("puan","puan:"+musteri.puanAl()+" fiyat:"+fiyat);
                        }
                        else if(seferler.get(j).ulasimTipiAl().equals("Ucak")){
                            int eklenecekPuan = fiyat*3/100+1;
                            musteri.puanEkle(eklenecekPuan);
                            Log.e("puan","puan:"+musteri.puanAl()+" fiyat:"+fiyat);
                        }
                        else if(seferler.get(j).ulasimTipiAl().equals("Tren")){
                            int eklenecekPuan = fiyat*2/100+1;
                            musteri.puanEkle(eklenecekPuan);
                            Log.e("puan","puan:"+musteri.puanAl()+" fiyat:"+fiyat);
                        }

                        if(musteriVarmı==0){
                            new VeriTabanidao().musteriEkle(vt,musteri);
                        }
                        if(musteriVarmı==1){
                            new VeriTabanidao().musteriGuncelle(vt,kimlikNo,musteri.puanAl());
                        }
                        Log.e("puan","puan:"+musteri.puanAl()+" fiyat:"+fiyat);
                        Toast.makeText(getApplicationContext(),"Ödeme yapıldı.",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Boş koltuk yok.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        buttonPuanKullanarakOdemeYap=(Button) this.findViewById(R.id.buttonPuanKullanarakOdeme);
        buttonPuanKullanarakOdemeYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean uygunMu=true;
                if(checkBoxNakit.isChecked()==false && checkBoxKrediKarti.isChecked()==false && checkBoxCek.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"Ödeme türü seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if((checkBoxNakit.isChecked()==true && checkBoxKrediKarti.isChecked()==true) || (checkBoxNakit.isChecked()==true && checkBoxCek.isChecked()==true) || (checkBoxCek.isChecked()==true && checkBoxKrediKarti.isChecked()==true) || (checkBoxNakit.isChecked()==true && checkBoxKrediKarti.isChecked()==true && checkBoxCek.isChecked()==true)){
                    Toast.makeText(getApplicationContext(),"Sadece bir ödeme türü seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(uygunMu==true){
                    if(bosYerVarMi==true){
                        int musteriCount_puan=0;
                        for(Musteri aMusteri : gelenMusteriListesi) {
                            if (aMusteri.kimlikNoAl().compareTo(kimlikNo)==0) {
                                musteriCount_puan=1;
                                int kullanilanPuan = aMusteri.puanAl( );
                                int odenenUcret = fiyat - kullanilanPuan;
                                if (aMusteri.puanAl() > 0) {
                                    aMusteri.puanSil(kullanilanPuan);
                                    if (odenenUcret >= 0) {
                                        Toast.makeText(getApplicationContext( ), "Kullanılan puan:" + Float.toString(kullanilanPuan) + " TL", Toast.LENGTH_SHORT).show( );
                                        Toast.makeText(getApplicationContext( ), "Ödenen ücret:" + Float.toString(odenenUcret) + " TL", Toast.LENGTH_SHORT).show( );
                                        new VeriTabanidao().musteriGuncelle(vt,kimlikNo,0);
                                    } else {
                                        aMusteri.puanEkle(-odenenUcret);
                                        Toast.makeText(getApplicationContext(), "Ödenen ücret:0 TL", Toast.LENGTH_LONG).show();
                                        new VeriTabanidao().musteriGuncelle(vt,kimlikNo,0);
                                    }
                                    seferler.get(j).yolcuEkle(aMusteri);
                                    VeritabanıSeferBilgisi seferBilgisi = new VeritabanıSeferBilgisi(j,kimlikNo,seferler.get(j).bosKoltukSayisiAl());
                                    new VeriTabanidao().seferEkle(vt,seferBilgisi);
                                    if (seferler.get(j).ulasimTipiAl().equals("Otobus")) {
                                        aMusteri.puanEkle(fiyat / 100+1);
                                    } else if (seferler.get(j).ulasimTipiAl().equals("Ucak")) {
                                        aMusteri.puanEkle(fiyat * 3 / 100+1);
                                    } else if (seferler.get(j).ulasimTipiAl().equals("Tren")) {
                                        aMusteri.puanEkle(fiyat * 2 / 100+1);
                                    }
                                    new VeriTabanidao().musteriGuncelle(vt,kimlikNo,aMusteri.puanAl());


                                } else {
                                    Toast.makeText(getApplicationContext( ), "Müşterinin yeterli puanı olmadığı için ödeme yapılamıyor "+kullanilanPuan, Toast.LENGTH_SHORT).show( );
                                }
                            }
                        }
                        if (musteriCount_puan==0){
                            Toast.makeText(getApplicationContext( ), "Müşteri kayıtlı değil", Toast.LENGTH_SHORT).show( );
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Boş koltuk yok.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        buttonAnasayfa = this.findViewById(R.id.buttonAnasayfa);
        buttonAnasayfa.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intentAnasayfa=new Intent(ActivityOdemeYap.this,MainActivity.class);
                startActivity(intentAnasayfa);
            }
        });
    }
}
