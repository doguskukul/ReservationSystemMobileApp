package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterRezervasyon extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<VeritabanıRezervasyonBilgisi> rezervasyonBilgisi;
    Context context;
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textView_kimlikNo;
        public TextView textView_giris;
        public TextView textView_cikis;
        public TextView textView_odaNo;
        public TextView textView_kisiSayisi;
        public View layout;
        public ViewHolder (View v){
            super(v);
            layout=v;
            textView_kimlikNo=v.findViewById(R.id.textView_rezMusteri);
            textView_giris=v.findViewById(R.id.textView_rezGiris);
            textView_cikis=v.findViewById(R.id.textView_rezCikis);
            textView_odaNo=v.findViewById(R.id.textView_rezOdano);
            textView_kisiSayisi=v.findViewById(R.id.textView_rezKisiSayisi);
        }
    }
    public AdapterRezervasyon(ArrayList<VeritabanıRezervasyonBilgisi> myDataset, Context context){
        rezervasyonBilgisi=myDataset;
        this.context=context;
    }
    public AdapterRezervasyon.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_view_rezervasyon,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i){
        ViewHolder vh = (ViewHolder) viewHolder;
        vh.textView_kimlikNo.setText(rezervasyonBilgisi.get(i).getKimlikNo());
        vh.textView_odaNo.setText(Integer.toString(rezervasyonBilgisi.get(i).getOdaNo()));
        vh.textView_cikis.setText(rezervasyonBilgisi.get(i).getCikisTarihi());
        vh.textView_giris.setText(rezervasyonBilgisi.get(i).getGirisTarihi());
        vh.textView_kisiSayisi.setText(Integer.toString(rezervasyonBilgisi.get(i).getKisiSayisi()));
    }
    public int getItemCount(){
        return rezervasyonBilgisi.size();
    }
}
