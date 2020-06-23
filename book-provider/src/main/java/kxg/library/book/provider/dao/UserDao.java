package kxg.library.book.provider.dao;

import kxg.library.book.provider.mapper.UserMapper;
import kxg.library.book.provider.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

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

    public Integer addUser(User user){
        return userMapper.insert(user);
    }

    public Integer updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public List<User> login(String phoneNumber,String password){
        Example example=new Example(User.class);
        example.createCriteria()
                .andEqualTo("phoneNumber",phoneNumber)
                .andEqualTo("password",password);
        return userMapper.selectByExample(example);
    }


    public Integer addUserList(List<User> users){
        return userMapper.insertList(users);
    }


    public Integer delete(Long id){
        return userMapper.deleteByPrimaryKey(id);
    }
}
