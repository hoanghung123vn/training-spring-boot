package mangotech.test1.exception;

/**
 * Xử lý ngoại lệ không tìm thấy tài nguyên.
 */
public class ResourceNotFoundException extends RuntimeException {
    ResourceNotFoundException(String message){
        super(message);
    }

    ResourceNotFoundException(String message, Throwable cause){
        super(message, cause);
    }
}
