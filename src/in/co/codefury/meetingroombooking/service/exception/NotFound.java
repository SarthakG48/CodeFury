package in.co.codefury.meetingroombooking.service.exception;

//generic not found exception can be used for any entity
public class NotFound extends Exception {
    
    private String message;
    public NotFound(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
    
    
}
