import java.util.ArrayList;
import java.util.List;
public class Zoo {  //동물 전체 관리 시스템

    private List<Animal> animalRepository = new ArrayList<>();

    public List<Animal> findAll(){
            return new ArrayList<>(animalRepository); //얕은 복사
    }
    public Animal findByIdx(int idx){
        return animalRepository.get(idx);
    }
    public void addAnimal(Animal animal){
        animalRepository.add(animal);
    }
}
