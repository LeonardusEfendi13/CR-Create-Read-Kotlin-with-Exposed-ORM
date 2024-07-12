package com.assignment.demo.Configuration

import org.jetbrains.exposed.sql.Database
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

//Konfigurasi Database untuk exposed ORM
@Configuration
class DatabaseConfiguration {

    @Value("\${spring.datasource.url}")
    private lateinit var url: String

    @Value("\${spring.datasource.username}")
    private lateinit var username: String

    @Value("\${spring.datasource.password}")
    private lateinit var password: String

    @Bean
    fun database(): Database {
        return Database.connect(url, driver = "org.postgresql.Driver", user = username, password = password)
    }
}