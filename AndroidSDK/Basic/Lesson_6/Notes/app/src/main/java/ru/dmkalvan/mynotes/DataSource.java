package ru.dmkalvan.mynotes;

public interface DataSource {
    DataHandler getData(int position);

    int size();
}
