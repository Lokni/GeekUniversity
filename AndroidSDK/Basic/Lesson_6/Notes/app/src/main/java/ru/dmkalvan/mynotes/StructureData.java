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
        setNoteLabel(noteLabel);
        setNoteDescription(noteDescription);
        setNoteDate(noteDate);
        setNoteBody(noteBody);
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

    public void setNoteLabel(String noteLabel) {
        this.noteLabel = noteLabel;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public void setNoteDate(String noteDate) {
        this.noteDate = noteDate;
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
