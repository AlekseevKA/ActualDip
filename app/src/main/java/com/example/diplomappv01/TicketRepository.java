package com.example.diplomappv01;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TicketRepository {
    private final TicketApi ticketApi;

    public TicketRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apigw.intradesk.ru") // Базовый URL вашего API
                .addConverterFactory(GsonConverterFactory.create()) // Конвертер для преобразования JSON в объекты Java
                .build();

        ticketApi = retrofit.create(TicketApi.class);
    }

    public Call<TicketResponse> createTicket(String apiKey, TicketData ticketData) {
        return ticketApi.createTicket(apiKey, ticketData);
    }
}

