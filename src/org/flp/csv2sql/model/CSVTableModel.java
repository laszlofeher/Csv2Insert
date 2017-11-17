/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.csv2sql.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author feherlaszlo
 */
public class CSVTableModel extends AbstractTableModel{
    
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    private ArrayList<String> fieldsName = new ArrayList();
    public CSVTableModel() {
    }
    
    public CSVTableModel(ArrayList<ArrayList<String>> data) {
        this.data = data;
    }
    
    
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return maxColumnCount();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(columnIndex < this.data.get(rowIndex).size()){
            return this.data.get(rowIndex).get(columnIndex);
        }
        return "";
    }
    
    private int maxColumnCount(){
        int max = 0;
        for (int i = 0; i < this.data.size(); i++) {
            if(max< this.data.get(i).size()){
                max = this.data.get(i).size();
            }
            
        }
        return max;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if(columnIndex < this.fieldsName.size()){
            this.fieldsName.get(columnIndex);
        }
        return "";
    }
    
    
    public void addFieldName(String fieldName){
        this.fieldsName.add(fieldName);
        this.fireTableStructureChanged();
    }
    
    public void removeFieldName(int index){
        if(index < this.fieldsName.size()){
            this.fieldsName.remove(index);
        }
        this.fireTableStructureChanged();
    }
    
    //setters getters

    public ArrayList<ArrayList<String>> getData() {
        return data;
    }

    public void setData(ArrayList<ArrayList<String>> data) {
        this.data = data;
    }
    
    
}
