package com.example.myapplication;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityListTest {
    private List<Activity> activities = new ArrayList<>();


    private static ActivityListTest instance;

    public static ActivityListTest getInstance() {
        if (instance == null) {
            instance = new ActivityListTest();
        }
        return instance;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public void removeActivities(Activity activity) {
        activity.finish();
        activities.remove(activity);
    }

}
