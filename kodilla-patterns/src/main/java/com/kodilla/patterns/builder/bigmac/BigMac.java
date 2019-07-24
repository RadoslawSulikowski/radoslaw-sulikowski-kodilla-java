package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {
    public static String SESAME = "SESAME";
    public static String NO_SESAME = "NO SESAME";
    public static String STANDARD = "STANDARD";
    public static String THOUSAND_ISLAND = "THOUSAND ISLAND";
    public static String BARBECUE = "BARBECUE";
    public static String LETTUCE = "LETTUCE";
    public static String ONION = "ONION";
    public static String BECKON = "BECKON";
    public static String PICKLE = "PICKLE";
    public static String CHILI_PEPPERS = "CHILI PEPPERS";
    public static String MUSHROOMS = "MUSHROOMS";
    public static String SHRIMPS = "SHRIMPS";
    public static String CHEESE = "CHEESE";

    private final String bun;
    private final int burgers;
    private final String sauce;
    private List<String> ingredients;

    private BigMac(String bun, int burgers, String sauce, List<String> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public String getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public String getSauce() {
        return sauce;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun='" + bun + '\'' +
                ", burgers=" + burgers +
                ", sauce='" + sauce + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }

    static class BigMacBuilder {
        private String bun;
        private int burgers;
        private String sauce;
        private List<String> ingredients = new ArrayList<>();

        private boolean ifRightIngredient(String ingredient) {
            return ingredient.equals(LETTUCE) || ingredient.equals(ONION) || ingredient.equals(MUSHROOMS)
                    || ingredient.equals(BECKON) || ingredient.equals(PICKLE) || ingredient.equals(CHILI_PEPPERS)
                    || ingredient.equals(SHRIMPS) || ingredient.equals(CHEESE);
        }

        private boolean ifRightSauce(String sauce) {
            return sauce.equals(STANDARD) || sauce.equals(THOUSAND_ISLAND) || sauce.equals(BARBECUE);
        }

        private boolean ifRightBun( String bun){
            return bun.equals(SESAME) || bun.equals(NO_SESAME);
        }

        public BigMacBuilder bun(String bun) {
            if (ifRightBun(bun)) {
                this.bun = bun;
                return this;
            } else {
                throw new IllegalStateException("Bun can only be " + SESAME + " or " + NO_SESAME + "!");
            }
        }

        public BigMacBuilder burgers(int burgers) {
            this.burgers = burgers;
            return this;
        }

        public BigMacBuilder sauce(String sauce) {
            if (ifRightSauce(sauce)) {
                this.sauce = sauce;
                return this;
            } else {
                throw new IllegalStateException("Sauce can only be one of: " + STANDARD + ", " + THOUSAND_ISLAND + ", " + BARBECUE + "!");
            }
        }

        public BigMacBuilder ingredient(String ingredient) {
            if (ifRightIngredient(ingredient)) {
                ingredients.add(ingredient);
                return this;
            } else {
                throw new IllegalStateException("Ingredient can only be one of: "
                        +LETTUCE + ", " + ONION + ", " + MUSHROOMS + ", " + BECKON + ", " + PICKLE + ", "
                        + CHILI_PEPPERS + ", " + SHRIMPS + ", " + CHEESE
                        + "!");
            }
        }

        public BigMac build(){
            return new BigMac(bun, burgers, sauce, ingredients);
        }
    }
}
