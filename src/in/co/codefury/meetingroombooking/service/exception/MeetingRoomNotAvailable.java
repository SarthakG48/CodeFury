package in.co.codefury.meetingroombooking.service.exception;

public class MeetingRoomNotAvailable extends Exception {
    private String message;
    public MeetingRoomNotAvailable(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
