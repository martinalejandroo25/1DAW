package weather;

import javax.swing.SwingUtilities;

public class WeatherStationApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WeatherStationGUI().setVisible(true));
    }
}