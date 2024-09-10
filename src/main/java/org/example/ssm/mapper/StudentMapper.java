package org.example.ssm.mapper;

import org.apache.ibatis.annotations.*;
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
    void add(@Param("username") String username, @Param("password") String password);

    @Update("update student set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id=#{id}")
    void update(Student student);

    @Update("update student set user_pic=#{avatarUrl},update_time=now() where id=#{id}")
    void updateAvatar(@Param("avatarUrl") String avatarUrl,@Param("id") Integer id);
}




