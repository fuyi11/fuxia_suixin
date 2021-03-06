package com.susion.fuxiaboring.music.service;

/**
 * Created by susion on 17/2/13.
 */
public class MusicServiceInstruction {
    //service
    //music play control
    public static final String SERVER_RECEIVER_PLAY_MUSIC = "SERVER_RECEIVER_PLAY_MUSIC";
    public static final String SERVER_RECEIVER_PAUSE_MUSIC = "SERVER_RECEIVER_PAUSE_MUSIC";
    public static final String SERVER_RECEIVER_SEEK_TO = "SERVER_RECEIVER_SEEK_TO";
    public static final String SERVER_RECEIVER_PLAY_NEXT = "SERVER_RECEIVER_PLAY_NEXT";
    public static final String SERVER_RECEIVER_PLAY_PRE = "SERVER_RECEIVER_PLAY_PRE";
    public static final String SERVER_RECEIVER_SONG_TO_NEXT_PLAY = "SERVER_RECEIVER_SONG_TO_NEXT_PLAY";
    public static final String SERVER_RECEIVER_LOAD_MUSIC_INFO = "LOAD_MUSIC_INFO";
    public static final String SERVER_RECEIVER_CHANGE_MUSIC = "SERVER_RECEIVER_CHANGE_MUSIC";
    public static final String SERVER_RECEIVER_QUERY_IS_PLAYING = "SERVER_RECEIVER_QUERY_IS_PLAYING";
    public static final String SERVER_RECEIVER_CURRENT_PLAY_MUSIC = "SERVER_RECEIVER_CURRENT_PLAY_MUSIC";
    public static final String SERVER_RECEIVER_SAVE_LAST_PLAY_MUSIC = "SERVER_RECEIVER_SAVE_LAST_PLAY_MUSIC";
    public static final String SERVER_RECEIVER_UPDATE_PLAY_MUSIC_INFO = "SERVER_RECEIVER_UPDATE_PLAY_MUSIC_INFO";
    public static final String SERVER_RECEIVER_GET_PLAY_PROGRESS = "SERVER_RECEIVER_GET_PLAY_PROGRESS";

    public static final String SERVER_PARAM_UPDATE_SONG = "SERVER_PARAM_UPDATE_SONG";
    public static final String SERVER_PARAM_PLAY_SONG_AUTO_PLAY = "SERVER_PARAM_PLAY_SONG_AUTO_PLAY";
    public static final String SERVER_PARAM_CHANGE_MUSIC = "SERVER_PARAM_CHANGE_MUSIC";
    public static final String SERVER_PARAM_PLAY_SONG = "SERVER_PARAM_PLAY_SONG";
    public static final String SERVER_PARAM_SEEK_TO_POS = "SERVER_PARAM_SEEK_TO_POS";

    //music play queue
    public static final String SERVER_RECEIVER_QUERY_CURRENT_STATE = "SERVER_RECEIVER_QUERY_CURRENT_STATE";
    public static final String SERVER_RECEIVER_PLAY_MODE_RANDOM = "SERVER_RECEIVER_PLAY_MODE_RANDOM";
    public static final String SERVER_RECEIVER_PLAY_MODE_CIRCLE = "SERVER_RECEIVER_PLAY_MODE_CIRCLE";
    public static final String SERVER_RECEIVER_GET_PLAY_QUEUE = "SERVER_RECEIVER_GET_PLAY_QUEUE";
    public static final String SERVER_RECEIVER_RANDOM_PLAY_PLAY_LIST = "SERVER_RECEIVER_RANDOM_PLAY_PLAY_LIST";
    public static final String SERVER_RECEIVER_REMOVE_SONG_FROM_QUEUE = "SERVER_RECEIVER_REMOVE_SONG_FROM_QUEUE";
    public static final String SERVER_RECEIVER_SONG_QUERY_CUR_MODE = "SERVER_RECEIVER_SONG_QUERY_CUR_MODE";
    public static final String SERVER_RECEIVER_CIRCLE_PLAY_PLAY_LIST = "SERVER_RECEIVER_CIRCLE_PLAY_PLAY_LIST";
    public static final String SERVER_RECEIVER_PLAY_MODE_QUEUE = "SERVER_RECEIVER_PLAY_MODE_QUEUE";
    public static final String SERVER_RECEIVER_ADD_MUSIC_TO_QUEUE = "SERVER_RECEIVER_ADD_MUSIC_TO_QUEUE";

