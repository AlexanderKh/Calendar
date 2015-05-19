package Alex;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

class ImprovedCalendar{
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		ArrayList<Integer> date;
		try{
		if (args.length == 0)
			date = interactiveInput();
		else
			date = parseConsoleInput(args);
		}catch(Exception e){
			System.out.println("error");
			return;
		}
		int year = date.get(0);
		int month = date.get(1);
		int day = date.get(2);
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		while(calendar.get(Calendar.DAY_OF_WEEK) > 1)
			calendar.add(Calendar.DAY_OF_YEAR, -1);

		System.out.println("\u001B[31mSun\u001B[0m\tMon\tTue\tWed\tThu\tFri\t\u001B[31mSat\u001B[0m ");
		while ((calendar.get(Calendar.MONTH) + 12) % 11 <= month + 1 && calendar.get(Calendar.YEAR) <= year){
			for (int j = 0; j < 7; j++){
				colorSwitch(calendar, month, day);
				System.out.print(calendar.get(Calendar.DAY_OF_MONTH) + "\t");
				calendar.add(Calendar.DAY_OF_YEAR, 1);
			}
			System.out.println();
		}
		System.out.print("\u001B[0m");
	}

	public static void colorSwitch(Calendar calendar, int month, int day){
		if (calendar.get(Calendar.MONTH) != month){
					System.out.print("\u001B[33m");
				}else{
					System.out.print("\u001B[0m");
					if (calendar.get(Calendar.DAY_OF_WEEK) == 7 || calendar.get(Calendar.DAY_OF_WEEK) == 1)
						System.out.print("\u001B[31m");
					if (calendar.get(Calendar.DAY_OF_MONTH) == day)
						System.out.print("\u001B[32m");
				}
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

	public static ArrayList<Integer> interactiveInput() throws Exception{
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		System.out.print("Input Year: ");
		list.add(Integer.valueOf(in.next()));
		System.out.print("Input Month: ");
		list.add(parseMonth(in.next()));
		System.out.print("Input Day: ");
		int day = Integer.valueOf(in.next());
		while (day > 31 || day < 1){
			System.out.println("Wrong input, please try again: ");
			day = Integer.valueOf(in.next());
		}
		list.add(day);
		return list;
	}

	public static ArrayList<Integer> parseConsoleInput(String[] input) throws Exception{
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(Integer.valueOf(input[0]));
		list.add(parseMonth(input[1]));
		list.add(Integer.valueOf(input[2]));
		return list;
	}
}