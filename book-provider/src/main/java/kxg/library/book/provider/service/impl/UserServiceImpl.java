package kxg.library.book.provider.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import kxg.library.book.dto.UserDto;
import kxg.library.book.provider.dao.UserDao;
import kxg.library.book.provider.pojo.User;
import kxg.library.book.provider.service.UserService;
import kxg.library.book.request.AddUserRequest;
import kxg.library.book.request.FindAllUserRequest;
import kxg.library.book.request.LoginRequest;
import kxg.library.book.request.UpdateUserRequest;
import kxg.library.book.response.FindAllUserResponse;
import kxg.library.book.response.IntegerResultResponse;
import kxg.library.book.response.LoginResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 要写注释呀
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public IntegerResultResponse addUser(AddUserRequest request) {
        IntegerResultResponse response=new IntegerResultResponse();
        User user=new User();
        BeanUtils.copyProperties(request,user);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        Integer result = userDao.addUser(user);
        response.setEnd(result);
        return response;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        LoginResponse response=new LoginResponse();
        List<User> login = userDao.login(request.getPhoneNumber(), request.getPassword());
        if (CollectionUtils.isEmpty(login)){
            throw new RuntimeException("请检查用户名和密码");
        }
        BeanUtils.copyProperties(login.get(0),response);
        return response;
    }

    @Override
    public IntegerResultResponse updateUser(UpdateUserRequest request) {
        IntegerResultResponse response=new IntegerResultResponse();
        User user=new User();
        BeanUtils.copyProperties(request,user);
        user.setUpdateTime(new Date());
        Integer result = userDao.updateUser(user);
        response.setEnd(result);
        return response;
    }

    @Override
    public FindAllUserResponse findUser(FindAllUserRequest request) {
        FindAllUserResponse response=new FindAllUserResponse();
        User user=new User();
        BeanUtils.copyProperties(request,user);
        PageHelper.startPage(request.getPageNumber(),request.getPageSize());
        List<User> userDaoUser = userDao.findUser(user);
        PageInfo<User> pageInfo=new PageInfo<>(userDaoUser);
        List<UserDto> userDtoList = pageInfo.getList().stream().map(new Function<User, UserDto>() {
            @Override
            public UserDto apply(User user) {
                UserDto userDto = new UserDto();
                BeanUtils.copyProperties(user, userDto);
                return userDto;
            }
        }).collect(Collectors.toList());
        response.setData(userDtoList);
        response.setTotals(pageInfo.getTotal());
        return response;
    }

    @Override
    public IntegerResultResponse deleteUser(Long id) {
        IntegerResultResponse response=new IntegerResultResponse();
        Integer result=userDao.delete(id);
        response.setEnd(result);
        return response;
    }
}
