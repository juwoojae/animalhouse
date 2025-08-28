import service.Service;
import service.ServiceImp;
import service.Validator;

import java.io.IOException;

class Main{
    public static void main(String[] args) throws IOException {
       Service service = new ServiceImp();
       while(true){
           service.menu(service.command());
       }
    }
}