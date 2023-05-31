package com.example.diplomappv01;

import com.google.gson.annotations.SerializedName;

public class Task {
    @SerializedName("id")
    private int id;

    @SerializedName("tasknumber")
    private int taskNumber;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    // Добавьте остальные поля заявки, если необходимо

    // Геттеры и сеттеры
    // ...


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

