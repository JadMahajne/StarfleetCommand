package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		myComparator comp=new myComparator();
		List<Spaceship> lst=new ArrayList<Spaceship>();
		for(Spaceship spaceship: fleet) {
			lst.add(spaceship);
		}
		Collections.sort(lst,comp);
		List<String> res=new ArrayList<String>();
		for (Spaceship spaceship:lst) {
			res.add(spaceship.toString());
		}
		return res;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String, Integer> map=new HashMap<String, Integer>();
		for (Spaceship spaceship:fleet) {
			String name=spaceship.getClass().getSimpleName();
			if (!map.containsKey(name)) {
				map.put(name,1);
			}
			else {
				int val=map.get(name)+1;
				map.replace(name,val);
			}
		}
		return map;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int sum=0;
		for(Spaceship spaceship:fleet) {
			sum+=spaceship.getAnnualMaintenanceCost();
		}
		return sum;

	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> set=new HashSet<String>();
		for(Spaceship spaceship:fleet) {
			if(spaceship.getClass().getSimpleName().equals("TransportShip")) {
				continue;
			}
			for(Weapon weapon:((myAbstractWeapon)spaceship).getWeapon()) {
				set.add(weapon.getName());
			}
		}
		return set;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int sum=0;
		for(Spaceship spaceship : fleet) {
			sum+=spaceship.getCrewMembers().size();
		}
		return sum;

	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		int sum=0;
		int cnt=0;
		for (Spaceship spaceship : fleet) {
			Set<? extends CrewMember> set=spaceship.getCrewMembers();
			for (CrewMember member:set) {
				if(member.getClass().getSimpleName().equals("Officer")) {
					sum+=member.getAge();
					cnt++;
				}
				else {
					continue;
				}
			}
		}
		float avg=((float)(sum))/cnt;
		return avg;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer,Spaceship> map = new HashMap<Officer,Spaceship>();
		for (Spaceship spaceship : fleet) {
			OfficerRank max=null;
			Officer name=null;
			Set<? extends CrewMember> set=spaceship.getCrewMembers();
			for (CrewMember member:set) {
				if(member.getClass().getSimpleName().equals("Officer")) {
					Officer tmp=(Officer)member;
					if (max==null) {
						max=tmp.getRank();
						name=tmp;
					}
					else if (tmp.getRank().compareTo(max)>0) {
						max=tmp.getRank();
						name=tmp;
					}
				}
				else {
					continue;
				}
			}
			if (max!=null) {
				map.put(name,spaceship );
			}
		}
		return map;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank,Integer> map= new HashMap<OfficerRank, Integer>();
		for (Spaceship spaceship:fleet) {
			Set<? extends CrewMember> set=spaceship.getCrewMembers();
			for (CrewMember member:set) {
				if(member.getClass().getSimpleName().equals("Officer")) {
					OfficerRank tmprk=((Officer)member).getRank();
					if (!map.containsKey(tmprk)) {
						map.put(tmprk, 1);
					}
					else {
						Integer val=map.get(tmprk) +1;
						map.replace(tmprk, val);
					}
				}
				else {
					continue;
				}
		    }
	    }
		List<Map.Entry<OfficerRank, Integer>> lst=new ArrayList<Map.Entry<OfficerRank, Integer>>(map.entrySet());
		myMapEntryORComparator comp=new myMapEntryORComparator();
		Collections.sort(lst, comp);
		return lst;
	}
		

}
