package bait.chodznapiwo.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bait.chodznapiwo.R;
import bait.chodznapiwo.model.Event;
import bait.chodznapiwo.service.EventDetailsFragment;

/**
 * Created by Mateusz on 25.11.2017.
 */

public class EventAdapter extends BaseAdapter {
    private Activity mActivity;
    private List<Event> mItems = new ArrayList<>();
    private LayoutInflater inflater;

    public EventAdapter(Activity activity, List<Event> items) {
        this.mActivity = activity;
        this.mItems = items;
    }

    @Override
    public int getCount() {
        return this.mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }




    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item_events, parent, false);

        Event it = mItems.get(position);
        TextView titleTextView =convertView.findViewById(R.id.event_name);

        titleTextView.setText(it.getName());

        TextView dateTextView = convertView.findViewById(R.id.event_date);
        dateTextView.setText(it.getDate().toString());

        return convertView;

    }

}
