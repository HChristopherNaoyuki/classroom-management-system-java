package Solution.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages data persistence for the application
 */
public class DataManager
{
    private static final String DATA_FILE = "classroom_data.ser";
    private List<Teacher> teachers = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();
    private List<Classroom> classrooms = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    
    public DataManager()
    {
        loadData();
    }
    
    @SuppressWarnings("unchecked")
    private void loadData()
    {
        File file = new File(DATA_FILE);
        if (!file.exists())
        {
            return;
        }
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)))
        {
            teachers = (List<Teacher>) ois.readObject();
            subjects = (List<Subject>) ois.readObject();
            classrooms = (List<Classroom>) ois.readObject();
            courses = (List<Course>) ois.readObject();
        }
        catch (Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(
                null, 
                "Error loading data: " + e.getMessage(),
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void saveData()
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE)))
        {
            oos.writeObject(teachers);
            oos.writeObject(subjects);
            oos.writeObject(classrooms);
            oos.writeObject(courses);
        }
        catch (Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(
                null, 
                "Error saving data: " + e.getMessage(),
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public List<Teacher> getTeachers()
    {
        return teachers;
    }
    
    public void addTeacher(Teacher teacher)
    {
        teachers.add(teacher);
    }
    
    public List<Subject> getSubjects()
    {
        return subjects;
    }
    
    public void addSubject(Subject subject)
    {
        subjects.add(subject);
    }
    
    public List<Classroom> getClassrooms()
    {
        return classrooms;
    }
    
    public void addClassroom(Classroom classroom)
    {
        classrooms.add(classroom);
    }
    
    public List<Course> getCourses()
    {
        return courses;
    }
    
    public void addCourse(Course course)
    {
        courses.add(course);
    }
}