package com.jadilindo.meau.meau;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fragments.PetsDadosFragment;

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

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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


            itemView.setOnClickListener(this);

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

//        private Context context;
        @Override
        public void onClick(View view) {
            Log.d("my", "Elemento " + getAdapterPosition() + " clicado.");
            Bundle arg = new Bundle();
            arg.putSerializable("MyData", animais.get(getAdapterPosition()));
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Fragment myFragment = new PetsDadosFragment();
            myFragment.setArguments(arg);
            activity.getFragmentManager().beginTransaction().replace(R.id.ContentMainFrame, myFragment).addToBackStack( "tag" ).commit();
//            FragmentManager fm = ((Activity) context).getFragmentManager();
//            fm.beginTransaction().replace(R.id.ContentMainFrame, new PerfilFragment()).addToBackStack( "tag" ).commit();
        }
    }
}
