package com.example.designpatterns.patterns.factory


/**
 * Factory:
 *
 * Это порождающий паттерн проектирования, который определяет общий интерфейс для создания объектов
 * в суперклассе, позволяя подклассам изменять тип создаваемых объектов.
 *
 * Задача: Создание UI компонентов
 *
 * Создайте фабрику для создания различных машин (например, Bmw, Mercedes и т.д.)
 * в зависимости от переданных параметров.
 *
 * Условия:
 *
 * - Фабрика должна иметь метод createComponent(type: String):CarModel, где type может быть "Bmw", "Mercedes" и т.д.
 * - Фабрика должна возвращать соответствующий компонент в зависимости от переданного типа.
 *
 * **/

interface CreateCarModelFactory {
    fun createCarModel(type: String): CarModel
}

class createUiComponentsFactoryImpl : CreateCarModelFactory {
    override fun createCarModel(type: String): CarModel {
        return when (type) {
            "BMW" -> BMW()
            "Mercedes" -> Mercedes()
            else -> {
                CarModel.Companion.Default()
            }
        }
    }
}

interface CarModel {
    fun carModelTitle(): String

    companion object {
        class Default : CarModel {
            override fun carModelTitle(): String {
                return "Not found"
            }

        }
    }

}

class BMW : CarModel {
    override fun carModelTitle(): String {
        return "Bmw"
    }
}

class Mercedes : CarModel {
    override fun carModelTitle(): String {
        return "Mercedes"
    }

}