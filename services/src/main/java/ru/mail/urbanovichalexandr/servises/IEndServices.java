package ru.mail.urbanovichalexandr.servises;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ru.mail.urbanovichalexandr.datamodel.End;

public interface IEndServices {

	End get(Integer studentId);
	
	 @Transactional
	 void save(End end);
	 
	 @Transactional
	 void saveMultiple(End...end);
	 
	 List<End> getAll();
	 
	 @Transactional
	 void delete(Integer studentId);
}
