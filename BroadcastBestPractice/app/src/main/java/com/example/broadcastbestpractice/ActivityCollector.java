package com.example.broadcastbestpractice;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理所以的活动
 */
public class ActivityCollector {
        public static List<Activity> activities = new ArrayList<>();
        public static void addActivity(Activity activity){
            activities.add(activity);
        }
        public static void removeActivity(Activity activity){
            activities.remove(activity);
        }
        public static void finishALL(){
            for (Activity activity:activities){
                if (!activity.isFinishing()){
                    activity.finish();
                }
            }
            activities.clear();
        }

}
