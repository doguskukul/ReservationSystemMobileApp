package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class VeriTabani extends SQLiteOpenHelper {

    public VeriTabani(Context context){
        super(context,"Kayitlar",null,1);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE musteriler (musteri_isim TEXT,musteri_soyisim TEXT,musteri_kimlikNo TEXT,musteri_telefon TEXT,musteri_puan INTEGER);");
        db.execSQL("CREATE TABLE rezervasyon (rezervasyon_otelIsmi TEXT, rezervasyon_musteriKimlikNo TEXT, rezervasyon_girisTarihi TEXT, rezervasyon_cikisTarihi TEXT, rezervasyon_odaNo INTEGER, rezervasyon_kisiSayisi INTEGER,rezervasyon_bosYer INTEGER)");
        db.execSQL("CREATE TABLE sefer(sefer_seferCount INTEGER, sefer_kimlikNo TEXT, sefer_bosKoltuk INTEGER)");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS musteriler");
        db.execSQL("DROP TABLE IF EXISTS rezervasyon");
        db.execSQL("DROP TABLE IF EXISTS sefer");
        onCreate(db);
    }
}
