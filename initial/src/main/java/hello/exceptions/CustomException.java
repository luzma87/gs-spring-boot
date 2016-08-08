package hello.exceptions;

import javax.servlet.http.HttpServletResponse;

public class CustomException extends Exception {
    public CustomException(HttpServletResponse response, String message) {
        super(message);
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
}
