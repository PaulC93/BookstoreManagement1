import javax.swing.*;

import java.awt.*;

/**
 * Builds a table with the following properties: name, columns names and data, just for visualisation, the data can't be modified.
 * Offers methods to show the table in a window and close the window.
 * @author Paul Calean
 */
@SuppressWarnings("serial")
public class Table extends JPanel {
   
    private JFrame frame;
    
    /**
     *Builds a table with the specified properties
     * @param tableName the name of the table
     * @param columnsNames the names of the table's columns
     * @param data the data to be displayed in the table
     */
    public Table(String tableName, String[] columnsNames, Object[][] data) {
        super(new GridLayout(1,0));
        
        frame=new JFrame(tableName);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setOpaque(true); //content panes must be opaque
        frame.setContentPane(this);	
        frame.setLocationRelativeTo(null);
        final JTable table = new JTable(data,columnsNames);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }
    
    /**
     * Shows the window that contains the table.
     */
   public void display() {       
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }    
   /**
    * Closes the window containing the table
    */
   public void close()
   {
	   frame.setVisible(false);
	   frame.dispose();
   }
}
