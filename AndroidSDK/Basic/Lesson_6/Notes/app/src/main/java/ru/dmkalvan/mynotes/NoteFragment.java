package ru.dmkalvan.mynotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NoteFragment extends Fragment implements Constants {
    EditText label, description, date, body;

    private StructureData noteData;

    public NoteFragment() {
        // Required empty public constructor
    }

    public static NoteFragment newInstance(String param1, String param2) {
        NoteFragment fragment = new NoteFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        populateView();
        saveNoteData();
    }

    private void initView(View view) {
        label = view.findViewById(R.id.note_label);
        description = view.findViewById(R.id.note_description);
        date = view.findViewById(R.id.note_date);
        body = view.findViewById(R.id.note_body);
    }

    private void populateView() {
        label.setText(noteData.getNoteLabel());
        description.setText(noteData.getNoteDescription());
        date.setText(noteData.getNoteDate());
        body.setText(noteData.getNoteBody());
    }

    private void saveNoteData() {
        noteData = new StructureData(label.getText().toString(),
                description.getText().toString(),
                date.getText().toString(),
                body.getText().toString());
    }

}