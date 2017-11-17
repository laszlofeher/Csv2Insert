/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.flp.csv2sql.parser;

import java.util.ArrayList;

/**
 *
 * @author feherlaszlo
 */
public interface SQLGenerator {
    public void setFields(ArrayList<String> fields);
    public ArrayList<String> getFields();
    public void setData(ArrayList<ArrayList<String>> data);
    public String generateSQL();
}
