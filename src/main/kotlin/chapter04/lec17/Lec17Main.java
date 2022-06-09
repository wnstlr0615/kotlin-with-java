package chapter04.lec17;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Lec17Main {
    public static void main(String[] args) {
        List<Fruit> fruits = List.of(
                new Fruit("사과", 1000),
                new Fruit("사과", 1200),
                new Fruit("사과", 1200),
                new Fruit("사과", 1500),
                new Fruit("바나나", 3000),
                new Fruit("바나나", 3200),
                new Fruit("바나나", 2500),
                new Fruit("수박", 10000)
            );
    }

    private List<Fruit> filterFruits(List<Fruit> fruits, Predicate<Fruit> fruitFilter){
        List<Fruit> results = new ArrayList<>();
        for (Fruit fruit : results) {
            if(fruitFilter.test(fruit)){
                results.add(fruit);
            }
        }
        return results;
    }
}
