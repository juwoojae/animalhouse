package exception;
//입력값이 프로그램이 제어하는 인덱스의 범위를 벗어나는 경우
public class InputOutofRangeException extends Exception {
    public InputOutofRangeException(String message) {
        super(message);
    }
}
