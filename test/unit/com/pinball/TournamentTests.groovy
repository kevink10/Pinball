package com.pinball

import grails.test.mixin.*

@TestFor(Tournament)
class TournamentTests {
	def tourny
	def validName
	Date validStartDate, validEndDate
	
	@Before
	void setup() {
		validName = "Tourny"
		validStartDate = new Date(2013, 9, 25)
		validEndDate = validStartDate.plus(1)
		tourny = new Tournament(name: validName, startDate: validStartDate, endDate: validEndDate)
	}

	@Test
	void testTournamentShouldHaveAName() {
		assertEquals(validName, tourny.name)
	}
	
	@Test
	void testTournamentsNameCannotBeBlank() {
		mockForConstraintsTests(Tournament)
		def testTourny = new Tournament(name: "")
		assertFalse testTourny.validate()
	}
	
	@Test
	void testTournamentShouldHaveStartDate() {
		assertEquals(validStartDate, tourny.startDate)
	}
	
	@Test
	void testTournamentStartDateIsNotNullable() {
		mockForConstraintsTests(Tournament)
		tourny.startDate = null
		assertFalse tourny.validate()
	}
	
	@Test
	void testTournamentShouldHaveEndDate() {
		assertEquals(validEndDate, tourny.endDate)
	}
	
	@Test
	void testTournamentEndDateIsNotNullable() {
		mockForConstraintsTests(Tournament)
		tourny.endDate = null
		assertFalse tourny.validate()
	}
	
	@Test
	void testTournamentEndDateCannotBeBeforeStartDate() {
		mockForConstraintsTests(Tournament)
		tourny.endDate = validStartDate.plus(-1)
		assertFalse tourny.validate()
	}
}
