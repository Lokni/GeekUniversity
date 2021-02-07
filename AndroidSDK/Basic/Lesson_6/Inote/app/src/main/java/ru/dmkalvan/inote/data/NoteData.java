package ru.dmkalvan.inote.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class NoteData implements Parcelable {
    public static final Creator<NoteData> CREATOR = new Creator<NoteData>() {
        @Override
        public NoteData createFromParcel(Parcel in) {
            return new NoteData(in);
        }

        @Override
        public NoteData[] newArray(int size) {
            return new NoteData[size];
        }
    };
    private String id;
    private final String title;
    private final String description;
    private final Date date;
    private final String body;

    public NoteData(String title, String description, Date date, String body) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.body = body;
    }

    protected NoteData(Parcel in) {
        title = in.readString();
        description = in.readString();
        body = in.readString();
        date = new Date(in.readLong());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeLong(date.getTime());
        dest.writeString(body);

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getBody() {
        return body;
    }
}
