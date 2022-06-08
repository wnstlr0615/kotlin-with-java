package chapter03.lec09;

public class Lec09Main {
    //== 1. 클래스와 프로퍼티 ==//
    public static class JavaPerson{
        private final String name;
        private int age;

        public JavaPerson(String name, int age) {
            // 나이 검증 추가
            if(age <= 0){
                throw new IllegalArgumentException(String.format("나이는 %d 일 수 없습니다.", age));
            }
            this.name = name;
            this.age = age;

        }

        public JavaPerson(String name){
            this(name, 1);
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        //성인 유무 확인인
       public boolean isAdult(){
            return age >= 20;
        }
    }


}
