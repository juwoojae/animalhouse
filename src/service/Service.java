package service;

import domain.Animal;

import java.io.IOException;

public interface Service {
    void selectList();//동물의 목록 조회 메서드
    Animal selectAnimal() throws IOException; //동물의 목록 조회 메서드
    int command() throws IOException; //command 를 입력 받는 메서드
    void menu(int cmd) throws IOException; //사용자 메뉴 콘솔 화면 cmd 를 받아서 처리하는 메서드
}
