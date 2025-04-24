/* WeatherStationApp.java */
package weather;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeatherStationGUI extends JFrame {
    private JTextField cityField;
    private JButton updateButton;
    private JTextArea currentArea;
    private JTable forecastTable;
    private ForecastTableModel forecastModel;

    // conceptsCovered: Clases, herencia, colecciones, listeners, GUI con Swing, manejo de excepciones
    public static final String conceptsCovered = "Clases, herencia, colecciones, listeners, GUI con Swing, manejo de excepciones";

    public WeatherStationGUI() {
        setTitle("Estación Meteorológica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        initComponents();
    }

    private void initComponents() {
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Ciudad:"));
        cityField = new JTextField(15);
        topPanel.add(cityField);
        updateButton = new JButton("Actualizar");
        topPanel.add(updateButton);
        add(topPanel, BorderLayout.NORTH);

        currentArea = new JTextArea(5, 40);
        currentArea.setEditable(false);
        add(new JScrollPane(currentArea), BorderLayout.CENTER);

        forecastModel = new ForecastTableModel();
        forecastTable = new JTable(forecastModel);
        add(new JScrollPane(forecastTable), BorderLayout.SOUTH);

        updateButton.addActionListener(e -> onUpdateClicked());
    }

    private void onUpdateClicked() {
        String city = cityField.getText().trim();
        if (city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduce una ciudad.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            WeatherService.update(city);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error actualizando datos: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        }

        // Mostrar tiempo actual
        String precip = WeatherService.getCurrentPrecipitation();
        String temp   = WeatherService.getCurrentTemperature();
        String wind   = WeatherService.getCurrentWind();
        String hum    = WeatherService.getCurrentHumidity();
        currentArea.setText(String.format("Precipitación: %s mm\nTemperatura: %s °C\nViento: %s m/s\nHumedad: %s %%",
            precip, temp, wind, hum));

        // Mostrar previsión
        String[] times   = WeatherService.getForecastTime();
        String[] tPrecip = WeatherService.getForecastPrecipitation();
        String[] tTemp   = WeatherService.getForecastTemperature();
        String[] tWind   = WeatherService.getForecastWind();
        String[] tHum    = WeatherService.getForecastHumidity();
        forecastModel.setForecast(times, tPrecip, tTemp, tWind, tHum);
    }
}