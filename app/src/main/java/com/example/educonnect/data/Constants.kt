package com.example.educonnect.data

object Constants {
    const val STUDENT = "Student"
    const val TEACHER = "Teacher"
    const val DATABASE_NAME = "edu_database"

    private const val IP = "192.168.156.242"  // Change the ip to your own ip
    private const val BASE_URL = "https://${IP}/"
    const val AUTH_URL = BASE_URL +"AuthAPI.php"
}