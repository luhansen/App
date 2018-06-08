package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jadilindo.meau.meau.R;

/**
 * Created by pedro on 23/05/18.
 */

public class CadastrarApadrinharAjudarFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cadastrar_apadrinhar_ajudar, container, false);
        return rootView;
    }
}
