package in.co.codefury.meetingroombooking.service.exception;

public class AccessDenied extends Exception {
    private String message;
    public AccessDenied(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
