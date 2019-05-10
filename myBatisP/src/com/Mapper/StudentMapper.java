package com.Mapper;

import java.util.List;

import com.pojo.PageInfo;
import com.pojo.Student;

public interface StudentMapper {
	List<Student>selByPage(PageInfo pi);
	long selCountByPageInfo(PageInfo pi);
}
