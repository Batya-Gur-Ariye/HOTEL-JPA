package Hotel;

import java.time.LocalDate;

public class Order {

	private final int numOrder;
	private static int index = 100;
	private Guest guest;
	private Room room;
	// תאריך שבו הוזמנה
	private LocalDate orderDate;
	private int numDays;

	public Order(Guest guest, Room room, LocalDate orderDate, int numDays) throws IllegalAccessException {
		if (room.isActive()) {
			this.numOrder = index++;
			this.guest = guest;
			guest.setNumVisit(guest.getNumVisit() + 1);
			this.room = room;
			room.setActive(false);
			this.orderDate = orderDate;
			this.numDays = numDays;
		} else {
			throw new IllegalAccessException("the room mot  available.");
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Order o)
			return this.numOrder == o.getNumOrder();
		return false;
	}

	public double calcPrice() {
		double price = room.getPrice() * numDays;
		if (numDays > 3)
			price *= 0.85;
		if (guest instanceof BuissnesGuest) {
			price *= BuissnesGuest.getDiscountPercent();
		}
		return price;
	}

	@Override
	public String toString() {
		return "Order:\nnumOrder=" + numOrder + ", guest=" + guest + ", room=" + room + ", orderDate=" + orderDate
				+ ", numDays=" + numDays + "\n";
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public int getNumDays() {
		return numDays;
	}

	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}

	public int getNumOrder() {
		return numOrder;
	}

}
