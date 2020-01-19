package exercise03_2;

import javax.persistence.*;

@Entity

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private int id;
    private String title;
    private int isbn;
    @ManyToOne
    @JoinTable(name="Publisher_book")
    private Publisher publisher;

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {

        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Book(String title, int isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    private String author;



    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title=" + title +

                '}';
    }


    public Book(){}


    public int getId()

    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }






}
