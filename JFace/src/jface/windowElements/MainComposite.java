package jface.windowElements;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class MainComposite extends Composite{
    
    
    private Table table;
    private TableViewer tableViewer;
    private Button closeButton;
    
    private final String NAME_COLUMN     = "Name";
    private final String GROUP_COLUMN   = "Group";
    private final String SWT_DONE_COLUMN       = "SWT Done";
    
    // Set column names
    private String[] columnNames = new String[] { 
            NAME_COLUMN, 
            GROUP_COLUMN,
            SWT_DONE_COLUMN,
        };

    public MainComposite(Composite parent, int style) {
        super(parent, style);
        Label separator = new Label(this, SWT.VERTICAL | SWT.SEPARATOR);
        separator.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        
    }
    
    /**
     * Create the Table
     */
//    private void createTable(Composite parent) {
//      int style = SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | 
//            SWT.FULL_SELECTION | SWT.HIDE_SELECTION;
//
//      final int NUMBER_COLUMNS = 4;
//
//      table = new Table(parent, style);
//      
//      GridData gridData = new GridData(GridData.FILL_BOTH);
//      gridData.grabExcessVerticalSpace = true;
//      gridData.horizontalSpan = 3;
//      table.setLayoutData(gridData);    
//            
//      table.setLinesVisible(true);
//      table.setHeaderVisible(true);
//
//      // 1st column with image/checkboxes - NOTE: The SWT.CENTER has no effect!!
//      TableColumn column = new TableColumn(table, SWT.CENTER, 0);   
//      column.setText("!");
//      column.setWidth(20);
//      
//      // 2nd column with task Description
//      column = new TableColumn(table, SWT.LEFT, 1);
//      column.setText("Description");
//      column.setWidth(400);
//      // Add listener to column so tasks are sorted by description when clicked 
//    }

}
