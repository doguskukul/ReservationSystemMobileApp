package com.example.celebiseyehatbilet_tatilsistemi;

import java.io.Serializable;

public class Musteri implements Serializable {
    private String ad,soyad,kimlikNo,telefon;
    private int puan;
    public Musteri(String ad,String soyad,String kimlikNo,String telefon,int puan) {
        this.ad=ad;
        this.soyad=soyad;
        this.kimlikNo=kimlikNo;
        this.telefon=telefon;
        this.puan=puan;
    }
    public String isimAl() {
        return ad;
    }
    public void isimDuzenle(String ad) {
        this.ad=ad;
    }
    public String soyisimAl() {
        return soyad;
    }
    public void soyisimDuzenle(String soyad) {
        this.soyad=soyad;
    }
    public String kimlikNoAl() {
        return kimlikNo;
    }
    public void kimlikNoDuzenle(String kimlikNo) { this.kimlikNo=kimlikNo; }
    public String telefonNoAl() {
        return telefon;
    }
    public void telefonNoDuzenle(String telefon) {
        this.telefon=telefon;
    }
    public int puanAl() {
        return puan;
    }
    public void puanDuzenle(int puan) { this.puan=puan;}
    public void puanEkle(int eklenecekPuan) { puan=puan+eklenecekPuan; }
    public void puanSil(int silinecekPuan){
        puan=puan-silinecekPuan;
    }
}
