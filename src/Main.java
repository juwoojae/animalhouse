import exception.EmptyListException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static Zoo zoo = new Zoo();

    static void selectList() {
        int indexing = 0;
        for (Animal animal : zoo.findAll()) {
            System.out.printf("%d.: %s (%s, %d살)\n", ++indexing, animal.getAge(), animal.getSpecies(), animal.getAge());
        }
    }

    //사용자 메뉴 콘솔 화면
    static void menu() throws IOException {
        System.out.println("=== 사용자 메뉴 ===");
        System.out.println("1. 동물 등록");
        System.out.println("2. 동물 목록 보기");
        System.out.println("3. 동물과 놀기");
        System.out.println("4. 먹이주기");
        System.out.println("5. 동물 상태 확인");
        System.out.println("6. 울음소리 듣기");
        System.out.println("7. 종료");
        System.out.printf("숫자를 입력하세요: ");

        int cmd;
        while (true){
            try {
                cmd = Integer.parseInt(bufferedReader.readLine());
                break;
            } catch (NumberFormatException e) {   //입력이 올바른 입력이 아닌경우
                System.out.println("숫자를 입력해주세요");   //출력후 정상적인 입력을 받을때 까지 루프를 돌린다
            }
        }
        if (cmd == 1) { //동물 등록
            System.out.printf("동물 이름을 입력하세요: ");
            String name = bufferedReader.readLine();
            System.out.printf("동물 나이를 입력하세요: ");
            int species;
            int age;
            while (true){
                try {
                    age = Integer.parseInt(bufferedReader.readLine());
                    break;
                } catch (NumberFormatException e) {   //입력이 올바른 입력이 아닌경우
                    System.out.println("숫자를 입력해주세요");  //출력후 정상적인 입력을 받을때 까지 루프를 돌린다
                }
            }
            System.out.printf("동물 종류를 선택하세요 (1.강아지 2.고양이): ");
            while (true){
                try {
                   species = Integer.parseInt(bufferedReader.readLine());
                    break;
                } catch (NumberFormatException e) {   //입력이 올바른 입력이 아닌경우
                    System.out.println("숫자를 입력해주세요");   //출력후 정상적인 입력을 받을때 까지 루프를 돌린다
                }
            }
            if (species == 1) {  //이코드 확장성 최악
                zoo.addAnimal(new Dog(name, "강아지", age));
                System.out.printf("%s(강아지, %d살)가 등록되었습니다.\n\n", name, age);
            } else {
                zoo.addAnimal(new Cat(name, "고양이", age));
                System.out.printf("%s(고양이, %d살)가 등록되었습니다.\n\n", name, age);
            }
        } else if (cmd == 2) { //동물 목록 보기
            selectList();
        } else if (cmd == 3) { //동물과 놀기
            System.out.println("같이 놀 동물을 선택하세요:\n");
            selectList();
            System.out.printf("선택: ");
            Animal animal = zoo.findByIdx(Integer.parseInt(bufferedReader.readLine()) - 1); //0부터 시작하므로
            animal.play();
            System.out.printf("%s (%s) 의 행복도가 1 증가 했습니다\n", animal.getName(), animal.getSpecies());
        } else if (cmd == 4) { //먹이 주기
            System.out.println("먹이를 줄 동물을 선택하세요:\n");
            selectList();
            System.out.printf("선택: ");
            Animal animal = zoo.findByIdx(Integer.parseInt(bufferedReader.readLine()) - 1); //0부터 시작하므로
            animal.feed();
            System.out.printf("%s (%s) 의 포만도 가 1 증가 했습니다\n", animal.getName(), animal.getSpecies());
        } else if (cmd == 5) {
            System.out.println("상태를 확인할 동물을 선택하세요:\n");
            selectList();
            System.out.printf("선택: ");
            Animal animal = zoo.findByIdx(Integer.parseInt(bufferedReader.readLine()) - 1); //0부터 시작하므로
            System.out.printf("%s (%s, %d살) 포만도: %d, 행복도: %d\n", animal.getName(),
                    animal.getSpecies(),
                    animal.getAge(),
                    animal.getHungerFigure(),
                    animal.getHappiness());

        } else if (cmd == 6) {
            System.out.println("울음 소리를 들을 동물을 선택하세요:\n");
            selectList();
            System.out.printf("선택: ");
            Animal animal = zoo.findByIdx(Integer.parseInt(bufferedReader.readLine()) - 1); //0부터 시작하므로
            animal.sound();
        } else {
            System.out.println("먹이를 줄 동물을 선택하세요:\n");
            selectList();
            System.out.printf("선택: ");
            Animal animal = zoo.findByIdx(Integer.parseInt(bufferedReader.readLine()) - 1); //0부터 시작하므로
            animal.feed();
            System.out.printf("%s (%s) 의 포만도 가 1 증가 했습니다\n", animal.getName(), animal.getSpecies());
        }
    }

    public static void main(String[] args) throws IOException {
        while (true) {
            menu();
        }
    }

}