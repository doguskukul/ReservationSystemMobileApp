package com.example.celebiseyehatbilet_tatilsistemi;

public class VeritabanıSeferBilgisi {
    private int seferCount,bosKoltuk;
    private String kimlikNo;
    public VeritabanıSeferBilgisi(int seferCount, String kimlikNo, int bosKoltuk){
        this.seferCount=seferCount;
        this.kimlikNo=kimlikNo;
        this.bosKoltuk=bosKoltuk;
    }

    public String getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(String kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public int getSeferCount(){
        return seferCount;
    }

    public void setSeferCount(int seferNo){
        this.seferCount = seferNo;
    }

    public int getBosKoltuk() {
        return bosKoltuk;
    }

    public void setBosKoltuk(int bosKoltuk) {
        this.bosKoltuk = bosKoltuk;
    }
}
