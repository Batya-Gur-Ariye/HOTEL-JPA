package Hotel;

import java.io.Serializable;
// this class defended a business guest in a hotel

@SuppressWarnings("serial")
public class BuissnesGuest extends Guest implements Serializable {

	private int businessGuestCode;
	private static int discountPercent = 10;

	public BuissnesGuest(Person person, int businessGuestCode) {
		super(person);
		setBusinessGuestCode(businessGuestCode);
	}

	// sent to a fathers ctor
	public BuissnesGuest(Person person) {
		super(person);
	}

	public int getBusinessGuestCode() {
		return businessGuestCode;
	}

	public void setBusinessGuestCode(int businessGuestCode) {
		this.businessGuestCode = businessGuestCode;
	}

	public static int getDiscountPercent() {
		return discountPercent;
	}

	public static void setDiscountPercent(int discountPercent) {
		BuissnesGuest.discountPercent = discountPercent;
	}
}
