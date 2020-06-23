package kxg.library.book.provider.controller;

import kxg.library.book.provider.config.SzpJsonResult;
import kxg.library.book.provider.service.UserService;
import kxg.library.book.request.AddUserRequest;
import kxg.library.book.request.FindAllUserRequest;
import kxg.library.book.request.LoginRequest;
import kxg.library.book.request.UpdateUserRequest;
import kxg.library.book.response.FindAllUserResponse;
import kxg.library.book.response.IntegerResultResponse;
import kxg.library.book.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 要写注释呀
 */
@RestController
@RequestMapping("add")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("add")
    public SzpJsonResult<IntegerResultResponse> add(@RequestBody AddUserRequest request){
        return SzpJsonResult.ok(userService.addUser(request));
    }
    @PostMapping("login")
    public SzpJsonResult<LoginResponse> login(@RequestBody LoginRequest request){
        return SzpJsonResult.ok(userService.login(request));
    }
    @PutMapping("update")
    public SzpJsonResult<IntegerResultResponse> updateUser(@RequestBody UpdateUserRequest request){
        return SzpJsonResult.ok(userService.updateUser(request));
    }
    @PostMapping("search")
    public SzpJsonResult<FindAllUserResponse> findUser(@RequestBody FindAllUserRequest request){
        return SzpJsonResult.ok(userService.findUser(request));
    }
    @DeleteMapping("delete/{id}")
    public SzpJsonResult<IntegerResultResponse> delete(@PathVariable("id") Long id){
        return SzpJsonResult.ok(userService.deleteUser(id));
    }

}
