package jface.model;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

/**
 * 
 * @author SZabara
 *  this class will be use, if we wil be need some sorting in the table.
 */
public class PersonFilter extends ViewerFilter {

    private String searchString;

    public void setSearchText(String s) {
        // ensure that the value can be used for matching
        this.searchString = ".*" + s + ".*";
    }

    @Override
    public boolean select(Viewer viewer,
            Object parentElement,
            Object element) {
        if (searchString == null || searchString.length() == 0) {
            return true;
        }
        Person p = (Person) element;
        if (p.getName().matches(searchString)) {
            return true;
        }
        if (String.valueOf(p.getGroup()).matches(searchString)) {
            return true;
        }

        return false;
    }
}
