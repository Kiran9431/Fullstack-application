public class Response {
    private int status;
    private String message;
    private String errorMessage;


    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

	public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

