package pgdp.messenger;

public class UserArray {
	private User[] users;
	private int capacity, size;

	public UserArray(int initCapacity) {
		if (initCapacity < 1) {
			capacity = 1;
		}
		else {
			capacity = initCapacity;
		}
		users = new User[capacity];
		size = 0;
	}

	/** Fügt den übergebenen Nutzer in das durch dieses Objekt dargestellte 'UserArray' ein
	 * @param user Eine beliebige User-Referenz (schließt 'null' mit ein)
	 */
	public void addUser(User user) {
		// Check if user is null
		if (user == null) {
			return;
		}
		// Check if array is full
		if (size == capacity) {
			// Double the capacity
			capacity *= 2;
			// Transfer current array to a new bigger one
			User[] temp = users;
			users = new User[capacity];
			for (int i = 0; i < size; ++i) {
				users[i] = temp[i];
			}
		}
		// Add user
		for (int i = 0; i < capacity; i++) {
			if (users[i] == null) {
				users[i] = user;
				size++;
				break;
			}
		}
	}

	/** Entfernt den Nutzer mit der übergebenen ID aus dem Array und gibt diesen zurück.
	 *  Wenn kein solcher Nutzer existiert, wird 'null' zurückgegeben.
	 * @param id Ein beliebiger long
	 * @return Der eben aus dem UserArray entfernte Nutzer, wenn ein Nutzer mit der übergebenen id darin existiert, sonst 'null'
	 */
	public User deleteUser(long id) {
		for (int i = 0; i < capacity; i++) {
			if (users[i].getId() == id) {
				User result = users[i];
				users[i] = null;
				size--;
				return result;
			}
		}
		return null;
	}

	public int size() {
		return size;
	}
}
