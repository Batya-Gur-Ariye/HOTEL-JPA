package Hotel;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Optional;

//this class describe the list guests in a hotel
@SuppressWarnings("serial")
public class ListGuest implements Serializable {

	private ArrayList<Guest> arrayGuest = new ArrayList<>();
	private ListOrder listOrder;

	public ListGuest(ListOrder listOrders) {
		this.listOrder = listOrders;
	}

	public boolean addGuest(Guest guest) {
		arrayGuest.add(guest);
		return true;
	}

	public Optional<Guest> searchById(int id) {
		return arrayGuest.stream().filter(g -> g.getPerson().getId() == id).findAny();
	}

	public Optional<Guest> searchByfirstName(String firstName) {
		return arrayGuest.stream().filter(g -> g.getPerson().getFirstName().equals(firstName)).findAny();
	}

	public boolean deleteGuest(Guest guest) {
		// if the function didn't return a order we can delete
		if (listOrder.searchOrderByGuest(guest).get() == null)
			return arrayGuest.remove(guest);
		return false;
	}

	public void printById(int id) {
		System.out.println(arrayGuest.stream().filter(g -> g.getPerson().getId() == id).toString());

	}

	public Optional<Guest> searchByPhoneNumber(String phoneNumber) {
		return arrayGuest.stream().filter(g -> g.getPerson().getNumberPhone().equals(phoneNumber)).findAny();
	}

	public void printByFirstName(String firstName) {
		System.out.println(
				arrayGuest.stream().filter(g -> g.getPerson().getFirstName().equals(firstName)).findFirst().toString());
	}

	public void printAll() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return arrayGuest.stream().filter(g -> g != null).toString();
	}

	public void sortByVisits() {
		arrayGuest.sort((g1, g2) -> g1.getNumVisit() - g2.getNumVisit());
	}

	public void sortById() {
		arrayGuest.sort((g1, g2) -> g1.getPerson().getId() - g2.getPerson().getId());
	}

	public ArrayList<Guest> getArrayGuest() {
		return arrayGuest;
	}

	public void setArrayGuest(ArrayList<Guest> arrayGuest) {
		this.arrayGuest = arrayGuest;
	}

	public void ReportActiveGuests() {
		String FilePath = "Report Active Guests.txt";
		ObjectOutputStream o = null;
		try {
			o = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(FilePath)));
			for (int i = 0; i < arrayGuest.size(); i++) {
				if (listOrder.searchOrderByGuest(arrayGuest.get(i)) != null)
					o.writeObject(arrayGuest.get(i));
			}
			o.flush();

		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				o.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
