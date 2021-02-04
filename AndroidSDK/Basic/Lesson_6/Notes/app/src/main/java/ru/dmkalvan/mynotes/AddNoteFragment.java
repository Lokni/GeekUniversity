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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class AddNoteFragment extends Fragment implements Constants {
    DataHandler newData;
    private TextView label, description, date, body;

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
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.new_note_menu, menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_save) {
            addDataToList();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView(View view) {
        label = view.findViewById(R.id.edit_label);
        description = view.findViewById(R.id.edit_description);
        date = view.findViewById(R.id.edit_date);
        body = view.findViewById(R.id.edit_body);
    }

    private void addDataToList() {
        newData = new DataHandler(label.getText().toString(),
                description.getText().toString(),
                date.getText().toString(),
                body.getText().toString());
        NotesListFragment fragment = NotesListFragment.newInstance(newData);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commitAllowingStateLoss();
    }

}