package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jadilindo.meau.meau.R;

/**
 * Created by pedro on 28/06/18.
 */

public class PetsDadosFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pet_dados_fragment, container, false);
        return rootView;
    }
}
