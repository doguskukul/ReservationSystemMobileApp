package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;

public class VeriTabanidao {

    public void musteriEkle(VeriTabani vt, Musteri musteri) {
        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("musteri_isim", musteri.isimAl());
        degerler.put("musteri_soyisim", musteri.soyisimAl());
        degerler.put("musteri_kimlikNo", musteri.kimlikNoAl());
        degerler.put("musteri_telefon", musteri.telefonNoAl());
        degerler.put("musteri_puan",musteri.puanAl());

        dbx.insertOrThrow("musteriler", null, degerler);
        dbx.close( );
    }

    public void rezervasyonEkle(VeriTabani vt, VeritabanıRezervasyonBilgisi rezervasyonBilgisi){
        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("rezervasyon_otelIsmi",rezervasyonBilgisi.getOtelIsmi());
        degerler.put("rezervasyon_musteriKimlikNo",rezervasyonBilgisi.getKimlikNo());
        degerler.put("rezervasyon_girisTarihi", rezervasyonBilgisi.getGirisTarihi());
        degerler.put("rezervasyon_cikisTarihi",rezervasyonBilgisi.getCikisTarihi());
        degerler.put("rezervasyon_odaNo",rezervasyonBilgisi.getOdaNo());
        degerler.put("rezervasyon_kisiSayisi",rezervasyonBilgisi.getKisiSayisi());
        degerler.put("rezervasyon_bosYer",rezervasyonBilgisi.getBosYer());

        dbx.insertOrThrow("rezervasyon",null,degerler);
        dbx.close();
    }

    public void seferEkle(VeriTabani vt, VeritabanıSeferBilgisi seferBilgisi){
        SQLiteDatabase dbx = vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("sefer_seferCount",seferBilgisi.getSeferCount());
        degerler.put("sefer_kimlikNo",seferBilgisi.getKimlikNo());
        degerler.put("sefer_bosKoltuk",seferBilgisi.getBosKoltuk());

        dbx.insertOrThrow("sefer",null,degerler);
        dbx.close();
    }

    public void musteriGuncelle(VeriTabani vt,String kimlikNo,int puan){
        SQLiteDatabase dbx= vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("musteri_puan",puan);
        dbx.update("musteriler",degerler,"musteri_kimlikNo=?",new String[]{kimlikNo});
        dbx.close();
    }

    public void seferGuncelle(VeriTabani vt,int seferCount,int yeniBosKoltuk){
        SQLiteDatabase dbx= vt.getWritableDatabase();
        ContentValues degerler = new ContentValues();

        degerler.put("sefer_bosKoltuk",yeniBosKoltuk);
        dbx.update("sefer",degerler,"sefer_seferCount=?",new String[]{Integer.toString(seferCount)});
        dbx.close();
    }

    public void rezervasyonGuncelle(VeriTabani vt,String otelAdi,int yeniBosYer){
        SQLiteDatabase dbx= vt.getWritableDatabase();
        ContentValues degerler= new ContentValues();

        degerler.put("rezervasyon_bosYer",yeniBosYer);
        dbx.update("rezervasyon",degerler,"rezervasyon_otelIsmi=?",new String[]{otelAdi});
        dbx.close();
    }

    public void rezervasyonGuncelle2(VeriTabani vt,String kimlikNo,int yeniBosYer){
        SQLiteDatabase dbx= vt.getWritableDatabase();
        ContentValues degerler= new ContentValues();

        degerler.put("rezervasyon_bosYer",yeniBosYer);
        dbx.update("rezervasyon",degerler,"rezervasyon_musteriKimlikNo=?",new String[]{kimlikNo});
        dbx.close();
    }

    public ArrayList<Musteri> tumMusteriler(VeriTabani vt) {
        ArrayList<Musteri> musterilerArrayList = new ArrayList<>( );
        SQLiteDatabase dbx = vt.getWritableDatabase();
        Cursor c = dbx.rawQuery("SELECT * FROM musteriler", null);
        while (c.moveToNext( )) {
            Musteri musteri = new Musteri(
                    c.getString(c.getColumnIndex("musteri_isim"))
                    , c.getString(c.getColumnIndex("musteri_soyisim"))
                    , c.getString(c.getColumnIndex("musteri_kimlikNo"))
                    , c.getString(c.getColumnIndex("musteri_telefon"))
            ,c.getInt(c.getColumnIndex("musteri_puan")));
            musterilerArrayList.add(musteri);
        }
        return musterilerArrayList;
    }

    public ArrayList<VeritabanıSeferBilgisi> tumSeferler(VeriTabani vt) {
        ArrayList<VeritabanıSeferBilgisi> seferBilgisiArrayList = new ArrayList<>();
        SQLiteDatabase dbx = vt.getWritableDatabase();
        Cursor c = dbx.rawQuery("SELECT * FROM sefer",null);
        while (c.moveToNext()){
            VeritabanıSeferBilgisi seferBilgisi = new VeritabanıSeferBilgisi(
                    c.getInt(c.getColumnIndex("sefer_seferCount"))
                    ,c.getString(c.getColumnIndex("sefer_kimlikNo"))
                    ,c.getInt(c.getColumnIndex("sefer_bosKoltuk")));
            seferBilgisiArrayList.add(seferBilgisi);
        }
        return seferBilgisiArrayList;
    }

    public ArrayList<VeritabanıRezervasyonBilgisi> tumRezervasyonlar(VeriTabani vt){
        ArrayList<VeritabanıRezervasyonBilgisi> rezervasyonBilgisiArrayList = new ArrayList<>();
        SQLiteDatabase dbx = vt.getWritableDatabase();
        Cursor c = dbx.rawQuery("SELECT * FROM rezervasyon",null);
        while(c.moveToNext()){
            VeritabanıRezervasyonBilgisi rezervasyonBilgisi = new VeritabanıRezervasyonBilgisi(
            c.getString(c.getColumnIndex("rezervasyon_otelIsmi")),
            c.getString(c.getColumnIndex("rezervasyon_musteriKimlikNo")),
            c.getString(c.getColumnIndex("rezervasyon_girisTarihi")),
            c.getString(c.getColumnIndex("rezervasyon_cikisTarihi")),
            c.getInt(c.getColumnIndex("rezervasyon_odaNo")),
            c.getInt(c.getColumnIndex("rezervasyon_kisiSayisi")),
            c.getInt(c.getColumnIndex("rezervasyon_bosYer")));
            rezervasyonBilgisiArrayList.add(rezervasyonBilgisi);
        }
        return rezervasyonBilgisiArrayList;
    }

    public void oteldenRezervasyonSil(VeriTabani vt,String kimlikNo){
        SQLiteDatabase dbx = vt.getWritableDatabase();
        dbx.delete("rezervasyon","rezervasyon_musteriKimlikNo=?",new String[]{kimlikNo});
        dbx.close();
    }
    public void seferdenRezervasyonSil(VeriTabani vt,String kimlikNo){
        SQLiteDatabase dbx = vt.getWritableDatabase();
        dbx.delete("sefer","sefer_kimlikNo=?",new String[]{kimlikNo});
        dbx.close();
    }
}
