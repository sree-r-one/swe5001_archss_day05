//1.	How can you better improve this piece of code for adding days, months or weeks to a date value?

package maintainability;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Question01 {

    public static void main(String args[]) {

        // Declare and Print the Actual Date
        String inputDate = "01/12/2025";
        System.out.println("The Actual Date is: " + inputDate);

        // Specify a Valid Date Format to Match the Given Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // Set the calendar object according to the given Date
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(dateFormat.parse(inputDate));
        } catch (ParseException excep) {
            excep.printStackTrace();
        }

        // Add Days to Date Using add() Method
        calendar = nowPlusTime(calendar, 0, 0, 5);
        String modifiedDate = dateFormat.format(calendar.getTime());

        // Print the Modified Date
        System.out.println("The Modified Date is: " + modifiedDate);
    }

    public static Calendar nowPlusTime(Calendar cal, int months, int weeks, int days) {

        if (months > 0)
            // Add Days to Date Using add() Method
            cal.add(Calendar.DAY_OF_MONTH, months);

        if (weeks > 0)
            // Add Days to Date Using add() Method
            cal.add(Calendar.DAY_OF_WEEK, weeks);

        if (days > 0)
            // Add Days to Date Using add() Method
            cal.add(Calendar.DAY_OF_YEAR, days);

        return cal;
    }

}