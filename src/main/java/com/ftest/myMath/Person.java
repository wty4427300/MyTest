package com.ftest.myMath;

/**
 * 一个简单的建造者模式的栗子
 */
public class Person {
    private String name;
    private String age;
    private int time;

    public static final class PersonBuilder {
        private String name;
        private String age;
        private int time;

        private PersonBuilder() {
        }

        public static PersonBuilder aPerson() {
            return new PersonBuilder();
        }

        public PersonBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder withAge(String age) {
            this.age = age;
            return this;
        }

        public PersonBuilder withTime(int time) {
            this.time = time;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.time = this.time;
            person.name = this.name;
            person.age = this.age;
            return person;
        }
    }

    public static void main(String[] args) {
        Person person= PersonBuilder.aPerson().withAge("11").build();
    }
}
