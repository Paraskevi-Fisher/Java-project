package com.Service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.Mapper.StudentMapper;
import com.Mapper.TeacherMapper;
import com.pojo.PageInfo;
import com.pojo.Student;
import com.util.MyBatisUtil;

public class StudentServiceImpl implements StudentService{

	@Override
	public PageInfo showPage(String sname, String tname, int pageSize,
			int pageNum) {
		SqlSession session=MyBatisUtil.getSession();
		StudentMapper studentMapper = session.getMapper(StudentMapper.class);
		TeacherMapper teacherMapper = session.getMapper(TeacherMapper.class);
		
		PageInfo pi = new PageInfo();
		pi.setPageNumber(pageNum);
		pi.setPageSize(pageSize);
		pi.setPageStart((pageNum-1)*pageSize);
		pi.setSname(sname);
		pi.setTname(tname);
		List<Student>list = studentMapper.selByPage(pi);
		for (Student i : list)
		{
			i.setTeacher(teacherMapper.selById(i.getTid()));
		}
		pi.setList(list);
		long count = studentMapper.selCountByPageInfo(pi);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}

}
