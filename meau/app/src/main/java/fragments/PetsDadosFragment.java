package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jadilindo.meau.meau.Animal;
import com.jadilindo.meau.meau.R;

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

        Log.d("my", "Elemento " + animal.getName() + " clicado.");

        return rootView;
    }
}
