package com.example.demomobilv4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demomobilv4.Entity.ResultsDB;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    public Context context;

    ArrayList<ResultsDB> listResultsDB;

    public CustomAdapter(ArrayList<ResultsDB> listResultsDB, Context context) {

        this.context = context;
        this.listResultsDB = listResultsDB;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.my_row_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvDescripcionCode.setText(listResultsDB.get(position).getDescripcionResult());
    }

    @Override
    public int getItemCount() {

        return listResultsDB.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvCodigoCode, tvDescripcionCode, tvValorCode;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescripcionCode = (TextView) itemView.findViewById(R.id.tvDescripcionLO);
        }
    }
}
