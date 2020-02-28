package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AdapterSefer extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Sefer> seferler;
    Context context;
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView kalkisTarihi;
        public TextView kalkisSaati;
        public TextView kalkisYeri;
        public TextView varisYeri;
        public View layout;
        public ViewHolder(View v){
            super(v);
            layout=v;
            kalkisTarihi=(TextView) v.findViewById(R.id.textViewKalkisTarihi);
            kalkisSaati=(TextView) v.findViewById(R.id.textViewKalkisSaati);
            kalkisYeri=(TextView) v.findViewById(R.id.textViewKalkisYeri);
            varisYeri=(TextView) v.findViewById(R.id.textViewVarisYeri);
        }
    }
    public AdapterSefer(ArrayList<Sefer> myDataset, Context context){
        seferler = myDataset;
        this.context = context;
    }
    public AdapterSefer.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_view_sefer,parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        final String saat;
        ViewHolder vh = (ViewHolder) viewHolder;
        final DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
        Date tarih=seferler.get(i).kalkisZamaniAl();
        String strTarih=dateFormat.format(tarih);
        if(seferler.get(i).kalkisZamaniAl().getHours()==10){
            saat="10.00";
        }
        else{
            saat="23.00";
        }
        vh.kalkisTarihi.setText(strTarih);
        vh.kalkisSaati.setText(saat);
        vh.kalkisYeri.setText(seferler.get(i).kalkisYeriAl());
        vh.varisYeri.setText(seferler.get(i).varisYeriAl());
        ((ViewHolder) viewHolder).kalkisTarihi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSeferDetaylari=new Intent(context,ActivitySeferBilgileriniGoruntule.class);
                intentSeferDetaylari.putExtra("kalkisZamani",kalkisZamaniBul(i));
                intentSeferDetaylari.putExtra("varisZamani",varisZamaniBul(i));
                intentSeferDetaylari.putExtra("seferNo",Integer.toString(seferler.get(i).seferNoAl()));
                intentSeferDetaylari.putExtra("fiyat",Integer.toString(seferler.get(i).fiyatAl()));
                intentSeferDetaylari.putExtra("kapasite",Integer.toString(seferler.get(i).kapasiteAl()));
                intentSeferDetaylari.putExtra("bosKoltukSayisi",Integer.toString(seferler.get(i).bosKoltukSayisiAl()));
                intentSeferDetaylari.putExtra("kalkisYeri",seferler.get(i).kalkisYeriAl());
                intentSeferDetaylari.putExtra("varisYeri",seferler.get(i).varisYeriAl());
                intentSeferDetaylari.putExtra("ulasimTipi",seferler.get(i).ulasimTipiAl());
                context.startActivity(intentSeferDetaylari);
            }
        });
        ((ViewHolder) viewHolder).kalkisSaati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSeferDetaylari=new Intent(context,ActivitySeferBilgileriniGoruntule.class);
                intentSeferDetaylari.putExtra("kalkisZamani",kalkisZamaniBul(i));
                intentSeferDetaylari.putExtra("varisZamani",varisZamaniBul(i));
                intentSeferDetaylari.putExtra("seferNo",Integer.toString(seferler.get(i).seferNoAl()));
                intentSeferDetaylari.putExtra("fiyat",Integer.toString(seferler.get(i).fiyatAl()));
                intentSeferDetaylari.putExtra("kapasite",Integer.toString(seferler.get(i).kapasiteAl()));
                intentSeferDetaylari.putExtra("bosKoltukSayisi",Integer.toString(seferler.get(i).bosKoltukSayisiAl()));
                intentSeferDetaylari.putExtra("kalkisYeri",seferler.get(i).kalkisYeriAl());
                intentSeferDetaylari.putExtra("varisYeri",seferler.get(i).varisYeriAl());
                intentSeferDetaylari.putExtra("ulasimTipi",seferler.get(i).ulasimTipiAl());
                context.startActivity(intentSeferDetaylari);
            }
        });
        ((ViewHolder) viewHolder).kalkisYeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSeferDetaylari=new Intent(context,ActivitySeferBilgileriniGoruntule.class);
                intentSeferDetaylari.putExtra("kalkisZamani",kalkisZamaniBul(i));
                intentSeferDetaylari.putExtra("varisZamani",varisZamaniBul(i));
                intentSeferDetaylari.putExtra("seferNo",Integer.toString(seferler.get(i).seferNoAl()));
                intentSeferDetaylari.putExtra("fiyat",Integer.toString(seferler.get(i).fiyatAl()));
                intentSeferDetaylari.putExtra("kapasite",Integer.toString(seferler.get(i).kapasiteAl()));
                intentSeferDetaylari.putExtra("bosKoltukSayisi",Integer.toString(seferler.get(i).bosKoltukSayisiAl()));
                intentSeferDetaylari.putExtra("kalkisYeri",seferler.get(i).kalkisYeriAl());
                intentSeferDetaylari.putExtra("varisYeri",seferler.get(i).varisYeriAl());
                intentSeferDetaylari.putExtra("ulasimTipi",seferler.get(i).ulasimTipiAl());
                context.startActivity(intentSeferDetaylari);
            }
        });
        ((ViewHolder) viewHolder).varisYeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSeferDetaylari=new Intent(context,ActivitySeferBilgileriniGoruntule.class);
                intentSeferDetaylari.putExtra("kalkisZamani",kalkisZamaniBul(i));
                intentSeferDetaylari.putExtra("varisZamani",varisZamaniBul(i));
                intentSeferDetaylari.putExtra("seferNo",Integer.toString(seferler.get(i).seferNoAl()));
                intentSeferDetaylari.putExtra("fiyat",Integer.toString(seferler.get(i).fiyatAl()));
                intentSeferDetaylari.putExtra("kapasite",Integer.toString(seferler.get(i).kapasiteAl()));
                intentSeferDetaylari.putExtra("bosKoltukSayisi",Integer.toString(seferler.get(i).bosKoltukSayisiAl()));
                intentSeferDetaylari.putExtra("kalkisYeri",seferler.get(i).kalkisYeriAl());
                intentSeferDetaylari.putExtra("varisYeri",seferler.get(i).varisYeriAl());
                intentSeferDetaylari.putExtra("ulasimTipi",seferler.get(i).ulasimTipiAl());
                context.startActivity(intentSeferDetaylari);
            }
        });
    }
    @Override
    public int getItemCount() {
        return seferler.size();
    }
    public String kalkisZamaniBul(int i){
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH.mm");
        Date tarih=seferler.get(i).kalkisZamaniAl();
        String zaman=dateFormat.format(tarih);
        return zaman;
    }
    public String varisZamaniBul(int i){
        DateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy HH.mm");
        Date tarih=seferler.get(i).varisZamaniAl();
        String zaman=dateFormat.format(tarih);
        return zaman;
    }
}
