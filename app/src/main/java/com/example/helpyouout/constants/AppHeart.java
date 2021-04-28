package com.example.helpyouout.constants;

public interface AppHeart {

    String APP_BASE_URL = "https://helpyouout.androforces.com/";

    Long HTTP_TIMEOUT = 80L;
    int success = 200;

    Long SPLASH_TIMEOUT = 1500L;


    //API params

    String PARAM_EMAIL = "email";
    String PARAM_PASSWORD = "password";
    String PARAM_NAME = "name";
    String PARAM_GENDER ="gender";
    String PARAM_DOB ="dob";
    String PARAM_VERIFIED = "1";
    String PARAM_ID="userId";
    String PARAM_SCORE="Score";


    //Prefs
    String PREF_LOGGED_IN = "loggedIn";
    String PREF_USER_DATA = "userData";


}
