package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class ActivityOtelPuanDuzenle extends AppCompatActivity {
    EditText editTextOtelIsmi,editTextYeniPuan;
    Button buttonGuncelle,buttonAnasayfa;
    ArrayList<Otel> oteller;
    Context context=this;
    static final String PREF_NAME = "CelebiSeyehat";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otel_puan_duzenle);
        Intent intentOtelPuanDuzenle = getIntent();
        oteller=(ArrayList<Otel>) intentOtelPuanDuzenle.getSerializableExtra("oteller");
        editTextOtelIsmi = this.findViewById(R.id.editText_otelIsim_pd);
        editTextYeniPuan = this.findViewById(R.id.editText_Puan_pd);
        buttonGuncelle = this.findViewById(R.id.buttonGuncelle_pd);
        buttonAnasayfa = this.findViewById(R.id.buttonAnasayfa_pd);

        buttonGuncelle.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                int kontrol=0;
                String otelIsmi = editTextOtelIsmi.getText().toString();
                int yeniPuan = Integer.parseInt(editTextYeniPuan.getText().toString());
                for(Otel aOtel:oteller){
                    if(aOtel.isimAl().compareTo(otelIsmi)==0){
                        SharedPreferences sharedPref = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putInt("otel_yeniPuan"+aOtel.isimAl(),yeniPuan);
                        editor.commit();
                        kontrol=1;
                        Toast.makeText(getApplicationContext(),"Puan güncellendi",Toast.LENGTH_SHORT).show();
                    }
                }
                if(kontrol==0){
                    Toast.makeText(getApplicationContext(),"Girdiğiniz otel bulunamadı.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        buttonAnasayfa.setOnClickListener(new View.OnClickListener( ) {
            @Override
            public void onClick(View v) {
                Intent intentAnasayfa = new Intent(ActivityOtelPuanDuzenle.this,MainActivity.class);
                startActivity(intentAnasayfa);
            }
        });
    }
}
