//package alex;
//
//import java.util.Calendar;
//import java.util.Scanner;
//
//class ImprovedCalendar{
//	public static final int DAYS_IN_WEEK = 7;
//	public static final int MONTHS_IN_YEAR = 12;
//
//	public static void main(String[] args) {
//		Calendar calendar = Calendar.getInstance();
//		try{
//			if (args.length == 0)
//				interactiveInput(calendar);
//			else
//				parseConsoleInput(calendar, args);
//		}catch(Exception e){
//			System.out.println("Error");
//			return;
//		}
//		showCalendar(calendar);
//	}
//
//	public static void showCalendar(Calendar calendar){
//		int monthInput = calendar.get(Calendar.MONTH);
//		int dayInput = calendar.get(Calendar.DAY_OF_MONTH);
//		calendar.set(Calendar.DAY_OF_MONTH, 1);
//		rewindToSunday(calendar);
//		printHeaderColor();
//		while (isCurrentOrPreviousMonth(calendar, monthInput)){
//			for (int j = 0; j < DAYS_IN_WEEK; j++){
//				colorSwitch(calendar, monthInput, dayInput);
//				System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "\t");
//				calendar.add(Calendar.DAY_OF_YEAR, 1);
//			}
//			System.out.println();
//		}
//		System.out.print("\u001B[0m");
//	}
//
//	public static boolean isCurrentOrPreviousMonth(Calendar calendar, int month){
//		int calendarMonth = calendar.get(Calendar.MONTH);
//		if (month == calendarMonth)
//			return true;
//		if (month - 1 == calendarMonth)
//			return true;
//		if (month == 0 && calendarMonth == 11)
//			return true;
//		return false;
//	}
//
//	public static void rewindToSunday(Calendar calendar) {
//		while(calendar.get(Calendar.DAY_OF_WEEK) > 1)
//			calendar.add(Calendar.DAY_OF_YEAR, -1);
//	}
//
//	public static void printHeaderColor() {
//		System.out.println("\u001B[31mSun\u001B[0m\tMon\tTue\tWed\tThu\tFri\t\u001B[31mSat\u001B[0m ");
//	}
//
//	public static void printHeaderColorless() {
//		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
//	}
//
//	public static void colorSwitch(Calendar calendar, int month, int day){
//		if (calendar.get(Calendar.MONTH) != month){
//					System.out.print("\u001B[33m");
//				}else{
//					System.out.print("\u001B[0m");
//					if (isWeekend(calendar))
//						System.out.print("\u001B[31m");
//					if (calendar.get(Calendar.DAY_OF_MONTH) == day)
//						System.out.print("\u001B[32m");
//				}
//	}
//
//	public static boolean isWeekend(Calendar calendar) {
//		return calendar.get(Calendar.DAY_OF_WEEK) == 7 || calendar.get(Calendar.DAY_OF_WEEK) == 1;
//	}
//
//}