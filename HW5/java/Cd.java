import javax.persistence.Entity;

@Entity
public class Cd extends Product {
    private String artist;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Cd() {
    }

    public Cd(String name, String description, String artist) {
        super(name, description);
        this.artist = artist;
    }
}
