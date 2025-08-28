package repository;

import domain.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalRepositoryImp implements AnimalRepository{
    private List<Animal> animalRepository = new ArrayList<>();
    @Override
    public List<Animal> findAll(){
        return new ArrayList<>(animalRepository); //얕은 복사
    }
    @Override
    public Animal findByIdx(int idx){
        return animalRepository.get(idx);
    }
    @Override
    public void addAnimal(Animal animal){
        animalRepository.add(animal);
    }
}
