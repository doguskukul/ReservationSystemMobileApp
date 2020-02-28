package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AdapterOtel extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Otel> oteller;
    Context context;
    String girisTarihi,cikisTarihi,amac;
    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageViewOtelResmi;
        public TextView textViewOtelIsmi;
        public TextView textViewBolge;
        public TextView textViewFiyat;
        public ImageView imageViewYildiz;
        public View layout;
        public ViewHolder(View v){
            super(v);
            layout=v;
            imageViewOtelResmi=(ImageView) v.findViewById(R.id.imageViewOtelResmi);
            textViewOtelIsmi=(TextView) v.findViewById(R.id.textViewOtelIsmi);
            textViewBolge=(TextView) v.findViewById(R.id.textViewBolge);
            textViewFiyat=(TextView) v.findViewById(R.id.textViewOtelFiyat);
            imageViewYildiz=(ImageView) v.findViewById(R.id.imageViewYildiz);
        }
    }
    public AdapterOtel(ArrayList<Otel> myDataset, Context context,String girisTarihi,String cikisTarihi,String amac){
        oteller = myDataset;
        this.context = context;
        this.girisTarihi=girisTarihi;
        this.cikisTarihi=cikisTarihi;
        this.amac=amac;
    }
    public AdapterOtel.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.card_view_otel,parent,false);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder vh = (ViewHolder) viewHolder;
        if(oteller.get(i).isimAl().equals("Holiday Inn Express")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.holiday_inn_express);
        }
        else if(oteller.get(i).isimAl().equals("Bof Hotels")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.bof_hotels);
        }
        else if(oteller.get(i).isimAl().equals("Dedeman")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.dedeman);
        }
        else if(oteller.get(i).isimAl().equals("Ontur")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.ontur);
        }
        else if(oteller.get(i).isimAl().equals("The Green Park")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.the_green_park);
        }
        else if(oteller.get(i).isimAl().equals("Etap Mola")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.etap_mola);
        }
        else if(oteller.get(i).isimAl().equals("Aegean")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.aegean);
        }
        else if(oteller.get(i).isimAl().equals("Banu")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.banu);
        }
        else if(oteller.get(i).isimAl().equals("Hotel D Maris Bay")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.hotel_d_maris_bay);
        }
        else if(oteller.get(i).isimAl().equals("Orange County Resort")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.orange_county_resort);
        }
        else if(oteller.get(i).isimAl().equals("Meder Resort")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.meder_resort);
        }
        else if(oteller.get(i).isimAl().equals("Hotel Pine Bay")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.hotel_pine_bay);
        }
        else if(oteller.get(i).isimAl().equals("Soleil")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.soleil);
        }
        else if(oteller.get(i).isimAl().equals("Club Scala Nuova")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.club_scala_nuova);
        }
        else if(oteller.get(i).isimAl().equals("Hotel Green Gold")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.hotel_green_gold);
        }
        else if(oteller.get(i).isimAl().equals("Narcia Resort")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.narcia_resort);
        }
        else if(oteller.get(i).isimAl().equals("Glamour Resort")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.glamour_resort);
        }
        else if(oteller.get(i).isimAl().equals("Hotel Cunda Fora")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.hotel_cunda_fora);
        }
        else if(oteller.get(i).isimAl().equals("Ergin")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.ergin);
        }
        else if(oteller.get(i).isimAl().equals("Kadak Garden")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.kadak_garden);
        }
        else if(oteller.get(i).isimAl().equals("Hilton Garden Inn")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.hilton_garden_inn);
        }
        else if(oteller.get(i).isimAl().equals("Ramada Plaza")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.ramada_plaza);
        }
        else if(oteller.get(i).isimAl().equals("Wyndham Grand")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.wyndham_grand);
        }
        else if(oteller.get(i).isimAl().equals("Anemon Izmir")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.anemon_izmir);
        }
        else if(oteller.get(i).isimAl().equals("Point Hotel Ankara")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.point_hotel_ankara);
        }
        else if(oteller.get(i).isimAl().equals("Business Park Hotel")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.business_park_hotel);
        }
        else if(oteller.get(i).isimAl().equals("Hotel SU & Aqualand")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.hotel_su_aqualand);
        }
        else if(oteller.get(i).isimAl().equals("Club Falcon")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.club_falcon);
        }
        else if(oteller.get(i).isimAl().equals("The Marmara Antalya")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.the_marmara_antalya);
        }
        else if(oteller.get(i).isimAl().equals("Duru Suites")){
            vh.imageViewOtelResmi.setImageResource(R.drawable.duru_suites);
        }
        vh.textViewOtelIsmi.setText(oteller.get(i).isimAl());
        vh.textViewBolge.setText(oteller.get(i).bolgeAl());
        vh.textViewFiyat.setText(Integer.toString(oteller.get(i).fiyatAl()));
        if(oteller.get(i).yildizSayisiAl()==2){
            vh.imageViewYildiz.setImageResource(R.drawable.star2);
        }
        else if(oteller.get(i).yildizSayisiAl()==3){
            vh.imageViewYildiz.setImageResource(R.drawable.star3);
        }
        else if(oteller.get(i).yildizSayisiAl()==4){
            vh.imageViewYildiz.setImageResource(R.drawable.star4);
        }
        else if(oteller.get(i).yildizSayisiAl()==5){
            vh.imageViewYildiz.setImageResource(R.drawable.star5);
        }
        ((ViewHolder) viewHolder).imageViewOtelResmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amac.equals("otelBilgileri")){
                    Intent intentOtelBilgileri=new Intent(context,ActivityOtelBilgileriniGoruntule.class);
                    intentOtelBilgileri.putExtra("oteller",oteller);
                    intentOtelBilgileri.putExtra("otelNo",i);
                    context.startActivity(intentOtelBilgileri);
                }
                else if(amac.equals("otelRezervasyonu")){
                    Intent intentOtelRezervasyonu=new Intent(context,ActivityOtelRezervasyonuYap.class);
                    intentOtelRezervasyonu.putExtra("otel",oteller.get(i));
                    intentOtelRezervasyonu.putExtra("girisTarihi",girisTarihi);
                    intentOtelRezervasyonu.putExtra("cikisTarihi",cikisTarihi);
                    context.startActivity(intentOtelRezervasyonu);
                }
            }
        });
        ((ViewHolder) viewHolder).textViewOtelIsmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amac.equals("otelBilgileri")){
                    Intent intentOtelBilgileri=new Intent(context,ActivityOtelBilgileriniGoruntule.class);
                    intentOtelBilgileri.putExtra("oteller",oteller);
                    intentOtelBilgileri.putExtra("otelNo",i);
                    context.startActivity(intentOtelBilgileri);
                }
                else if(amac.equals("otelRezervasyonu")){
                    Intent intentOtelRezervasyonu=new Intent(context,ActivityOtelRezervasyonuYap.class);
                    intentOtelRezervasyonu.putExtra("otel",oteller.get(i));
                    intentOtelRezervasyonu.putExtra("girisTarihi",girisTarihi);
                    intentOtelRezervasyonu.putExtra("cikisTarihi",cikisTarihi);
                    context.startActivity(intentOtelRezervasyonu);
                }
            }
        });
        ((ViewHolder) viewHolder).textViewBolge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amac.equals("otelBilgileri")){
                    Intent intentOtelBilgileri=new Intent(context,ActivityOtelBilgileriniGoruntule.class);
                    intentOtelBilgileri.putExtra("oteller",oteller);
                    intentOtelBilgileri.putExtra("otelNo",i);
                    context.startActivity(intentOtelBilgileri);
                }
                else if(amac.equals("otelRezervasyonu")){
                    Intent intentOtelRezervasyonu=new Intent(context,ActivityOtelRezervasyonuYap.class);
                    intentOtelRezervasyonu.putExtra("otel",oteller.get(i));
                    intentOtelRezervasyonu.putExtra("girisTarihi",girisTarihi);
                    intentOtelRezervasyonu.putExtra("cikisTarihi",cikisTarihi);
                    context.startActivity(intentOtelRezervasyonu);
                }
            }
        });
        ((ViewHolder) viewHolder).textViewFiyat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amac.equals("otelBilgileri")){
                    Intent intentOtelBilgileri=new Intent(context,ActivityOtelBilgileriniGoruntule.class);
                    intentOtelBilgileri.putExtra("oteller",oteller);
                    intentOtelBilgileri.putExtra("otelNo",i);
                    context.startActivity(intentOtelBilgileri);
                }
                else if(amac.equals("otelRezervasyonu")){
                    Intent intentOtelRezervasyonu=new Intent(context,ActivityOtelRezervasyonuYap.class);
                    intentOtelRezervasyonu.putExtra("otel",oteller.get(i));
                    intentOtelRezervasyonu.putExtra("girisTarihi",girisTarihi);
                    intentOtelRezervasyonu.putExtra("cikisTarihi",cikisTarihi);
                    context.startActivity(intentOtelRezervasyonu);
                }
            }
        });
        ((ViewHolder) viewHolder).imageViewYildiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(amac.equals("otelBilgileri")){
                    Intent intentOtelBilgileri=new Intent(context,ActivityOtelBilgileriniGoruntule.class);
                    intentOtelBilgileri.putExtra("oteller",oteller);
                    intentOtelBilgileri.putExtra("otelNo",i);
                    context.startActivity(intentOtelBilgileri);
                }
                else if(amac.equals("otelRezervasyonu")){
                    Intent intentOtelRezervasyonu=new Intent(context,ActivityOtelRezervasyonuYap.class);
                    intentOtelRezervasyonu.putExtra("otel",oteller.get(i));
                    intentOtelRezervasyonu.putExtra("girisTarihi",girisTarihi);
                    intentOtelRezervasyonu.putExtra("cikisTarihi",cikisTarihi);
                    context.startActivity(intentOtelRezervasyonu);
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        return oteller.size();
    }
}
