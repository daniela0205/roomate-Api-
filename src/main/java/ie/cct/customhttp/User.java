package ie.cct.customhttp;

public class User {

	private String name;
	private Integer age;
	private String email;
	private String password;
	private boolean smoke;
	private String hobbies;
	private double longitude;
    private double latitude; 

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	
	public boolean isSmoke() {
		return smoke;
	}
	public void setSmoke(boolean smoke) {
		this.smoke = smoke;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", password=" + password + ", smoke="
				+ smoke + "]";
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLatitude() {
		// TODO Auto-generated method stub
		return latitude;
	}

	
}
