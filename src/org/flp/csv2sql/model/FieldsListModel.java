/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.csv2sql.model;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author feherlaszlo
 */
public class FieldsListModel extends AbstractListModel{
    ArrayList<String> fieldsNames = new ArrayList();
    @Override
    public int getSize() {
        return fieldsNames.size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.fieldsNames.get(i);
    }

    public ArrayList<String> getFieldsNames() {
        return fieldsNames;
    }

    public void addItem(String s){
        this.fieldsNames.add(s);
        this.fireIntervalAdded(this, 0, this.fieldsNames.size());
    }

    public void removeItem(int index){
        this.fieldsNames.remove(index);
        this.fireIntervalRemoved(this, 0, this.fieldsNames.size());
    }
}