import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Что открыть? \n1 - блокнот \n2 - калькулятор \n3 - пейнт");
        String commandOpen;
        String commandClose;
        switch (sc.nextInt()){
            case 1:
                commandOpen = "notepad.exe";
                commandClose = "taskkill /f /im notepad.exe";
                break;
            case 2:
                commandOpen = "calc.exe";
                commandClose = "taskkill /f /im CalculatorApp.exe";
                break;
            case 3:
                commandOpen = "mspaint.exe";
                commandClose = "taskkill /f /im mspaint.exe";
                break;
            default:
                System.out.println("Нет такого");
                return;
        }
        ProcessBuilder p1 = new ProcessBuilder(commandOpen);
        try{
            Process process1 = p1.start();
            System.out.println(process1.info());
            System.out.println("PID: "+process1.toHandle().pid());
            System.out.println("Закрыть программу? 1 - да");
            if(sc.nextInt()==1){
                Runtime.getRuntime().exec(commandClose);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}