package kxg.library.book.provider.dao;

import kxg.library.book.provider.mapper.UserMapper;
import kxg.library.book.provider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 要写注释呀
 */
@Repository
public class UserDao {
    @Autowired
    private UserMapper userMapper;

    public List<User> findUser(User user){
        return userMapper.findAllUserByCondition(user);
    }
}
