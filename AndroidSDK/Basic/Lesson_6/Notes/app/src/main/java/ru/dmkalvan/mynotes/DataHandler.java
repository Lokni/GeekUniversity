package ru.dmkalvan.mynotes;

import android.os.Parcel;
import android.os.Parcelable;

class DataHandler implements Parcelable {
    public static final Creator<DataHandler> CREATOR = new Creator<DataHandler>() {
        @Override
        public DataHandler createFromParcel(Parcel in) {
            return new DataHandler(in);
        }

        @Override
        public DataHandler[] newArray(int size) {
            return new DataHandler[size];
        }
    };
    private String noteLabel;
    private String noteDescription;
    private String noteDate;
    private String noteBody;

    public DataHandler() {
    }

    public DataHandler(String noteLabel, String noteDescription, String noteDate, String noteBody) {
        setNoteLabel(noteLabel);
        setNoteDescription(noteDescription);
        setNoteDate(noteDate);
        setNoteBody(noteBody);
    }

    protected DataHandler(Parcel in) {
        noteLabel = in.readString();
        noteDescription = in.readString();
        noteDate = in.readString();
        noteBody = in.readString();
    }

    public String getNoteLabel() {
        return noteLabel;
    }

    public void setNoteLabel(String noteLabel) {
        this.noteLabel = noteLabel;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
    }

    public String getNoteBody() {
        return noteBody;
    }

    public void setNoteBody(String noteBody) {
        this.noteBody = noteBody;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteLabel);
        dest.writeString(noteDescription);
        dest.writeString(noteDate);
        dest.writeString(noteBody);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
