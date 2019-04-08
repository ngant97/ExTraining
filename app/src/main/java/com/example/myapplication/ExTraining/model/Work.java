package com.example.myapplication.ExTraining.model;

public class Work {

    private int id;
    private String nameWork;
    private float time;

    public Work(int id, String nameWork, float time) {
        this.id = id;
        this.nameWork = nameWork;
        this.time = time;
    }


    public Work(String nameWork, float time) {
        this.nameWork = nameWork;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameWork() {
        return nameWork;
    }

    public void setNameWork(String nameWork) {
        this.nameWork = nameWork;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Work{" +
                "nameWork='" + nameWork + '\'' +
                ", time=" + time +
                '}';
    }
}
