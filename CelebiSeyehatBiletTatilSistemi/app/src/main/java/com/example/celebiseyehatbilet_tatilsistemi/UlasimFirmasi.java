package com.example.celebiseyehatbilet_tatilsistemi;
import java.util.ArrayList;

public class UlasimFirmasi {
    private String isim,ulasimTipi;
    private ArrayList<Sefer> seferler;
    private int seferSayisi;
    public UlasimFirmasi(String isim,String ulasimTipi) {
        this.isim=isim;
        this.ulasimTipi=ulasimTipi;
        seferSayisi=0;
        seferler=new ArrayList<Sefer>();
    }
    public String isimAl() {
        return isim;
    }
    public void isimDuzenle(String isim) {
        this.isim=isim;
    }
    public String ulasimTipiAl() {
        return ulasimTipi;
    }
    public void ulasimTipiDuzenle(String ulasimTipi) {
        this.ulasimTipi=ulasimTipi;
    }
    public int seferSayisiAl() {
        return seferSayisi;
    }
    public void seferSayisiDuzenle(int seferSayisi) {
        this.seferSayisi=seferSayisi;
    }
    public boolean seferEkle(Sefer birSefer) {
        if(seferBul(birSefer.seferNoAl())!=null) {
            System.out.println("Kayitli olan bir sefer eklenemez.");
            return false;
        }
        else {
            seferler.add(birSefer);
            seferSayisiDuzenle(seferSayisiAl()+1);
            return true;
        }
    }
    public boolean seferSil(Sefer birSefer) {
        if(seferBul(birSefer.seferNoAl())!=null){
            seferler.remove(birSefer);
            seferSayisiDuzenle(seferSayisiAl()-1);
            return true;
        }
        return false;
    }
    public Sefer seferBul(int seferNo) {
        for(Sefer birSefer : seferler) {
            if(birSefer.seferNoAl()==seferNo) {
                return birSefer;
            }
        }
        return null;
    }

}
