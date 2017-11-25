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

    public String getName() {
        return mName;
    }

    public Timestamp getDate() {
        return mDate;
    }

    public String getPlace() {
        return mPlace;
    }

    public String getCoords() {
        return mCoords;
    }

    public int getEvent_type_id() {
        return mEvent_type_id;
    }

    public String getDescription() {
        return mDescription;
    }
}
