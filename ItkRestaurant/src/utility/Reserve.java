package utility;

public class Reserve {

	private String name;
	private String email;
	private String date;
	private String phone;
	private String parking;
	private int person;
	private String time;

	public Reserve(String name, String email, String date, String phone, String parking, int person, String time) {
		super();
		this.name = name;
		this.email = email;
		this.date = date;
		this.phone = phone;
		this.parking = parking;
		this.person = person;
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
