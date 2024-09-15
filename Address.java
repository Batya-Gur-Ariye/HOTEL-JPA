package Hotel;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Address implements Serializable {

	private String City;
	private String Street;
	private int numHouse;

	public Address(){
	}

	public Address(String City, String Street, int numHouse) {
		setCity(City);
		setStreet(Street);
		setNumHouse(numHouse);
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public int getNumHouse() {
		return numHouse;
	}

	public void setNumHouse(int numHouse) {
		this.numHouse = numHouse;
	}
}
