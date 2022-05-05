package com.zeruk.retrofitjava.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeruk.retrofitjava.R;
import com.zeruk.retrofitjava.databinding.RowLayoutBinding;
import com.zeruk.retrofitjava.model.CryptoModel;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private ArrayList<CryptoModel> cryptoModels;
    private String[] colors={"#99E942", "#76CBA1", "#99DDDD", "#E0DC4C", "#DD9999"};

    public RecyclerViewAdapter(ArrayList<CryptoModel> cryptoModels)
    {
        this.cryptoModels = cryptoModels;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bind(cryptoModels.get(position), colors, position);
    }

    @Override
    public int getItemCount() {
        return cryptoModels.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView text_name;
        TextView text_price;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
        public void bind(CryptoModel cryptoModel, String[] colors, Integer position)
        {
            itemView.setBackgroundColor(Color.parseColor(colors[position%5]));
            text_name = itemView.findViewById(R.id.text_name);
            text_price = itemView.findViewById(R.id.text_price);
            text_name.setText(cryptoModel.currency);
            text_price.setText(cryptoModel.price);
        }
    }
}
