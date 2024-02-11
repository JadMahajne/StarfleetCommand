package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public abstract class myAbstractWeapon extends myAbstractSpaceShip {
	private List<Weapon> weaponslst;
	
	public myAbstractWeapon(List<Weapon> weapons,String name,int commissionyear,float maximalspeed,Set<? extends CrewMember> CrewMembers) {
		super(name,commissionyear,maximalspeed,CrewMembers);
		this.weaponslst=weapons;
	}
	public List<Weapon> getWeapon() {
		return this.weaponslst;
	}
	
	@Override
	public int getFirePower() {
		int sum=10;
		for(Weapon weapon:this.weaponslst) {
			sum+=weapon.getFirePower();
		}
		return sum;
	}
}
