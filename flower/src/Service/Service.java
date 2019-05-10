package Service;

import java.util.List;

import dao.FlowerDao;
import dao.FlowerDaoImpl;
import pojo.flower;

public class Service {
	public List<flower> show(){
		FlowerDao fdDao = new FlowerDaoImpl();
		return fdDao.selAll();
	}
}
