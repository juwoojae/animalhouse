package service;
import domain.Animal;
import domain.Cat;
import domain.Dog;
import exception.InputOutofRangeException;
import exception.NoDataFoundException;
import repository.AnimalRepository;
import repository.AnimalRepositoryImp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServiceImp implements Service{
    BufferedReader bufferedReader ;
    AnimalRepository animalRepository ;
    //의존관계 주입
    public ServiceImp(){
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.animalRepository = new AnimalRepositoryImp();
    }

    //동물의 목록 조회 메서드
    @Override
    public void selectList() {
        int indexing = 0;
        for (Animal animal : animalRepository.findAll()) {
            System.out.printf("%d : %s (%s, %d살)\n", ++indexing, animal.getName(), animal.getSpecies(), animal.getAge());
        }
    }

    //동물의 목록 조회 메서드
    @Override
    public Animal selectAnimal() throws IOException {
        selectList();
        Animal animal;
        while (true) {
            System.out.printf("선택: ");
            try {
                animal = animalRepository.findByIdx(Integer.parseInt(bufferedReader.readLine()) - 1); //0부터 시작하므로
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("명령어 인식 불가");
            } catch (NumberFormatException e){
                System.out.println("잘못된입력 (숫자를 입력해 주세요)");
            }
        }
        return animal;
    }

    //command 를 입력 받는 메서드
    @Override
    public int command() throws IOException{
        System.out.println("=== 사용자 메뉴 ===");
        System.out.println("1. 동물 등록");
        System.out.println("2. 동물 목록 보기");
        System.out.println("3. 동물과 놀기");
        System.out.println("4. 먹이주기");
        System.out.println("5. 동물 상태 확인");
        System.out.println("6. 울음소리 듣기");
        System.out.println("7. 종료");
        int cmd;
        while (true) {  // cmd 입력과 예외처리
            try {
                System.out.println();
                cmd = Integer.parseInt(bufferedReader.readLine());
                //이코드가 맞나?? 싶다. 객체를굳이 생성? ㅇ
                Validator validator = new Validator(animalRepository);
                validator.validatecommand(cmd);
                return cmd;
            } catch (NumberFormatException e) {   //입력이 올바른 입력이 아닌경우
                System.out.println("잘못된입력 (숫자를 입력해 주세요)");   //출력후 정상적인 입력을 받을때 까지 루프를 돌린다
            } catch (NoDataFoundException e) {
                System.out.println("현재 동물원에 동물이 없습니다. 동물을 추가해주세요 (동물추가 1.)");
            } catch (InputOutofRangeException e){
                System.out.println("범위 안의 숫자를 입력해주세요");
            }
        }
    }

    //사용자 메뉴 콘솔 화면 cmd 를 받아서 처리하는 메서드
    @Override
    public void menu(int cmd) throws IOException {

        // cmd 입력에 따른 동작
        switch (cmd) {
            case 1: // 동물 등록
                System.out.printf("동물 이름을 입력하세요: ");
                String name = bufferedReader.readLine();
                int species;
                int age;

                // 나이 입력
                while (true) {
                    try {
                        System.out.printf("동물 나이를 입력하세요: ");
                        age = Integer.parseInt(bufferedReader.readLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("숫자를 입력해주세요");
                    }
                }

                // 동물 종류 선택
                while (true) {
                    try {
                        System.out.printf("동물 종류를 선택하세요 (1.강아지 2.고양이): ");
                        species = Integer.parseInt(bufferedReader.readLine());
                        switch (species) {  //여기 코드 확장성 최악
                            case 1:
                                animalRepository.addAnimal(new Dog(name, "강아지", age));
                                System.out.printf("%s(강아지, %d살)가 등록되었습니다.\n\n", name, age);
                                break;
                            case 2:
                                animalRepository.addAnimal(new Cat(name, "고양이", age));
                                System.out.printf("%s(고양이, %d살)가 등록되었습니다.\n\n", name, age);
                                break;
                            default: // 선택 동물 목록 이외의 숫자를 입력 받는경우의 예외
                                throw new IllegalArgumentException("잘못된 인수 입력");
                        }
                        break;  //다중 예외처리 구문
                    } catch (NumberFormatException e) {
                        System.out.println("숫자를 입력해주세요");
                    } catch (IllegalArgumentException e) {
                        System.out.println("명령어 인식 불가");
                    }
                }
                break;

            case 2: // 동물 목록 보기
                selectList();
                break;

            case 3: // 동물과 놀기
                System.out.println("같이 놀 동물을 선택하세요:\n");
                Animal playAnimal = selectAnimal(); //선택된 동물을 찾아서 리턴
                playAnimal.play();
                System.out.printf("%s (%s) 의 행복도가 1 증가 했습니다\n", playAnimal.getName(), playAnimal.getSpecies());
                break;

            case 4: // 먹이 주기
                System.out.println("먹이를 줄 동물을 선택하세요:\n");
                Animal feedAnimal = selectAnimal();
                feedAnimal.feed();
                System.out.printf("%s (%s) 의 포만도가 1 증가 했습니다\n", feedAnimal.getName(), feedAnimal.getSpecies());
                break;

            case 5: // 상태 확인
                System.out.println("상태를 확인할 동물을 선택하세요:\n");
                Animal statusAnimal = selectAnimal();
                System.out.printf("%s (%s, %d살) 포만도: %d, 행복도: %d\n",
                        statusAnimal.getName(),
                        statusAnimal.getSpecies(),
                        statusAnimal.getAge(),
                        statusAnimal.getHungerFigure(),
                        statusAnimal.getHappiness());
                break;

            case 6: // 울음소리 듣기
                System.out.println("울음 소리를 들을 동물을 선택하세요:\n");
                Animal soundAnimal = selectAnimal();
                soundAnimal.sound();
                break;

            case 7: // 종료
                System.out.println("프로그램을 종료합니다.");
                System.exit(0);
                break;

            default:
                throw new IllegalArgumentException("잘못된 인자");
        }
    }
}
