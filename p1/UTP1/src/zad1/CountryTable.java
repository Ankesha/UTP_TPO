package zad1;


import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class CountryTable extends AbstractTableModel {
    public String countriesFileName;
    private List <Country> CountryList = new ArrayList<>();
    private String columnName [] = new String [4];


    public CountryTable(String countriesFileName) {
        this.countriesFileName=countriesFileName;
    }

    public JTable create() throws IOException {
        FileReader fr = new FileReader(countriesFileName);
        String pom = "";
        int pom2;

        while ((pom2 = fr.read()) != -1) {
            pom += (char) pom2;
        }
        StringTokenizer st = new StringTokenizer(pom, ".");
        for (int i = 0; i < 4; i++){
            columnName[i] = st.nextToken();
        }

        while (st.hasMoreTokens()){
            CountryList.add(new Country(st.nextToken(),st.nextToken(),Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        JTable jTable = new JTable(this){
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column){
                Component c = super.prepareRenderer(renderer, row, column);
                if(column == 2){
                    int populationAbove = Integer.parseInt(getValueAt(row,2).toString());
                    if(populationAbove > 20000) {
                        c.setForeground(Color.RED);
                    } else {
                        c.setForeground(Color.BLACK);
                    }
                }
                return c;
            }
        };
        return jTable;
    }

    @Override
    public int getRowCount() {
        return CountryList.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        return columnName[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIdx) {
        return getValueAt(2,columnIdx).getClass();
    }

    @Override
    public Object getValueAt(int rowIdx, int columnIdx) {
        Country country = CountryList.get(rowIdx);
        if (columnIdx == 0) {
            return country.getName();
        } else if (columnIdx == 1) {
            return country.getCapital();
        } else if (columnIdx == 2) {
            return country.getPopulation();
        } else if (columnIdx == 3) {
            return country.getFlag();
        } else {
            return null;
        }
    }

}
