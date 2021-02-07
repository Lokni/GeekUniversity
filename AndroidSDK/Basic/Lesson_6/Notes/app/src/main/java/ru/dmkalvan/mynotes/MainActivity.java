package ru.dmkalvan.mynotes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * 1. Сделайте фрагмент добавления и редактирования данных, если вы ещё не сделали его.
 * <p>
 * 2. Сделайте навигацию между фрагментами, также организуйте обмен данными между
 * фрагментами.
 * <p>
 * 3. Создайте контекстное меню для изменения и удаления заметок.
 * <p>
 * 4. * Изучите, каким образом можно вызывать DatePicker в виде диалогового окна. Создайте
 * текстовое поле, при нажатии на которое вызывалось бы диалоговое окно с DatePicker.
 *
 * @author Dmitri Kalvan
 * @date 03.02.21
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
        // Check for orientation with already use Note.
        if (getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE && fragment instanceof NoteFragment) {
            fragmentManager.popBackStack();
        } else {
            // Add fragment.
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            // Close transaction.
            fragmentTransaction.commitAllowingStateLoss();
        }


    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}