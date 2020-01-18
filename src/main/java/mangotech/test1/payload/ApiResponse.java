package mangotech.test1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class ApiResponse {
    private int statusCode;
    private String message;
    private Object data;
    public ApiResponse(int statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
    }
}
