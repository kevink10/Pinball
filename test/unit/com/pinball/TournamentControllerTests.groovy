package com.pinball

import grails.test.mixin.*

@TestFor(TournamentController)
class TournamentControllerTests {

    void testTournamentControllerIsScaffolded() {
       def controller = new TournamentController()
	   assertTrue controller.scaffold
    }
}
