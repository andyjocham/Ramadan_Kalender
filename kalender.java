import java.time.LocalDate;
import java.time.Month;
import java.time.chrono.HijrahChronology;
import java.time.chrono.HijrahDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

import javax.swing.JOptionPane;

public class kalender {

    public static void main(String[] args) {
	int jahr = 0;
	while (true) {

	    String eingabe = JOptionPane.showInputDialog("Bitte ein Jahr eingeben: ");

	    // abfrage noch aufteilen damit bei abbrechen auch abgebrochen wird
	    if (eingabe == null || !eingabe.matches("\\d{4}")) {
		JOptionPane.showMessageDialog(null, "Ungültige Eingabe! Bitte eine 4stellige Zahl eingeben.");
	    } else {
		jahr = Integer.parseInt(eingabe);

		HijrahDate hijrahDate = HijrahChronology.INSTANCE.date(LocalDate.of(jahr, Month.JANUARY, 1));

		HijrahDate ramadan = hijrahDate.with(ChronoField.DAY_OF_MONTH, 1).with(ChronoField.MONTH_OF_YEAR, 9);

		String ramadanstart = LocalDate.from(ramadan).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
		LocalDate ramadanend = LocalDate.from(ramadan.with(TemporalAdjusters.lastDayOfMonth()));
		String ramadanende = LocalDate.from(ramadanend).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

		JOptionPane.showMessageDialog(null,
			"\nRamadan im Jahr " + jahr + "\n\nStart : " + ramadanstart + "\nEnde : " + ramadanende + "\n");
		break;
	    }
	}
    }
}
// git test von zuhause, eclipse neu aufgesetzt