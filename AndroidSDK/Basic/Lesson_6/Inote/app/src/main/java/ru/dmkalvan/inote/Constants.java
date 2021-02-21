package ru.dmkalvan.inote;

public interface Constants {
    // StartFragment constants.
    int RC_SIGN_IN = 40404;

    // NoteListFragment constants.
    int MY_DEFAULT_DURATION = 1000;

    // NoteListAdapter constants.
    int X_POS = 10;
    int Y_POS = 10;

    // NoteFragment constants.
    String ARG_NOTE_DATA = "Param_NoteData";
    String DEFAULT_PARAMS = "Empty";

    // NoteSourceFirebaseImpl constants.
    String NOTES_COLLECTION = "notes";

    // NotesSourceImplementation.
    int DEFAULT_CAPACITY = 7;

    // Fragment dialog.
    String FRAGMENT_DIALOG = "fragment_dialog";
    String CANCELED = "Canceled";
    String ACCEPTED = "Accepted";
}
