package bait.chodznapiwo.model;

import java.sql.Timestamp;

/**
 * Created by karol on 11/25/17.
 */

public class Event {
    private String mName;
    private Timestamp mDate;
    private String mPlace;
    private String mCoords;
    private int mEvent_type_id;
    private String mDescription;

    public Event(String mName, Timestamp mDate, String mPlace, String mCoords, int mEvent_type_id, String mDescription) {
        this.mName = mName;
        this.mDate = mDate;
        this.mPlace = mPlace;
        this.mCoords = mCoords;
        this.mEvent_type_id = mEvent_type_id;
        this.mDescription = mDescription;
    }
    //asasas
}
