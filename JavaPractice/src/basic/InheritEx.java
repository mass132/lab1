package basic;

import oopconcept.NewModel;
import oopconcept.RangeRover;

public class InheritEx {
	public static void main(String[] args) {
		NewModel myCar = new NewModel();
		myCar.horn();
		myCar.move();
		myCar.automatic();
		myCar.nitro();
		RangeRover myRR = new RangeRover();
		myRR.run();
		myRR.horn();
		myRR.move();
		
	}

}
