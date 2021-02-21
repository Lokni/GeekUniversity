package ru.dmkalvan.inote.observe;

import java.util.ArrayList;
import java.util.List;

import ru.dmkalvan.inote.data.NoteData;

public class Publisher {
    private final List<Observer> observers;

    public Publisher() {
        observers = new ArrayList<>();
    }

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifySingle(NoteData noteData) {
        for (Observer observer : observers) {
            observer.updateNoteData(noteData);
            unsubscribe(observer);
        }
    }
}
