package com.pinball

import grails.test.mixin.*

@TestFor(Score)
class ScoreTests {
	def score
	def validTable
	def validScore
	def validPlayer
	
	@Before
	void setup(){
		validTable = new Table(name: "Medieval Madness")
		validPlayer = new Player(name: "Player One", initials: "AAA")
		validScore = 1000
		score = new Score(table: validTable, score: validScore, player: validPlayer)
	}

	@Test
	void testScoreHasScoreField() {
		assert validScore == score.score
	}
	
	@Test
	void testScoreShouldNotBeNull() {
		mockForConstraintsTests(Score)
		score.score = null
		assertFalse score.validate()
	}
	
	@Test
	void testScoreShouldNotBeNegative() {
		mockForConstraintsTests(Score)
		score.score = -1
		assertFalse score.validate()
	}
	
	@Test
	void testScoreShouldHaveTable() {
		assertEquals(validTable, score.table)
	}
	
	@Test
	void testScoresTableShouldNotBeNull() {
		mockForConstraintsTests(Score)
		score.table = null
		assertFalse score.validate()
	}
	
	@Test
	void testScoreShouldHavePlayer() {
		assert validPlayer == score.player
	}
	
	@Test
	void testScoresPlayerShouldNotBeNull() {
		mockForConstraintsTests(Score)
		score.player = null
		assertFalse score.validate()
	}
}
