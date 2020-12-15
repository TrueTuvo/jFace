package vogella.jface.tableviewer.edit;



import org.eclipse.jface.viewers.TableViewer;

import jface.model.Person;


public class GroupEditingSupport extends NameEditingSupport {

    private final TableViewer viewer;

    public GroupEditingSupport(TableViewer viewer) {
        super(viewer);
        this.viewer = viewer;
    }

    @Override
    protected Object getValue(Object element) {
        return ((Person) element).getGroup();
    }

    @Override
    protected void setValue(Object element, Object value) {
        ((Person) element).setGroup(Integer.parseInt(value.toString()));
        viewer.update(element, null);
    }
}
