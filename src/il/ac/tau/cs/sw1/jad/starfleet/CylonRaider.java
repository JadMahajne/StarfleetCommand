package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter {

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);

	}
	@Override
	public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("CylonRaider");
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
		int sum=3500;
		for (Weapon weapon:this.getWeapon()) {
			sum+=weapon.getAnnualMaintenanceCost();
		}
		sum+=this.getCrewMembers().size()*500;
		int x=(int) (1200*this.getMaximalSpeed());
		sum+=x;
		return sum;
	}


	

}
