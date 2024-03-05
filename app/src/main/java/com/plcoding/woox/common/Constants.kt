package com.plcoding.woox.common

object Constants {

    const val BASE_URL = "http://boox.boomboomlearningtoons.com/boox/learning/apis/apis/api.php/records/"

    const val PARAM_COIN_ID = "coinId"


    const val USER_AUTHENTICATE = "school_users?filter=user_id,eq,adecstudent1"
    const val GET_GAMES = BASE_URL+"school_student_games?filter=student_id,eq,"
    const val GAME_DETAIL =  BASE_URL+"games?filter=game_id,eq,"
    const val IMAGE_URL =  "http://boox.boomboomlearningtoons.com/all_data/thumbnails/"
    const val GAME_URL =  "http://boox.boomboomlearningtoons.com/all_data/"
    const val GAME_SUBJECTS =  BASE_URL+"subjects"
    const val GAME_CATEGORY =  BASE_URL+"categories"
    const val GAME_GRAPH =  BASE_URL+"student_game_attempt?"
    const val LEADER_BOARD =  "https://boomboomlearningtoons.com/boox/c3games/apis/leaderboard.php"
}