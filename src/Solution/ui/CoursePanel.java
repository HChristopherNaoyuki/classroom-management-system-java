package Solution.ui;

import Solution.model.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for managing courses
 */
public class CoursePanel extends JPanel
{
    private DataManager dataManager;
    private JTable courseTable;
    
    public CoursePanel(DataManager dataManager)
    {
        this.dataManager = dataManager;
        initializeUI();
    }
    
    private void initializeUI()
    {
        setLayout(new BorderLayout());
        
        // Table setup
        String[] columns = {"ID", "Name", "Description"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        for (Course course : dataManager.getCourses())
        {
            model.addRow(new Object[]{
                course.getCourseID(),
                course.getCourseName(),
                course.getCourseDescription()
            });
        }
        
        courseTable = new JTable(model);
        add(new JScrollPane(courseTable), BorderLayout.CENTER);
        
        // Form setup
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField nameField = new JTextField();
        JTextField descField = new JTextField();
        
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Description:"));
        formPanel.add(descField);
        
        JButton addButton = new JButton("Add Course");
        addButton.addActionListener(e -> addCourse(nameField, descField, model));
        
        formPanel.add(addButton);
        add(formPanel, BorderLayout.SOUTH);
    }
    
    private void addCourse(JTextField nameField, JTextField descField, DefaultTableModel model)
    {
        String name = nameField.getText().trim();
        String desc = descField.getText().trim();
        
        if (name.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int newId = dataManager.getCourses().isEmpty() ? 1 : 
            dataManager.getCourses().get(dataManager.getCourses().size() - 1).getCourseID() + 1;
        
        Course course = new Course(newId, name, desc);
        dataManager.addCourse(course);
        model.addRow(new Object[]{newId, name, desc});
        
        nameField.setText("");
        descField.setText("");
    }
}