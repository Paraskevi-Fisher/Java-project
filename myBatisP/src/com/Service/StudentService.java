package com.Service;

import com.pojo.PageInfo;

public interface StudentService {
	PageInfo showPage(String sname,String tname,int pageSize,int pageNum);
}
