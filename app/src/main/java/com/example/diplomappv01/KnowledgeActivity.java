package com.example.diplomappv01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KnowledgeActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private KnowledgeAdapter adapter;
    private List<KnowledgeItem> knowledgeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_knowledge);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        knowledgeList = new ArrayList<>();
        adapter = new KnowledgeAdapter(knowledgeList);
        recyclerView.setAdapter(adapter);

        // Получение базы знаний с сервера
        getKnowledgeBase();
    }

    private void getKnowledgeBase() {
        TicketApi knowledgeApi = TicketRepository.getRetrofitInstance().create(TicketApi.class);
        Call<TicketResponse> call = knowledgeApi.getKnowledgeBase("C9716729475046A3AEA32F1FEF");

        call.enqueue(new Callback<TicketResponse>() {
            @Override
            public void onResponse(Call<TicketResponse> call, Response<TicketResponse> response) {
                if (response.isSuccessful()) {
                    TicketResponse knowledgeResponse = response.body();
                    if (knowledgeResponse != null) {
                        List<KnowledgeItem> items = knowledgeResponse.getValue();
                        knowledgeList.addAll(items);
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    // Обработка неуспешного ответа
                    Toast.makeText(KnowledgeActivity.this, "Ошибка при создании заявки. Код ошибки: " + response.code(), Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<TicketResponse> call, Throwable t) {
                // Обработка ошибки
                Toast.makeText(KnowledgeActivity.this, "Ошибка при создании заявки. Код ошибки: ", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
