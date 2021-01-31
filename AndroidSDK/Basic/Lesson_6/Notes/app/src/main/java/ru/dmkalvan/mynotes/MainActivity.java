package ru.dmkalvan.mynotes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * 1. Создайте список ваших заметок.
 * <p>
 * 2. Создайте карточку для элемента списка.
 * <p>
 * 3. Класс данных, созданный на шестом уроке, используйте для заполнения карточки списка.
 * <p>
 * 4. * Создайте фрагмент для редактирования данных в конкретной карточке.
 * Этот фрагмент пока можно вызвать через основное меню.
 *
 * @author Dmitri Kalvan
 * @date 31.01.21
 */


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        addFragment(new NotesListFragment());
    }

    private void addFragment(Fragment fragment) {
        // Get fragment manager.
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Open transaction.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Add fragment.
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        // Add transaction in back-stack
        fragmentTransaction.addToBackStack(null);
        // Close transaction.
        fragmentTransaction.commitAllowingStateLoss();

    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}