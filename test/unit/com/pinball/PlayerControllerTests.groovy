package com.pinball

import grails.test.mixin.*
import org.junit.*

@TestFor(PlayerController)
class PlayerControllerTests {

	@Test
    void testPlayerControllerIsScaffolded() {
    	PlayerController controller = new PlayerController()
		assertTrue controller.scaffold
    }
}
