package ru.dmkalvan.inote.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.material.button.MaterialButton;

import ru.dmkalvan.inote.MainActivity;
import ru.dmkalvan.inote.Navigation;

public class StartFragment extends Fragment {

    private static final int RC_SIGN_IN = 40404;
    private static final String TAG = "GoogleAuth";

    private Navigation navigation;

    private GoogleSignInClient googleSignInClient;

    private com.google.android.gms.common.SignInButton buttonSignIn;

    private MaterialButton buttonSingOut;
    private TextView emailView;
    private MaterialButton continue_;

    public static StartFragment newInstance() {
        StartFragment fragment = new StartFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        // Get Navigation for application, therefore move to NoteListFragment
        MainActivity activity = (MainActivity)context;
        navigation = activity.getNavigation();
    }
    @Override
    public void onDetach() {
        navigation = null;
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
