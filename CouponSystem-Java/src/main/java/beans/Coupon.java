package beans;

import java.util.Date;

public class Coupon {
    private int id;
    private int companyID;
    private Category category;
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int amount;
    private double price;
    private String image;

    //builder
    public Coupon() {
    }

    public static Coupon builder(){
        return new Coupon();
    }

    public Coupon id (int id){
        this.id = id;
        return this;
    }

    public Coupon companyID (int companyID){
        this.companyID = companyID;
        return this;
    }

    public Coupon category (Category category){
        this.category = category;
        return this;
    }

    public Coupon title (String title){
        this.title = title;
        return this;
    }

    public Coupon description (String description){
        this.description = description;
        return this;
    }

    public Coupon startDate (Date startDate){
        this.startDate = startDate;
        return this;
    }

    public Coupon endDate (Date endDate){
        this.endDate = endDate;
        return this;
    }

    public Coupon amount (int amount){
        this.amount = amount;
        return this;
    }

    public Coupon price (double price){
        this.price = price;
        return this;
    }

    public Coupon image (String image){
        this.image = image;
        return this;
    }

    //getter setter toString
    //id - no setter
    public int getId() {
        return id;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", companyID=" + companyID +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
