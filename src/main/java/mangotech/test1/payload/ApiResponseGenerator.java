package mangotech.test1.payload;

import mangotech.test1.config.Const;
import org.springframework.http.HttpStatus;

/**
 * Generate Api response
 */
public class ApiResponseGenerator {
    // Generate success response
    public static  ApiResponse genSuccessResponse(Object data){
        return new ApiResponse(HttpStatus.OK.value(), Const.SUCCESS_MESSAGE, data);
    }
    // Generate fail response
    public static ApiResponse genSuccessResponse(){
        return new ApiResponse(HttpStatus.OK.value(), Const.FAIL_MESSAGE);
    }
}
