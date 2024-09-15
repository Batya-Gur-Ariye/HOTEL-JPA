package Hotel;

//describe a room in a hotel
public class Room {

	private final int numRoom;
	private int floor;
	private level level;
	private boolean isActive;
	private static double startPrice;
	private static int index = 100;

	static {
		startPrice = 500;
	}

	public Room(int floor, level level) {
		this.numRoom = (++index);
		setFloor(floor);
		setLevel(level);
		isActive = true;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Room r)
			return this.numRoom == r.numRoom;
		return false;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public level getLevel() {
		return level;
	}

	public void setLevel(level level) {
		this.level = level;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getPrice() {
		return startPrice + 50 * floor;
	}

	public static void setPrice(double price) {
		Room.startPrice = price;
	}

	public int getNumRoom() {
		return numRoom;
	}

	@Override
	public String toString() {
		return "Room: numRoom=" + numRoom + ", floor=" + floor + ", level=" + level + ", isActive=" + isActive + "";
	}
}

enum level {
	HIGH_LEVEL, AVERAGE_LEVEL, LOW_LEVEL
}
