package com.pinball

class Player {
	String name
	String initials
	
    static constraints = {
		initials size: 3..3, blank: false
    }
}
