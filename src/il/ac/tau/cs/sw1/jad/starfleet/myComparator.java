package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Comparator;

public class myComparator implements Comparator<Spaceship> {

	@Override
	public int compare(Spaceship o1,Spaceship o2) {
		int x=Integer.compare(o2.getFirePower(),o1.getFirePower());
		if (x!=0) {
			return x;
		}
		int y=Integer.compare(o2.getCommissionYear(), o1.getCommissionYear());
		if(y!=0) {
			return y;
		}
		int z=o2.getName().compareTo(o1.getName());
		return z;
	}
	

}
