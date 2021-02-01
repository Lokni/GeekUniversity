package ru.dmkalvan.mynotes;

import android.content.res.Resources;

import java.util.ArrayList;
import java.util.List;

public class DataSourceImpl implements DataSource {
    private final List<DataHandler> dataSource;
    private final Resources resources;

    public DataSourceImpl(Resources resources) {
        dataSource = new ArrayList<>(3);
        this.resources = resources;
    }

    public DataSourceImpl init() {
        String[] titles = resources.getStringArray(R.array.titles);
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        String[] dates = resources.getStringArray(R.array.dates);
        String[] bodies = resources.getStringArray(R.array.bodies);

        for (int i = 0; i < titles.length; i++) {
            dataSource.add(new DataHandler(titles[i], descriptions[i], dates[i], bodies[i]));
        }
        return this;
    }

    public DataHandler getData(int position) {
        return dataSource.get(position);
    }

    @Override
    public int size() {
        return dataSource.size();
    }
}
