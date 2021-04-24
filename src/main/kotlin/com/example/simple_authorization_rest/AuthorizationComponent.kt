package com.example.simple_authorization_rest

import org.springframework.stereotype.Component

@Component
class AuthorizationComponent {
    var correctUsername : String = "user1"
    var correctPassword : String = "1234"
    fun authorizeUser(username: String, password: String) : Boolean
    {
        print((correctUsername == username && correctPassword == password))
        return (correctUsername == username && correctPassword == password)
    }
}