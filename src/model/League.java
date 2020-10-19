package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="league")
public class League {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="LEAGUE_ID")
	private int id;
	@Column(name="LEAGUE_NAME")
	private String leagueName;
	@Column(name="START_DATE")
	private LocalDate startDate;
	@ManyToOne (cascade=CascadeType.PERSIST)
	@JoinColumn(name="PLAYER_ID")
	private Player player;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
		@JoinTable
		(
				name="items_in_list",
				joinColumns= {@JoinColumn(name="LEAGUE_ID", referencedColumnName="LEAGUE_ID")},
				inverseJoinColumns= {@JoinColumn(name="ITEM_ID", referencedColumnName="ID", unique=true)}
				)
	private List<TeamItem> listOfItems;
	
	//Constructors
	public League() {
		super();
		// TODO Auto-generated constructor stub
	}

	public League(int id, String leagueName, LocalDate startDate, Player player, List<TeamItem> listOfItems) {
		super();
		this.id = id;
		this.leagueName = leagueName;
		this.startDate = startDate;
		this.player = player;
		this.listOfItems = listOfItems;
	}

	public League(String leagueName, LocalDate startDate, Player player, List<TeamItem> listOfItems) {
		super();
		this.leagueName = leagueName;
		this.startDate = startDate;
		this.player = player;
		this.listOfItems = listOfItems;
	}

	public League(String leagueName, LocalDate startDate, Player player) {
		super();
		this.leagueName = leagueName;
		this.startDate = startDate;
		this.player = player;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<TeamItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<TeamItem> listOfItems) {
		this.listOfItems = listOfItems;
	}
	
	
	
}
