package com.mapper;

import java.util.List;

import pojo.flower;

public interface FlowerMapper {
	List<flower> selAll();
	List<flower> selOne();
	flower selById(int id);
	List<flower> selByFlower(flower f);
}
