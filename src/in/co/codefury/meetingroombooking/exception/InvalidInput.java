package in.co.codefury.meetingroombooking.exception;


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