    public static final String SERVER_PARAM_SONG_TO_NEXT_PLAY = "SERVER_PARAM_SONG_TO_NEXT_PLAY";
    public static final String SERVER_PARAM_PLAY_LIST = "SERVER_PARAM_PLAY_LIST";
    public static final String SERVER_PARAM_REMOVE_SONG = "SERVER_PARAM_REMOVE_SONG";
    public static final String SERVER_PARAM_QUEUE_ADD_SONG = "SERVER_PARAM_QUEUE_ADD_SONG";


    //client
    //music play control
    public static final String CLIENT_RECEIVER_SET_DURATION = "CLIENT_RECEIVER_SET_DURATION";
    public static final String CLIENT_RECEIVER_PLAYER_PREPARED = "CLIENT_RECEIVER_PLAYER_PREPARED";
    public static final String CLIENT_RECEIVER_UPDATE_BUFFERED_PROGRESS = "CLIENT_RECEIVER_UPDATA_BUFFERED_PROGRESS";
    public static final String CLIENT_RECEIVER_CURRENT_PLAY_MUSIC = "CLIENT_RECEIVER_CURRENT_PLAY_MUSIC";
    public static final String CLIENT_RECEIVER_CURRENT_IS_PALING = "CLIENT_RECEIVER_CURRENT_IS_PALING";
    public static final String CLIENT_RECEIVER_UPDATE_PLAY_PROGRESS = "CLIENT_RECEIVER_UPDATE_PLAY_PROGRESS";
    public static final String CLIENT_RECEIVER_CURRENT_PLAY_PROGRESS = "CLIENT_RECEIVER_CURRENT_PLAY_PROGRESS";
    public static final String CLIENT_RECEIVER_CAN_CHANGE_MUSIC = "CLIENT_RECEIVER_CAN_CHANGE_MUSIC";

    public static final String CLIENT_PARAM_BUFFERED_PROGRESS = "CLIENT_PARAM_BUFFERED_PROGRESS";
    public static final String CLIENT_PARAM_PLAY_PROGRESS_CUR_POS = "CLIENT_PARAM_PLAY_PROGRESS_CUR_POS";
    public static final String CLIENT_PARAM_PLAY_PROGRESS_DURATION = "CLIENT_PARAM_PLAY_PROGRESS__DURATION";
    public static final String CLIENT_PARAM_PREPARED_TOTAL_DURATION = "CLIENT_PARAM_PREPARED_TOTAL_DURATION";
    public static final String CLIENT_PARAM_CURRENT_PLAY_MUSIC = "CLIENT_PARAM_CURRENT_PLAY_MUSIC";
    public static final String CLIENT_PARAM_MEDIA_DURATION = "CLIENT_PARAM_MEDIA_DURATION";
    public static final String CLIENT_PARAM_CURRENT_PLAY_PROGRESS = "CLIENT_PARAM_CURRENT_PLAY_PROGRESS";
    public static final String CLIENT_PARAM_REFRESH_SONG = "CLIENT_PARAM_REFRESH_SONG";


    //music queue
    public static final String CLIENT_RECEIVER_PLAY_QUEUE = "CLIENT_RECEIVER_PLAY_QUEUE";
    public static final String CLIENT_RECEIVER_QUEUE_NO_MORE_MUSIC = "CLIENT_RECEIVER_QUEUE_NO_MORE_MUSIC";
    public static final String CLIENT_RECEIVER_REFRESH_MODE = "CLIENT_RECEIVER_REFRESH_MODE";
    public static final String CLIENT_PARAM_PLAY_MODE = "CLIENT_PARAM_PLAY_MODE";
    public static final String CLIENT_PARAM_PLAY_QUEUE = "CLIENT_PARAM_PLAY_QUEUE";


    public static final String CLIENT_PARAM_PLAY_PROGRESS_MAX_DURATION = "CLIENT_PARAM_PLAY_PROGRESS_MAX_DURATION";
    public static final String CLIENT_PARAM_CURRENT_PLAY_MUSIC_PLAY_STATUS = "CLIENT_PARAM_CURRENT_PLAY_MUSIC_PLAY_STATUS";
}
