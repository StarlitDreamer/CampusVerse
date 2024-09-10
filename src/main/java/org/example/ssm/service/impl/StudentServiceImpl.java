package org.example.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.ssm.entity.Student;
import org.example.ssm.service.StudentService;
import org.example.ssm.mapper.StudentMapper;
import org.example.ssm.utils.MD5Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chen3
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2024-09-04 15:30:57
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findByStudentName(String username) {
        Student student = studentMapper.findByStudentName(username);
        return student;
    }

    @Override
    public void register(String username, String password) {
        String md5 = MD5Tool.generateMD5(password);
        studentMapper.add(username, md5);
    }
}




