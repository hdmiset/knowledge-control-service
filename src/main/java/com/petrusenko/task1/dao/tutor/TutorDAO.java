package com.petrusenko.task1.dao.tutor;

import java.io.Serializable;
import java.util.List;

public interface TutorDAO<K extends Serializable, T> {
	
	    public void updateMath(String[] questions);
	    public void updateRus(String[] questions);
	    public void updatePhysics(String[] questions);
	    public List<String> chooseMath();
	    public List<String> chooseRus();
	    public List<String> choosePhysics();

}
