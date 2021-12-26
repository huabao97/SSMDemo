package com.kg.controller;

import com.kg.domain.Student;
import com.kg.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    /**
     声明引用类型， 调用引用类型的业务方法
     引用类型自动注入  @Autowired, @Resource
     */
    @Resource
    private StudentService studentService;
    @RequestMapping(value="/addStudent.do")
    public ModelAndView addStudent(Student student){
        ModelAndView mv=new ModelAndView();
        int row=studentService.addStudent(student);
        String msg="注册失败！！！";
        if(row > 0 ){
            //注册成功， 给用户成功的数据和视图
            msg = "注册成功的";
        }
        mv.addObject("msg", student.getName()+"," + msg);
        mv.setViewName("result");
        return mv;
    }

    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudent(){
        return studentService.queryAllStudent();
    }
}
