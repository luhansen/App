package fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jadilindo.meau.meau.R;

/**
 * Created by pedro on 09/05/18.
 */

public class LegislacaoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_legislacao, container, false);


        String s = "Art. 4º";
        String text = getString(R.string.Art4);
        TextView t = (TextView) rootView.findViewById(R.id.Art4id);
        t.setText(text, TextView.BufferType.SPANNABLE);
        Spannable span = (Spannable) t.getText();
        int start = 0;
        int end = s.length();
        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.TextColorGreenArt)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        t = (TextView) rootView.findViewById(R.id.Art5id);
        text = getString(R.string.Art5);
        t.setText(text, TextView.BufferType.SPANNABLE);
        span = (Spannable) t.getText();
        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.TextColorGreenArt)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        t = (TextView) rootView.findViewById(R.id.Art6id);
        text = getString(R.string.Art6);
        t.setText(text, TextView.BufferType.SPANNABLE);
        span = (Spannable) t.getText();
        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.TextColorGreenArt)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        t = (TextView) rootView.findViewById(R.id.Art7id);
        text = getString(R.string.Art7);
        t.setText(text, TextView.BufferType.SPANNABLE);
        span = (Spannable) t.getText();
        span.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.TextColorGreenArt)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);


        return rootView;
    }
}
