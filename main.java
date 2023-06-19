import java.util.Scanner;
import java.util.InputMismatchException;

import components.KalkulatorNormal;
import components.KalkulatorLuasSegitiga;
import components.KalkulatorLuasLingkaran;
import components.KalkulatorLuasPersegiPanjang;

/**
 *
 * @author Kevin Reynaufal
 * @kelas IF - Z (2242803)
 * @note Program ini mencakup tugas 7 dan praktikum 7. Terdapat 4 program GUI
 *       yang terdiri dari calculator normal, calculator luas segitiga,
 *       calculator luas lingkaran, calculator luas persegi panjang.
 * 
 */

public class main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private static void programNo1() {
        try {
            new KalkulatorNormal();
            System.out.println(ANSI_GREEN + "||======================================================||");
            System.out.println("|| SUCCESS : PROGRAM BERHASIL DI JALANKAN\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "||======================================================||");
            System.out.println("|| WARNING : TERJADI KESALAHAN SAAT MEMBUKA PROGRAM\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        }
    }

    private static void programNo2() {
        try {
            new KalkulatorLuasSegitiga();
            System.out.println(ANSI_GREEN + "||======================================================||");
            System.out.println("|| SUCCESS : PROGRAM BERHASIL DI JALANKAN\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "||======================================================||");
            System.out.println("|| WARNING : TERJADI KESALAHAN SAAT MEMBUKA PROGRAM\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        }
    }

    private static void programNo3() {
        try {
            new KalkulatorLuasLingkaran();
            System.out.println(ANSI_GREEN + "||======================================================||");
            System.out.println("|| SUCCESS : PROGRAM BERHASIL DI JALANKAN\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "||======================================================||");
            System.out.println("|| WARNING : TERJADI KESALAHAN SAAT MEMBUKA PROGRAM\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        }
    }

    private static void programNo4() {
        try {
            new KalkulatorLuasPersegiPanjang();
            System.out.println(ANSI_GREEN + "||======================================================||");
            System.out.println("|| SUCCESS : PROGRAM BERHASIL DI JALANKAN\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        } catch (Exception e) {
            System.out.println(ANSI_RED + "||======================================================||");
            System.out.println("|| WARNING : TERJADI KESALAHAN SAAT MEMBUKA PROGRAM\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
        }
    }

    private static void quitApp() {
        String quitss = "y";
        System.out.println(ANSI_RED + "||======================================================||");
        System.out.print("|| KELUAR DARI PROGRAM? (Y/T) >>> ");
        quitss = new Scanner(System.in).nextLine();
        if (quitss.equalsIgnoreCase("y")) {
            System.out.println("||======================================================||" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "||======================================================||");
            System.out.println("|| SUCCESS : BERHASIL KELUAR DARI DALAM PROGRAM\t\t||");
            System.out.println("||======================================================||" + ANSI_RESET);
            System.exit(0);
        } else {
            System.out.println("||======================================================||" + ANSI_RESET);
            menuProgram();
        }
    }

    private static void menuChooser(int choosenMenu) {
        switch (choosenMenu) {
            case 1:
                programNo1();
                break;
            case 2:
                programNo2();
                break;
            case 3:
                programNo3();
                break;
            case 4:
                programNo4();
                break;
            case 5:
                quitApp();
                break;
            default:
                System.out.println(ANSI_RED + "||======================================================||");
                System.out.println("|| WARNING : PILIH MENU SESUAI NOMOR YANG TERSEDIA !!!\t||");
                System.out.println("||======================================================||" + ANSI_RESET);
                break;
        }
        menuProgram();
    }

    private static void menuProgram() {
        // System.out.println("\n");
        int loopX = 0, choosenMenu = 0;
        while (loopX == 0) {
            System.out.println(ANSI_CYAN + "||======================================================||");
            System.out.println("||\t\tM E N U - P R O G R A M\t\t\t||");
            System.out.println("||======================================================||");
            System.out.println("|| 1. Kalkulator Normal\t\t\t\t\t||");
            System.out.println("|| 2. Kalkulator Luas Segitiga\t\t\t\t||");
            System.out.println("|| 3. Kalkulator Luas Lingkaran\t\t\t\t||");
            System.out.println("|| 4. Kalkulator Luas Persegi Panjang\t\t\t||");
            System.out.println("|| 5. Keluar Dari Program\t\t\t\t||");
            System.out.print("|| Pilihan Menu (1 - 5) >>> ");
            Scanner menuOption = new Scanner(System.in);
            try {
                choosenMenu = menuOption.nextInt();
                loopX = 1;
            } catch (InputMismatchException e) {
                System.out.println("||======================================================||" + ANSI_RESET);
                System.out.println(ANSI_RED + "||======================================================||");
                System.out.println("|| WARNING : MASUKAN NILAI BERUPA ANGKA !!!\t\t||");
                System.out.println("||======================================================||" + ANSI_RESET);
            }
        }
        System.out.println("||======================================================||" + ANSI_RESET);
        menuChooser(choosenMenu);
    }

    public static void main(String[] args) {
        System.out.println(ANSI_RED + "||======================================================||");
        System.out.println("||\tP R O G R A M   K A L K U L A T O R   G U I\t||");
        System.out.println("||======================================================||" + ANSI_RESET);
        menuProgram();
    }
}
