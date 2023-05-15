package com.example.diplomappv01.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.diplomappv01.R;
import com.example.diplomappv01.databinding.FragmentSettingsBinding;

public class SettingsFragment extends Fragment {
 AppCompatButton darkThemeBtn;
    private FragmentSettingsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        darkThemeBtn = (AppCompatButton) getActivity().findViewById(R.id.darkThemeBtn);




























        SettingsViewModel settingsViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

    //    final TextView textView = binding.textNotifications;
    //    settingsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;



    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.darkThemeBtn:
                if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
                    // Если текущая тема темная, то устанавливаем светлую тему
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    // Иначе, если текущая тема светлая, то устанавливаем темную тему
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                getActivity().recreate(); // Пересоздаем активити, чтобы изменения темы применились
                break;
            default:
                break;
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}