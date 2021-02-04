package ru.dmkalvan.mynotes;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

public class NotesListFragment extends Fragment implements Constants {

    private RecyclerView recyclerView;
    private NoteListAdapter adapter;
    private DataSource data;
    private DataHandler myNote;
    private boolean isLandscape;
    private int currentPosition = 0;

    public NotesListFragment() {
        // Required empty public constructor
    }

    public static NotesListFragment newInstance(DataHandler data) {
        NotesListFragment fragment = new NotesListFragment();
        Bundle args = new Bundle();
        args.putParcelable(YOUR_NOTES, data);
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
        View view = inflater.inflate(R.layout.fragment_notes_list, container, false);
        initView(view);
        setHasOptionsMenu(true);
        return view;

    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view_lines);
        data = new DataSourceImpl(getResources()).init();
        initRecyclerView();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new NoteListAdapter(data);
        recyclerView.setAdapter(adapter);

        DividerItemDecoration decorator = new DividerItemDecoration(Objects.requireNonNull(getContext()), LinearLayoutManager.VERTICAL);
        decorator.setDrawable(getResources().getDrawable(R.drawable.separator, null));
        recyclerView.addItemDecoration(decorator);

        if (getArguments() != null) {
            data.saveData(getArguments().getParcelable(YOUR_NOTES));
            adapter.notifyItemInserted(data.size() - 1);
            recyclerView.scrollToPosition(data.size() - 1);
        }

        adapter.setOnItemClickListener((view, position) -> {
            currentPosition = position;
            showNotes(currentPosition);
        });
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main, menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                callAddNote();
                return true;

            case R.id.action_clear:
                data.clearData();
                adapter.notifyDataSetChanged();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(CURRENT_NOTE, currentPosition);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        isLandscape = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;

        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(CURRENT_NOTE, 0);
        }

        if (isLandscape) {
            showLandNotes(currentPosition);
        }

    }


    private void showNotes(int index) {
        if (isLandscape) {
            showLandNotes(index);
        } else {
            showPortNotes(index);
        }
    }

    private void showLandNotes(int index) {
        myNote = data.getData(index);
        NoteFragment detail = NoteFragment.newInstance(myNote);
        FragmentManager fragmentManager =
                requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.note, detail);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void showPortNotes(int index) {
        myNote = data.getData(index);
        NoteFragment detail = NoteFragment.newInstance(myNote);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, detail);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void callAddNote() {
        if (isLandscape) {
            callAddNewNoteLand();
        } else {
            callAddNotePort();
        }
    }

    private void callAddNewNoteLand() {
        AddNoteFragment detail = new AddNoteFragment();
        FragmentManager fragmentManager =
                requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.note, detail);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commitAllowingStateLoss();
    }

    private void callAddNotePort() {
        AddNoteFragment detail = new AddNoteFragment();
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, detail);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commitAllowingStateLoss();
    }

}