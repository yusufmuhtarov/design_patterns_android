package com.example.designpatterns.patterns.singleton

/** Singleton (одиночка) — это шаблон проектирования, который гарантирует,
 *  что у класса есть только один экземпляр, и предоставляет глобальную точку доступа к этому экземпляру.
 *  В Kotlin реализация Singleton довольно проста благодаря объектам.**/
class User {
    private var userName: String = "default Value"

    fun setNewUserName(newValue: String) {
        userName = newValue
    }

    fun getCurrnetUserName(): String {
        return userName
    }
}

object ObjectUser {
    private var userName: String = "default Value"

    fun setNewUserName(newValue: String) {
        userName = newValue
    }

    fun getCurrentUserName(): String {
        return userName
    }
}


fun main() {
    val objectUser = ObjectUser

    val secondObject = ObjectUser

    val user = User()

    val secondUser = User()

    objectUser.setNewUserName("objectName: Alex")

    println(secondObject.getCurrentUserName())

    user.setNewUserName("newUserName: Abu")

    println(secondUser.getCurrnetUserName())
}