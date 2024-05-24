package com.example.designpatterns.patterns.singleton

import kotlinx.coroutines.flow.MutableStateFlow

/**Задача:
 *
 * Создайте класс для управления аутентификацией пользователя.
 * Используйте паттерн Singleton, чтобы гарантировать единственный экземпляр класса аутентификации.
 *
 * Условия:
 *
 * - Класс должен предоставлять методы для входа и выхода пользователя.
 * - Класс должен хранить информацию о текущем аутентифицированном пользователе.
 * - Класс должен поддерживать проверку токена для определения, авторизован ли пользователь.
 * **/

object UserAuthentication {

    private val userIds: MutableList<String> = mutableListOf()
    private val usersTokens: MutableStateFlow<List<String>> = MutableStateFlow(emptyList())

    private var firstName: String = String()
    private var lastName: String = String()
    private var password: String = String()
    fun login(
        userFirstName: String,
        userLastName: String,
        userPassword: String,
        userToken: String,
    ) {
        firstName = userFirstName
        lastName = userLastName
        password = userPassword

        userIds.add(userToken)
        usersTokens.tryEmit(userIds)
    }

    fun logout(
        token: String
    ) {
        firstName = String()
        lastName = String()
        password = String()

        val currentToken = userIds.find { it == token }
        userIds.remove(currentToken)
        usersTokens.tryEmit(emptyList())
    }

    fun isUserSigned(token: String): Boolean {
        return usersTokens.value.contains(token)
    }
}


fun main() {
    val userAuth = UserAuthentication

    userAuth.login(
        userFirstName = "Yusuf",
        userLastName = "Muhtarov",
        userPassword = "12345678",
        userToken = "lndcjknksnkjdnjk.sod-1sd"
    )

    val isUserAuthenticate = userAuth.isUserSigned("lndcjknksnkjdnjk.sod-1sd")

    val userAuthToken = if (isUserAuthenticate) "User is signed"
    else "User is not fonund"


    println(userAuthToken)
}