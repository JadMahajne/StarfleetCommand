package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public abstract class myAbstractCrewMember implements CrewMember {
	private String name;
	private int age;
	private int yearsInService;
	
	public myAbstractCrewMember(int age, int yearsInService, String name) {
		this.name=name;
		this.age=age;
		this.yearsInService=yearsInService;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name, yearsInService);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		myAbstractCrewMember other = (myAbstractCrewMember) obj;
		return age == other.age && Objects.equals(name, other.name) && yearsInService == other.yearsInService;
	}
	@Override
	public int getAge() {
		return this.age;
	}
	@Override
	public int getYearsInService() {
		return this.yearsInService;
	}

}
