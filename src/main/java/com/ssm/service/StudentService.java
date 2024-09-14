package com.ssm.service;

import com.ssm.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author chen3
* @description 针对表【student】的数据库操作Service
* @createDate 2024-09-04 15:30:57
*/
public interface StudentService extends IService<Student> {

    Student findByStudentName(String username);

    void register(String username, String password);

    void update(Student student);

    void updateAvatar(String avatarUrl);

    void updatePwd(String newPwd);
}
