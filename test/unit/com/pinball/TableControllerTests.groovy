package com.pinball

import grails.test.mixin.*

@TestFor(TableController)
class TableControllerTests {

    void testTableControllerIsScaffolded() {
		def controller = new TableController()
		assertTrue controller.scaffold
    }
}
