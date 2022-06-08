package chapter03.lec13;

class Lec13Main {
}
class JavaHouse{
    private String address;
    private LivingRoom livingRoom;

    JavaHouse(String address, LivingRoom livingRoom) {
        this.address = address;
        this.livingRoom = new LivingRoom(10);
    }

    public LivingRoom getLivingRoom() {
        return livingRoom;
    }

    // 중첩 클래스에서 static가 없을 경우 밖에서 호출이 가능하므로  중첩클래스에는 static을 붙여줘야한다.
    public /*static*/ class LivingRoom{
        private double area;

        public LivingRoom(double area) {
            this.area = area;
        }
        public String getAddress(){
            return JavaHouse.this.address;
        }
    }
}
