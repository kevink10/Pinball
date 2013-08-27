package com.pinball

class Tournament {
	String name
	Date startDate, endDate

    static constraints = {
		name blank: false
		startDate nullable: false
		endDate validator: { val, obj ->
			obj.startDate != null &&
			val?.after(obj.startDate)
		}
    }
}
