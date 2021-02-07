package ru.dmkalvan.mynotes;

public interface DataSource {
    DataHandler getData(int index);
    int size();
    void saveData(DataHandler data);
    void deleteData(int index);
    void editData(int index, DataHandler data);
    void clearData();
}
