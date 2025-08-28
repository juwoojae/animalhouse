package exception;
//데이터 테이블을 조회하려는데 데이터 테이블이 없을때 발생하는 에러
public class NoDataFoundException extends Exception {
    public NoDataFoundException (String message) {
        super(message);
    }
}
