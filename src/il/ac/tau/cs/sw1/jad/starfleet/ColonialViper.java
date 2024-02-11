package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter  {

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
	}
	
	@Override
	public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("ColonialViper");
	str.append("\n\tName=").append(this.getName());
	str.append("\n\tCommissionYear=").append(this.getCommissionYear());
	str.append("\n\tMaximalSpeed=").append(this.getMaximalSpeed());
	str.append("\n\tFirePower=").append(this.getFirePower());
	str.append("\n\tCrewMembers=").append(this.getCrewMembers().size());
	str.append("\n\tAnnualMaintenance=").append(this.getAnnualMaintenanceCost());
	str.append("\n\tWeapons=").append(this.getWeapon().toString());
	return str.toString();
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		int sum=4000;
		for (Weapon weapon:this.getWeapon()) {
			sum+=weapon.getAnnualMaintenanceCost();
		}
		sum+=this.getCrewMembers().size()*500;
		int x=(int) (500*this.getMaximalSpeed());
		sum+=x;
		return sum;
	}

}
