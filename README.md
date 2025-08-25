## Spring 1기 최종 과제: 동물 관리 시스템
#### 1. 프로젝트 설명
* **콘솔 기반**의 동물 관리 시스템
* 동물원에서 여러종의 동물들을 등록및 관리 한다
* 동물은 `이름`, `나이`, `포만도`, `행복도` 를 가진다 
* `먹이주기`, `놀아주기` 시스템이 있다
* 각 동물들은 **고유의 울음**을 가진다

#### 2. 구현방법

`ClassDiagram` 에서 구체적인 계층구조 설명
* `Animal` 클래스 (부모클래스)
  * `name` : 동물의 이름
  * `spesice` : 동물의 종
  * `age` : 동물의 나이
  * `hungerFigure` : 동물의 배고픔 수치
  * `happiness` : 동물의 행복감
  * `생성자`: name, spesice,age 초기화
  * `hungerFigure`,`happiness` 의 `getter`,`setter`
* `Animal` 을 상속받는 하위클래스
  *  `Animal` 에서 상속받은 생성자. 동물의 종 클래스들이 각각 고유의 울음소리메서드를 가짐  
* `Main` 클래스
  *  `Zoo` 클래스에 의존한다 콘솔창을 띄우고 사용자의 입력에 따라 `Zoo` 내부클래스들을 실행시킴
    * 콘솔창을 통해서 숫자를 입력받아 각 행동에 대한 클래스 메서드호출
  ```txt
  //콘솔화면
  === 사용자 메뉴 ===
  1. 모든 동물 조회하기 
  2. 동물 추가하기
  3. 동물 제거하기
  4. 원하는 동물 먹이주기
  5. 원하는 동물 놀아주기
  숫자를 입력하세요: 
  ```
* `Zoo` 클래스 동물관리 클래스
  * `animalRepository`:  `ArrayList` 형태로 업캐스팅으로 모든 동물을 저장하는 데이터베이스
  * `findAnimalKey`: `Animal animal` 매개변수로 `ArrayList` 에서 iter 를 이용해서 `animalRepository` 에서 인덱스 를 찾는다
  * `addAnimal` : `Animal animal` 을 매개변수로 받아서 `animalRepository` 에 추가한다
  * `animalFeed` : idx 를 매개변수로 받고 해당 인덱스의 동물의 배고픔수치를 +1 해준다
  * `animalPlay` : idx 를 매개변수로 받고 해당 인덱스의 동물의 행복감을 +1 해준다
  * `animalSound` : idx 를 매개변수로 받고 해당 인덱스의 `Animal` 인스턴스를 다운캐스탱해서 내부메서드 실행
  * `animalStatus` : idx 를 매개변수로 받고 해당 인덱스의 행복감,배고픔수치,나이를 리턴해준다
