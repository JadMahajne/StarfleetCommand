package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;
import java.util.Set;

public abstract class myAbstractSpaceShip implements Spaceship {
	private String name;
	private int commissionyear;
	private float maximalspeed;
	private Set<? extends CrewMember> CrewMembers;
	
	public myAbstractSpaceShip(String name,int commissionyear,float maximalspeed,Set<? extends CrewMember> CrewMembers) {
		this.name=name;
		this.commissionyear=commissionyear;
		this.maximalspeed=maximalspeed;
		this.CrewMembers=CrewMembers;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(CrewMembers, commissionyear, maximalspeed, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		myAbstractSpaceShip other = (myAbstractSpaceShip) obj;
		return Objects.equals(CrewMembers, other.CrewMembers) && commissionyear == other.commissionyear
				&& Float.floatToIntBits(maximalspeed) == Float.floatToIntBits(other.maximalspeed)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public int getCommissionYear() {
		return this.commissionyear;
	}
	@Override
	public float getMaximalSpeed() {
		return this.maximalspeed;
	}
	@Override
	public int getFirePower() {
		return 10;
	}
	@Override
	public Set<? extends CrewMember> getCrewMembers(){
		return this.CrewMembers;
	}
	@Override
	public abstract int getAnnualMaintenanceCost();

	

}
