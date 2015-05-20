package Alex;

import java.util.Calendar;
import java.util.Scanner;

class ImprovedCalendar{
	public static final int DAYS_IN_WEEK = 7;
	public static final int MONTHS_IN_YEAR = 12;

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		try{
			if (args.length == 0)
				interactiveInput(calendar);
			else
				parseConsoleInput(calendar, args);
		}catch(Exception e){
			System.out.println("Error");
			return;
		}
		showCalendar(calendar);
	}

	public static void showCalendar(Calendar calendar){
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		rewindToSunday(calendar);
		printHeaderColor();
		while (isCurrentOrPreviousMonth(calendar, month)){
			for (int j = 0; j < DAYS_IN_WEEK; j++){
				colorSwitch(calendar, month, day);
				System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "\t");
				calendar.add(Calendar.DAY_OF_YEAR, 1);
			}
			System.out.println();
		}
		System.out.print("\u001B[0m");
	}

	public static boolean isCurrentOrPreviousMonth(Calendar calendar, int month){
		int currentMonth = calendar.get(Calendar.MONTH);
		if (month == currentMonth)
			return true;
		if (month - 1 == currentMonth)
			return true;
		if (month == 0 && currentMonth == 11)
			return true;
		return false;
	}
	
	public static void rewindToSunday(Calendar calendar) {
		while(calendar.get(Calendar.DAY_OF_WEEK) > 1)
			calendar.add(Calendar.DAY_OF_YEAR, -1);
	}

	public static void printHeaderColor() {
		System.out.println("\u001B[31mSun\u001B[0m\tMon\tTue\tWed\tThu\tFri\t\u001B[31mSat\u001B[0m ");
	}
	
	public static void printHeaderColorless() {
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
	}

	public static void colorSwitch(Calendar calendar, int month, int day){
		if (calendar.get(Calendar.MONTH) != month){
					System.out.print("\u001B[33m");
				}else{
					System.out.print("\u001B[0m");
					if (isWeekend(calendar))
						System.out.print("\u001B[31m");
					if (calendar.get(Calendar.DAY_OF_MONTH) == day)
						System.out.print("\u001B[32m");
				}
	}

	public static boolean isWeekend(Calendar calendar) {
		return calendar.get(Calendar.DAY_OF_WEEK) == 7 || calendar.get(Calendar.DAY_OF_WEEK) == 1;
	}

	public static int parseMonth(String month) throws Exception{
		if (month.matches("\\d+")){
			return Integer.valueOf(month) - 1;
		}
		else{
			String uppercaseMonth = month.toUpperCase();
			if (uppercaseMonth.equals("JAN") || uppercaseMonth.equals("JANUARY"))
				return 0;
			if (uppercaseMonth.equals("FEB") || uppercaseMonth.equals("FEBRUARY"))
				return 1;
			if (uppercaseMonth.equals("MAR") || uppercaseMonth.equals("MARCH"))
				return 2;
			if (uppercaseMonth.equals("APR") || uppercaseMonth.equals("APRIL"))
				return 3;
			if (uppercaseMonth.equals("MAY"))
				return 4;
			if (uppercaseMonth.equals("JUN") || uppercaseMonth.equals("JUNE"))
				return 5;
			if (uppercaseMonth.equals("JUL") || uppercaseMonth.equals("JULY"))
				return 6;
			if (uppercaseMonth.equals("AUG") || uppercaseMonth.equals("AUGUST"))
				return 7;
			if (uppercaseMonth.equals("SEP") || uppercaseMonth.equals("SEPTEMBER"))
				return 8;
			if (uppercaseMonth.equals("OCT") || uppercaseMonth.equals("OCTOBER"))
				return 9;
			if (uppercaseMonth.equals("NOV") || uppercaseMonth.equals("NOVEMBER"))
				return 10;
			if (uppercaseMonth.equals("DEC") || uppercaseMonth.equals("DECEMBER"))
				return 11;
		}
		throw new Exception("Month conversion error");
	}

	public static void interactiveInput(Calendar calendar) throws Exception{
		Scanner in = new Scanner(System.in);
		System.out.print("Input Year: ");
		calendar.set(Calendar.YEAR, Integer.valueOf(in.next()));
		System.out.print("Input Month: ");
		calendar.set(Calendar.MONTH, parseMonth(in.next()));
		System.out.print("Input Day: ");
		int day = Integer.valueOf(in.next());
		while (day > 31 || day < 1){
			System.out.println("Wrong input, please try again: ");
			day = Integer.valueOf(in.next());
		}
		calendar.set(Calendar.DAY_OF_MONTH, day);
		in.close();
	}

	public static void parseConsoleInput(Calendar calendar, String[] input) throws Exception{
		calendar.set(Calendar.YEAR, Integer.valueOf(input[0]));
		calendar.set(Calendar.MONTH, parseMonth(input[1]));
		calendar.set(Calendar.DAY_OF_MONTH, Integer.valueOf(input[2]));
	}
}