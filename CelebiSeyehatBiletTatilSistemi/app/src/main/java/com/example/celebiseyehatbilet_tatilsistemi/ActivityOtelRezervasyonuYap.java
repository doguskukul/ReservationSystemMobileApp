package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ActivityOtelRezervasyonuYap extends AppCompatActivity {
    EditText editTextIsim,editTextSoyisim,editTextKimlikNo,editTextTelefonNo;
    CheckBox checkBoxNakit,checkBoxKrediKarti,checkBoxCek,checkBox1,checkBox2,checkBox3;
    Button buttonOdemeYap,buttonPuanKullan,buttonAnasayfa;
    Otel otel;
    String strGirisTarihi,strCikisTarihi;
    private VeriTabani vt;
    ArrayList<Musteri> gelenMusteriListesi;
    int kisiSayisi,gun;
    Date girisTarihi,cikisTarihi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otel_rezervasyonu_yap);
        Intent intentOtelRezervasyonu=getIntent();
        strGirisTarihi=intentOtelRezervasyonu.getStringExtra("girisTarihi");
        strCikisTarihi=intentOtelRezervasyonu.getStringExtra("cikisTarihi");
        otel= (Otel) intentOtelRezervasyonu.getSerializableExtra("otel");
        editTextIsim=(EditText) this.findViewById(R.id.editIsim);
        editTextSoyisim=(EditText) this.findViewById(R.id.editSoyisim);
        editTextKimlikNo=(EditText) this.findViewById(R.id.editKimlikNo);
        editTextTelefonNo=(EditText) this.findViewById(R.id.editTelefonNo);
        checkBoxNakit=(CheckBox) this.findViewById(R.id.checkNakit);
        checkBoxKrediKarti=(CheckBox) this.findViewById(R.id.checkKrediKarti);
        checkBoxCek=(CheckBox) this.findViewById(R.id.checkCek);
        checkBox1=(CheckBox) this.findViewById(R.id.checkBox1);
        checkBox2=(CheckBox) this.findViewById(R.id.checkBox2);
        checkBox3=(CheckBox) this.findViewById(R.id.checkBox3);
        buttonOdemeYap=(Button) this.findViewById(R.id.buttonOdeme);
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        girisTarihi=null;
        cikisTarihi=null;
        try {
            girisTarihi=dateFormat.parse(strGirisTarihi);
            cikisTarihi=dateFormat.parse(strCikisTarihi);
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        long zaman=cikisTarihi.getTime()-girisTarihi.getTime();
        gun=(int)zaman/(1000*60*60*24);
        vt = new VeriTabani(this);
        gelenMusteriListesi = new VeriTabanidao().tumMusteriler(vt);
        buttonOdemeYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean uygunMu=true;
                if(editTextIsim.getText().toString().equals("") || editTextSoyisim.getText().toString().equals("") || editTextKimlikNo.getText().toString().equals("") || editTextTelefonNo.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Lütfen tüm bilgileri giriniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(checkBox1.isChecked()==false && checkBox2.isChecked()==false && checkBox3.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"Kişi sayısı seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if((checkBox1.isChecked()==true && checkBox2.isChecked()==true) || (checkBox1.isChecked()==true && checkBox3.isChecked()==true) || (checkBox2.isChecked()==true && checkBox3.isChecked()==true) || (checkBox1.isChecked()==true && checkBox2.isChecked()==true && checkBox3.isChecked()==true)){
                    Toast.makeText(getApplicationContext(),"Sadece bir kişi sayısı seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(checkBoxNakit.isChecked()==false && checkBoxKrediKarti.isChecked()==false && checkBoxCek.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"Ödeme türü seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if((checkBoxNakit.isChecked()==true && checkBoxKrediKarti.isChecked()==true) || (checkBoxNakit.isChecked()==true && checkBoxCek.isChecked()==true) || (checkBoxCek.isChecked()==true && checkBoxKrediKarti.isChecked()==true) || (checkBoxNakit.isChecked()==true && checkBoxKrediKarti.isChecked()==true && checkBoxCek.isChecked()==true)){
                    Toast.makeText(getApplicationContext(),"Sadece bir ödeme türü seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(uygunMu==true){
                    if(otel.bosYerSayisiAl()>0){
                        Musteri musteri=new Musteri(editTextIsim.getText().toString(),editTextSoyisim.getText().toString(),editTextKimlikNo.getText().toString(),editTextTelefonNo.getText().toString(),0);
                        int musteriVarmı=0;
                        for(Musteri aMusteri: gelenMusteriListesi){
                            if(aMusteri.kimlikNoAl().compareTo(editTextKimlikNo.getText().toString())==0){
                                musteriVarmı=1;
                                musteri.puanDuzenle(aMusteri.puanAl());
                            }
                        }
                        if(checkBox1.isChecked()==true){
                            kisiSayisi=1;
                        }
                        else if(checkBox2.isChecked()==true){
                            kisiSayisi=2;
                        }
                        else if(checkBox3.isChecked()==true){
                            kisiSayisi=3;
                        }
                        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
                        Date girisTarihi=new Date();
                        try {
                            girisTarihi=format.parse(strGirisTarihi);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Date cikisTarihi=new Date();
                        try {
                            cikisTarihi=format.parse(strCikisTarihi);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        Rezervasyon rezervasyon = new Rezervasyon(otel,musteri,girisTarihi,cikisTarihi,kisiSayisi);
                        int odaNoVal = rezervasyon.odaNoAl();
                        VeritabanıRezervasyonBilgisi rezervasyonBilgisi = new VeritabanıRezervasyonBilgisi(otel.isimAl(), musteri.kimlikNoAl(), strGirisTarihi, strCikisTarihi,odaNoVal,kisiSayisi,otel.bosYerSayisiAl());
                        new VeriTabanidao().rezervasyonEkle(vt,rezervasyonBilgisi);
                        new VeriTabanidao().rezervasyonGuncelle2(vt,musteri.kimlikNoAl(),otel.bosYerSayisiAl()-1);
                        musteri.puanEkle(otel.fiyatAl()*kisiSayisi*gun*otel.puanAl()/100+1);
                        if(musteriVarmı==0){
                            new VeriTabanidao().musteriEkle(vt,musteri);
                        }
                        if(musteriVarmı==1){
                            new VeriTabanidao().musteriGuncelle(vt,editTextKimlikNo.getText().toString(),musteri.puanAl());
                        }
                        Log.e("puan","puan:"+musteri.puanAl()+" fiyat:"+otel.fiyatAl()*kisiSayisi*gun);



                        Toast.makeText(getApplicationContext(),"Ödeme yapıldı.",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Boş oda yok.",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        buttonPuanKullan=(Button) this.findViewById(R.id.buttonPuanKullan);
        buttonPuanKullan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean uygunMu=true;
                if(editTextIsim.getText().toString().equals("") || editTextSoyisim.getText().toString().equals("") || editTextKimlikNo.getText().toString().equals("") || editTextTelefonNo.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Lütfen tüm bilgileri giriniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(checkBox1.isChecked()==false && checkBox2.isChecked()==false && checkBox3.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"Kişi sayısı seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if((checkBox1.isChecked()==true && checkBox2.isChecked()==true) || (checkBox1.isChecked()==true && checkBox3.isChecked()==true) || (checkBox2.isChecked()==true && checkBox3.isChecked()==true) || (checkBox1.isChecked()==true && checkBox2.isChecked()==true && checkBox3.isChecked()==true)){
                    Toast.makeText(getApplicationContext(),"Sadece bir kişi sayısı seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(checkBoxNakit.isChecked()==false && checkBoxKrediKarti.isChecked()==false && checkBoxCek.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"Ödeme türü seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if((checkBoxNakit.isChecked()==true && checkBoxKrediKarti.isChecked()==true) || (checkBoxNakit.isChecked()==true && checkBoxCek.isChecked()==true) || (checkBoxCek.isChecked()==true && checkBoxKrediKarti.isChecked()==true) || (checkBoxNakit.isChecked()==true && checkBoxKrediKarti.isChecked()==true && checkBoxCek.isChecked()==true)){
                    Toast.makeText(getApplicationContext(),"Sadece bir ödeme türü seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(uygunMu==true){
                    if(otel.bosYerSayisiAl()>0){
                        int musteriCount_puan=0;
                        if(checkBox1.isChecked()==true){
                            kisiSayisi=1;
                        }
                        else if(checkBox2.isChecked()==true){
                            kisiSayisi=2;
                        }
                        else if(checkBox3.isChecked()==true){
                            kisiSayisi=3;
                        }
                        for(Musteri aMusteri : gelenMusteriListesi) {
                            if (aMusteri.kimlikNoAl().compareTo(editTextKimlikNo.getText().toString())==0) {
                                musteriCount_puan=1;
                                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                                Date girisTarihi = new Date( );
                                try {
                                    girisTarihi = format.parse(strGirisTarihi);
                                } catch (ParseException e) {
                                    e.printStackTrace( );
                                }
                                Date cikisTarihi = new Date( );
                                try {
                                    cikisTarihi = format.parse(strCikisTarihi);
                                } catch (ParseException e) {
                                    e.printStackTrace( );
                                }
                                if (aMusteri.puanAl( ) > 0) {
                                    VeritabanıRezervasyonBilgisi rezervasyon = new VeritabanıRezervasyonBilgisi(otel.isimAl(), aMusteri.kimlikNoAl(), strGirisTarihi, strCikisTarihi,0,kisiSayisi,otel.bosYerSayisiAl());
                                    new VeriTabanidao().rezervasyonEkle(vt,rezervasyon);
                                    new VeriTabanidao().rezervasyonGuncelle2(vt,aMusteri.kimlikNoAl(),otel.bosYerSayisiAl()-1);
                                    int kullanilanPuan = aMusteri.puanAl( );
                                    int odenenUcret = kisiSayisi*gun*otel.fiyatAl( ) - kullanilanPuan;
                                    aMusteri.puanSil(kullanilanPuan);
                                    if (odenenUcret >= 0) {
                                        Toast.makeText(getApplicationContext( ), "Kullanılan puan:" + Float.toString(kullanilanPuan) + " TL", Toast.LENGTH_SHORT).show( );
                                        Toast.makeText(getApplicationContext( ), "Ödenen ücret:" + Float.toString(odenenUcret) + " TL", Toast.LENGTH_SHORT).show( );
                                        new VeriTabanidao().musteriGuncelle(vt,editTextKimlikNo.getText().toString(),0);
                                    }
                                    else {
                                        aMusteri.puanEkle(-odenenUcret);
                                        Toast.makeText(getApplicationContext( ), "Ödenen ücret:0 TL", Toast.LENGTH_LONG).show( );
                                        new VeriTabanidao().musteriGuncelle(vt,editTextKimlikNo.getText().toString(),0);
                                    }
                                    aMusteri.puanEkle(otel.fiyatAl( )*kisiSayisi*gun*otel.puanAl( ) / 100+1);
                                }
                                else {
                                    Toast.makeText(getApplicationContext( ), "Müşterinin puanı olmadığı için ödeme yapılamıyor.", Toast.LENGTH_SHORT).show( );
                                }
                            }
                        }
                        if (musteriCount_puan==0){
                            Toast.makeText(getApplicationContext( ), "Müşteri kayıtlı değil.", Toast.LENGTH_SHORT).show( );
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Boş oda yok.",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        buttonAnasayfa = this.findViewById(R.id.buttonAnasayfa_rezervasyon);
        buttonAnasayfa.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intentAnasayfa=new Intent(ActivityOtelRezervasyonuYap.this,MainActivity.class);
                startActivity(intentAnasayfa);
            }
        });
    }
}
