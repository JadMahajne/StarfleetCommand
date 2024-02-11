package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter{
	public static final Weapon laser=new Weapon("Laser Cannons",10,100);
	private static List<Weapon> weaponslst=Arrays.asList(laser);
	private static int cnt;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		cnt++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		super(name,commissionYear,maximalSpeed,crewMembers,weaponslst);
		cnt++;
		
	}
	
	@Override
	public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("StealthCruiser");
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
		int x =(int) (1000*this.getMaximalSpeed());
		int sum=2500+x ;
		List<Weapon> weapons=this.getWeapon();
		for(Weapon weapon:weapons) {
			sum+=weapon.getAnnualMaintenanceCost();
		}
		sum+=50*cnt;
		return sum;
	}

	
}
