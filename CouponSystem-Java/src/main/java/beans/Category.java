package beans;

import java.util.concurrent.ThreadLocalRandom;

public enum Category {
    Food(1),
    Electricity(2),
    Restaurant(3),
    Vacation(4);

    private final int numericalCategory;

    Category(int numericalMethod) {
        this.numericalCategory = numericalMethod;
    }

    public int getNumericalCategory() {
        return numericalCategory;
    }

    // Static method to get Category by numerical value
    public static Category fromNumericalCategory(int numericalCategory) {
        for (Category category : Category.values()) {
            if (category.getNumericalCategory() == numericalCategory) {
                return category;
            }
        }
        throw new IllegalArgumentException("No category found for value: " + numericalCategory);
    }

    public static Category randomCategory(){
        return Category.values()[ThreadLocalRandom.current().nextInt(0,Category.values().length)];
    }
}
