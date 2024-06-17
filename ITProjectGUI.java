package RefDefCwk;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Provide a GUI interface for the simulation
 * 
 * @author A.A.Marczyk
 * @version 20/04/24
 */
public class ITProjectGUI 
{
    private BITS mg = new ITProject("Mary",1000);
    private JFrame myFrame = new JFrame("Project GUI");
    private JTextArea listing = new JTextArea();
    private JLabel codeLabel = new JLabel ();
    private JButton listBtn = new JButton("List all Staff");
    private JButton quitBtn = new JButton("Quit");
    private JPanel eastPanel = new JPanel();

    public static void main(String[] args)
    {
        new ITProjectGUI();
    }
    
    
    public ITProjectGUI()
    {
        makeFrame();
        makeMenuBar(myFrame);
        listing.setVisible(true);
    }
    

    /**
     * Create the Swing frame and its content.
     */
    private void makeFrame()
    {    
        myFrame.setLayout(new BorderLayout());
        myFrame.add(listing,BorderLayout.CENTER);

        myFrame.add(eastPanel, BorderLayout.EAST);
        // set panel layout and add components
        eastPanel.setLayout(new GridLayout(6,1));
        eastPanel.add(listBtn);
        eastPanel.add(quitBtn);

        listBtn.addActionListener(new ListHandler());
        quitBtn.addActionListener(new QuitHandler());

        listBtn.setVisible(true);
        quitBtn.setVisible(true);
        // building is done - arrange the components and show        
        myFrame.pack();
        myFrame.setVisible(true);
    }
    
    /**
     * Create the main frame's menu bar.
     */
    private void makeMenuBar(JFrame frame)
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        // create the File menu
        JMenu fileMenu = new JMenu("Jobs");
        menubar.add(fileMenu);
        
        
        JMenuItem view = new JMenuItem("View State of project"); 
        view.addActionListener(new StateHandler());
        fileMenu.add(view);
        
            
    }

// Menu item handlers

    private class StateHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            String result = mg.toString();
            listing.setText(result);

        }
    }
    

// Button handlers
    
    private class ListHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            listing.setVisible(true);
            String xx = mg.getAllAvailableStaff();
            listing.setText(xx);
        }
    }
   
    
    private class QuitHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        { 
            int answer = JOptionPane.showConfirmDialog(myFrame,
                "Are you sure you want to quit?","Finish",
                JOptionPane.YES_NO_OPTION);
            // closes the application
            if (answer == JOptionPane.YES_OPTION)
            {
                System.exit(0); //closes the application
            }              
        }
    }
    

    
}
   
