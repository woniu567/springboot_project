package cn.rivamed.dao;

import cn.rivamed.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserDao {

    List<User> getByMap(Map<String,Object> map);

    User getById(Integer id);

    Integer create(User user);

    int delete(Integer id);
}
