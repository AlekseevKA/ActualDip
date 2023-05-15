package com.example.diplomappv01;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TicketApi {
    @POST("/changes/tasks")
    Call<TicketResponse> createTicket(
            @Query("ApiKey") String apiKey,
            @Body TicketData ticketData
    );
}

