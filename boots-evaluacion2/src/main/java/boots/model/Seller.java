package boots.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="seller")
public class Seller implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(length=50)
	private String name;
	@Column(name="last_name",length=50)
	private String lastName;
	@Column(length=15)
	private String telephone;
	@Column(length=80)
	private String address;
	@Column(length=70)
	private String email;
	@Column(length=50)
	private String turn;
	
	public Seller(String name, String lastName, String telephone, String address, String email, String turn) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
		this.email = email;
		this.turn = turn;
	}
	
	public Seller(){
		this("","","","","","");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", lastName=" + lastName + ", telephone=" + telephone
				+ ", address=" + address + ", email=" + email + ", turn=" + turn + "]";
	}
	
	
	
}
