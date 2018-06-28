package com.jadilindo.meau.meau;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ListAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_line_view, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textElement;

        public ListViewHolder(View itemView){
            super(itemView);
            textElement = (TextView) itemView.findViewById(R.id.name_pet);
            itemView.setOnClickListener(this);


        }

        public void bindView(int position){


//            textElement.setText();
        }

        public void onClick(View view){

        }

    }
}
