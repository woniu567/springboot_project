package cn.rivamed.dao;

import cn.rivamed.bean.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface NewsDao {

    List<News> getByMap(Map<String,Object> map);

    News getById(Integer id);

    Integer create(News news);

    int update(News news);

    int delete(Integer id);
}
