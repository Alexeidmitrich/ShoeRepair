package shoeRepair;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandTool {
    private ShoeRepairSystem shoeRepairSystem;

    public CommandTool(){
        shoeRepairSystem= new ShoeRepairSystem();
    }

    public  void parseCommand(String command){
      final String addShoeRepairInfo = "(addshoerepairinfo) ([a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9+]+;[a-zA-Z\\sа-яА-Я\\- W$0-9]+)";
      final String addClient = "(addclient) ([a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9+]+)";
      final String printClientById = "(printclient) ([0-9]+)";
      final String printAllClient = "(printallclient)";
      final String addOrder = "(addorder) ([a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9]+)";
      Matcher matcher = isPatternMatches(command, addShoeRepairInfo);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] shoerepairInfoData = data.split(";");
            shoeRepairSystem.addShoeRepairInfo(shoerepairInfoData[0], shoerepairInfoData[1], shoerepairInfoData[2], shoerepairInfoData[3]);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addClient);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] clientData = data.split(";");
            shoeRepairSystem.addClient(clientData[0], clientData[1], clientData[2]);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, addOrder);
        if(matcher.find()){
            String data = matcher.group(2);
            String [] orderData = data.split(";");
            System.out.println(data);
            int idClient = Integer.parseInt(orderData[2]);
            shoeRepairSystem.addOrder(orderData[0], orderData[1],idClient);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, printClientById);
        if(matcher.find()){
            String data = matcher.group(2);
            String [] clientIdData = data.split(";");
            System.out.println(data);
            int id = Integer.parseInt(clientIdData[0]);
            shoeRepairSystem.printClientById(id);
            System.out.println("Ok");
        }
        matcher = isPatternMatches(command, printAllClient);
        if(matcher.find()) {
            shoeRepairSystem.printAllClientByOrder();
            System.out.println("OK");
        }
    }
    public Matcher isPatternMatches(String command, String regex){
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(command);
        return matcher;
    }
    public static void main(String[] args) {
        CommandTool commandTool = new CommandTool();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please, type a command");
            String command = sc.nextLine();
            commandTool.parseCommand(command);
        }
    }
}
