package org.forten.zuoye.model;


import java.util.Date;

public class Book2 {
    private int id;
    private String name;
    private String author;
    private String publisher;
    private Date pubDate;
    private double price;
    private double discount;
    private Date creatTime;
    public Book2() {
        super();
        this.creatTime = new Date();
    }
    public Book2(String name, String author, String publisher, Date pubDate, double price, double discount) {
        this();
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.pubDate = pubDate;
        this.price = price;
        this.discount = discount;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public Date getPubDate() {
        return pubDate;
    }
    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getDiscount() {
        return discount;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public Date getCreatTime() {
        return creatTime;
    }
    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Book2 other = (Book2) obj;
        if (id != other.id)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Book2 [id=" + id + ", name=" + name + ", author=" + author + ", publisher=" + publisher + ", pubDate="
                + pubDate + ", price=" + price + ", discount=" + discount + ", creatTime=" + creatTime + "]";
    }

}
