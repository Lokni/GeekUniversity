package ru.dmkalvan.inote.data;

public interface NoteSource {
    NoteSource init(NoteSourceResponse noteSourceResponse);

    NoteData getNoteData(int position);

    int size();

    void deleteNoteData(int position);

    void updateNoteData(int position, NoteData noteData);

    void addNoteData(NoteData noteData);

    void clearNoteData();
}
