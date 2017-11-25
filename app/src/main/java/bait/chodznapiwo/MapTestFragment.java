package bait.chodznapiwo;

/**
 * Created by Piotrek on 25.11.2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 */
public class MapTestFragment extends Fragment implements OnMapReadyCallback {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);


        SupportMapFragment mapFragment =
                (SupportMapFragment) this.getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return rootView;
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera.
     */
    @Override
    public void onMapReady(GoogleMap map) {
        map.addMarker(new MarkerOptions().position(new LatLng(50.066718, 19.922727)).title("Tezeusz"));
        map.moveCamera( CameraUpdateFactory.newLatLngZoom(new LatLng(50.066718, 19.922727) , 20.0f) );
    }
}
