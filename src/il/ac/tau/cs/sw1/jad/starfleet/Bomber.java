package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myAbstractWeapon{
	private int numoftechs;
	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(weapons,name,commissionYear,maximalSpeed,crewMembers);
		this.numoftechs=numberOfTechnicians;
	}
	
	@Override
	public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("Bomber");
	str.append("\n\tName=").append(this.getName());
	str.append("\n\tCommissionYear=").append(this.getCommissionYear());
	str.append("\n\tMaximalSpeed=").append(this.getMaximalSpeed());
	str.append("\n\tFirePower=").append(this.getFirePower());
	str.append("\n\tCrewMembers=").append(this.getCrewMembers().size());
	str.append("\n\tAnnualMaintenance=").append(this.getAnnualMaintenanceCost());
	str.append("\n\tWeaponArray=").append(this.getWeapon().toString());
	str.append("\n\tNumberOfTechnicians=").append(this.getNumberOfTechnicians());

	return str.toString();
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		int sum=0;
		List<Weapon> weapons=this.getWeapon();
		for(Weapon weapon:weapons) {
			sum+=weapon.getAnnualMaintenanceCost();
		}
		double y=(10*this.getNumberOfTechnicians());
		double x=((100-y)/100);
		double tmp=x*sum;
		int res=(int)tmp + 5000;
		return res;
	}
	public int getNumberOfTechnicians() {
		return this.numoftechs;
	}


}
