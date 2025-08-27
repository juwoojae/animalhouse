public abstract class Animal {
    private String name;
    private String species;
    private int age;
    private int hungerFigure;
    private int happiness;

    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.hungerFigure = 50; //기본 배고픔 수치
        this.happiness = 50; //기본 행복도
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getHungerFigure() {
        return hungerFigure;
    }

    public int getHappiness() {
        return happiness;
    }

    public abstract void sound();

    public void feed() {
        hungerFigure += 10;
    }

    public void play() {
        happiness += 10;
    }
}
