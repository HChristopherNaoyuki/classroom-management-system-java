package Solution.ui;

import Solution.model.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for managing classrooms
 */
public class ClassroomPanel extends JPanel
{
    private DataManager dataManager;
    private JTable classroomTable;
    
    public ClassroomPanel(DataManager dataManager)
    {
        this.dataManager = dataManager;
        initializeUI();
    }
    
    private void initializeUI()
    {
        setLayout(new BorderLayout());
        
        // Table setup
        String[] columns = {"ID", "Venue", "Capacity"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        for (Classroom classroom : dataManager.getClassrooms())
        {
            model.addRow(new Object[]{
                classroom.getClassroomID(),
                classroom.getClassroomVenue(),
                classroom.getClassroomCapacity()
            });
        }
        
        classroomTable = new JTable(model);
        add(new JScrollPane(classroomTable), BorderLayout.CENTER);
        
        // Form setup
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField venueField = new JTextField();
        JTextField capacityField = new JTextField();
        
        formPanel.add(new JLabel("Venue:"));
        formPanel.add(venueField);
        formPanel.add(new JLabel("Capacity:"));
        formPanel.add(capacityField);
        
        JButton addButton = new JButton("Add Classroom");
        addButton.addActionListener(e -> addClassroom(venueField, capacityField, model));
        
        formPanel.add(addButton);
        add(formPanel, BorderLayout.SOUTH);
    }
    
    private void addClassroom(JTextField venueField, JTextField capacityField, DefaultTableModel model)
    {
        String venue = venueField.getText().trim();
        String capacityStr = capacityField.getText().trim();
        
        if (venue.isEmpty() || capacityStr.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Venue and Capacity cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try
        {
            int capacity = Integer.parseInt(capacityStr);
            int newId = dataManager.getClassrooms().isEmpty() ? 1 : 
                dataManager.getClassrooms().get(dataManager.getClassrooms().size() - 1).getClassroomID() + 1;
            
            Classroom classroom = new Classroom(newId, venue, capacity);
            dataManager.addClassroom(classroom);
            model.addRow(new Object[]{newId, venue, capacity});
            
            venueField.setText("");
            capacityField.setText("");
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(this, "Capacity must be a number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}