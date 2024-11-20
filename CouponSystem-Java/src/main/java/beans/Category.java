package beans;

import java.util.concurrent.ThreadLocalRandom;

public class Category {
    // Fields for each category
    public static final Category Food = new Category(1);
    public static final Category Electricity = new Category(2);
    public static final Category Restaurant = new Category(3);
    public static final Category Vacation = new Category(4);

    private final int numericalCategory;

    // Private constructor for Category
    private Category(int numericalCategory) {
        this.numericalCategory = numericalCategory;
    }

    // Getter for numericalCategory
    public int getCategoryId() {
        return numericalCategory;
    }

    // Static method to get Category by numerical value
    public static Category fromNumericalCategory(int numericalCategory) {
        if (numericalCategory == Food.getCategoryId()) {
            return Food;
        } else if (numericalCategory == Electricity.getCategoryId()) {
            return Electricity;
        } else if (numericalCategory == Restaurant.getCategoryId()) {
            return Restaurant;
        } else if (numericalCategory == Vacation.getCategoryId()) {
            return Vacation;
        } else {
            throw new IllegalArgumentException("No category found for value: " + numericalCategory);
        }
    }

    // Static method to get a random category
    public static Category randomCategory() {
        // Choose a random category from the list
        Category[] categories = {Food, Electricity, Restaurant, Vacation};
        return categories[ThreadLocalRandom.current().nextInt(categories.length)];
    }


    @Override
    public String toString() {
        return "Category{" +
                "numericalCategory=" + numericalCategory +
                '}';
    }
}



//import java.util.concurrent.ThreadLocalRandom;
//
//public enum Category {
//    Food(1),
//    Electricity(2),
//    Restaurant(3),
//    Vacation(4);
//
//    private final int numericalCategory;
//
//    Category(int numericalMethod) {
//        this.numericalCategory = numericalMethod;
//    }
//
//    public int getNumericalCategory() {
//        return numericalCategory;
//    }
//
//    // Static method to get Category by numerical value
//    public static Category fromNumericalCategory(int numericalCategory) {
//        for (Category category : Category.values()) {
//            if (category.getNumericalCategory() == numericalCategory) {
//                return category;
//            }
//        }
//        throw new IllegalArgumentException("No category found for value: " + numericalCategory);
//    }
//
//    public static Category randomCategory(){
//        return Category.values()[ThreadLocalRandom.current().nextInt(0,Category.values().length)];
//    }

