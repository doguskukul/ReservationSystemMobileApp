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

public class ActivityBiletSat extends AppCompatActivity {
    EditText editIsim,editSoyisim,editKimlikNo,editTelefonNo,editKalkisTarihi;
    ImageButton imageButtonTakvim;
    CheckBox checkBoxYtur,checkBoxUcanTurk,checkBoxDevletDemirYollari,checkBoxIstanbul,checkBoxAnkara,checkBoxIzmir,checkBoxIstanbul2,checkBoxAnkara2,checkBoxIzmir2,checkBox10,checkBox23;
    Button buttonOnayla;
    Date secilenGun,suAn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilet_sat);
        Intent i=getIntent();
        final ArrayList<Sefer> seferler=(ArrayList<Sefer>) i.getSerializableExtra("seferler");
        editIsim=(EditText) this.findViewById(R.id.editTextIsim);
        editSoyisim=(EditText) this.findViewById(R.id.editTextSoyisim);
        editKimlikNo=(EditText) this.findViewById(R.id.editTextKimlikNo);
        editTelefonNo=(EditText) this.findViewById(R.id.editTextTelefonNo);
        editKalkisTarihi=(EditText) this.findViewById(R.id.editTextKalkisTarihi);
        editKalkisTarihi.setKeyListener(null);
        final Context context=this;
        imageButtonTakvim=(ImageButton) findViewById(R.id.imageButtonKalkisTarihi);
        imageButtonTakvim.setOnClickListener(new View.OnClickListener() {
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
                                suAn=new Date();
                                long birGunUzunlugu=1000*60*60*24;
                                Date yediGunSonra=new Date(suAn.getTime()+(7*birGunUzunlugu));
                                secilenGun=new Date();
                                secilenGun.setDate(dayOfMonth);
                                secilenGun.setMonth(month);
                                secilenGun.setYear(year-1900);
                                if(secilenGun.before(suAn) || secilenGun.after(yediGunSonra)){
                                    Toast.makeText(getApplicationContext(),"Geçersiz kalkış tarihi.",Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    month = month+1;
                                    editKalkisTarihi.setText(dayOfMonth + "/" + month + "/" + year);
                                }
                            }
                        }, yil, ay, gun);
                dpd.setButton(DatePickerDialog.BUTTON_POSITIVE, "Tamam", dpd);
                dpd.setButton(DatePickerDialog.BUTTON_NEGATIVE, "İptal", dpd);
                dpd.show();
            }
        });
        checkBoxYtur=(CheckBox) this.findViewById(R.id.checkBoxYtur);
        checkBoxUcanTurk=(CheckBox) this.findViewById(R.id.checkBoxUcanTurk);
        checkBoxDevletDemirYollari=(CheckBox) this.findViewById(R.id.checkBoxDevletDemirYollari);
        checkBoxIstanbul=(CheckBox) this.findViewById(R.id.checkBoxIstanbul);
        checkBoxAnkara=(CheckBox) this.findViewById(R.id.checkBoxAnkara);
        checkBoxIzmir=(CheckBox) this.findViewById(R.id.checkBoxIzmir);
        checkBoxIstanbul2=(CheckBox) this.findViewById(R.id.checkBoxIstanbul2);
        checkBoxAnkara2=(CheckBox) this.findViewById(R.id.checkBoxAnkara2);
        checkBoxIzmir2=(CheckBox) this.findViewById(R.id.checkBoxIzmir2);
        checkBox10=(CheckBox) this.findViewById(R.id.checkBox10_00);
        checkBox23=(CheckBox) this.findViewById(R.id.checkBox23_00);
        buttonOnayla=(Button) this.findViewById(R.id.buttonOnayla);
        buttonOnayla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean uygunMu=true;
                Date bugun10=new Date();
                bugun10.setHours(10);
                bugun10.setMinutes(00);
                bugun10.setSeconds(00);
                if(checkBox10.isChecked()==true){
                    secilenGun.setHours(10);
                    secilenGun.setMinutes(00);
                    secilenGun.setSeconds(00);
                }
                if(checkBox23.isChecked()==true){
                    secilenGun.setHours(23);
                    secilenGun.setMinutes(00);
                    secilenGun.setSeconds(00);
                }
                if(suAn.after(bugun10) && secilenGun.before(suAn)){
                    Toast.makeText(getApplicationContext(),"Geçersiz kalkış tarihi.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(editIsim.getText().toString().equals("") || editSoyisim.getText().toString().equals("") || editKimlikNo.getText().toString().equals("") || editTelefonNo.getText().toString().equals("") || editKalkisTarihi.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Lütfen tüm bilgileri giriniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(checkBoxYtur.isChecked()==false && checkBoxUcanTurk.isChecked()==false && checkBoxDevletDemirYollari.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"Ulaşım firması seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(checkBoxIstanbul.isChecked()==false && checkBoxAnkara.isChecked()==false && checkBoxIzmir.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"Kalkış yeri seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(checkBoxIstanbul2.isChecked()==false && checkBoxAnkara2.isChecked()==false && checkBoxIzmir2.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"Varış yeri seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(checkBox10.isChecked()==false && checkBox23.isChecked()==false){
                    Toast.makeText(getApplicationContext(),"Kalkış saati seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if((checkBoxYtur.isChecked()==true && checkBoxUcanTurk.isChecked()==true) || (checkBoxYtur.isChecked()==true && checkBoxDevletDemirYollari.isChecked()==true) || (checkBoxDevletDemirYollari.isChecked()==true && checkBoxUcanTurk.isChecked()==true) || (checkBoxYtur.isChecked()==true && checkBoxUcanTurk.isChecked()==true && checkBoxDevletDemirYollari.isChecked()==true)){
                    Toast.makeText(getApplicationContext(),"Sadece bir ulaşım firması seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if((checkBoxIstanbul.isChecked()==true && checkBoxAnkara.isChecked()==true) || (checkBoxIstanbul.isChecked()==true && checkBoxIzmir.isChecked()==true) || (checkBoxIzmir.isChecked()==true && checkBoxAnkara.isChecked()==true) || (checkBoxIstanbul.isChecked()==true && checkBoxAnkara.isChecked()==true && checkBoxIzmir.isChecked()==true)){
                    Toast.makeText(getApplicationContext(),"Sadece bir kalkış yeri seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if((checkBoxIstanbul2.isChecked()==true && checkBoxAnkara2.isChecked()==true) || (checkBoxIstanbul2.isChecked()==true && checkBoxIzmir2.isChecked()==true) || (checkBoxIzmir2.isChecked()==true && checkBoxAnkara2.isChecked()==true) || (checkBoxIstanbul2.isChecked()==true && checkBoxAnkara2.isChecked()==true && checkBoxIzmir2.isChecked()==true)){
                    Toast.makeText(getApplicationContext(),"Sadece bir varış yeri seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(checkBox10.isChecked()==true && checkBox23.isChecked()==true){
                    Toast.makeText(getApplicationContext(),"Sadece bir kalkış saati seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if((checkBoxIstanbul.isChecked()==true && checkBoxIstanbul2.isChecked()==true) || (checkBoxAnkara.isChecked()==true && checkBoxAnkara2.isChecked()==true) || (checkBoxIzmir.isChecked()==true && checkBoxIzmir2.isChecked()==true)){
                    Toast.makeText(getApplicationContext(),"Farklı kalkış ve varış yerleri seçiniz.",Toast.LENGTH_SHORT).show();
                    uygunMu=false;
                }
                if(uygunMu==true){
                    String ulasimFirmasi=null,kalkisYeri=null,varisYeri=null,kalkisSaati=null;
                    Intent intentOdemeYap=new Intent(ActivityBiletSat.this,ActivityOdemeYap.class);
                    intentOdemeYap.putExtra("seferler",seferler);
                    intentOdemeYap.putExtra("isim",editIsim.getText().toString());
                    intentOdemeYap.putExtra("soyisim",editSoyisim.getText().toString());
                    intentOdemeYap.putExtra("kimlikNo",editKimlikNo.getText().toString());
                    intentOdemeYap.putExtra("telefonNo",editTelefonNo.getText().toString());
                    intentOdemeYap.putExtra("kalkisTarihi",editKalkisTarihi.getText().toString());
                    if(checkBoxYtur.isChecked()==true){
                        ulasimFirmasi="YTUR Otobus Firmalari";
                    }
                    else if(checkBoxUcanTurk.isChecked()==true){
                        ulasimFirmasi="Ucan Turk Ozel Hava Yolu";
                    }
                    else if(checkBoxDevletDemirYollari.isChecked()==true){
                        ulasimFirmasi="Devlet Demir Yollari";
                    }
                    if(checkBoxIstanbul.isChecked()==true){
                        kalkisYeri="Istanbul";
                    }
                    else if(checkBoxAnkara.isChecked()==true){
                        kalkisYeri="Ankara";
                    }
                    else if(checkBoxIzmir.isChecked()==true){
                        kalkisYeri="Izmir";
                    }
                    if(checkBoxIstanbul2.isChecked()==true){
                        varisYeri="Istanbul";
                    }
                    else if(checkBoxAnkara2.isChecked()==true){
                        varisYeri="Ankara";
                    }
                    else if(checkBoxIzmir2.isChecked()==true){
                        varisYeri="Izmir";
                    }
                    if(checkBox10.isChecked()==true){
                        kalkisSaati="10.00";
                    }
                    else if(checkBox23.isChecked()==true){
                        kalkisSaati="23.00";
                    }
                    intentOdemeYap.putExtra("ulasimFirmasi",ulasimFirmasi);
                    intentOdemeYap.putExtra("kalkisYeri",kalkisYeri);
                    intentOdemeYap.putExtra("varisYeri",varisYeri);
                    intentOdemeYap.putExtra("kalkisSaati",kalkisSaati);
                    startActivity(intentOdemeYap);
                }
            }
        });
    }
}
