package com.example.diplomappv01;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TicketResponse {
    private String ticketId;
    private String ticketName;
    private String ticketDescription;
    @SerializedName("@odata.count")
    private int count;
    private List<KnowledgeItem> value;

    @SerializedName("@odata.count")
    private int countTask;

    @SerializedName("value")
    private List<Task> tasks;


    public String getTicketId() {
        return ticketId;
    }

    public String getTicketName() {
        return ticketName;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }


    //KnowledgeBase
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<KnowledgeItem> getValue() {
        return value;
    }

    public void setValue(List<KnowledgeItem> value) {
        this.value = value;
    }

    //Get List Task

  public int getCountTask() {
       return countTask;
   }

   public void setCountTask(int countTask) {
       this.countTask = countTask;
   }

   public List<Task> getTasks() {
       return tasks;
   }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}

