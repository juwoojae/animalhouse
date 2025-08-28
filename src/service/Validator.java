package service;

import exception.InputOutofRangeException;
import exception.NoDataFoundException;
import repository.AnimalRepository;

public class Validator {
    AnimalRepository animalRepository ;
    public Validator(AnimalRepository animalRepository){
        this.animalRepository=  animalRepository;
    }
    void validatecommand(int cmd) throws NoDataFoundException, InputOutofRangeException {
         if (cmd > 1 && cmd < 7 && animalRepository.findAll().isEmpty()) {
             throw new NoDataFoundException("animalRepositoryIsEmpty");  //동물의 목록이 없는데 목록을 조회해야하는경우 예외처리
         }
         if (cmd>7){
             throw new InputOutofRangeException("범위를 벗어남"); //cmd 의 값이 7을 넘어가는 경우
         }
     }
}
