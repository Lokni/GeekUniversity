package ru.dmkalvan.mynotes;

import android.os.Parcel;
import android.os.Parcelable;

class StructureData implements Parcelable {
    public static final Creator<StructureData> CREATOR = new Creator<StructureData>() {
        @Override
        public StructureData createFromParcel(Parcel in) {
            return new StructureData(in);
        }

        @Override
        public StructureData[] newArray(int size) {
            return new StructureData[size];
        }
    };
    private String noteLabel;
    private String noteDescription;
    private String noteDate;
    private String noteBody;

    public StructureData() {
    }

    public StructureData(String noteLabel, String noteDescription, String noteDate, String noteBody) {
        this.noteLabel = noteLabel;
        this.noteDescription = noteDescription;
        this.noteDate = noteDate;
        this.noteBody = noteBody;
    }

    protected StructureData(Parcel in) {
        noteLabel = in.readString();
        noteDescription = in.readString();
        noteDate = in.readString();
        noteBody = in.readString();
    }

    public String getNoteLabel() {
        return noteLabel;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public String getNoteDate() {
        return noteDate;
    }

    public String getNoteBody() {
        return noteBody;
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
