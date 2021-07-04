import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Hotel {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        String[][] Rooms = new String[][]{

                {"101", "NA", "NA", "NA", "NA", "NA", "mountain view", "2"},
                {"102", "NA", "NA", "NA", "NA", "NA", "mountain view", "2"},
                {"103", "NA", "NA", "NA", "NA", "NA", "View of the Yard", "2"},
                {"104", "NA", "NA", "NA", "NA", "NA", "View of the Yard", "2"},
                {"105", "NA", "NA", "NA", "NA", "NA", "View of the Yard", "3"},
                {"106", "NA", "NA", "NA", "NA", "NA", "mountain view", "3"},
                {"107", "NA", "NA", "NA", "NA", "NA", "View of the Yard", "3"},
                {"108", "NA", "NA", "NA", "NA", "NA", "mountain view", "4"},
                {"109", "NA", "NA", "NA", "NA", "NA", "sea", "4"},
                {"110", "NA", "NA", "NA", "NA", "NA", "sea", "4"},
        };
        boolean flag = true;
        System.out.println("Welcome!");
        System.out.println();

        while (flag) {
            System.out.println("Please select one of the options:");
            System.out.println("1: Registration in a room.");
            System.out.println("2: List ot available rooms.");
            System.out.println("3: Vacating a occupied room.");
            System.out.println("4: Reference for a room by period.");
            System.out.println("5: Search for a free room. ");
            System.out.println("6: Enter a extra for room");
            System.out.println("          ***              ");
            System.out.println(" Please enter number from 1 to 6 to your selection:");
            String selection = scanner.nextLine();
            switch (selection) {
                case "1": {
                    registrationInRoom(Rooms);

                    break;
                }
                case "2": {
                    availableList(Rooms);
                    System.out.println();
                    break;
                }
                case "3": {
                    releaseRoom(Rooms);

                    break;
                }
                case "4": {
                    readText();
                    break;
                }
                case "5": {
                    searchRoom(Rooms);
                    System.out.println();
                    break;
                }
                case "6": {
                    enterExtra(Rooms);
                    System.out.println();
                    break;
                }
                default: {

                }
            }
        }
    }

    public static void registrationInRoom(String[][] Rooms) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter room number:");
        int n = scanner.nextInt();
        if (n >= 101 && n <= 110) {
            n = n - 100;
            for (int i = n - 1; i <= n - 1; i++) {
                for (int j = 1; j <= 3; j++) {
                    if (j == 1) {
                        System.out.println("Start date: ");

                    } else if (j == 2) {
                        System.out.println("End date: ");

                    } else {
                        System.out.println("Enter notes: ");
                    }
                    Rooms[i][j] = String.valueOf(scanner.next());

                }

                for (i = 0; i <= 9; i++) {
                    for (int j = 1; j <= 2; j++) {
                        if (!Rooms[i][j].equals("NA")) {
                            String startDate1 = Rooms[i][1];
                            String endDate2 = Rooms[i][2];
                            check(Rooms, startDate1, endDate2);
                            LocalDate startDate = LocalDate.parse(Rooms[i][1], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                            LocalDate endDate = LocalDate.parse(Rooms[i][2], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                            boolean isAfter = endDate.isAfter(startDate);
                            if (!isAfter) {
                                registrationInRoom(Rooms);
                            }
                        }
//                        CheckDate2(Rooms, Rooms[i][j]);
                    }
                }
                System.out.println("Reservation was created! ");
                System.out.println();
            }

        } else {
            System.out.println("Wrong choice. Please enter room ID from 1 to 10:");
            registrationInRoom(Rooms);
        }
        listDays(Rooms);
    }

    public static void enterExtra(String[][] Rooms) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter room ID from 101 to 110:");
        int n = scanner.nextInt();
        if (n >= 101 && n <= 110) {
            n = n - 100;
            for (int i = n - 1; i <= n - 1; i++) {
                for (int j = 4; j <= 5; j++) {
                    if (j == 4) {
                        System.out.println("Please enter yes/no for a extra baby cot");
                    } else {
                        System.out.println("Please enter yes/no  for extra breakfast");
                    }
                    Rooms[i][j] = String.valueOf(scanner.next());
                }
            }
            System.out.println("Update was created!");

        } else {
            System.out.println("Wrong choice!");
            enterExtra(Rooms);
        }
    }

    public static void availableList(String[][] Rooms) {
        int j = 0;
        for (int i = 0; i <= 9; i++) {
            for (j = 1; j <= 1; j++) {
                if (Rooms[i][j].equals("NA")) {
                    System.out.println(Rooms[i][0] + " ");
                }
            }
        }
    }

    public static void releaseRoom(String[][] Rooms) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter room ID from 101 to 110:");
        int n = scanner.nextInt();

        if (n >= 101 && n <= 110) {
            n = n - 100;
            for (int i = n - 1; i <= n - 1; i++) {
                for (int j = 1; j <= 6; j++) {

                    Rooms[i][j] = "NA";
                }
            }
            System.out.println("The room is free ");
            System.out.println();

        } else {
            System.out.println("Wrong choice. Please enter room ID from 101 to 110:");
            releaseRoom(Rooms);
        }
    }

    public static void searchRoom(String[][] Rooms) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of bed");
        String numberBed = scanner.nextLine();
        System.out.println("Enter start date: ");
        String startDate = scanner.nextLine();
        System.out.println("Enter end date: ");
        String endDate = scanner.nextLine();
        System.out.println("Available rooms:");

        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 0; j++) {
                if ((Rooms[i][1]).equals("NA") && Rooms[i][7].equals(numberBed)) {
                    System.out.println(" " + Rooms[i][0] + " ");
                }
            }
        }
    }

    public static void listDays(String[][] Rooms) throws IOException {
        try {
            ArrayList<String> list = new ArrayList<String>(100);
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j <= 2; j++) {
                    if (!(Rooms[i][1]).equals("NA")) {
                        list.add(Rooms[i][j]);
                    }
                }
            }
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("RoomOccupancyList.txt")));
            for (int i = 0; i < list.size(); i++) {
                out.println(list.get(i));
            }
            out.close();
        } catch (IOException e) {
            System.out.println("occurance of exception" + e);
        }
    }

    public static void readText() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<String>();

        Scanner scan = new Scanner(new File("RoomOccupancyList.txt"));

        while (scan.hasNext()) {
            list.add(scan.next());
        }
