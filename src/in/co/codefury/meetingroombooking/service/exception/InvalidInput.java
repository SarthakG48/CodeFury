package in.co.codefury.meetingroombooking.service.exception;


//e.g. invalid input
public class InvalidInput extends Exception {
    private String message;
    public InvalidInput(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
