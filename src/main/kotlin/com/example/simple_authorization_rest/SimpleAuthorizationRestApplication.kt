package com.example.simple_authorization_rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class SimpleAuthorizationRestApplication

fun main(args: Array<String>) {
	runApplication<SimpleAuthorizationRestApplication>(*args)
}


@RestController
class MessageResource {

	@Autowired
	lateinit var authComp : AuthorizationComponent

	@RequestMapping("/")
	fun index() = "Zaloguj się przez /login jako parametry przesyłając 'username' oraz 'password' "

	@RequestMapping("/login")
	fun search(@RequestParam(required = false) username: String, @RequestParam(required = false) password : String) : String {
		var incorrectLogin : String = "Błędna nazwa użytkownika lub hasło, poprawne dane to username=" + authComp.correctUsername + " password=" + authComp.correctPassword
		var isAuth : Boolean =  authComp.authorizeUser(username, password)
		return if (isAuth) "Poprawne dane logowania" else incorrectLogin
	}

}