//1.	How can you better improve this piece of code for adding days, months or weeks to a date value?

/*
ANSWER: This code has several critical issues that need improvement:

PROBLEMS IDENTIFIED:
1. INCORRECT CALENDAR FIELDS: 
   - Adding months using Calendar.DAY_OF_MONTH instead of Calendar.MONTH
   - Adding weeks using Calendar.DAY_OF_WEEK instead of Calendar.WEEK_OF_YEAR
   - Adding days using Calendar.DAY_OF_YEAR instead of Calendar.DAY_OF_MONTH

2. LOGIC ERRORS:
   - The method parameter 'months' actually adds days, not months
   - The method parameter 'weeks' changes day of week, not adds weeks
   - Inconsistent and confusing behavior

3. DESIGN ISSUES:
   - Poor method naming (nowPlusTime doesn't clearly indicate purpose)
   - Method modifies the passed Calendar object (side effects)
   - No input validation
   - Uses legacy Date/Calendar API instead of modern java.time

IMPROVED SOLUTIONS:

Option 1 - Fix current approach:
public static Calendar addTimeToDate(Calendar cal, int months, int weeks, int days) {
    Calendar result = (Calendar) cal.clone(); // Avoid side effects
    
    if (months != 0) result.add(Calendar.MONTH, months);
    if (weeks != 0) result.add(Calendar.WEEK_OF_YEAR, weeks);
    if (days != 0) result.add(Calendar.DAY_OF_MONTH, days);
    
    return result;
}

Option 2 - Use modern java.time API (RECOMMENDED):
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public static LocalDate addTimeToDate(LocalDate date, int months, int weeks, int days) {
    return date.plusMonths(months).plusWeeks(weeks).plusDays(days);
}

Option 3 - Builder pattern for complex date operations:
public class DateCalculator {
    private LocalDate date;
    
    public DateCalculator(LocalDate date) { this.date = date; }
    public DateCalculator addMonths(int months) { this.date = date.plusMonths(months); return this; }
    public DateCalculator addWeeks(int weeks) { this.date = date.plusWeeks(weeks); return this; }
    public DateCalculator addDays(int days) { this.date = date.plusDays(days); return this; }
    public LocalDate build() { return date; }
}

BEST PRACTICES:
- Use java.time package (available since Java 8)
- Immutable date objects prevent bugs
- Clear method names and documentation
- Input validation for edge cases
- Separate concerns (parsing, calculation, formatting)
*/

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
        // ISSUE: Method name is unclear and parameters are confusing (months=0,
        // weeks=0, days=5)
        // IMPROVEMENT: Use more descriptive method name and consider modern java.time
        // API
        calendar = nowPlusTime(calendar, 0, 0, 5);
        String modifiedDate = dateFormat.format(calendar.getTime());

        // Print the Modified Date
        System.out.println("The Modified Date is: " + modifiedDate);
    }

    // PROBLEMATIC METHOD: Contains multiple logical errors
    // ISSUE 1: Method name doesn't clearly indicate it adds time periods
    // ISSUE 2: Modifies the passed Calendar object (side effects)
    // ISSUE 3: Uses wrong Calendar constants for months and weeks
    public static Calendar nowPlusTime(Calendar cal, int months, int weeks, int days) {

        if (months > 0)
            // BUG: This adds DAYS, not MONTHS! Should use Calendar.MONTH
            // WRONG: Calendar.DAY_OF_MONTH adds days to the month
            // CORRECT: cal.add(Calendar.MONTH, months);
            cal.add(Calendar.DAY_OF_MONTH, months);

        if (weeks > 0)
            // BUG: This changes day of week, doesn't add weeks!
            // WRONG: Calendar.DAY_OF_WEEK sets which day of week (1=Sunday, 2=Monday, etc.)
            // CORRECT: cal.add(Calendar.WEEK_OF_YEAR, weeks);
            cal.add(Calendar.DAY_OF_WEEK, weeks);

        if (days > 0)
            // INCONSISTENT: Uses DAY_OF_YEAR instead of DAY_OF_MONTH like above
            // BETTER: Use Calendar.DAY_OF_MONTH for consistency
            // MODERN: Use java.time.LocalDate.plusDays() for cleaner code
            cal.add(Calendar.DAY_OF_YEAR, days);

        return cal;
    }

}