package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myAbstractWeapon {
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(weapons,name,commissionYear,maximalSpeed,crewMembers);
	}
	
	@Override
	public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("Fighter");
	str.append("\n \tName=").append(this.getName());
	str.append("\n \tCommissionYear=").append(this.getCommissionYear());
	str.append("\n \tMaximalSpeed=").append(this.getMaximalSpeed());
	str.append("\n \tFirePower=").append(this.getFirePower());
	str.append("\n \tCrewMembers=").append(this.getCrewMembers().size());
	str.append("\n \tAnnualMaintenance=").append(this.getAnnualMaintenanceCost());
	str.append("\n \tWeaponArray=").append(this.getWeapon().toString());
	return str.toString();
	}
	
	
	@Override
	public int getAnnualMaintenanceCost() {
		int x =(int) (1000*this.getMaximalSpeed());
		int sum=2500+x ;
		List<Weapon> weapons=this.getWeapon();
		for(Weapon weapon:weapons) {
			sum+=weapon.getAnnualMaintenanceCost();
		}
		return sum;
	}

	
	
}
