package com.example.helpyouout.utli;

import android.app.Activity;
import android.content.SharedPreferences;
import android.provider.CalendarContract;

import java.util.Calendar;

public class breatheSharedPref {
    private SharedPreferences breathePref;

    public breatheSharedPref(Activity breatheActivity) {
        this.breathePref = breatheActivity.getPreferences(Activity.MODE_PRIVATE);

        //Utsav

    }
    public void setDate(long milisSeconds) {
        breathePref.edit().putLong("seconds", milisSeconds).apply();
    }

    public String getDate(){
        long miliDates = breathePref.getLong("seconds",0);
        String amOrpm;

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(miliDates);
        int a = calendar.get(Calendar.AM_PM);
        if (a==Calendar.AM)
            amOrpm = "AM";
          else
              amOrpm = "PM";

        String Time = "Last " +  calendar.get(Calendar.HOUR_OF_DAY) + ":" +calendar.get(Calendar.MINUTE) + "" + amOrpm;
        return Time;

    }
    public void setBreathe(int breathe){
        breathePref.edit().putInt("breathe",breathe).apply();
    }
    public int getBreathe(){
        return breathePref.getInt("breathe",0);
    }

    public void setSessions(int sessions){
        breathePref.edit().putInt("sessions",sessions).apply();
    }
    public int getSessions(){
        return breathePref.getInt("sessions",0);
    }


}
