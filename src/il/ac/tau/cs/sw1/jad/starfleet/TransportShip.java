package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends myAbstractSpaceShip{
	private int annualmaintenance;
	private int cargoCapacity;
	private int passengerCapacity;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name,commissionYear,maximalSpeed,crewMembers);
		this.annualmaintenance=3000+5*cargoCapacity+3*passengerCapacity;
		this.cargoCapacity=cargoCapacity;
		this.passengerCapacity=passengerCapacity;
	}
	@Override
	public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("TransportShip");
	str.append("\n\tName=").append(this.getName());
	str.append("\n\tCommissionYear=").append(this.getCommissionYear());
	str.append("\n\tMaximalSpeed=").append(this.getMaximalSpeed());
	str.append("\n\tFirePower=").append(this.getFirePower());
	str.append("\n\tCrewMembers=").append(this.getCrewMembers().size());
	str.append("\n\tAnnualMaintenance=").append(this.getAnnualMaintenanceCost());
	str.append("\n\tCargoCapacity=").append(this.getCargoCapacity());
	str.append("\n\tPassengerCapacity=").append(this.getPassengerCapacity());
	return str.toString();
	}

	@Override
	public int getAnnualMaintenanceCost() {
		return this.annualmaintenance;
	}
	
	public int getCargoCapacity() {
		return this.cargoCapacity;
	}
	
	public int getPassengerCapacity() {
		return this.passengerCapacity;
	}

}
