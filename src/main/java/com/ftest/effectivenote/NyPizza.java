package com.ftest.effectivenote;

import java.util.Objects;

public class NyPizza extends Pizza{
    public enum Size { SMALL , MEDIUM, LARGE }
    private final Size size;

    public NyPizza(Builder builder) {
        super(builder);
        size=builder.size;
    }

    /**
     * 父类的Builder的addToppings会调用self返回Builder本身
     *
     * 子类的builder的build方法会返回初始化自己的一个对象
     */
    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public void main(String[] args) {
        NyPizza pizza = new Builder(Size.SMALL).addTopping(Topping.SAUSAGE).addTopping(Topping.ONION).build();
    }
}
