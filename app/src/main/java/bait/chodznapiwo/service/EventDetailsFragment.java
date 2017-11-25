package bait.chodznapiwo.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import bait.chodznapiwo.R;
import bait.chodznapiwo.adapter.EventAdapter;
import bait.chodznapiwo.app.AppController;
import bait.chodznapiwo.model.Event;
import bait.chodznapiwo.model.User;




public class EventDetailsFragment extends Fragment {
    private Event mEvent;
    //private EventAdapter mEventAdapterAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mEvent= AppController.getInstance().getActualEvent();
        View rootView = inflater.inflate(R.layout.fragment_event_details, container, false);
        TextView nameTextView = rootView.findViewById(R.id.event_details_name);
        nameTextView.setText(mEvent.getName());

        TextView dateTextView = rootView.findViewById(R.id.event_details_date);
        dateTextView.setText(mEvent.getDate().toString());


        TextView peopleTextView = rootView.findViewById(R.id.event_details_type);
        nameTextView.setText(mEvent.getEvent_type_id());

        TextView descripteTextView = rootView.findViewById(R.id.event_details_description);
        nameTextView.setText(mEvent.getDescription());

        return rootView;
    }
}