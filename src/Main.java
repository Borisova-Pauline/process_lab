import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Что открыть? \n1 - блокнот \n2 - калькулятор \n3 - пейнт\n4 - все три");
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
            case 4:
                threeProcess();
                return;
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
    public static void threeProcess(){
        Scanner sc = new Scanner(System.in);
        ProcessBuilder p1 = new ProcessBuilder("notepad.exe");
        ProcessBuilder p2 = new ProcessBuilder("calc.exe");
        ProcessBuilder p3 = new ProcessBuilder("mspaint.exe");
        try{
            Process process1 = p1.start();
            Process process2 = p2.start();
            Process process3 = p3.start();
            System.out.println(process1.info()+"\n"+process2.info()+"\n"+process3.info());
            System.out.println("PID блокнота: \t"+process1.toHandle().pid());
            System.out.println("PID кулькулятора: \t"+process2.toHandle().pid());
            System.out.println("PID пейнта: \t"+process3.toHandle().pid());
            System.out.println("Закрыть программы? 1 - да");
            if(sc.nextInt()==1){
                Runtime.getRuntime().exec("taskkill /f /im notepad.exe");
                Runtime.getRuntime().exec("taskkill /f /im CalculatorApp.exe");
                Runtime.getRuntime().exec("taskkill /f /im mspaint.exe");
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}