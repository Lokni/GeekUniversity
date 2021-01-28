package ru.dmkalvan.mynotes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * 1. Подумайте о функционале вашего приложения заметок.
 * Какие экраны там могут быть, помимо основного со списком заметок?
 * Как можно использовать меню и всплывающее меню в вашем приложении?
 * Не обязательно сразу пытаться реализовать весь этот функционал,
 * достаточно создать макеты и структуру,
 * а реализацию пока заменить на заглушки или всплывающие уведомления (Toast).
 * Используйте подход Single Activity для отображения экранов.
 * <p>
 * В качестве примера: на главном экране приложения у вас список всех заметок,
 * при нажатии на заметку открывается экран с этой заметкой.
 * В меню главного экрана у вас есть иконка поиска по заметкам и сортировка.
 * В меню «Заметки» у вас есть иконки «Переслать» (или «Поделиться»),
 * «Добавить ссылку или фотографию к заметке»​.
 * <p>
 * 2. Создайте боковое навигационное меню для своего приложения и добавьте туда хотя бы один экран,
 * например «Настройки» или «О приложении».
 * <p>
 * 3. * Создайте полноценный заголовок для NavigationDrawer’а.
 * К примеру, аватарка пользователя, его имя и какая-то дополнительная информация.
 * <p>
 * (*) Задача для дополнительного обучения.
 *
 * @author Dmitri Kalvan
 * @date 27.01.21
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