package Solution.model;

import java.io.Serializable;

/**
 * Represents a Subject entity
 */
public class Subject implements Serializable
{
    private static final long serialVersionUID = 1L;
    private final int subjectID;
    private final String subjectName;
    private final String subjectCode;
    
    public Subject(int subjectID, String subjectName, String subjectCode)
    {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
    }
    
    public int getSubjectID()
    {
        return subjectID;
    }
    
    public String getSubjectName()
    {
        return subjectName;
    }
    
    public String getSubjectCode()
    {
        return subjectCode;
    }
}