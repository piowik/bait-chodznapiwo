package bait.chodznapiwo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Piotrek on 25.11.2017.
 */

public class AddEventFragment extends Fragment {
    public AddEventFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_add, container, false);
        // Inflate the layout for this fragment
        return rootView;
    }
}
