package psa.model;

public class Contact {

	private String id;
	private String name;
	private String telephone;

	public Contact(String id, String name, String telephone) {
		this.id = id;
		this.name = name;
		this.telephone = telephone;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
