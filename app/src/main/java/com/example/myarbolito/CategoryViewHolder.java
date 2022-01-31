package com.example.myarbolito;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Model.Categoria;

public  class   CategoryViewHolder extends RecyclerView.Adapter<CategoryViewHolder.ViewHolder> implements View.OnClickListener {
    private List<Categoria> mDataSet;
    private View.OnClickListener listener;

    @Override
    public void onClick(View v) {
        if (listener!=null)
                listener.onClick(v);
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
       private  TextView tvCategoria;
       private  ImageView imgFav;
       private CardView cv;


        public ViewHolder( View itemView) {
            super(itemView);
            tvCategoria =itemView.findViewById(R.id.textViewContenido);
            imgFav=itemView.findViewById(R.id.imageViewColor);
            cv=itemView.findViewById(R.id.cardView);

        }
    }
    public CategoryViewHolder(List<Categoria> dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_lista,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    Categoria categoria= mDataSet.get(position);
    holder.tvCategoria.setText(categoria.getNombreCategoria());
    holder.imgFav.setImageResource(categoria.getIcon());
    holder.cv.setCardBackgroundColor(categoria.getColor());


    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
    public void setonClickListener(View.OnClickListener listener){

   this.listener=listener;

    }




}
