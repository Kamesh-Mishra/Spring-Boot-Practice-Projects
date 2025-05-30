package com.fakestore.store.entity;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    private String title;
    private double price;
   // @Size(min = 6, max = 1000, message = "Desc must be between 6 and 1000 characters") 
    private String description;
    private String category;
    private String image;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "id")
    private Rating rating;

    public long getID() { return id; }
    public void setID(long value) { this.id = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }

    public double getPrice() { return price; }
    public void setPrice(double value) { this.price = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getCategory() { return category; }
    public void setCategory(String value) { this.category = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }

    public Rating getRating() { return rating; }
    public void setRating(Rating value) { this.rating = value; }
}
