package bait.chodznapiwo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Piotrek on 25.11.2017.
 */

public class FindEventFragment extends Fragment {
    public FindEventFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_find, container, false);
        // Inflate the layout for this fragment
        return rootView;
    }
}
