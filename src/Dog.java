public class Dog extends Animal{

    public Dog(String name,String  species, int age) {
        super(name,species ,age);
    }

    @Override
    public void sound() {
        System.out.println("멍멍!");
    }
}
