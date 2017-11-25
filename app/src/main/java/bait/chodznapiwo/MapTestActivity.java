package bait.chodznapiwo;

/**
 * Created by Piotrek on 25.11.2017.
 */

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * This shows how to create a simple activity with a map and a marker on the map.
 */
public class MapTestActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_test);

        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
