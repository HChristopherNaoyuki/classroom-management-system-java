package Solution;

import Solution.ui.MainFrame;

/**
 * Main entry point for the Classroom Management System
 */
public class Solution
{
    public static void main(String[] args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    new MainFrame().setVisible(true);
                }
                catch (Exception e)
                {
                    javax.swing.JOptionPane.showMessageDialog(
                        null, 
                        "Failed to initialize application: " + e.getMessage(),
                        "Error", 
                        javax.swing.JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }
}