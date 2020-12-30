import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class DateMerger {
	public static void main(String[] args) throws Exception {

		// Taking input and adding to arrayList
		ArrayList<DateRange> list = new ArrayList<DateRange>();
		DateRange dateRange1 = new DateRange("01/01/2014", "30/01/2014");
		DateRange dateRange2 = new DateRange("15/01/2014", "15/02/2014");
		DateRange dateRange3 = new DateRange("10/03/2014", "15/04/2014");
		DateRange dateRange4 = new DateRange("10/04/2014", "15/05/2014");

		list.add(dateRange1);
		list.add(dateRange2);
		list.add(dateRange3);
		list.add(dateRange4);

		list = mergeDates(list); // Calling a mergeDates method and storing result into list.
		// Printing mergedDate final Result.
		for (DateRange d : list) {
			System.out.println(d.startDate + " - " + d.endDate);
		}
	}

	// method for merge data
	public static ArrayList<DateRange> mergeDates(ArrayList<DateRange> dateRanges) throws Exception {

		ArrayList<Date> keySetStartDate = new ArrayList<Date>();
		ArrayList<Date> valueSetEndDate = new ArrayList<Date>();
		for (DateRange d : dateRanges) {
			Date startDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(d.startDate);
			keySetStartDate.add(startDate1); // seprating start date and adding to arrayList.

			Date endDate1 = new SimpleDateFormat("dd/MM/yyyy").parse(d.endDate);
			valueSetEndDate.add(endDate1); // seprating end date and adding to arrayList.

		}

		ArrayList<DateRange> dateRanges2 = new ArrayList<DateRange>(); // For store final result.
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy");

		for (int i = 0; i < keySetStartDate.size() - 1; i++) {
			Date key1 = (Date) keySetStartDate.get(i + 1);
			Date value1 = (Date) valueSetEndDate.get(i);
			if (key1.before(value1)) { // checking start date and endDate before or after.

				String startDateStr = dateFormat.format((Date) (keySetStartDate.get(i))); // converting date to string
				String endDateStr = dateFormat.format((Date) (valueSetEndDate.get(i + 1)));
				DateRange dateRange1 = new DateRange(startDateStr, endDateStr);
				dateRanges2.add(dateRange1); // adding result to list.

			} else if (key1.equals(value1)) {

				// logic for startDate and endDate are equal.
				String startDateStr = dateFormat.format((Date) (keySetStartDate.get(i))); // converting date to string
				String endDateStr = dateFormat.format((Date) (valueSetEndDate.get(i + 1)));
				DateRange dateRange2 = new DateRange(startDateStr, endDateStr);
				dateRanges2.add(dateRange2); // adding result to list.

			}

		}

		return dateRanges2; // returning a mergedate list.
	}

}

// Class which contain startDate and endDate and constructor.
class DateRange {

	String startDate;
	String endDate;

	public DateRange(String startDate, String endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
