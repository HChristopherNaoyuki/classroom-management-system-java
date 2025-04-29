package Solution.ui;

import Solution.model.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 * Panel for managing subjects
 */
public class SubjectPanel extends JPanel
{
    private DataManager dataManager;
    private JTable subjectTable;
    
    public SubjectPanel(DataManager dataManager)
    {
        this.dataManager = dataManager;
        initializeUI();
    }
    
    private void initializeUI()
    {
        setLayout(new BorderLayout());
        
        // Table setup
        String[] columns = {"ID", "Name", "Code"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        
        for (Subject subject : dataManager.getSubjects())
        {
            model.addRow(new Object[]{
                subject.getSubjectID(),
                subject.getSubjectName(),
                subject.getSubjectCode()
            });
        }
        
        subjectTable = new JTable(model);
        add(new JScrollPane(subjectTable), BorderLayout.CENTER);
        
        // Form setup
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        JTextField nameField = new JTextField();
        JTextField codeField = new JTextField();
        
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Code:"));
        formPanel.add(codeField);
        
        JButton addButton = new JButton("Add Subject");
        addButton.addActionListener(e -> addSubject(nameField, codeField, model));
        
        formPanel.add(addButton);
        add(formPanel, BorderLayout.SOUTH);
    }
    
    private void addSubject(JTextField nameField, JTextField codeField, DefaultTableModel model)
    {
        String name = nameField.getText().trim();
        String code = codeField.getText().trim();
        
        if (name.isEmpty() || code.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Name and Code cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int newId = dataManager.getSubjects().isEmpty() ? 1 : 
            dataManager.getSubjects().get(dataManager.getSubjects().size() - 1).getSubjectID() + 1;
        
        Subject subject = new Subject(newId, name, code);
        dataManager.addSubject(subject);
        model.addRow(new Object[]{newId, name, code});
        
        nameField.setText("");
        codeField.setText("");
    }
}