package com.jadilindo.meau.meau;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private ArrayList<Animal> animais;
    public ListAdapter(ArrayList<Animal> animais){
        this.animais = animais;

    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_line_view, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        Animal animal = animais.get(position);
        holder.textNome.setText(animal.getName());
        holder.textIdade.setText(animal.getAge());
        holder.textSexo.setText(animal.getGender());
        holder.textTam.setText(animal.getSize());
        holder.textLoc.setText(animal.getName());

        Picasso.with(holder.imagePet.getContext())
            .load(animal.getPicture())
            .noFade().into(holder.imagePet);
    }

    @Override
    public int getItemCount() {
        return animais.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private TextView textNome;
        private TextView textIdade;
        private TextView textSexo;
        private TextView textTam;
        private TextView textLoc;

        private ImageView imagePet;

        public ListViewHolder(View itemView){
            super(itemView);
            textNome = (TextView) itemView.findViewById(R.id.name_pet);
            imagePet = (ImageView) itemView.findViewById(R.id.image_pet);
            textIdade = (TextView) itemView.findViewById(R.id.idade_pet);
            textSexo = (TextView) itemView.findViewById(R.id.sexo_pet);
            textTam = (TextView) itemView.findViewById(R.id.tamanho_pet);
            textLoc = (TextView) itemView.findViewById(R.id.localizacao_pet);




//            TextView textNome = (TextView) rootView.findViewById(R.id.name_pet);
//            textNome.setText(animal.getName());
//            textNome = (TextView) rootView.findViewById(R.id.idade_pet);
//            textNome.setText(animal.getAge());
//            textNome = (TextView) rootView.findViewById(R.id.sexo_pet);
//            textNome.setText(animal.getGender());
//            textNome = (TextView) rootView.findViewById(R.id.tamanho_pet);
//            textNome.setText(animal.getSize());
//            textNome = (TextView) rootView.findViewById(R.id.localizacao_pet);
//            textNome.setText("vazio");


        }

    }
}
