package Solution.ui;

import Solution.model.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for managing teachers
 */
public class TeacherPanel extends JPanel
{
    private DataManager dataManager;
    private JTable teacherTable;
    
    public TeacherPanel(DataManager dataManager)
    {
        this.dataManager = dataManager;
        initializeUI();
    }
    
    private void initializeUI()
    {
        setLayout(new BorderLayout());
        
        // Table setup
        String[] columns = {"ID", "Name", "Details"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        for (Teacher teacher : dataManager.getTeachers())
        {
            model.addRow(new Object[]{
                teacher.getTeacherID(),
                teacher.getTeacherName(),
                teacher.getTeacherDetails()
            });
        }
        
        teacherTable = new JTable(model);
        add(new JScrollPane(teacherTable), BorderLayout.CENTER);
        
        // Form setup
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField nameField = new JTextField();
        JTextField detailsField = new JTextField();
        
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Details:"));
        formPanel.add(detailsField);
        
        JButton addButton = new JButton("Add Teacher");
        addButton.addActionListener(e -> addTeacher(nameField, detailsField, model));
        
        formPanel.add(addButton);
        add(formPanel, BorderLayout.SOUTH);
    }
    
    private void addTeacher(JTextField nameField, JTextField detailsField, DefaultTableModel model)
    {
        String name = nameField.getText().trim();
        String details = detailsField.getText().trim();
        
        if (name.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int newId = dataManager.getTeachers().isEmpty() ? 1 : 
            dataManager.getTeachers().get(dataManager.getTeachers().size() - 1).getTeacherID() + 1;
        
        Teacher teacher = new Teacher(newId, name, details);
        dataManager.addTeacher(teacher);
        model.addRow(new Object[]{newId, name, details});
        
        nameField.setText("");
        detailsField.setText("");
    }
}