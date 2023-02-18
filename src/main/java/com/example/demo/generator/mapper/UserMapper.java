package com.example.demo.generator.mapper;

import com.example.demo.generator.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-02-12 20:21:20
* @Entity com.example.demo.generator.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




