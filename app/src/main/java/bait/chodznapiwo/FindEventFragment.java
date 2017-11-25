package bait.chodznapiwo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import bait.chodznapiwo.adapter.EventAdapter;
import bait.chodznapiwo.app.AppController;
import bait.chodznapiwo.model.Event;
import bait.chodznapiwo.model.User;
import bait.chodznapiwo.service.EventDetailsFragment;

/**
 * Created by Piotrek on 25.11.2017.
 */

public class FindEventFragment extends Fragment {
    private ListView mEventList;
    private EventAdapter mEventAdapterAdapter;
    private List<Event> tmp;

    public FindEventFragment() {


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_event_find, container, false);
        // Inflate the layout for this fragment
        tmp= new ArrayList<Event>();
        tmp.add(new Event("Pierwszy",new Timestamp(2010,7,7,7,7,0,0),"Olimp","00000",1,"testowy", new LinkedList<User>()));

        mEventList= rootView.findViewById(R.id.event_list);
        mEventAdapterAdapter =new EventAdapter(this.getActivity(),tmp);
        mEventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d("test", "Item ID: " + i);
                AppController.getInstance().setActualEvent(tmp.get(i));
                FragmentTransaction fragmentTransaction = (getActivity().getSupportFragmentManager().beginTransaction());
                fragmentTransaction.replace(R.id.fragmentContainer, new EventDetailsFragment());
                fragmentTransaction.commit();

            }
        });
        mEventList.setAdapter(mEventAdapterAdapter);


        return rootView;
    }


}
