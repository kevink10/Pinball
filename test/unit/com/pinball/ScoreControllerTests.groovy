package com.pinball

import grails.test.mixin.*

@TestFor(ScoreController)
class ScoreControllerTests {

    void testScoreControllerIsScaffolded() {
		def controller = new ScoreController()
		assertTrue controller.scaffold
    }
}
