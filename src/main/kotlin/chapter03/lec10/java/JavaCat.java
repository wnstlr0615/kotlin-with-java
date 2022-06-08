package chapter03.lec10.java;

import chapter03.lec10.kotlin.Animal;
import org.jetbrains.annotations.NotNull;

public class JavaCat extends Animal {
    public JavaCat(@NotNull String species) {
        super(species, 4);
    }
    @Override
    public void move() {
        System.out.println("고양이가 사뿐 사뿐 걸어가~");
    }
}
