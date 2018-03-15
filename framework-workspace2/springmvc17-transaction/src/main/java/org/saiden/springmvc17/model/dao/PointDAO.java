package org.saiden.springmvc17.model.dao;

import org.saiden.springmvc17.model.vo.PointVO;

public interface PointDAO {
	PointVO findPointById(String id);
	void register(PointVO pvo);
}
