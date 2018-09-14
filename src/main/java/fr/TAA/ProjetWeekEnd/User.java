package fr.TAA.ProjetWeekEnd;

import java.util.List;

import javax.persistence.Column;
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
	private String username;
	private String password;
	private String email;
	
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


	@Column(nullable = false)
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String name;

    private List<Sport> favoriteSports;
    
    private List<Location> favoriteLocations;

	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((favoriteLocations == null) ? 0 : favoriteLocations.hashCode());
		result = prime * result + ((favoriteSports == null) ? 0 : favoriteSports.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (favoriteLocations == null) {
			if (other.favoriteLocations != null)
				return false;
		} else if (!favoriteLocations.equals(other.favoriteLocations))
			return false;
		if (favoriteSports == null) {
			if (other.favoriteSports != null)
				return false;
		} else if (!favoriteSports.equals(other.favoriteSports))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}
