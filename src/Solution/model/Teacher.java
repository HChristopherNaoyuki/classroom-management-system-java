package Solution.model;

import java.io.Serializable;

/**
 * Represents a Teacher entity
 */
public class Teacher implements Serializable
{
    private static final long serialVersionUID = 1L;
    private final int teacherID;
    private final String teacherName;
    private final String teacherDetails;
    
    public Teacher(int teacherID, String teacherName, String teacherDetails)
    {
        this.teacherID = teacherID;
        this.teacherName = teacherName;
        this.teacherDetails = teacherDetails;
    }
    
    public int getTeacherID()
    {
        return teacherID;
    }
    
    public String getTeacherName()
    {
        return teacherName;
    }
    
    public String getTeacherDetails()
    {
        return teacherDetails;
    }
}