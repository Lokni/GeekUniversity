package ru.dmkalvan.mynotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.HashMap;

public class NotesListFragment extends Fragment implements Constants {

    private HashMap<Integer, StructureData> notesBank = new HashMap<>();


    public NotesListFragment() {
        // Required empty public constructor
    }

    public static NotesListFragment newInstance() {
        NotesListFragment fragment = new NotesListFragment();
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
        return inflater.inflate(R.layout.fragment_notes_list, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dataCollector(0, new StructureData("Shopping List",
                "Need to buy today", "24.01.21",
                "1. Potato\n2. Onion\n3. Bread"));
        dataCollector(1, new StructureData("To do",
                "On this weekend", "21.01.21",
                "Lorem12"));
        dataCollector(2, new StructureData("Wedding Anniversary",
                "Next month", "15.01.21",
                "Booking table in restaurant, get smoking from dry cleaning, order flowers. "));
        initNotesList(view);
    }

    //    Create notes list on the screen.
    private void initNotesList(View view) {
        LinearLayout linearView = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.notes_example);

        for (int i = 0; i < notes.length; i++) {
            String note = notes[i];
            TextView textView = new TextView(getContext());
            textView.setText(note);
            textView.setTextSize(30f);
            linearView.addView(textView);
            final int fi = i;
            textView.setOnClickListener(v -> showNotes(fi));
        }
    }

    private void showNotes(int index) {
        Intent intent = new Intent(getActivity(), NoteActivity.class);
        intent.putExtra(YOUR_NOTES, dataPicker(index));
        startActivity(intent);
    }

    private void dataCollector(int index, StructureData sd){
        notesBank.put(index, sd);
    }

    private StructureData dataPicker(int index){
        return  notesBank.get(index);
    }
}