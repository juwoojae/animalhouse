package repository;
import domain.Animal;

import java.util.List;
//Zoo
public interface AnimalRepository {  //동물 전체 관리 시스템
    //동물리스트를 얕은 복사해서 반환하는 메서드
    List<Animal> findAll();
    //idx를 통해 리스트에 있는 Animal 인스턴스를 반환하는 메서드
    Animal findByIdx(int idx);
    //Animal 인스턴스를 동물 리스트에 추가하는 메서드
    void addAnimal(Animal animal);

}
