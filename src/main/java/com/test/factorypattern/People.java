package com.test.factorypattern;

public class People {

    public Food food;

    public People(String foodName){
        if("fruit".equals(foodName)){
            this.food = new Fruit();
        }else if("meat".equals(foodName)){
            this.food = new Meat();
        }
    }

    public void eatFood(){
        food.eat();
    }

    public static void main(String[] args) {
        People p = new People("meat");
        p.eatFood();
    }
}
