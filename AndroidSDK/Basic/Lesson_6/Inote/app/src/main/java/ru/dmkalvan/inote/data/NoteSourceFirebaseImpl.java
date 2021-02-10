package ru.dmkalvan.inote.data;

import android.util.Log;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.dmkalvan.inote.Constants;

public class NoteSourceFirebaseImpl implements NoteSource, Constants {

    private static final String TAG = "[NoteSourceFirebaseImpl]";

    private final FirebaseFirestore store = FirebaseFirestore.getInstance();

    private final CollectionReference collection = store.collection(NOTES_COLLECTION);

    private List<NoteData> notesData = new ArrayList<>();

    @Override
    public NoteSource init(NoteSourceResponse noteSourceResponse) {
        collection.orderBy(NoteDataMapping.Fields.DATE, Query.Direction.DESCENDING).get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        notesData = new ArrayList<>();
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            Map<String, Object> doc = document.getData();
                            String id = document.getId();
                            NoteData cardData = NoteDataMapping.toNoteData(id, doc);
                            notesData.add(cardData);
                        }
                        Log.d(TAG, "success " + notesData.size() + " qnt");
                        noteSourceResponse.initialized(NoteSourceFirebaseImpl.this);
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                })
                .addOnFailureListener(e -> Log.d(TAG, "get failed with ", e));
        return this;
    }

    @Override
    public NoteData getNoteData(int position) {
        return notesData.get(position);
    }

    @Override
    public int size() {
        if (notesData == null) {
            return 0;
        }
        return notesData.size();
    }

    @Override
    public void deleteNoteData(int position) {
        collection.document(notesData.get(position).getId()).delete();
        notesData.remove(position);
    }

    @Override
    public void updateNoteData(int position, NoteData noteData) {
        String id = noteData.getId();
        collection.document(id).set(NoteDataMapping.toDocument(noteData));
    }

    @Override
    public void addNoteData(NoteData noteData) {
        collection.add(NoteDataMapping.toDocument(noteData)).addOnSuccessListener(documentReference -> noteData.setId(documentReference.getId()));
    }

    @Override
    public void clearNoteData() {
        for (NoteData noteData : notesData) {
            collection.document(noteData.getId()).delete();
        }
        notesData = new ArrayList<>();
    }
}
