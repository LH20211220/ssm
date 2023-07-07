package com.lh.ssm.mapper;

import com.lh.ssm.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserInfoMapper {

    /**
     * 增加一条数据
     * @param userInfo 数据
     */
    void add(User userInfo);

    /**
     * 删除一条数据
     * @param id 被删除数据的id
     */
    void delete(Integer id);

    /**
     * 修改一条数据
     * @param userInfo 修改的数据
     */
    void update(User userInfo);

    /**
     * 根据id去查询一条数据
     * @param id 查询的id
     */
    User queryById(Integer id);

    /**
     * 查询全部数据
     * @return
     */
    List<User> queryAll();
}

