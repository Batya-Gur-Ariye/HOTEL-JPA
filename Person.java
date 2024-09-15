package Hotel;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Person implements Serializable {
	private int id;
	private String firstName;
	private String lastName;
	private String numberPhone = null;
	private String eMail = null;
	public int age =  0;

	public Person(int id, String firstName, String lastName, int age) {
		setFirstName(firstName);
		setLastName(lastName);
		setId(id);
		this.age = age;
	}

	public Person(int id, String firstName, String lastName, int age, String numberPhone, String eMail) {
		this(id, firstName, lastName, age);
		setNumberPhone(numberPhone);
		seteMail(eMail);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Person p )
			return this.getId() == p.getId();
		return false;
	}

	/**
	 * the func return string
	 * because the email and phone is not must i ask before to add it to a details
	 */
	@Override
	public String toString() {
		String str = "Person: id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ",";
		
				if(numberPhone != null)
				str += " numberPhone=" + numberPhone + ", ";
				if(eMail != null)
				str += "eMail=" + eMail;
		return str;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

}
