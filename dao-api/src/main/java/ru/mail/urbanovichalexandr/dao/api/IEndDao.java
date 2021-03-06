package ru.mail.urbanovichalexandr.dao.api;

import java.util.List;

import ru.mail.urbanovichalexandr.datamodel.End;

public interface IEndDao {
	
	End get(Integer endId);
	
	End insert(End end);
	
	void update(End end);
	
	List<End> getAll();
	
	void delete(Integer end);


}
