package Solution.model;

import java.io.Serializable;

/**
 * Represents a Course entity
 */
public class Course implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int courseID;
    private String courseName;
    private String courseDescription;
    
    public Course(int courseID, String courseName, String courseDescription)
    {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }
    
    public int getCourseID()
    {
        return courseID;
    }
    
    public String getCourseName()
    {
        return courseName;
    }
    
    public String getCourseDescription()
    {
        return courseDescription;
    }
}