package org.example.ssm.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.ssm.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @author chen3
 * @description 针对表【student】的数据库操作Mapper
 * @createDate 2024-09-04 15:30:57
 * @Entity org.example.ssm.entity.Student
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select("select * from student where username = #{username}")
    Student findByStudentName(@Param("username") String username);

    @Insert("insert into student(username, password,create_time,update_time) values(#{username}, #{password},now(),now())")
    void add(@Param("username")String username, @Param("password") String password);
}




