package ru.dmkalvan.mynotes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class NoteFragment extends Fragment implements Constants {

    private TextView label, description, date, body;

    private DataHandler noteData;

    public NoteFragment() {
        // Required empty public constructor
    }

    public static NoteFragment newInstance(DataHandler sd) {
        NoteFragment fragment = new NoteFragment();
        Bundle args = new Bundle();
        args.putParcelable(YOUR_NOTES, sd);
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
        View view = inflater.inflate(R.layout.fragment_note, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.new_note_menu, menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                if (label.getText() != null || body.getText() != null) {
                    addDataToList();
                    Toast.makeText(getContext(), "Note saved", Toast.LENGTH_SHORT).show();
                }
                return true;
            case R.id.action_clear:
                clearNote();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView(View view) {
        label = view.findViewById(R.id.note_label);
        description = view.findViewById(R.id.note_description);
        date = view.findViewById(R.id.note_date);
        body = view.findViewById(R.id.note_body);
        populateView();
    }

    private void populateView() {
        if (getArguments() != null) {
            noteData = getArguments().getParcelable(YOUR_NOTES);
            label.setText(noteData.getNoteLabel());
            description.setText(noteData.getNoteDescription());
            date.setText(noteData.getNoteDate());
            body.setText(noteData.getNoteBody());
        }
    }

    private void addDataToList() {
        noteData = new DataHandler(label.getText().toString(),
                description.getText().toString(),
                date.getText().toString(),
                body.getText().toString());
        NotesListFragment fragment = NotesListFragment.newInstance(noteData);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void clearNote() {
        label.setText(R.string.empty_string);
        description.setText(R.string.empty_string);
        date.setText(R.string.empty_string);
        body.setText(R.string.empty_string);
    }


}