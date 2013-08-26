package com.pinball

import grails.test.mixin.*
import org.junit.*


@TestFor(Player)
class PlayerTests {
	def testPlayer
	def validName
	def validInitials
	
	@Before
	void setUp() {
		validName = "Player One"
		validInitials = "AAA"
		testPlayer = new Player(name: validName, initials: validInitials)
	}

	@Test
    void testPlayerHasName() {
		assertEquals(validName, testPlayer.name)
    }
	
	@Test
	void testPlayersHasInitials() {
		assertEquals(validInitials, testPlayer.initials)
	}
	
	@Test
	void testPlayersInitialsCannotBeBlank() {
		mockForConstraintsTests(Player)
		testPlayer.initials = ""
		assertFalse("Player's initials cannot be blank", testPlayer.validate())
	}
	
	@Test
	void testPlayersInitialsCannotBeTwoCharacters() {
		mockForConstraintsTests(Player)
		testPlayer.initials = "BB"
		assertFalse("Player's initials must be three characters long", testPlayer.validate())
	}
	
	@Test
	void testPlayersInitialsCannotBeFourCharacters() {
		mockForConstraintsTests(Player)
		testPlayer.initials = "BBBB"
		assertFalse("Player's initials must be three characters long", testPlayer.validate())
	}
	
	@Test
	void testPlayersInitialsShouldBeThreeCharacters() {
		mockForConstraintsTests(Player)
		assertTrue("Player's initials must be three characters long", testPlayer.validate())
	}
}
