package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.jadilindo.meau.meau.Animal;
import com.jadilindo.meau.meau.R;
import com.squareup.picasso.Picasso;

/**
 * Created by pedro on 28/06/18.
 */

public class PetsDadosFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pet_dados_fragment, container, false);
        Animal animal = (Animal)getArguments().getSerializable("MyData");



        TextView textElement = (TextView) rootView.findViewById(R.id.pet_name_perfil);
        textElement.setText(animal.getName());
        textElement = (TextView) rootView.findViewById(R.id.detalhesIdade);
        textElement.setText(animal.getAge());
        textElement = (TextView) rootView.findViewById(R.id.detalhesPorte);
        textElement.setText(animal.getSize());
        textElement = (TextView) rootView.findViewById(R.id.detalhesSexo);
        textElement.setText(animal.getGender());
        ImageView imageViewAnimal = (ImageView) rootView.findViewById(R.id.pet_image_perfil);
        Picasso.with(getActivity())
                .load(animal.getPicture())
                .noFade().into(imageViewAnimal);

            textElement = (TextView) rootView.findViewById(R.id.detalhesVermifugado);
            textElement.setText("Não");


            textElement = (TextView) rootView.findViewById(R.id.detalhesVacinado);
            textElement.setText("Não");


            textElement = (TextView) rootView.findViewById(R.id.detalhesCastrado);
            textElement.setText("Não");

            textElement = (TextView) rootView.findViewById(R.id.detalhesDoencas);
            textElement.setText("Não");


        for (String s :animal.getHealth()){
            if (s.equals("vermifugado")){
                textElement = (TextView) rootView.findViewById(R.id.detalhesVermifugado);
                textElement.setText("Sim");
            }
            else if(s.equals("vacinado")){
                textElement = (TextView) rootView.findViewById(R.id.detalhesVacinado);
                textElement.setText("Sim");
            }
            else if(s.equals("castrado")){
                textElement = (TextView) rootView.findViewById(R.id.detalhesCastrado);
                textElement.setText("Sim");
            }
            else if(s.equals("doente")){
                textElement = (TextView) rootView.findViewById(R.id.detalhesDoencas);
                textElement.setText(animal.getDesease());
            }
        }

        String temperamento = "";
        for(String s : animal.getTemper()){
            if(s.equals("amoroso")){
                temperamento += "amoroso, ";
            }
            if(s.equals("brincalhao")){
                temperamento += "brincalhao, ";
            }
            if(s.equals("calmo")){
                temperamento += "calmo, ";
            }
            if(s.equals("preguicoso")){
                temperamento += "preguicoso, ";
            }
            if(s.equals("guarda")){
                temperamento += "guarda, ";
            }
            if(s.equals("timido")){
                temperamento += "timido, ";
            }

        }
        temperamento = temperamento.substring(0, temperamento.length() - 2);
        textElement = (TextView) rootView.findViewById(R.id.DetalhesTemperamento);
        textElement.setText(temperamento);

        textElement = (TextView) rootView.findViewById(R.id.detalhesMais);
        textElement.setText(animal.getAbout());

        textElement = (TextView) rootView.findViewById(R.id.exigencias_Adocao_text);
        String exigencias = "";
        if(animal.isObj_need()){

        }
        if(animal.isAdoption_term()){

        }

        ImageButton fav_button = (ImageButton) rootView.findViewById(R.id.imageButtonFav);
//                                    View.OnClickListener mOnClickListenerFav = new View.OnClickListener() {
//                                        @Override
//                                        public void onClick(final View view) {
//                                            fav_animal_for_current_user(view);
//                                        }
//                                    };
//        textElement.setText(animal.getHealth());


        return rootView;
    }
}
