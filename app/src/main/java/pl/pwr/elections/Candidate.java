package pl.pwr.elections;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Tomek on 07.12.2016.
 */

public class Candidate implements Parcelable {

    String name;
    String position;
    int imgId;

    public Candidate(String name, String position, int imgId) {
        this.name = name;
        this.position = position;
        this.imgId = imgId;
    }

    protected Candidate(Parcel in) {
        name = in.readString();
        position = in.readString();
        imgId = in.readInt();
    }

    public static final Creator<Candidate> CREATOR = new Creator<Candidate>() {
        @Override
        public Candidate createFromParcel(Parcel in) {
            return new Candidate(in);
        }

        @Override
        public Candidate[] newArray(int size) {
            return new Candidate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(position);
        dest.writeInt(imgId);
    }
}
