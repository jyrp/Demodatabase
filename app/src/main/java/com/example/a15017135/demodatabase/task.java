package com.example.a15017135.demodatabase;


public class task {
    private int id;
    private String description;
    private String date;

    public task(int id, String description, String date) {
        this.id = id;
        this.description = description;
        this.date = date;
    }
        public int getId() {
            return id;
        }

        public String getDescription() {
            return description;
        }

        public String getDate() {
            return date;
        }

    }

