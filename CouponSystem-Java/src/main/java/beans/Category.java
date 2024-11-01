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

    public static Category randomUrgency(){
        return Category.values()[ThreadLocalRandom.current().nextInt(0,Category.values().length)];
    }
}
