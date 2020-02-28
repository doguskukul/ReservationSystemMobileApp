package com.example.celebiseyehatbilet_tatilsistemi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class AdapterMusteri extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<Musteri> musteriler;
    Context context;
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewIsim;
        public TextView textViewSoyisim;
        public TextView textViewKimlikNo;
        public View layout;
        public ViewHolder(View v){
            super(v);
            layout=v;
            textViewIsim=v.findViewById(R.id.textViewIsim_musteri);
            textViewSoyisim=v.findViewById(R.id.textViewSoyisim_musteri);
            textViewKimlikNo=v.findViewById(R.id.textViewKimlikNo_musteri);
        }
    }

    public AdapterMusteri(ArrayList<Musteri> myDataset, Context context){
        musteriler=myDataset;
        this.context=context;
    }

    public AdapterMusteri.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.recycler_view_musteri,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        ViewHolder vh = (ViewHolder) viewHolder;
        vh.textViewIsim.setText(musteriler.get(i).isimAl());
        vh.textViewSoyisim.setText(musteriler.get(i).soyisimAl());
        vh.textViewKimlikNo.setText(musteriler.get(i).kimlikNoAl());
        ((ViewHolder) viewHolder).textViewIsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMusteriBilgileri=new Intent(context,ActivityMusteriBilgileriniGoruntule.class);
                intentMusteriBilgileri.putExtra("ad",musteriler.get(i).isimAl());
                intentMusteriBilgileri.putExtra("soyad",musteriler.get(i).soyisimAl());
                intentMusteriBilgileri.putExtra("kimlikNo",musteriler.get(i).kimlikNoAl());
                intentMusteriBilgileri.putExtra("telefonNo",musteriler.get(i).telefonNoAl());
                intentMusteriBilgileri.putExtra("puan",Integer.toString(musteriler.get(i).puanAl()));
                context.startActivity(intentMusteriBilgileri);
            }
        });
        ((ViewHolder) viewHolder).textViewSoyisim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMusteriBilgileri=new Intent(context,ActivityMusteriBilgileriniGoruntule.class);
                intentMusteriBilgileri.putExtra("ad",musteriler.get(i).isimAl());
                intentMusteriBilgileri.putExtra("soyad",musteriler.get(i).soyisimAl());
                intentMusteriBilgileri.putExtra("kimlikNo",musteriler.get(i).kimlikNoAl());
                intentMusteriBilgileri.putExtra("telefonNo",musteriler.get(i).telefonNoAl());
                intentMusteriBilgileri.putExtra("puan",Integer.toString(musteriler.get(i).puanAl()));
                context.startActivity(intentMusteriBilgileri);
            }
        });
        ((ViewHolder) viewHolder).textViewKimlikNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMusteriBilgileri=new Intent(context,ActivityMusteriBilgileriniGoruntule.class);
                intentMusteriBilgileri.putExtra("ad",musteriler.get(i).isimAl());
                intentMusteriBilgileri.putExtra("soyad",musteriler.get(i).soyisimAl());
                intentMusteriBilgileri.putExtra("kimlikNo",musteriler.get(i).kimlikNoAl());
                intentMusteriBilgileri.putExtra("telefonNo",musteriler.get(i).telefonNoAl());
                intentMusteriBilgileri.putExtra("puan",Integer.toString(musteriler.get(i).puanAl()));
                context.startActivity(intentMusteriBilgileri);
            }
        });
    }

    @Override
    public int getItemCount() {
        return musteriler.size();
    }
}
