import java.time.LocalDate;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

import javax.swing.JOptionPane;

public class Kalender2 {
	public static void main(String[] args) {
		int year = 0;
		while (true) {
			String input = JOptionPane.showInputDialog("Bitte ein Jahr eingeben: ");

			if (input == null || !input.matches("\\d{4}")) {
				JOptionPane.showMessageDialog(null, "Ungültige Eingabe! Bitte eine 4stellige Zahl eingeben.");
			} else {
				year = Integer.parseInt(input);

				HijrahDate hijriDate = HijrahDate.from(LocalDate.of(year, 1, 1));

				HijrahDate ramadanStart = hijriDate.with(ChronoField.DAY_OF_MONTH, 1).with(ChronoField.MONTH_OF_YEAR,
						9);
				String ramadanStartDate = LocalDate.from(ramadanStart)
						.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

				HijrahDate ramadanEnd = ramadanStart.with(ChronoField.DAY_OF_MONTH, ramadanStart.lengthOfMonth());
				String ramadanEndDate = LocalDate.from(ramadanEnd).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

				JOptionPane.showMessageDialog(null, "\nRamadan im Jahr " + year + "\n\nStart : " + ramadanStartDate
						+ "\nEnde : " + ramadanEndDate + "\n");
				break;
			}
		}
	}
}
