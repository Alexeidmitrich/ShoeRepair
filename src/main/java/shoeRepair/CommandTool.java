package shoeRepair;

import java.sql.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandTool {
    private ShoeRepairRefactirung shoeRepairRefactirung;

    public CommandTool(){
        shoeRepairRefactirung = new ShoeRepairRefactirung();
    }

    public  void parseCommand(String command){
      final String addClient = "(addclient) ([a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9]+;[a-zA-Z\\sа-яА-Я\\- W$0-9]+)";
      Matcher matcher = isPatternMatches(command, addClient);
        if (matcher.find()) {
            String data = matcher.group(2);
            System.out.println(data);
            String[] clientData = data.split(";");
            shoeRepairRefactirung.addClient(clientData[0], clientData[1], clientData[2],clientData[3]);
            System.out.println("Ok");
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
