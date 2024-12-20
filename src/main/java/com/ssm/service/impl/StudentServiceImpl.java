package com.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssm.entity.Student;
import com.ssm.mapper.StudentMapper;
import com.ssm.service.StudentService;
import com.ssm.utils.MD5Tool;
import com.ssm.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

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

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        studentMapper.updateAvatar(avatarUrl,id);
    }

    @Override
    public void updatePwd(String newPwd) {
        Map<String, Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        studentMapper.updatePwd(MD5Tool.generateMD5(newPwd),id);
    }
}




