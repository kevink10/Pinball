package com.pinball



import grails.test.mixin.*
import org.junit.*


@TestFor(Player)
class PlayerTests {
	def testPlayer
	
	@Before
	void setUp() {
		testPlayer = new Player(name: "Player One", initials: "AAA")
	}

	@Test
    void testPlayerHasName() {
		assertEquals("Player One", testPlayer.name)
    }
	
	@Test
	void testPlayersHasInitials() {
		assertEquals("AAA", testPlayer.initials)
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
