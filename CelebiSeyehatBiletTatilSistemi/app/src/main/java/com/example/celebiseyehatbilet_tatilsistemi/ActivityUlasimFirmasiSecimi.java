package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class ActivityUlasimFirmasiSecimi extends AppCompatActivity {
    Button buttonYTUR,buttonUcanTurk,buttonDevletDemirYollari;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulasim_firmasi_secimi);
        Intent i4=getIntent();
        final ArrayList<Sefer> seferler=(ArrayList<Sefer>) i4.getSerializableExtra("seferler");
        buttonYTUR=(Button) this.findViewById(R.id.buttonYtur);
        buttonUcanTurk=(Button) this.findViewById(R.id.buttonUcanTurk);
        buttonDevletDemirYollari=(Button) this.findViewById(R.id.buttonDevletDemirYollari);
        buttonYTUR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentYTUR=new Intent(ActivityUlasimFirmasiSecimi.this,ActivitySeferListele.class);
                intentYTUR.putExtra("seferler",seferler);
                intentYTUR.putExtra("ulasimTuru","YTUR");
                startActivity(intentYTUR);
            }
        });
        buttonUcanTurk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentUcanTurk=new Intent(ActivityUlasimFirmasiSecimi.this,ActivitySeferListele.class);
                intentUcanTurk.putExtra("seferler",seferler);
                intentUcanTurk.putExtra("ulasimTuru","UcanTurk");
                startActivity(intentUcanTurk);
            }
        });
        buttonDevletDemirYollari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentDevletDemirYollari=new Intent(ActivityUlasimFirmasiSecimi.this,ActivitySeferListele.class);
                intentDevletDemirYollari.putExtra("seferler",seferler);
                intentDevletDemirYollari.putExtra("ulasimTuru","DevletDemirYollari");
                startActivity(intentDevletDemirYollari);
            }
        });
    }
}
