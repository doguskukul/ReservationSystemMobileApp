package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Button buttonBiletSat,buttonOtelBul,buttonMusteriBilgileri,buttonSeferBilgileri,buttonOtelBilgileri,buttonRezervasyonSil,buttonOtelPuanGuncelle;
    private VeriTabani vt;
    ArrayList<Sefer> seferler;
    ArrayList<Otel> oteller;
    Context context=this;
    static final String PREF_NAME = "CelebiSeyehat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vt = new VeriTabani(this);
        final ArrayList<Musteri> gelenMusteriListesi = new VeriTabanidao().tumMusteriler(vt);
        String isimUcanTurk="Ucan Turk Ozel Hava Yolu",ulasimTipiUcanTurk="Ucak";
        String isimDevletDemirYollari="Devlet Demir Yollari",ulasimTipiDevletDemirYollari="Tren";
        String isimYTUR="YTUR Otobus Firmalari",ulasimTipiYTUR="Otobus";
        String sehir1="Istanbul",sehir2="Ankara",sehir3="Izmir";
        long birGunUzunlugu=1000*60*60*24;
        Date bugun10=new Date();
        bugun10.setHours(10);
        bugun10.setMinutes(00);
        bugun10.setSeconds(00);
        Date bugun23=new Date();
        bugun23.setHours(23);
        bugun23.setMinutes(00);
        bugun23.setSeconds(00);
        Date yarin10=new Date(bugun10.getTime()+(birGunUzunlugu));
        Date yarin23=new Date(bugun23.getTime()+(birGunUzunlugu));
        Date ikiGunSonra10=new Date(bugun10.getTime()+(2*birGunUzunlugu));
        Date ikiGunSonra23=new Date(bugun23.getTime()+(2*birGunUzunlugu));
        Date ucGunSonra10=new Date(bugun10.getTime()+(3*birGunUzunlugu));
        Date ucGunSonra23=new Date(bugun23.getTime()+(3*birGunUzunlugu));
        Date dortGunSonra10=new Date(bugun10.getTime()+(4*birGunUzunlugu));
        Date dortGunSonra23=new Date(bugun23.getTime()+(4*birGunUzunlugu));
        Date besGunSonra10=new Date(bugun10.getTime()+(5*birGunUzunlugu));
        Date besGunSonra23=new Date(bugun23.getTime()+(5*birGunUzunlugu));
        Date altiGunSonra10=new Date(bugun10.getTime()+(6*birGunUzunlugu));
        Date altiGunSonra23=new Date(bugun23.getTime()+(6*birGunUzunlugu));
        Date yediGunSonra10=new Date(bugun10.getTime()+(7*birGunUzunlugu));
        Date yediGunSonra23=new Date(bugun23.getTime()+(7*birGunUzunlugu));
        final Sefer[] sefer=new Sefer[300];
        sefer[0]=new Sefer(1,bugun10,sehir1,sehir2,ulasimTipiYTUR);
        sefer[1]=new Sefer(2,bugun23,sehir1,sehir2,ulasimTipiYTUR);
        sefer[2]=new Sefer(3,yarin10,sehir1,sehir2,ulasimTipiYTUR);
        sefer[3]=new Sefer(4,yarin23,sehir1,sehir2,ulasimTipiYTUR);
        sefer[4]=new Sefer(5,ikiGunSonra10,sehir1,sehir2,ulasimTipiYTUR);
        sefer[5]=new Sefer(6,ikiGunSonra23,sehir1,sehir2,ulasimTipiYTUR);
        sefer[6]=new Sefer(7,ucGunSonra10,sehir1,sehir2,ulasimTipiYTUR);
        sefer[7]=new Sefer(8,ucGunSonra23,sehir1,sehir2,ulasimTipiYTUR);
        sefer[8]=new Sefer(9,dortGunSonra10,sehir1,sehir2,ulasimTipiYTUR);
        sefer[9]=new Sefer(10,dortGunSonra23,sehir1,sehir2,ulasimTipiYTUR);
        sefer[10]=new Sefer(11,besGunSonra10,sehir1,sehir2,ulasimTipiYTUR);
        sefer[11]=new Sefer(12,besGunSonra23,sehir1,sehir2,ulasimTipiYTUR);
        sefer[12]=new Sefer(13,altiGunSonra10,sehir1,sehir2,ulasimTipiYTUR);
        sefer[13]=new Sefer(14,altiGunSonra23,sehir1,sehir2,ulasimTipiYTUR);
        sefer[14]=new Sefer(15,bugun10,sehir1,sehir3,ulasimTipiYTUR);
        sefer[15]=new Sefer(16,bugun23,sehir1,sehir3,ulasimTipiYTUR);
        sefer[16]=new Sefer(17,yarin10,sehir1,sehir3,ulasimTipiYTUR);
        sefer[17]=new Sefer(18,yarin23,sehir1,sehir3,ulasimTipiYTUR);
        sefer[18]=new Sefer(19,ikiGunSonra10,sehir1,sehir3,ulasimTipiYTUR);
        sefer[19]=new Sefer(20,ikiGunSonra23,sehir1,sehir3,ulasimTipiYTUR);
        sefer[20]=new Sefer(21,ucGunSonra10,sehir1,sehir3,ulasimTipiYTUR);
        sefer[21]=new Sefer(22,ucGunSonra23,sehir1,sehir3,ulasimTipiYTUR);
        sefer[22]=new Sefer(23,dortGunSonra10,sehir1,sehir3,ulasimTipiYTUR);
        sefer[23]=new Sefer(24,dortGunSonra23,sehir1,sehir3,ulasimTipiYTUR);
        sefer[24]=new Sefer(25,besGunSonra10,sehir1,sehir3,ulasimTipiYTUR);
        sefer[25]=new Sefer(26,besGunSonra23,sehir1,sehir3,ulasimTipiYTUR);
        sefer[26]=new Sefer(27,altiGunSonra10,sehir1,sehir3,ulasimTipiYTUR);
        sefer[27]=new Sefer(28,altiGunSonra23,sehir1,sehir3,ulasimTipiYTUR);
        sefer[28]=new Sefer(29,bugun10,sehir3,sehir2,ulasimTipiYTUR);
        sefer[29]=new Sefer(30,bugun23,sehir3,sehir2,ulasimTipiYTUR);
        sefer[30]=new Sefer(31,yarin10,sehir3,sehir2,ulasimTipiYTUR);
        sefer[31]=new Sefer(32,yarin23,sehir3,sehir2,ulasimTipiYTUR);
        sefer[32]=new Sefer(33,ikiGunSonra10,sehir3,sehir2,ulasimTipiYTUR);
        sefer[33]=new Sefer(34,ikiGunSonra23,sehir3,sehir2,ulasimTipiYTUR);
        sefer[34]=new Sefer(35,ucGunSonra10,sehir3,sehir2,ulasimTipiYTUR);
        sefer[35]=new Sefer(36,ucGunSonra23,sehir3,sehir2,ulasimTipiYTUR);
        sefer[36]=new Sefer(37,dortGunSonra10,sehir3,sehir2,ulasimTipiYTUR);
        sefer[37]=new Sefer(38,dortGunSonra23,sehir3,sehir2,ulasimTipiYTUR);
        sefer[38]=new Sefer(39,besGunSonra10,sehir3,sehir2,ulasimTipiYTUR);
        sefer[39]=new Sefer(40,besGunSonra23,sehir3,sehir2,ulasimTipiYTUR);
        sefer[40]=new Sefer(41,altiGunSonra10,sehir3,sehir2,ulasimTipiYTUR);
        sefer[41]=new Sefer(42,altiGunSonra23,sehir3,sehir2,ulasimTipiYTUR);
        sefer[42]=new Sefer(43,bugun10,sehir2,sehir1,ulasimTipiYTUR);
        sefer[43]=new Sefer(44,bugun23,sehir2,sehir1,ulasimTipiYTUR);
        sefer[44]=new Sefer(45,yarin10,sehir2,sehir1,ulasimTipiYTUR);
        sefer[45]=new Sefer(46,yarin23,sehir2,sehir1,ulasimTipiYTUR);
        sefer[46]=new Sefer(47,ikiGunSonra10,sehir2,sehir1,ulasimTipiYTUR);
        sefer[47]=new Sefer(48,ikiGunSonra23,sehir2,sehir1,ulasimTipiYTUR);
        sefer[48]=new Sefer(49,ucGunSonra10,sehir2,sehir1,ulasimTipiYTUR);
        sefer[49]=new Sefer(50,ucGunSonra23,sehir2,sehir1,ulasimTipiYTUR);
        sefer[50]=new Sefer(51,dortGunSonra10,sehir2,sehir1,ulasimTipiYTUR);
        sefer[51]=new Sefer(52,dortGunSonra23,sehir2,sehir1,ulasimTipiYTUR);
        sefer[52]=new Sefer(53,besGunSonra10,sehir2,sehir1,ulasimTipiYTUR);
        sefer[53]=new Sefer(54,besGunSonra23,sehir2,sehir1,ulasimTipiYTUR);
        sefer[54]=new Sefer(55,altiGunSonra10,sehir2,sehir1,ulasimTipiYTUR);
        sefer[55]=new Sefer(56,altiGunSonra23,sehir2,sehir1,ulasimTipiYTUR);
        sefer[56]=new Sefer(57,bugun10,sehir3,sehir1,ulasimTipiYTUR);
        sefer[57]=new Sefer(58,bugun23,sehir3,sehir1,ulasimTipiYTUR);
        sefer[58]=new Sefer(59,yarin10,sehir3,sehir1,ulasimTipiYTUR);
        sefer[59]=new Sefer(60,yarin23,sehir3,sehir1,ulasimTipiYTUR);
        sefer[60]=new Sefer(61,ikiGunSonra10,sehir3,sehir1,ulasimTipiYTUR);
        sefer[61]=new Sefer(62,ikiGunSonra23,sehir3,sehir1,ulasimTipiYTUR);
        sefer[62]=new Sefer(63,ucGunSonra10,sehir3,sehir1,ulasimTipiYTUR);
        sefer[63]=new Sefer(64,ucGunSonra23,sehir3,sehir1,ulasimTipiYTUR);
        sefer[64]=new Sefer(65,dortGunSonra10,sehir3,sehir1,ulasimTipiYTUR);
        sefer[65]=new Sefer(66,dortGunSonra23,sehir3,sehir1,ulasimTipiYTUR);
        sefer[66]=new Sefer(67,besGunSonra10,sehir3,sehir1,ulasimTipiYTUR);
        sefer[67]=new Sefer(68,besGunSonra23,sehir3,sehir1,ulasimTipiYTUR);
        sefer[68]=new Sefer(69,altiGunSonra10,sehir3,sehir1,ulasimTipiYTUR);
        sefer[69]=new Sefer(70,altiGunSonra23,sehir3,sehir1,ulasimTipiYTUR);
        sefer[70]=new Sefer(71,bugun10,sehir2,sehir3,ulasimTipiYTUR);
        sefer[71]=new Sefer(72,bugun23,sehir2,sehir3,ulasimTipiYTUR);
        sefer[72]=new Sefer(73,yarin10,sehir2,sehir3,ulasimTipiYTUR);
        sefer[73]=new Sefer(74,yarin23,sehir2,sehir3,ulasimTipiYTUR);
        sefer[74]=new Sefer(75,ikiGunSonra10,sehir2,sehir3,ulasimTipiYTUR);
        sefer[75]=new Sefer(76,ikiGunSonra23,sehir2,sehir3,ulasimTipiYTUR);
        sefer[76]=new Sefer(77,ucGunSonra10,sehir2,sehir3,ulasimTipiYTUR);
        sefer[77]=new Sefer(78,ucGunSonra23,sehir2,sehir3,ulasimTipiYTUR);
        sefer[78]=new Sefer(79,dortGunSonra10,sehir2,sehir3,ulasimTipiYTUR);
        sefer[79]=new Sefer(80,dortGunSonra23,sehir2,sehir3,ulasimTipiYTUR);
        sefer[80]=new Sefer(81,besGunSonra10,sehir2,sehir3,ulasimTipiYTUR);
        sefer[81]=new Sefer(82,besGunSonra23,sehir2,sehir3,ulasimTipiYTUR);
        sefer[82]=new Sefer(83,altiGunSonra10,sehir2,sehir3,ulasimTipiYTUR);
        sefer[83]=new Sefer(84,altiGunSonra23,sehir2,sehir3,ulasimTipiYTUR);
        sefer[84]=new Sefer(1,bugun10,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[85]=new Sefer(2,bugun23,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[86]=new Sefer(3,yarin10,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[87]=new Sefer(4,yarin23,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[88]=new Sefer(5,ikiGunSonra10,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[89]=new Sefer(6,ikiGunSonra23,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[90]=new Sefer(7,ucGunSonra10,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[91]=new Sefer(8,ucGunSonra23,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[92]=new Sefer(9,dortGunSonra10,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[93]=new Sefer(10,dortGunSonra23,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[94]=new Sefer(11,besGunSonra10,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[95]=new Sefer(12,besGunSonra23,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[96]=new Sefer(13,altiGunSonra10,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[97]=new Sefer(14,altiGunSonra23,sehir1,sehir2,ulasimTipiUcanTurk);
        sefer[98]=new Sefer(15,bugun10,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[99]=new Sefer(16,bugun23,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[100]=new Sefer(17,yarin10,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[101]=new Sefer(18,yarin23,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[102]=new Sefer(19,ikiGunSonra10,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[103]=new Sefer(20,ikiGunSonra23,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[104]=new Sefer(21,ucGunSonra10,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[105]=new Sefer(22,ucGunSonra23,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[106]=new Sefer(23,dortGunSonra10,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[107]=new Sefer(24,dortGunSonra23,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[108]=new Sefer(25,besGunSonra10,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[109]=new Sefer(26,besGunSonra23,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[110]=new Sefer(27,altiGunSonra10,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[111]=new Sefer(28,altiGunSonra23,sehir1,sehir3,ulasimTipiUcanTurk);
        sefer[112]=new Sefer(29,bugun10,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[113]=new Sefer(30,bugun23,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[114]=new Sefer(31,yarin10,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[115]=new Sefer(32,yarin23,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[116]=new Sefer(33,ikiGunSonra10,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[117]=new Sefer(34,ikiGunSonra23,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[118]=new Sefer(35,ucGunSonra10,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[119]=new Sefer(36,ucGunSonra23,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[120]=new Sefer(37,dortGunSonra10,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[121]=new Sefer(38,dortGunSonra23,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[122]=new Sefer(39,besGunSonra10,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[123]=new Sefer(40,besGunSonra23,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[124]=new Sefer(41,altiGunSonra10,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[125]=new Sefer(42,altiGunSonra23,sehir3,sehir2,ulasimTipiUcanTurk);
        sefer[126]=new Sefer(43,bugun10,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[127]=new Sefer(44,bugun23,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[128]=new Sefer(45,yarin10,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[129]=new Sefer(46,yarin23,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[130]=new Sefer(47,ikiGunSonra10,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[131]=new Sefer(48,ikiGunSonra23,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[132]=new Sefer(49,ucGunSonra10,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[133]=new Sefer(50,ucGunSonra23,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[134]=new Sefer(51,dortGunSonra10,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[135]=new Sefer(52,dortGunSonra23,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[136]=new Sefer(53,besGunSonra10,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[137]=new Sefer(54,besGunSonra23,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[138]=new Sefer(55,altiGunSonra10,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[139]=new Sefer(56,altiGunSonra23,sehir2,sehir1,ulasimTipiUcanTurk);
        sefer[140]=new Sefer(57,bugun10,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[141]=new Sefer(58,bugun23,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[142]=new Sefer(59,yarin10,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[143]=new Sefer(60,yarin23,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[144]=new Sefer(61,ikiGunSonra10,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[145]=new Sefer(62,ikiGunSonra23,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[146]=new Sefer(63,ucGunSonra10,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[147]=new Sefer(64,ucGunSonra23,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[148]=new Sefer(65,dortGunSonra10,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[149]=new Sefer(66,dortGunSonra23,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[150]=new Sefer(67,besGunSonra10,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[151]=new Sefer(68,besGunSonra23,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[152]=new Sefer(69,altiGunSonra10,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[153]=new Sefer(70,altiGunSonra23,sehir3,sehir1,ulasimTipiUcanTurk);
        sefer[154]=new Sefer(71,bugun10,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[155]=new Sefer(72,bugun23,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[156]=new Sefer(73,yarin10,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[157]=new Sefer(74,yarin23,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[158]=new Sefer(75,ikiGunSonra10,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[159]=new Sefer(76,ikiGunSonra23,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[160]=new Sefer(77,ucGunSonra10,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[161]=new Sefer(78,ucGunSonra23,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[162]=new Sefer(79,dortGunSonra10,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[163]=new Sefer(80,dortGunSonra23,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[164]=new Sefer(81,besGunSonra10,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[165]=new Sefer(82,besGunSonra23,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[166]=new Sefer(83,altiGunSonra10,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[167]=new Sefer(84,altiGunSonra23,sehir2,sehir3,ulasimTipiUcanTurk);
        sefer[168]=new Sefer(1,bugun10,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[169]=new Sefer(2,bugun23,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[170]=new Sefer(3,yarin10,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[171]=new Sefer(4,yarin23,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[172]=new Sefer(5,ikiGunSonra10,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[173]=new Sefer(6,ikiGunSonra23,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[174]=new Sefer(7,ucGunSonra10,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[175]=new Sefer(8,ucGunSonra23,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[176]=new Sefer(9,dortGunSonra10,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[177]=new Sefer(10,dortGunSonra23,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[178]=new Sefer(11,besGunSonra10,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[179]=new Sefer(12,besGunSonra23,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[180]=new Sefer(13,altiGunSonra10,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[181]=new Sefer(14,altiGunSonra23,sehir1,sehir2,ulasimTipiDevletDemirYollari);
        sefer[182]=new Sefer(15,bugun10,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[183]=new Sefer(16,bugun23,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[184]=new Sefer(17,yarin10,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[185]=new Sefer(18,yarin23,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[186]=new Sefer(19,ikiGunSonra10,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[187]=new Sefer(20,ikiGunSonra23,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[188]=new Sefer(21,ucGunSonra10,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[189]=new Sefer(22,ucGunSonra23,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[190]=new Sefer(23,dortGunSonra10,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[191]=new Sefer(24,dortGunSonra23,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[192]=new Sefer(25,besGunSonra10,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[193]=new Sefer(26,besGunSonra23,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[194]=new Sefer(27,altiGunSonra10,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[195]=new Sefer(28,altiGunSonra23,sehir1,sehir3,ulasimTipiDevletDemirYollari);
        sefer[196]=new Sefer(29,bugun10,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[197]=new Sefer(30,bugun23,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[198]=new Sefer(31,yarin10,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[199]=new Sefer(32,yarin23,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[200]=new Sefer(33,ikiGunSonra10,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[201]=new Sefer(34,ikiGunSonra23,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[202]=new Sefer(35,ucGunSonra10,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[203]=new Sefer(36,ucGunSonra23,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[204]=new Sefer(37,dortGunSonra10,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[205]=new Sefer(38,dortGunSonra23,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[206]=new Sefer(39,besGunSonra10,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[207]=new Sefer(40,besGunSonra23,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[208]=new Sefer(41,altiGunSonra10,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[209]=new Sefer(42,altiGunSonra23,sehir3,sehir2,ulasimTipiDevletDemirYollari);
        sefer[210]=new Sefer(43,bugun10,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[211]=new Sefer(44,bugun23,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[212]=new Sefer(45,yarin10,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[213]=new Sefer(46,yarin23,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[214]=new Sefer(47,ikiGunSonra10,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[215]=new Sefer(48,ikiGunSonra23,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[216]=new Sefer(49,ucGunSonra10,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[217]=new Sefer(50,ucGunSonra23,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[218]=new Sefer(51,dortGunSonra10,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[219]=new Sefer(52,dortGunSonra23,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[220]=new Sefer(53,besGunSonra10,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[221]=new Sefer(54,besGunSonra23,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[222]=new Sefer(55,altiGunSonra10,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[223]=new Sefer(56,altiGunSonra23,sehir2,sehir1,ulasimTipiDevletDemirYollari);
        sefer[224]=new Sefer(57,bugun10,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[225]=new Sefer(58,bugun23,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[226]=new Sefer(59,yarin10,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[227]=new Sefer(60,yarin23,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[228]=new Sefer(61,ikiGunSonra10,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[229]=new Sefer(62,ikiGunSonra23,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[230]=new Sefer(63,ucGunSonra10,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[231]=new Sefer(64,ucGunSonra23,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[232]=new Sefer(65,dortGunSonra10,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[233]=new Sefer(66,dortGunSonra23,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[234]=new Sefer(67,besGunSonra10,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[235]=new Sefer(68,besGunSonra23,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[236]=new Sefer(69,altiGunSonra10,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[237]=new Sefer(70,altiGunSonra23,sehir3,sehir1,ulasimTipiDevletDemirYollari);
        sefer[238]=new Sefer(71,bugun10,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[239]=new Sefer(72,bugun23,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[240]=new Sefer(73,yarin10,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[241]=new Sefer(74,yarin23,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[242]=new Sefer(75,ikiGunSonra10,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[243]=new Sefer(76,ikiGunSonra23,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[244]=new Sefer(77,ucGunSonra10,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[245]=new Sefer(78,ucGunSonra23,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[246]=new Sefer(79,dortGunSonra10,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[247]=new Sefer(80,dortGunSonra23,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[248]=new Sefer(81,besGunSonra10,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[249]=new Sefer(82,besGunSonra23,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[250]=new Sefer(83,altiGunSonra10,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        sefer[251]=new Sefer(84,altiGunSonra23,sehir2,sehir3,ulasimTipiDevletDemirYollari);
        final ArrayList<VeritabanıSeferBilgisi> seferBilgisiVt = new VeriTabanidao().tumSeferler(vt);
        for(VeritabanıSeferBilgisi aSeferBilgisi: seferBilgisiVt){
            sefer[aSeferBilgisi.getSeferCount()].bosKoltukSayisiDuzenle(aSeferBilgisi.getBosKoltuk());
        }
        UlasimFirmasi ucanTurkOzelHavaYolu=new UlasimFirmasi(isimUcanTurk,ulasimTipiUcanTurk);
        UlasimFirmasi devletDemirYollari=new UlasimFirmasi(isimDevletDemirYollari,ulasimTipiDevletDemirYollari);
        UlasimFirmasi YTUR=new UlasimFirmasi(isimYTUR,ulasimTipiYTUR);
        for(int i=0;i<84;i++) {
            YTUR.seferEkle(sefer[i]);
            ucanTurkOzelHavaYolu.seferEkle(sefer[84+i]);
            devletDemirYollari.seferEkle(sefer[168+i]);
        }
        Date suAn=new Date();
        for(int i=0;i<252;i++) {
            if(sefer[i].kalkisZamaniAl().before(suAn)) {
                if(sefer[i].kalkisZamaniAl().getHours()==10) {
                    sefer[i].kalkisZamaniDuzenle(yediGunSonra10);
                }
                else if(sefer[i].kalkisZamaniAl().getHours()==23) {
                    sefer[i].kalkisZamaniDuzenle(yediGunSonra23);
                }
                sefer[i].varisZamaniHesapla();
                sefer[i].tumYolculariSil();
                sefer[i].kapasiteHesapla();
                sefer[i].bosKoltukSayisiDuzenle(sefer[i].kapasiteAl());
            }
        }
        seferler=new ArrayList<Sefer>();
        for(Sefer birSefer:sefer){
            seferler.add(birSefer);
        }
        Date baslangicTarihi1=new Date();
        baslangicTarihi1.setDate(10);
        baslangicTarihi1.setMonth(4);
        baslangicTarihi1.setYear(119);
        Date bitisTarihi1=new Date();
        bitisTarihi1.setDate(20);
        bitisTarihi1.setMonth(9);
        bitisTarihi1.setYear(119);
        Date baslangicTarihi2=new Date();
        baslangicTarihi2.setDate(1);
        baslangicTarihi2.setMonth(3);
        baslangicTarihi2.setYear(119);
        Date bitisTarihi2=new Date();
        bitisTarihi2.setDate(30);
        bitisTarihi2.setMonth(10);
        bitisTarihi2.setYear(119);
        Date baslangicTarihi3=new Date();
        baslangicTarihi3.setDate(7);
        baslangicTarihi3.setMonth(4);
        baslangicTarihi3.setYear(119);
        Date bitisTarihi3=new Date();
        bitisTarihi3.setDate(30);
        bitisTarihi3.setMonth(8);
        bitisTarihi3.setYear(119);
        Date baslangicTarihi4=new Date();
        baslangicTarihi4.setDate(25);
        baslangicTarihi4.setMonth(3);
        baslangicTarihi4.setYear(119);
        Date bitisTarihi4=new Date();
        bitisTarihi4.setDate(5);
        bitisTarihi4.setMonth(10);
        bitisTarihi4.setYear(119);
        Date baslangicTarihi5=new Date();
        baslangicTarihi5.setDate(1);
        baslangicTarihi5.setMonth(2);
        baslangicTarihi5.setYear(119);
        Date bitisTarihi5=new Date();
        bitisTarihi5.setDate(17);
        bitisTarihi5.setMonth(10);
        bitisTarihi5.setYear(119);
        Otel[] otel=new Otel[30];
        otel[0]=new Otel("Holiday Inn Express","Istanbul",baslangicTarihi1,bitisTarihi3,270,3,50,1);
        otel[1]=new Otel("Bof Hotels","Istanbul",baslangicTarihi3,bitisTarihi5,326,5,80,2);
        otel[2]=new Otel("Dedeman","Istanbul",baslangicTarihi5,bitisTarihi1,693,5,150,3);
        otel[3]=new Otel("Ontur","Izmir",baslangicTarihi2,bitisTarihi2,402,4,80,1);
        otel[4]=new Otel("The Green Park","Ankara",baslangicTarihi1,bitisTarihi3,588,5,120,3);
        otel[5]=new Otel("Etap Mola","Ankara",baslangicTarihi4,bitisTarihi5,250,3,70,1);
        otel[6]=new Otel("Aegean","Marmaris",baslangicTarihi1,bitisTarihi1,154,3,60,1);
        otel[7]=new Otel("Banu","Marmaris",baslangicTarihi4,bitisTarihi3,225,2,40,1);
        otel[8]=new Otel("Hotel D Maris Bay","Marmaris",baslangicTarihi3,bitisTarihi2,1881,5,200,4);
        otel[9]=new Otel("Orange County Resort","Kemer",baslangicTarihi1,bitisTarihi4,603,5,100,3);
        otel[10]=new Otel("Meder Resort","Kemer",baslangicTarihi2,bitisTarihi2,365,5,130,2);
        otel[11]=new Otel("Hotel Pine Bay","Kusadasi",baslangicTarihi1,bitisTarihi5,476,5,140,2);
        otel[12]=new Otel("Soleil","Kusadasi",baslangicTarihi4,bitisTarihi2,95,2,20,1);
        otel[13]=new Otel("Club Scala Nuova","Kusadasi",baslangicTarihi4,bitisTarihi2,136,4,100,1);
        otel[14]=new Otel("Hotel Green Gold","Kusadasi",baslangicTarihi1,bitisTarihi2,494,4,130,2);
        otel[15]=new Otel("Narcia Resort","Side",baslangicTarihi3,bitisTarihi3,497,5,140,3);
        otel[16]=new Otel("Glamour Resort","Side",baslangicTarihi5,bitisTarihi1,361,5,160,2);
        otel[17]=new Otel("Hotel Cunda Fora","Ayvalik",baslangicTarihi1,bitisTarihi2,393,4,80,2);
        otel[18]=new Otel("Ergin","Ayvalik",baslangicTarihi2,bitisTarihi2,160,3,70,1);
        otel[19]=new Otel("Kadak Garden","Istanbul",baslangicTarihi3,bitisTarihi1,374,4,130,2);
        otel[20]=new Otel("Hilton Garden Inn","Istanbul",baslangicTarihi5,bitisTarihi4,244,4,80,2);
        otel[21]=new Otel("Ramada Plaza","Istanbul",baslangicTarihi2,bitisTarihi5,336,5,170,2);
        otel[22]=new Otel("Wyndham Grand","Izmir",baslangicTarihi3,bitisTarihi2,704,5,160,3);
        otel[23]=new Otel("Anemon Izmir","Izmir",baslangicTarihi1,bitisTarihi5,276,4,100,2);
        otel[24]=new Otel("Point Hotel Ankara","Ankara",baslangicTarihi2,bitisTarihi2,739,5,140,4);
        otel[25]=new Otel("Business Park Hotel","Ankara",baslangicTarihi4,bitisTarihi3,171,4,90,2);
        otel[26]=new Otel("Hotel SU & Aqualand","Antalya",baslangicTarihi3,bitisTarihi1,701,5,190,3);
        otel[27]=new Otel("Club Falcon","Antalya",baslangicTarihi2,bitisTarihi2,716,4,120,3);
        otel[28]=new Otel("The Marmara Antalya","Antalya",baslangicTarihi1,bitisTarihi4,758,5,200,3);
        otel[29]=new Otel("Duru Suites","Antalya",baslangicTarihi4,bitisTarihi4,313,3,60,2);
        final ArrayList<VeritabanıRezervasyonBilgisi> rezervasyonBilgisiVt = new VeriTabanidao().tumRezervasyonlar(vt);
        for (VeritabanıRezervasyonBilgisi aRezervasyonBilgisi: rezervasyonBilgisiVt) {
            for (int otelCount = 0; otelCount < 30; otelCount++) {
                if (aRezervasyonBilgisi.getOtelIsmi( ).compareTo(otel[otelCount].isimAl( )) == 0) {
                    otel[otelCount].bosYerSayisiDuzenle(aRezervasyonBilgisi.getBosYer( ));
                }
            }
        }
        oteller=new ArrayList<>();
        for(Otel birOtel:otel){
            oteller.add(birOtel);
        }
        for(int i=0;i<30;i++){
            SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
            oteller.get(i).puanDuzenle(sharedPref.getInt("otel_yeniPuan"+oteller.get(i).isimAl(),oteller.get(i).puanAl()));
        }
        buttonBiletSat=(Button) this.findViewById(R.id.buttonBiletSat);
        buttonOtelBul=(Button) this.findViewById(R.id.buttonOtelRezervasyonu);
        buttonMusteriBilgileri=(Button) this.findViewById(R.id.buttonMusteriBilgileri);
        buttonSeferBilgileri=(Button) this.findViewById(R.id.buttonSeferBilgileri);
        buttonOtelBilgileri=(Button) this.findViewById(R.id.buttonOtelBilgileri);
        buttonRezervasyonSil=(Button) this.findViewById(R.id.buttonRezervasyonSil);
        buttonOtelPuanGuncelle=(Button) this.findViewById(R.id.buttonGuncelle);
        buttonBiletSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this, ActivityBiletSat.class);
                i.putExtra("seferler",seferler);
                startActivity(i);
            }
        });
        buttonOtelBul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(MainActivity.this,ActivityOtelFiltrele.class);
                i2.putExtra("oteller",oteller);
                startActivity(i2);
            }
        });
        buttonMusteriBilgileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(MainActivity.this, ActivityMusteriListele.class);
                i3.putExtra("musteriler",gelenMusteriListesi);
                startActivity(i3);
            }
        });
        buttonSeferBilgileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i4=new Intent(MainActivity.this,ActivityUlasimFirmasiSecimi.class);
                i4.putExtra("seferler",seferler);
                startActivity(i4);
            }
        });
        buttonOtelBilgileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i5=new Intent(MainActivity.this,ActivityOtelListele.class);
                i5.putExtra("amac","otelBilgileri");
                i5.putExtra("girisTarihi","");
                i5.putExtra("cikisTarihi","");
                i5.putExtra("oteller",oteller);
                startActivity(i5);
            }
        });
        buttonRezervasyonSil.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent i6=new Intent(MainActivity.this,ActivityRezervasyonSil.class);
                i6.putExtra("oteller",oteller);
                i6.putExtra("seferler",seferler);
                startActivity(i6);
            }
        });
        buttonOtelPuanGuncelle.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent i7=new Intent(MainActivity.this,ActivityOtelPuanDuzenle.class);
                i7.putExtra("oteller",oteller);
                startActivity(i7);
            }
        });
    }
}