//        System.out.println(list);
        String[] listRooms = list.stream().toArray(String[]::new);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//        System.out.println(Arrays.toString(listRooms));
        System.out.println("Please enter start date");
        String periodStart = scanner.next();
        LocalDate newPeriodStart = LocalDate.parse(periodStart, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("Please enter end date");
        String periodEnd = scanner.next();
        LocalDate newPeriodEnd = LocalDate.parse(periodEnd, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        int i = 0;
        Period busyRoom = null;
        boolean isAfter = newPeriodEnd.isAfter(newPeriodStart);
        if (newPeriodEnd.isAfter(newPeriodStart)) {

            for (i = 0; i < listRooms.length; i += 3) {

                LocalDate startDate = LocalDate.parse(listRooms[i + 1], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                LocalDate endDate = LocalDate.parse(listRooms[i + 2], DateTimeFormatter.ofPattern("dd.MM.yyyy"));

                if (isAfter) {
                    if ((startDate.isBefore(newPeriodStart)) && (endDate.isAfter(newPeriodEnd))) {
                        busyRoom = Period.between(newPeriodStart, newPeriodEnd);
                    } else if ((startDate.isAfter(newPeriodStart)) && (endDate.isBefore(newPeriodEnd))) {
                        busyRoom = Period.between(startDate, endDate);
                    } else if ((startDate.isBefore(newPeriodStart)) && (endDate.isBefore(newPeriodEnd))) {
                        busyRoom = Period.between(newPeriodStart, endDate);
                    } else if ((startDate.isAfter(newPeriodStart)) && (endDate.isAfter(newPeriodEnd))) {
                        busyRoom = Period.between(startDate, newPeriodEnd);
                    } else if ((startDate.isEqual(newPeriodStart)) && (endDate.isEqual(newPeriodEnd))) {
                        busyRoom = Period.between(newPeriodStart, newPeriodEnd);
                    } else if ((startDate.isEqual(newPeriodStart)) && (endDate.isBefore(newPeriodEnd))) {
                        busyRoom = Period.between(newPeriodStart, endDate);
                    } else if ((startDate.isEqual(newPeriodStart)) && (endDate.isAfter(newPeriodEnd))) {
                        busyRoom = Period.between(newPeriodStart, newPeriodEnd);
                    } else if ((startDate.isBefore(newPeriodStart)) && (endDate.isEqual(newPeriodEnd))) {
                        busyRoom = Period.between(newPeriodStart, newPeriodEnd);
                    } else if ((startDate.isAfter(newPeriodStart)) && (endDate.isEqual(newPeriodEnd))) {
                        busyRoom = Period.between(startDate, newPeriodEnd);
                    }


                    System.out.println(listRooms[i] + ": " + busyRoom.getDays() + " days");


                } else {
                    System.out.println("Wrong period");
                    readText();
                }

            }
            System.out.println();
        }

//    public static void CheckDate2(String[][] Rooms, String date) throws IOException {
//
//        String[] newDate = date.split("\\.");
//        int year = Integer.parseInt(newDate[2]);
//        int mount = Integer.parseInt(newDate[1]);
//        int day = Integer.parseInt(newDate[0]);
//
//        if (year == 2021) {
//            if (mount == 1 || mount == 3 || mount == 5 || mount == 7 || mount == 8 || mount == 10 || mount == 12) {
//                if (day >= 1 && day <= 31) {
////                    System.out.println("Valid date");
//
//                }
//            } else if (mount == 4 || mount == 6 || mount == 9 || mount == 11) {
//                if (day >= 1 && day <= 30) {
////                    System.out.println("Valid date");
//                }
//            } else if (mount == 2) {
//                if (day >= 1 && day <= 28) {
////                    System.out.println("Valid date");
//                }
//            }
//        } else {
//            System.out.println("Wrong date");
//            System.out.println("Please enter again");
//            registrationInRoom(Rooms);
//        }
    }


    public static void check(String[][] Rooms, String startDate1, String endDate2) throws IOException {
        boolean isDate = false;

        String datePattern = "\\d{1,2}.\\d{1,2}.\\d{4}";

        isDate = startDate1.matches(datePattern);
        isDate = endDate2.matches(datePattern);

        if (!isDate) {
            System.out.println("Wrong Date!");
            registrationInRoom(Rooms);
        }
    }
}
