package com.example.celebiseyehatbilet_tatilsistemi;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

public class Sefer implements Serializable {
    private Date kalkisZamani,varisZamani;
    private int seferNo,fiyat,kapasite,bosKoltukSayisi;
    private String kalkisYeri,varisYeri,ulasimTipi;
    private ArrayList<Musteri> musteriler;
    public Sefer(int seferNo,Date kalkisZamani,String kalkisYeri,String varisYeri,String ulasimTipi) {
        this.seferNo=seferNo;
        this.kalkisZamani=kalkisZamani;
        this.kalkisYeri=kalkisYeri;
        this.varisYeri=varisYeri;
        this.ulasimTipi=ulasimTipi;
        musteriler=new ArrayList<Musteri>();
        kapasiteHesapla();
        bosKoltukSayisi=kapasite;
        varisZamaniHesapla();
        fiyatHesapla();
    }
    public Date kalkisZamaniAl() {
        return kalkisZamani;
    }
    public void kalkisZamaniDuzenle(Date kalkisZamani) {
        this.kalkisZamani=kalkisZamani;
    }
    public Date varisZamaniAl() {
        return varisZamani;
    }
    public void varisZamaniDuzenle(Date varisZamani) {
        this.varisZamani=varisZamani;
    }
    public int fiyatAl() {
        return fiyat;
    }
    public void fiyatDuzenle(int fiyat) {
        this.fiyat=fiyat;
    }
    public int kapasiteAl() {
        return kapasite;
    }
    public void kapasiteDuzenle(int kapasite) {
        this.kapasite=kapasite;
    }
    public int seferNoAl() {
        return seferNo;
    }
    public void seferNoDuzenle(int seferNo) {
        this.seferNo=seferNo;
    }
    public int bosKoltukSayisiAl() {
        return bosKoltukSayisi;
    }
    public void bosKoltukSayisiDuzenle(int bosKoltukSayisi) {
        this.bosKoltukSayisi=bosKoltukSayisi;
    }
    public String kalkisYeriAl() {
        return kalkisYeri;
    }
    public void kalkisYeriDuzenle(String kalkisYeri) {
        this.kalkisYeri=kalkisYeri;
    }
    public String varisYeriAl() {
        return varisYeri;
    }
    public void varisYeriDuzenle(String varisYeri) {
        this.varisYeri=varisYeri;
    }
    public String ulasimTipiAl() {
        return ulasimTipi;
    }
    public boolean yolcuEkle(Musteri birMusteri) {
        if(bosYerVarMi()==false) {
            System.out.println("Maksimum "+kapasite+" yolcu eklenebilir.");
            return false;
        }
        else if(musteriBul(birMusteri.kimlikNoAl())!=null) {
            System.out.println("Kayitli olan bir yolcu eklenemez.");
            return false;
        }
        else {
            musteriler.add(birMusteri);
            bosKoltukSayisiDuzenle(bosKoltukSayisiAl()-1);
            return true;
        }
    }
    public boolean yolcuSil(Musteri birMusteri) {
        if(musteriBul(birMusteri.kimlikNoAl())!=null){
            musteriler.remove(birMusteri);
            bosKoltukSayisiDuzenle(bosKoltukSayisiAl()+1);
            return true;
        }
        return false;
    }
    public void tumYolculariSil() {
        for(Musteri birMusteri:musteriler) {
            musteriler.remove(birMusteri);
        }
    }
    public Musteri musteriBul(String kimlikNo) {
        for(Musteri birMusteri : musteriler) {
            if(birMusteri.kimlikNoAl().compareTo(kimlikNo)==0) {
                return birMusteri;
            }
        }
        return null;
    }
    public boolean bosYerVarMi() {
        if(bosKoltukSayisiAl()>0) {
            return true;
        }
        else {
            return false;
        }
    }
    public void kapasiteHesapla(){
        if(ulasimTipi.equalsIgnoreCase("Otobus")) {
            kapasite=45;
        }
        if(ulasimTipi.equalsIgnoreCase("Ucak")) {
            kapasite=100;
        }
        if(ulasimTipi.equalsIgnoreCase("Tren")) {
            kapasite=400;
        }
    }
    public void varisZamaniHesapla() {
        long birSaatUzunlugu=1000*60*60;
        Date birSaatSonra=new Date(kalkisZamani.getTime()+(birSaatUzunlugu));
        Date ucSaatSonra=new Date(kalkisZamani.getTime()+(3*birSaatUzunlugu));
        Date dortSaatSonra=new Date(kalkisZamani.getTime()+(4*birSaatUzunlugu));
        Date altiSaatSonra=new Date(kalkisZamani.getTime()+(6*birSaatUzunlugu));
        Date yediSaatSonra=new Date(kalkisZamani.getTime()+(7*birSaatUzunlugu));
        if((kalkisYeri.equalsIgnoreCase("Istanbul")&&varisYeri.equalsIgnoreCase("Ankara")&&ulasimTipi.equalsIgnoreCase("Otobus"))||(kalkisYeri.equalsIgnoreCase("Ankara")&&varisYeri.equalsIgnoreCase("Istanbul")&&ulasimTipi.equalsIgnoreCase("Otobus"))) {
            varisZamani=yediSaatSonra;
        }
        if((kalkisYeri.equalsIgnoreCase("Istanbul")&&varisYeri.equalsIgnoreCase("Ankara")&&ulasimTipi.equalsIgnoreCase("Ucak"))||(kalkisYeri.equalsIgnoreCase("Ankara")&&varisYeri.equalsIgnoreCase("Istanbul")&&ulasimTipi.equalsIgnoreCase("Ucak"))) {
            varisZamani=birSaatSonra;
        }
        if((kalkisYeri.equalsIgnoreCase("Istanbul")&&varisYeri.equalsIgnoreCase("Ankara")&&ulasimTipi.equalsIgnoreCase("Tren"))||(kalkisYeri.equalsIgnoreCase("Ankara")&&varisYeri.equalsIgnoreCase("Istanbul")&&ulasimTipi.equalsIgnoreCase("Tren"))) {
            varisZamani=dortSaatSonra;
        }
        if((kalkisYeri.equalsIgnoreCase("Istanbul")&&varisYeri.equalsIgnoreCase("Izmir")&&ulasimTipi.equalsIgnoreCase("Otobus"))||(kalkisYeri.equalsIgnoreCase("Izmir")&&varisYeri.equalsIgnoreCase("Istanbul")&&ulasimTipi.equalsIgnoreCase("Otobus"))) {
            varisZamani=altiSaatSonra;
        }
        if((kalkisYeri.equalsIgnoreCase("Istanbul")&&varisYeri.equalsIgnoreCase("Izmir")&&ulasimTipi.equalsIgnoreCase("Ucak"))||(kalkisYeri.equalsIgnoreCase("Izmir")&&varisYeri.equalsIgnoreCase("Istanbul")&&ulasimTipi.equalsIgnoreCase("Ucak"))) {
            varisZamani=birSaatSonra;
        }
        if((kalkisYeri.equalsIgnoreCase("Istanbul")&&varisYeri.equalsIgnoreCase("Izmir")&&ulasimTipi.equalsIgnoreCase("Tren"))||(kalkisYeri.equalsIgnoreCase("Izmir")&&varisYeri.equalsIgnoreCase("Istanbul")&&ulasimTipi.equalsIgnoreCase("Tren"))) {
            varisZamani=ucSaatSonra;
        }
        if((kalkisYeri.equalsIgnoreCase("Ankara")&&varisYeri.equalsIgnoreCase("Izmir")&&ulasimTipi.equalsIgnoreCase("Otobus"))||(kalkisYeri.equalsIgnoreCase("Izmir")&&varisYeri.equalsIgnoreCase("Ankara")&&ulasimTipi.equalsIgnoreCase("Otobus"))) {
            varisZamani=yediSaatSonra;
        }
        if((kalkisYeri.equalsIgnoreCase("Ankara")&&varisYeri.equalsIgnoreCase("Izmir")&&ulasimTipi.equalsIgnoreCase("Ucak"))||(kalkisYeri.equalsIgnoreCase("Izmir")&&varisYeri.equalsIgnoreCase("Ankara")&&ulasimTipi.equalsIgnoreCase("Ucak"))) {
            varisZamani=birSaatSonra;
        }
        if((kalkisYeri.equalsIgnoreCase("Ankara")&&varisYeri.equalsIgnoreCase("Izmir")&&ulasimTipi.equalsIgnoreCase("Tren"))||(kalkisYeri.equalsIgnoreCase("Izmir")&&varisYeri.equalsIgnoreCase("Ankara")&&ulasimTipi.equalsIgnoreCase("Tren"))) {
            varisZamani=dortSaatSonra;
        }
    }
    public void fiyatHesapla() {
        if(ulasimTipi.equalsIgnoreCase("Otobus")) {
            fiyat=70;
        }
        if(ulasimTipi.equalsIgnoreCase("Ucak")) {
            fiyat=150;
        }
        if(ulasimTipi.equalsIgnoreCase("Tren")) {
            fiyat=100;
        }
    }

}
