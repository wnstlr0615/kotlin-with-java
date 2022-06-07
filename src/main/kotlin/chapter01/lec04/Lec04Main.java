package chapter01.lec04;

import org.jetbrains.annotations.NotNull;

public class Lec04Main {
    public static void main(String[] args) {
        JavaMoney money1 = new JavaMoney(2000L);
        JavaMoney money2 = new JavaMoney(1000L);
        JavaMoney money3 = new JavaMoney(2000L);
        if(money1.compareTo(money2) > 0){
            System.out.println("money1 이 money2 보다 금액이 큽니다.");
        }
        System.out.println("money1 == money3(동일성 비교 ) :" + (money1 == money3));


        System.out.println(money1.plus(money2));
    }
    static class JavaMoney implements Comparable<JavaMoney> {
        private final long money;

        public JavaMoney(long money) {
            this.money = money;
        }
        public JavaMoney plus(JavaMoney otherMoney) {
            return new JavaMoney(money + otherMoney.money);
        }

        @Override
        public String toString() {
            return "JavaMoney{" + "money=" + money + '}';
        }

        @Override
        public int compareTo(@NotNull JavaMoney o) {
            return Long.compare(money, o.money);
        }

        @Override
        public boolean equals(Object obj) {
            JavaMoney other = (JavaMoney) obj;
            return money == other.money;
        }
    }

}

