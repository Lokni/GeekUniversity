package ru.dmkalvan.inote.data;

import android.content.res.Resources;
import android.icu.util.Calendar;

import java.util.ArrayList;
import java.util.List;

import ru.dmkalvan.inote.R;

public class NoteSourceImpl implements NoteSource {
    private final List<NoteData> dataSource;
    private final Resources resources;

    public NoteSourceImpl(Resources resources) {
        dataSource = new ArrayList<>(7);
        this.resources = resources;
    }

    @Override
    public NoteSource init(NoteSourceResponse noteSourceResponse) {
        String[] titles = resources.getStringArray(R.array.titles);
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        String[] bodies = resources.getStringArray(R.array.body);

        for (int i = 0; i < titles.length; i++) {
            dataSource.add(new NoteData(titles[i], descriptions[i], Calendar.getInstance().getTime(), bodies[i]));
        }

        if (noteSourceResponse != null) {
            noteSourceResponse.initialized(this);
        }

        return this;
    }

    @Override
    public NoteData getNoteData(int position) {
        return dataSource.get(position);
    }

    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public void deleteNoteData(int position) {
        dataSource.remove(position);
    }

    @Override
    public void updateNoteData(int position, NoteData noteData) {
        dataSource.set(position, noteData);
    }

    @Override
    public void addNoteData(NoteData noteData) {
        dataSource.add(noteData);
    }

    @Override
    public void clearNoteData() {
        dataSource.clear();
    }
}
