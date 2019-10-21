package com.example.second.Second.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books {
    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Id
    @Column(name = "id")
    int bookid;
    String title;

    public Books()
    {

    }

    public Books(int bookid, String title) {
        this.bookid = bookid;
        this.title = title;
    }
}
