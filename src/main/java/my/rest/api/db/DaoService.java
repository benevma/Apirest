package my.rest.api.db;

import java.util.List;

import my.rest.api.db.bean.DaoInputBean;

public class DaoService implements IDaoService {

	public void insertDb(List<DaoInputBean> inputData) {
		if(inputData!=null){
			for(DaoInputBean in : inputData){
				System.out.println("File Name "+in.getFileName());
				if(in.getAnalize()!=null && in.getAnalize().getData()!=null)
					System.out.println("insert data to db "+in.getAnalize().getData().toString());//prepare statement
				if(in.getCategorize()!=null && in.getCategorize().getData()!=null)
					System.out.println("insert data to db "+in.getCategorize().getData().toString());//prepare statement
			}
		}
	}

}
