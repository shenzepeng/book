package kxg.library.book.provider.service;

import kxg.library.book.request.AddUserRequest;
import kxg.library.book.request.FindAllUserRequest;
import kxg.library.book.request.LoginRequest;
import kxg.library.book.request.UpdateUserRequest;
import kxg.library.book.response.FindAllUserResponse;
import kxg.library.book.response.IntegerResultResponse;
import kxg.library.book.response.LoginResponse;

/**
 * 要写注释呀
 */
public interface UserService {
    IntegerResultResponse addUser(AddUserRequest request);
    LoginResponse login(LoginRequest request);
    IntegerResultResponse updateUser(UpdateUserRequest request);
    FindAllUserResponse findUser(FindAllUserRequest request);
    IntegerResultResponse deleteUser(Long id);
}
