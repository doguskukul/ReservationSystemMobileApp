package com.example.celebiseyehatbilet_tatilsistemi;

import java.util.Date;

public class Rezervasyon {
    private Otel otel;
    private Musteri musteri;
    private Date girisTarihi,cikisTarihi;
    private int odaNo,kisiSayisi;
    public Rezervasyon(Otel otel,Musteri musteri,Date girisTarihi,Date cikisTarihi,int kisiSayisi) {
        this.otel=otel;
        this.musteri=musteri;
        this.girisTarihi=girisTarihi;
        this.cikisTarihi=cikisTarihi;
        this.kisiSayisi=kisiSayisi;
        odaNoHesapla();
    }
    public Otel otelAl() {
        return otel;
    }
    public void otelDuzenle(Otel otel) {
        this.otel=otel;
    }
    public Musteri musteriAl(){
        return musteri;
    }
    public void musteriDuzenle(Musteri musteri){
        this.musteri=musteri;
    }
    public Date girisTarihiAl(){
        return girisTarihi;
    }
    public void girisTarihiDuzenle(Date girisTarihi){
        this.girisTarihi=girisTarihi;
    }
    public Date cikisTarihiAl(){
        return cikisTarihi;
    }
    public void cikisTarihiDuzenle(Date cikisTarihi){
        this.cikisTarihi=cikisTarihi;
    }
    public int kisiSayisiAl(){
        return kisiSayisi;
    }
    public void kisiSayisiDuzenle(int kisiSayisi){
        this.kisiSayisi=kisiSayisi;
    }
    public int odaNoAl(){
        return odaNo;
    }
    public void odaNoDuzenle(int odaNo){
        this.odaNo=odaNo;
    }
    public void odaNoHesapla(){
        int kat,numara,doluOdaSayisi;
        doluOdaSayisi=otel.kapasiteAl()-otel.bosYerSayisiAl();
        kat=(int)(doluOdaSayisi/20);
        kat++;
        numara=doluOdaSayisi%20;
        numara++;
        odaNo=kat*100+numara;
    }
}
