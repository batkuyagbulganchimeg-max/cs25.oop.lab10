import java.util.List;

// Animal үндсэн класс
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

// Animal-аас үүсмэл классууд
class Lion extends Animal {
    public Lion(String name) { super(name); }
}

class Crane extends Animal {
    public Crane(String name) { super(name); }
}

// Zoo<T extends Animal> - зөвхөн Animal ба түүний дэд төрлүүдийг авна
class Zoo<T extends Animal> {

    /**
     * transferAnimals:
     *   source      -> List<? extends T>  (T эсвэл T-ийн дэд төрөл уншина)
     *   destination -> List<? super T>    (T эсвэл T-ийн дээд төрөлд нэмнэ)
     *
     *   PECS дүрэм: Producer Extends, Consumer Super
     */
    public void transferAnimals(List<? extends T> source, List<? super T> destination) {
        for (T animal : source) {
            destination.add(animal);
        }
    }
}