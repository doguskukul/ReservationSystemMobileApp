package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class ActivitySeferListele extends AppCompatActivity {
    RecyclerView recyclerView;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sefer_listele);
        Intent intent=getIntent();
        final ArrayList<Sefer> seferler=(ArrayList<Sefer>) intent.getSerializableExtra("seferler");
        String ulasimTuru=intent.getStringExtra("ulasimTuru");
        recyclerView=(RecyclerView) this.findViewById(R.id.recyclerViewSefer);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Sefer> ulasimTuruneGoreSeferler=new ArrayList<>();
        for(int i=0;i<84;i++) {
            if(ulasimTuru.equals("YTUR")){
                ulasimTuruneGoreSeferler.add(seferler.get(i));
            }
            else if(ulasimTuru.equals("UcanTurk")){
                ulasimTuruneGoreSeferler.add(seferler.get(84+i));
            }
            else if(ulasimTuru.equals("DevletDemirYollari")){
                ulasimTuruneGoreSeferler.add(seferler.get(168+i));
            }
        }
        if(ulasimTuru.equals("YTUR")){
            AdapterSefer adapterSefer=new AdapterSefer(ulasimTuruneGoreSeferler,context);
            recyclerView.setAdapter(adapterSefer);
        }
        else if(ulasimTuru.equals("UcanTurk")){
            AdapterSefer adapterSefer=new AdapterSefer(ulasimTuruneGoreSeferler,context);
            recyclerView.setAdapter(adapterSefer);
        }
        else if(ulasimTuru.equals("DevletDemirYollari")){
            AdapterSefer adapterSefer=new AdapterSefer(ulasimTuruneGoreSeferler,context);
            recyclerView.setAdapter(adapterSefer);
        }
    }
}
