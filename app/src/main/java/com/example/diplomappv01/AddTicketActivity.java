package com.example.diplomappv01;

import android.animation.Animator;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddTicketActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText descriptionEditText;
    private Button createTicket;
    private TicketRepository ticketRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ticket);

        nameEditText = findViewById(R.id.nameEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        createTicket = findViewById(R.id.createTicket);

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
        ticketRepository = new TicketRepository();

        createTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String description = descriptionEditText.getText().toString().trim();

                // Создание объекта TicketData
                Blocks blocks = new Blocks("{\"value\":\"" + name + "\"}", "{\"value\":\"" + description + "\"}");
                TicketData ticketData = new TicketData(blocks);

                // Вызов метода для создания заявки
                Call<TicketResponse> call = ticketRepository.createTicket("500B5B31E4C948049F4BBF4328", ticketData);
                call.enqueue(new Callback<TicketResponse>() {
                    @Override
                    public void onResponse(Call<TicketResponse> call, Response<TicketResponse> response) {
                        //Если успешно
                        if (response.isSuccessful()) {
                            TicketResponse ticketResponse = response.body();
                            if (ticketResponse != null) {
                                // Обработка успешного ответа
                                Toast.makeText(AddTicketActivity.this, "Заявка создана успешно!", Toast.LENGTH_SHORT).show();



                                LottieAnimationView animationView = findViewById(R.id.animationView);
                                animationView.setAnimation(R.raw.successful);
                                animationView.playAnimation();
                                animationView.addAnimatorListener(new Animator.AnimatorListener() {
                                    @Override
                                    public void onAnimationStart(@NonNull Animator animator) {

                                    }

                                    @Override
                                    public void onAnimationEnd(@NonNull Animator animator) {
                                        animationView.setVisibility(View.GONE); // Скрыть анимацию после завершения


                                    }

                                    @Override
                                    public void onAnimationCancel(@NonNull Animator animator) {

                                    }

                                    @Override
                                    public void onAnimationRepeat(@NonNull Animator animator) {

                                    }
                                });



                            }
                        } else {
                            // Обработка ошибки
                            Toast.makeText(AddTicketActivity.this, "Ошибка при создании заявки. Код ошибки: " + response.code(), Toast.LENGTH_SHORT).show();
                            LottieAnimationView animationView = findViewById(R.id.animationView2);
                            animationView.setAnimation(R.raw.failure);
                            animationView.playAnimation();
                            animationView.addAnimatorListener(new Animator.AnimatorListener() {
                                @Override
                                public void onAnimationStart(@NonNull Animator animator) {
                                }
                                @Override
                                public void onAnimationEnd(@NonNull Animator animator) {
                                    animationView.setVisibility(View.GONE); // Скрыть анимацию после завершения


                                }

                                @Override
                                public void onAnimationCancel(@NonNull Animator animator) {

                                }

                                @Override
                                public void onAnimationRepeat(@NonNull Animator animator) {

                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<TicketResponse> call, Throwable t) {
                        // Обработка ошибки
                        Toast.makeText(AddTicketActivity.this, "Ошибка при создании заявки: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        LottieAnimationView animationView = findViewById(R.id.animationView2);
                        animationView.setAnimation(R.raw.failure);
                        animationView.playAnimation();
                        animationView.addAnimatorListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(@NonNull Animator animator) {
                            }
                            @Override
                            public void onAnimationEnd(@NonNull Animator animator) {
                                animationView.setVisibility(View.GONE); // Скрыть анимацию после завершения


                            }

                            @Override
                            public void onAnimationCancel(@NonNull Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(@NonNull Animator animator) {

                            }
                        });
                    }
                });
            }
        });
    }
}