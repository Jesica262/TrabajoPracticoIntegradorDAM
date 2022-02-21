package com.example.myarbolito;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myarbolito.Modelo.Arbol;

import java.util.List;

public  class ArbolViewHolder extends RecyclerView.Adapter<ArbolViewHolder.ViewHolder> implements View.OnClickListener {
    private List<Arbol> mDataSet;
    private View.OnClickListener listener;

    @Override
    public void onClick(View v) {
        if (listener != null)
            listener.onClick(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvArbol;
        private ImageView imgFav;
        private CardView cv;


        public ViewHolder(View itemView) {
            super(itemView);
            tvArbol = itemView.findViewById(R.id.textViewContenido);
            imgFav=itemView.findViewById(R.id.imageViewColor);
            cv = itemView.findViewById(R.id.cardView);

        }
    }

    public ArbolViewHolder(List<Arbol> dataSet) {
        mDataSet = dataSet;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.element, parent, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Arbol arbol = mDataSet.get(position);
        holder.tvArbol.setText(arbol.getNombreArbol());
        holder.imgFav.setImageResource(arbol.getIcon());
        holder.cv.setCardBackgroundColor(arbol.getColor());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setonClickListener(View.OnClickListener listener) { this.listener = listener; }
}