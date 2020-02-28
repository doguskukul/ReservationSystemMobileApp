package com.example.celebiseyehatbilet_tatilsistemi;

import java.io.Serializable;
import java.util.Date;

public class Otel implements Serializable {
    private String isim,bolge;
    private int fiyat,yildizSayisi,kapasite,bosYerSayisi,puan;
    private Date kabulTarihiBaslangici,kabulTarihiBitisi;
    public Otel(String isim, String bolge, Date kabulTarihiBaslangici, Date kabulTarihiBitisi, int fiyat,int yildizSayisi, int kapasite,int puan) {
        this.isim=isim;
        this.bolge=bolge;
        this.kabulTarihiBaslangici=kabulTarihiBaslangici;
        this.kabulTarihiBitisi=kabulTarihiBitisi;
        this.fiyat=fiyat;
        this.yildizSayisi=yildizSayisi;
        this.kapasite=kapasite;
        bosYerSayisi=kapasite;
        this.puan=puan;
    }
    public String isimAl() {
        return isim;
    }
    public void isimDuzenle(String isim) {
        this.isim=isim;
    }
    public String bolgeAl() {
        return bolge;
    }
    public void bolgeDuzenle(String bolge) {
        this.bolge=bolge;
    }
    public Date kabulTarihiBaslangiciAl() {
        return kabulTarihiBaslangici;
    }
    public void kabulTarihiBaslangiciDuzenle(Date kabulTarihiBaslangici) {
        this.kabulTarihiBaslangici=kabulTarihiBaslangici;
    }
    public Date kabulTarihiBitisiAl() {
        return kabulTarihiBitisi;
    }
    public void kabulTarihiBitisiDuzenle(Date kabulTarihiBitisi) {
        this.kabulTarihiBitisi=kabulTarihiBitisi;
    }
    public int fiyatAl() {
        return fiyat;
    }
    public void fiyatDuzenle(int fiyat) {
        this.fiyat=fiyat;
    }
    public int yildizSayisiAl() {
        return yildizSayisi;
    }
    public void yildizSayisiDuzenle(int yildizSayisi) {
        this.yildizSayisi=yildizSayisi;
    }
    public int kapasiteAl() {
        return kapasite;
    }
    public void kapasiteDuzenle(int kapasite) {
        this.kapasite=kapasite;
    }
    public int bosYerSayisiAl() {
        return bosYerSayisi;
    }
    public void bosYerSayisiDuzenle(int bosYerSayisi) {
        this.bosYerSayisi=bosYerSayisi;
    }
    public int puanAl(){
        return puan;
    }
    public void puanDuzenle(int puan){
        this.puan=puan;
    }
}
