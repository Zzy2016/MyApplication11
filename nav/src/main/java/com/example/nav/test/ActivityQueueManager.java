package com.example.nav.test;

import android.app.Activity;

import java.util.Iterator;
import java.util.LinkedList;

public class ActivityQueueManager {
    private static final ActivityQueueManager instance = new ActivityQueueManager();
    private final static String TAG = ActivityQueueManager.class.getSimpleName();
    private static LinkedList<Activity> mQueue;


    public ActivityQueueManager() {
        ActivityQueueManager.mQueue = new LinkedList<>();
    }


    public LinkedList<Activity> getAll() {
        return mQueue;
    }

    public void pushActivity(Activity activity) {
        instance.doPushActivity(activity);
    }

    public void popActivity(Activity activity) {
        instance.doPopActivity(activity);
    }


    //获取最上层activity
    public Activity pop() {
        if (mQueue != null && mQueue.size() > 0) {
            return mQueue.peek();
        } else {
            return null;
        }
    }

    //获取某一个activity
    public Activity popIndex(int index) {
        if (mQueue != null && mQueue.size() > index) {
            return mQueue.get(index);
        } else {
            return null;
        }
    }

    public void finishAllActivity() {
        doFinishAll();
    }

    public void doPushActivity(Activity activity) {
        mQueue.add(activity);
    }

    public void doPopActivity(Activity activity) {
        if (ActivityQueueManager.mQueue.contains(activity)) {
            ActivityQueueManager.mQueue.remove(activity);
        }
    }

    public void doPopActivityByIndex(int index) {
        if (index < 0 || index > mQueue.size() - 1) {
            return;
        }
        Activity activity = mQueue.get(index);
        if (activity != null) {
            activity.finish();
            mQueue.remove(activity);
        }
    }

    public void doFinishAll() {
        Iterator<Activity> it = mQueue.iterator();
        while (it.hasNext()) {
            Activity activity = it.next();
            it.remove();
            activity.finish();
        }
    }

    public static ActivityQueueManager getInstance() {
        return instance;
    }

    public LinkedList<Activity> getActivityLinkQueue() {
        return mQueue;
    }

    public int getSize() {
        return mQueue.size();
    }

    public void closeNumberActivites(int closeNumberActivites) {
        if (closeNumberActivites < 0) {
            return;
        }
        LinkedList<Activity> mActivites = mQueue;
        if (mActivites != null && mActivites.size() <= 1) {
            return;
        }
        try {
            int countTemp = 0;
            for (int i = mActivites.size() - 1; i >= 0; i--) {
                Activity mActicity = mActivites.get(i);
                if (mActicity != null) {
                    mActicity.finish();
                    mActivites.remove(mActicity);
                } else {
                    if (mActivites.size() > 1) {
                        mActicity.finish();
                        mActivites.remove(mActicity);
                        countTemp++;
                    } else {
                        i = -1;
                    }
                }

                if (countTemp == closeNumberActivites) {
                    i = -1;
                }

            }
        } catch (Exception e) {

        }
    }

}
