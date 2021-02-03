package ru.dmkalvan.mynotes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AddNoteFragment extends Fragment implements Constants{
    private TextView label, description, date, body;
    private DataSource data;

    public AddNoteFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_note, container, false);
        initView(view);
        if (body.getText() != null && label.getText() != null){
            collectData();
        }
        return view;
    }

    private void initView(View view) {
        label = view.findViewById(R.id.note_label);
        description = view.findViewById(R.id.note_description);
        date = view.findViewById(R.id.note_date);
        body = view.findViewById(R.id.note_body);
    }

    private void collectData(){
        data.saveData(new DataHandler(label.getText().toString(),
                description.getText().toString(),
                date.getText().toString(),
                body.getText().toString()));
    }
}