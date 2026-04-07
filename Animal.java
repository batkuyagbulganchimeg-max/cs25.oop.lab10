import java.util.List;
class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
class Lion extends Animal {
    public Lion(String name) { super(name); }
}

class Crane extends Animal {
    public Crane(String name) { super(name); }
}

// Zoo<T extends Animal> - 
class Zoo<T extends Animal> {
    public void transferAnimals(List<? extends T> source, List<? super T> destination) {
        for (T animal : source) {
            destination.add(animal);
        }
    }
}