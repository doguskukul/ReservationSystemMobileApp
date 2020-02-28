package com.example.celebiseyehatbilet_tatilsistemi;

public class VeritabanıRezervasyonBilgisi {
    private String otelIsmi,kimlikNo,girisTarihi,cikisTarihi;
    private int odaNo,kisiSayisi,bosYer;
    public VeritabanıRezervasyonBilgisi(String otelIsmi, String kimlikNo, String girisTarihi, String cikisTarihi, int odaNo, int kisiSayisi, int bosYer){
        this.otelIsmi=otelIsmi;
        this.kimlikNo=kimlikNo;
        this.girisTarihi=girisTarihi;
        this.cikisTarihi=cikisTarihi;
        this.odaNo=odaNo;
        this.kisiSayisi=kisiSayisi;
        this.bosYer=bosYer;
    }

    public String getOtelIsmi() {
        return otelIsmi;
    }

    public void setOtelIsmi(String otelIsmi) {
        this.otelIsmi = otelIsmi;
    }

    public String getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(String kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public String getGirisTarihi() {
        return girisTarihi;
    }

    public void setGirisTarihi(String girisTarihi) {
        this.girisTarihi = girisTarihi;
    }

    public String getCikisTarihi() {
        return cikisTarihi;
    }

    public void setCikisTarihi(String cikisTarihi) {
        this.cikisTarihi = cikisTarihi;
    }

    public int getOdaNo() {
        return odaNo;
    }

    public void setOdaNo(int odaNo) {
        this.odaNo = odaNo;
    }

    public int getKisiSayisi(){
        return kisiSayisi;
    }

    public void setKisiSayisi(int kisiSayisi){
        this.kisiSayisi=kisiSayisi;
    }

    public int getBosYer() {
        return bosYer;
    }

    public void setBosYer(int bosYer) {
        this.bosYer = bosYer;
    }
}
