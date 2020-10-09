package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="player")
public class Player {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="PLAYER_ID")
	private int id;
	@Column(name="PLAYER_NAME")
	private String playerName;
	
	//Constructors
	public Player() {
		super();
		
	}

	public Player(int id, String playerName) {
		super();
		this.id = id;
		this.playerName = playerName;
	}

	public Player(String playerName) {
		super();
		this.playerName = playerName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	@Override
	public String toString()
	{
		return "Player [id=" + id + ", playerName=" + playerName + "]";
	}
	
	
	
}
