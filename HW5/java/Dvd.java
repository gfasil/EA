import javax.persistence.Entity;

@Entity
public class Dvd extends Product {
    private String genere;

    public Dvd(String name, String description, String genere) {
        super(name, description);
        this.genere = genere;
    }

    public Dvd() {

    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }
}
