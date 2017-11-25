package bait.chodznapiwo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import bait.chodznapiwo.adapter.EventAdapter;
import bait.chodznapiwo.model.Event;

/**
 * Created by Piotrek on 25.11.2017.
 */

public class FindEventFragment extends Fragment {
    private ListView mEventList;
    private EventAdapter mEventAdapterAdapter;

    public FindEventFragment() {


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_find, container, false);
        // Inflate the layout for this fragment
        List<Event> tmp= new ArrayList<Event>();
        for(int i=0;i<10;i++) {
            tmp.add(new Event("Pierwszy",new Timestamp(2010,7,7,7,7,0,0),"Olimp","00000",1,"testowy"));
        }
        mEventList= rootView.findViewById(R.id.event_list);

            mEventAdapterAdapter = new EventAdapter(this.getActivity(), tmp);

        mEventList.setAdapter(mEventAdapterAdapter);

        return rootView;
    }
}
