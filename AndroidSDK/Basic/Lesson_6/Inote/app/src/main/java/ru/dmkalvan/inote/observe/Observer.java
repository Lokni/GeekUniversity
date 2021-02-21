package ru.dmkalvan.inote.observe;

import ru.dmkalvan.inote.data.NoteData;

public interface Observer {
    void updateNoteData(NoteData noteData);
}
