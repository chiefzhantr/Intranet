package Main;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
    private int bookId;
    private String name;
    private String author;
    private Date publishDate;

    public Book() {
    	
    }
    
    public Book(int bookId, String name, String author, Date publishDate) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.publishDate = publishDate;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }


}
