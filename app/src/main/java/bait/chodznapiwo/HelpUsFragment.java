package bait.chodznapiwo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by artur on 25.11.2017.
 */

public class HelpUsFragment extends Fragment {
    public HelpUsFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_help_us, container, false);
        // Inflate the layout for this fragment
        return rootView;
    }
}
