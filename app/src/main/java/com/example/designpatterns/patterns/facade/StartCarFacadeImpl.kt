package com.example.designpatterns.patterns.facade

import com.example.designpatterns.patterns.facade.actions.BuckleUp
import com.example.designpatterns.patterns.facade.actions.GetInCar
import com.example.designpatterns.patterns.facade.actions.OpenDoor
import com.example.designpatterns.patterns.facade.actions.StartEngine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class StartCarFacadeImpl(
    private val getInCar: GetInCar,
    private val openDoor: OpenDoor,
    private val buckleUp: BuckleUp,
    private val startEngine: StartEngine
) : StartCarFacade {
    override fun startCar() {
        CoroutineScope(Dispatchers.IO + SupervisorJob()).launch {
            openDoor.openDoor()
            getInCar.getInCar()
            buckleUp.buckleUp()
            startEngine.startEngine()
        }
    }
}