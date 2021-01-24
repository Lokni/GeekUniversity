package ru.dmkalvan.mynotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

public class NoteFragment extends Fragment implements Constants {

    EditText label, description, date, body;

    private StructureData noteData;

    public NoteFragment() {
        // Required empty public constructor
    }

    public static NoteFragment newInstance(StructureData sd) {
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

    private void initView(View view) {
        label = view.findViewById(R.id.note_label);
        description = view.findViewById(R.id.note_description);
        date = view.findViewById(R.id.note_date);
        body = view.findViewById(R.id.note_body);
    }


}