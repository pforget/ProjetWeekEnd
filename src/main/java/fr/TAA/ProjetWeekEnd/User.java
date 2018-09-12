package fr.TAA.ProjetWeekEnd;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    public User(Long id, String name, List<Sport> favoriteSports, List<Location> favoriteLocations) {
		super();
		this.id = id;
		this.name = name;
		this.favoriteSports = favoriteSports;
		this.favoriteLocations = favoriteLocations;
	}

	private Long id;

    private String name;

    private List<Sport> favoriteSports;
    
    private List<Location> favoriteLocations;

    public User() {
    }

    @Id
    @GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany
	public List<Sport> getFavoriteSports() {
		return favoriteSports;
	}

	public void setFavoriteSports(List<Sport> favoriteSports) {
		this.favoriteSports = favoriteSports;
	}

	@OneToMany
	public List<Location> getFavoriteLocations() {
		return favoriteLocations;
	}

	public void setFavoriteLocations(List<Location> favoriteLocations) {
		this.favoriteLocations = favoriteLocations;
	}

}
