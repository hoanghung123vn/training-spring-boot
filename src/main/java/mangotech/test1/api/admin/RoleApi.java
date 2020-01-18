package mangotech.test1.api.admin;

import mangotech.test1.payload.ApiResponse;
import mangotech.test1.payload.ApiResponseGenerator;
import mangotech.test1.service.role.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/admin")
public class RoleApi {
    @Autowired
    private RoleServiceImpl roleService;

    @GetMapping("/role/{id}")
    public ApiResponse findById(@PathVariable(name = "id") Integer id){
        return ApiResponseGenerator.genSuccessResponse(roleService.findById(id));
    }
}
