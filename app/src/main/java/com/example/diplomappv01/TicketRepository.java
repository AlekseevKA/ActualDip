package com.example.diplomappv01;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://apigw.intradesk.ru/";
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    private Retrofit createRetrofit() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        return new Retrofit.Builder()
                .baseUrl("https://apigw.intradesk.ru") // Базовый URL вашего API
                .client(client)
                .addConverterFactory(GsonConverterFactory.create()) // Конвертер для преобразования JSON в объекты Java
                .build();
    }

   // public Call<TicketResponse> getTasks(String apiKey) {
    //   return TicketApi.getTasks(apiKey);
   // }
}



