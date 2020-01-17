package mangotech.test1.exception;

import mangotech.test1.payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
    /**
     * Xử lý các ngoại lệ không được khai báo
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAllException(Exception ex, WebRequest request) {
        return new ErrorResponse(500, ex.getLocalizedMessage());
    }

    /**
     * IndexOutOfBoundsException sẽ được xử lý riêng tại đây
     */
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ErrorResponse handleOutOfBoundException(Exception ex, WebRequest request) {
        return new ErrorResponse(400, "Đối tượng không tồn tại");
    }
}
