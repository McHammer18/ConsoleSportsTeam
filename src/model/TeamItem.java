package model;

//Entity Manager
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class TeamItem {
	//variables
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int Id;
	@Column(name ="CITY")
	private String city;
	@Column(name="NICKNAME")
	private String nickName;
	@Column(name="NUMBEROFPLAYERS")
	private int numOfPlayers;

	
	//constructors
	public TeamItem() {
		super();
	}


	public TeamItem(String city, String nickName, int numOfPlayers) {
		super();
		this.city = city;
		this.nickName = nickName;
		this.numOfPlayers = numOfPlayers;
	}

	//Getters and setters
	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getNickName() {
		return nickName;
	}


	public void setNickName(String nickName) {
		this.nickName = nickName;
	}


	public int getNumOfPlayers() {
		return numOfPlayers;
	}


	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	//helper method
	public String returnItemDetails() {
		return city + ", " + nickName + ", " + numOfPlayers;
	}
	
	
}
