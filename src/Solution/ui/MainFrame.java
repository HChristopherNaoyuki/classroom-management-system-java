package Solution.ui;

import Solution.model.DataManager;
import javax.swing.*;

/**
 * Main application window
 */
public class MainFrame extends JFrame
{
    private final DataManager dataManager;
    
    public MainFrame()
    {
        dataManager = new DataManager();
        initializeUI();
    }
    
    private void initializeUI()
    {
        setTitle("Classroom Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Teachers", new TeacherPanel(dataManager));
        tabbedPane.addTab("Subjects", new SubjectPanel(dataManager));
        tabbedPane.addTab("Classrooms", new ClassroomPanel(dataManager));
        tabbedPane.addTab("Courses", new CoursePanel(dataManager));
        
        add(tabbedPane);
        
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent)
            {
                dataManager.saveData();
            }
        });
    }
}