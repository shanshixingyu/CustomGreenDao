package com.shanshixingyu.customgreendao.db.bean;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table NOTE.
 */
public class Note {

    private Long id;
    /** Not-null value. */
    private String name;
    /** Not-null value. */
    private String author;
    private Long time;

    public Note() {
    }

    public Note(Long id) {
        this.id = id;
    }

    public Note(Long id, String name, String author, Long time) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getName() {
        return name;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setName(String name) {
        this.name = name;
    }

    /** Not-null value. */
    public String getAuthor() {
        return author;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}