package kxg.library.book.provider.mapper;

import kxg.library.book.provider.common.CommonMapper;
import kxg.library.book.provider.pojo.User;

import java.util.List;

public interface UserMapper extends CommonMapper<User> {
    List<User> findAllUserByCondition(User user);
}