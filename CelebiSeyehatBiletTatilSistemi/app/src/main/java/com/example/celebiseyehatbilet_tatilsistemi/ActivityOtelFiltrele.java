package com.example.celebiseyehatbilet_tatilsistemi;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ActivityOtelFiltrele extends AppCompatActivity {
    EditText editGirisTarihi,editCikisTarihi;
    CheckBox checkIstanbul,checkAnkara,checkIzmir,checkAntalya,checkMarmaris,checkKemer,checkKusadasi,checkSide,checkAyvalik;
    ImageButton imageButtonGirisTarihi,imageButtonCikisTarihi;
    Button buttonOtelFiltrele;
    Date girisTarihi,cikisTarihi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otel_filtrele);
        Intent i2=getIntent();
        final ArrayList<Otel> oteller=(ArrayList<Otel>) i2.getSerializableExtra("oteller");
        editGirisTarihi=(EditText) this.findViewById(R.id.editTextGirisTarihi);
        editCikisTarihi=(EditText) this.findViewById(R.id.editTextCikisTarihi);
        editGirisTarihi.setKeyListener(null);
        editCikisTarihi.setKeyListener(null);
        final Context context=this;
        imageButtonGirisTarihi=(ImageButton) findViewById(R.id.imageButtonGirisTarihi);
        imageButtonCikisTarihi=(ImageButton) findViewById(R.id.imageButtonCikisTarihi);
        imageButtonGirisTarihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar takvim = Calendar.getInstance();
                final int yil = takvim.get(Calendar.YEAR);
                final int ay = takvim.get(Calendar.MONTH);
                final int gun = takvim.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                Date bugun=new Date();
                                Date secilenGun=new Date();
                                secilenGun.setDate(dayOfMonth);
                                secilenGun.setMonth(month);
                                secilenGun.setYear(year-1900);
                                if(secilenGun.before(bugun)){
                                    Toast.makeText(getApplicationContext(),"Geçersiz giriş tarihi.",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    month = month+1;
                                    editGirisTarihi.setText(dayOfMonth + "/" + month + "/" + year);
                                    girisTarihi=new Date();
                                    girisTarihi.setDate(dayOfMonth);
                                    girisTarihi.setMonth(month-1);
                                    girisTarihi.setYear(year-1900);
                                }
                            }
                        }, yil, ay, gun);
                dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Tamam", dpd);
                dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", dpd);
                dpd.show();
            }
        });
        imageButtonCikisTarihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar takvim = Calendar.getInstance();
                final int yil = takvim.get(Calendar.YEAR);
                final int ay = takvim.get(Calendar.MONTH);
                final int gun = takvim.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd = new DatePickerDialog(context,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                Date secilenGun=new Date();
                                secilenGun.setDate(dayOfMonth);
                                secilenGun.setMonth(month);
                                secilenGun.setYear(year-1900);
                                if(secilenGun.before(girisTarihi)){
                                    Toast.makeText(getApplicationContext(),"Geçersiz çıkış tarihi.",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    month = month+1;
                                    editCikisTarihi.setText(dayOfMonth + "/" + month + "/" + year);
                                    cikisTarihi=new Date();
                                    cikisTarihi.setDate(dayOfMonth);
                                    cikisTarihi.setMonth(month-1);
                                    cikisTarihi.setYear(year-1900);
                                }
                            }
                        }, yil, ay, gun);
                dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Tamam", dpd);
                dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", dpd);
                dpd.show();
            }
        });
        checkIstanbul=(CheckBox) this.findViewById(R.id.checkIstanbul);
        checkAnkara=(CheckBox) this.findViewById(R.id.checkAnkara);
        checkIzmir=(CheckBox) this.findViewById(R.id.checkIzmir);
        checkAntalya=(CheckBox) this.findViewById(R.id.checkAntalya);
        checkMarmaris=(CheckBox) this.findViewById(R.id.checkMarmaris);
        checkKemer=(CheckBox) this.findViewById(R.id.checkKemer);
        checkKusadasi=(CheckBox) this.findViewById(R.id.checkKusadasi);
        checkSide=(CheckBox) this.findViewById(R.id.checkSide);
        checkAyvalik=(CheckBox) this.findViewById(R.id.checkAyvalik);
        final ArrayList<Otel> filtrelenmisOteller=new ArrayList<>();
        buttonOtelFiltrele=(Button) this.findViewById(R.id.buttonOtelFiltrele);
        buttonOtelFiltrele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean uygunMu=true;
                filtrelenmisOteller.removeAll(oteller);
                for(int i=0;i<30;i++){
                    if(oteller.get(i).bolgeAl().equals("Istanbul") && checkIstanbul.isChecked()==true && oteller.get(i).kabulTarihiBaslangiciAl().before(girisTarihi) && oteller.get(i).kabulTarihiBitisiAl().after(cikisTarihi)){
                        filtrelenmisOteller.add(oteller.get(i));
                    }
                    if(oteller.get(i).bolgeAl().equals("Ankara") && checkAnkara.isChecked()==true && oteller.get(i).kabulTarihiBaslangiciAl().before(girisTarihi) && oteller.get(i).kabulTarihiBitisiAl().after(cikisTarihi)){
                        filtrelenmisOteller.add(oteller.get(i));
                    }
                    if(oteller.get(i).bolgeAl().equals("Izmir") && checkIzmir.isChecked()==true && oteller.get(i).kabulTarihiBaslangiciAl().before(girisTarihi) && oteller.get(i).kabulTarihiBitisiAl().after(cikisTarihi)){
                        filtrelenmisOteller.add(oteller.get(i));
                    }
                    if(oteller.get(i).bolgeAl().equals("Antalya") && checkAntalya.isChecked()==true && oteller.get(i).kabulTarihiBaslangiciAl().before(girisTarihi) && oteller.get(i).kabulTarihiBitisiAl().after(cikisTarihi)){
                        filtrelenmisOteller.add(oteller.get(i));
                    }
                    if(oteller.get(i).bolgeAl().equals("Marmaris") && checkMarmaris.isChecked()==true && oteller.get(i).kabulTarihiBaslangiciAl().before(girisTarihi) && oteller.get(i).kabulTarihiBitisiAl().after(cikisTarihi)){
                        filtrelenmisOteller.add(oteller.get(i));
                    }
                    if(oteller.get(i).bolgeAl().equals("Kemer") && checkKemer.isChecked()==true && oteller.get(i).kabulTarihiBaslangiciAl().before(girisTarihi) && oteller.get(i).kabulTarihiBitisiAl().after(cikisTarihi)){
                        filtrelenmisOteller.add(oteller.get(i));
                    }
                    if(oteller.get(i).bolgeAl().equals("Kusadasi") && checkKusadasi.isChecked()==true && oteller.get(i).kabulTarihiBaslangiciAl().before(girisTarihi) && oteller.get(i).kabulTarihiBitisiAl().after(cikisTarihi)){
                        filtrelenmisOteller.add(oteller.get(i));
                    }
                    if(oteller.get(i).bolgeAl().equals("Side") && checkSide.isChecked()==true && oteller.get(i).kabulTarihiBaslangiciAl().before(girisTarihi) && oteller.get(i).kabulTarihiBitisiAl().after(cikisTarihi)){
                        filtrelenmisOteller.add(oteller.get(i));
                    }
                    if(oteller.get(i).bolgeAl().equals("Ayvalik") && checkAyvalik.isChecked()==true && oteller.get(i).kabulTarihiBaslangiciAl().before(girisTarihi) && oteller.get(i).kabulTarihiBitisiAl().after(cikisTarihi)){
                        filtrelenmisOteller.add(oteller.get(i));
                    }
                }
                if(editGirisTarihi.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Giriş tarihini giriniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(editCikisTarihi.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Çıkış tarihini giriniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(checkIstanbul.isChecked()==false && checkAnkara.isChecked()==false && checkIzmir.isChecked()==false && checkAntalya.isChecked()==false && checkMarmaris.isChecked()==false && checkKemer.isChecked()==false && checkKusadasi.isChecked()==false && checkSide.isChecked()==false && checkAyvalik.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"Gidilmek istenen bölgeyi seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(uygunMu==true){
                    Intent intentOtelListele=new Intent(ActivityOtelFiltrele.this,ActivityOtelListele.class);
                    intentOtelListele.putExtra("oteller",filtrelenmisOteller);
                    intentOtelListele.putExtra("amac","otelRezervasyonu");
                    intentOtelListele.putExtra("girisTarihi",editGirisTarihi.getText().toString());
                    intentOtelListele.putExtra("cikisTarihi",editCikisTarihi.getText().toString());
                    startActivity(intentOtelListele);
                }
            }
        });
    }
}
