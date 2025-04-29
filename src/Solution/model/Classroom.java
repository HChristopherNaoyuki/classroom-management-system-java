package Solution.model;

import java.io.Serializable;

/**
 * Represents a Classroom entity
 */
public class Classroom implements Serializable
{
    private static final long serialVersionUID = 1L;
    private int classroomID;
    private String classroomVenue;
    private int classroomCapacity;
    
    public Classroom(int classroomID, String classroomVenue, int classroomCapacity)
    {
        this.classroomID = classroomID;
        this.classroomVenue = classroomVenue;
        this.classroomCapacity = classroomCapacity;
    }
    
    public int getClassroomID()
    {
        return classroomID;
    }
    
    public String getClassroomVenue()
    {
        return classroomVenue;
    }
    
    public int getClassroomCapacity()
    {
        return classroomCapacity;
    }
}