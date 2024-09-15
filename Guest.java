package Hotel;
// this class defended a guest in a hotel

import java.io.Serializable;


@SuppressWarnings("serial")
public class Guest implements Serializable {

	private Person person;
	private int numVisit;

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Guest g)
			return this.person.getId() == (g.person.getId());
		return false;
	}

	public Guest(Person person) {
		setPerson(person);
		numVisit = 0;
	}
	

	public Guest(Person person, int numVisit) {
		this(person);
		setNumVisit(numVisit);
	}

	public void addVisit() {
		numVisit++;
	}

	public void addAFewVisits(int countVisits) {
		numVisit += countVisits;
	}

	@Override
	public String toString() {
		return "Guest: " + person + ",\n numVisit = " + numVisit;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getNumVisit() {
		return numVisit;
	}

	public void setNumVisit(int numVisit) {
		this.numVisit = numVisit;
	}

}
