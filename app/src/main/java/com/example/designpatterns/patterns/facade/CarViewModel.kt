package com.example.designpatterns.patterns.facade

import androidx.lifecycle.ViewModel

class CarViewModel(
    private val startCarFacade: StartCarFacade
) : ViewModel() {
    init {
        startCarFacade.startCar()
    }
}
