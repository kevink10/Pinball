package com.pinball

class Score {
	BigInteger score
	Table table
	Player player

    static constraints = {
		score nullable: false, min: BigInteger.ZERO
    }
}
