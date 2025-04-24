package weather;

import javax.swing.table.AbstractTableModel;
import java.util.*;

public class ForecastTableModel extends AbstractTableModel {
    private String[] columnNames = {"FechaHora","Precipitación","Temp (°C)","Viento (m/s)","Humedad (%)"};
    private List<String[]> data = new ArrayList<>();

    @Override public int getRowCount() { return data.size(); }
    @Override public int getColumnCount() { return columnNames.length; }
    @Override public String getColumnName(int col) { return columnNames[col]; }
    @Override public Object getValueAt(int row, int col) { return data.get(row)[col]; }

    public void setForecast(String[] times, String[] precip, String[] temp, String[] wind, String[] hum) {
        data.clear();
        int n = Math.min(times.length,
                Math.min(precip.length,
                Math.min(temp.length,
                Math.min(wind.length, hum.length))));
        for (int i = 0; i < n; i++) {
            data.add(new String[]{times[i], precip[i], temp[i], wind[i], hum[i]});
        }
        fireTableDataChanged();
    }
}
