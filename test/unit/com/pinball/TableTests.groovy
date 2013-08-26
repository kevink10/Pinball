package com.pinball

import grails.test.mixin.*

@TestFor(Table)
class TableTests {

	@Test
    void testHasAName() {
		def testGame = new Table(name: "Medieval Madness")
		assertEquals("Medieval Madness", testGame.name)
    }
	
	@Test
	void testNameShouldNotBeBlank() {
		mockForConstraintsTests(Table)
		def testGame = new Table(name: "")
		assertFalse(testGame.validate())		
	}
}
