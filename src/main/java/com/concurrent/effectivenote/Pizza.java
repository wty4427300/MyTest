package com.concurrent.effectivenote;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class Pizza {
    public enum Topping {HAM,MUSHROOM,ONION,PEPPER,SAUSAGE }
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        //创建一个泛型字典
        EnumSet<Topping> toppings=EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        abstract Pizza build();
        protected abstract T self();
    }
    Pizza(Builder<?> builder){
        toppings=builder.toppings.clone();
    }
}


