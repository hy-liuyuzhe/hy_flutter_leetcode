package com.company.dart;

import java.util.ArrayList;
import java.util.List;

public class Fruit {

    public static void main(String[] args) {
        List<Orange2> orange2s = new ArrayList<>();
        //addApple(orange2s);//java 是类型安全的
    }

    //PECS
    static void addApple(List<Fruit2> fruits) {//? extends 是进入方法传（产生）
        fruits.add(new Apple2());//？super 这是消费行为
    }


}

class Fruit2 {
}

class Orange2 extends Fruit2 {
}

class Apple2 extends Fruit2 {
}

