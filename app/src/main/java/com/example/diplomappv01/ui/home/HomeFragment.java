package com.example.diplomappv01.ui.home;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.diplomappv01.AddTicketActivity;
import com.example.diplomappv01.MainActivity;
import com.example.diplomappv01.R;
import com.example.diplomappv01.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    AppCompatButton createTicket;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        createTicket = (AppCompatButton) getActivity().findViewById(R.id.createTicket);
        // Создание цветового состояния для нажатия
        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{android.R.attr.state_pressed},
                        new int[]{}
                },
                new int[]{
                        Color.BLUE, // Цвет текста для состояния нажатия (синий)
                        Color.WHITE // Цвет текста для обычного состояния (белый)
                }
        );
// Установка цветового состояния для текста кнопки
        createTicket.setTextColor(colorStateList);
        createTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddTicketActivity.class);
                startActivity(intent);
            }
        });

    }

}