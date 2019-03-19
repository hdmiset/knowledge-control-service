package com.petrusenko.task1.dao.question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface QuestionDAO {
	
    public List<List<String>> readMath();
    public List<List<String>> readRus();
    public List<List<String>> readPhysics();
    public List<String> checkMath(List<String> rad);
    public List<String> checkRus(List<String> rad);
    public List<String> checkPhysics(List<String> rad);

}

