import exception.EmptyListException;

import java.util.ArrayList;
import java.util.List;
public class Zoo {  //동물 전체 관리 시스템

    private List<Animal> animalRepository = new ArrayList<>();

    public List<Animal> findAll(){
        if (animalRepository.isEmpty()){
            throw new EmptyListException("리스트가 비어있음");
        } else {
            return new ArrayList<>(animalRepository);
        }

    }
    public Animal findByIdx(int idx){
        return animalRepository.get(idx);
    }
    public void addAnimal(Animal animal){
        animalRepository.add(animal);
    }
}
