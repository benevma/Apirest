package my.rest.api.db;

import java.util.List;

import my.rest.api.db.bean.DaoInputBean;

public interface IDaoService {
	
	public void insertDb(List<DaoInputBean> inputData);
	
}
