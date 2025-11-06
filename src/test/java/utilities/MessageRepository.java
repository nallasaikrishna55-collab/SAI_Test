package utilities;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageRepository {

    @Value("${login.invalid}")
    protected String invalidLoginCred;

    @Value("${account.Created}")
    protected  String accCreatedMsg;


    public String getInvalidLoginCred() {
        return invalidLoginCred;
    }

    public String getAccCreatedMsg() {
        return accCreatedMsg;
    }
}
