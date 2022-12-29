package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.List;

public class BigMac {

    private final Bun bun;
    private final int burgers;
    private final Sauce sauce;
    private List<Ingredients> ingredients;

    private BigMac(Bun bun, int burgers, Sauce sauce, List<Ingredients> ingredients) {
        this.bun = bun;
        this.burgers = burgers;
        this.sauce = sauce;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public static class BigmacBuilder {
        private Bun bun;
        private int burgers;
        private Sauce sauce;
        private List<Ingredients> ingredients = new ArrayList<>();

        public BigmacBuilder bun(Bun bun) {
            this.bun = bun;
            return this;
        }

        public BigmacBuilder burgers(int number) {
            this.burgers = number;
            return this;
        }

        public BigmacBuilder sauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public BigmacBuilder ingredients(Ingredients ingredient) {
            this.ingredients.add(ingredient);
            return this;
        }

        public BigMac build() {
            if (this.bun == null) {
                throw new IllegalStateException("You have to set bun type");
            }
            if (this.burgers <= 0) {
                throw new IllegalStateException("You have to choose amount of burgers");
            }
            if (this.sauce == null) {
                throw new IllegalStateException("You have to choose type of sauce");
            }
            return new BigMac(bun, burgers, sauce, ingredients);
        }
    }

    public Bun getBun() {
        return bun;
    }

    public int getBurgers() {
        return burgers;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public List<Ingredients> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return "BigMac{" +
                "bun=" + bun +
                ", burgers=" + burgers +
                ", sauce=" + sauce +
                ", ingredients=" + ingredients +
                '}';
    }
}
