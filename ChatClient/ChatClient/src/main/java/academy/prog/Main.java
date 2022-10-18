package academy.prog;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter your login: ");
            String login = scanner.nextLine();
            User.getInstance().setLogin(login);

            Thread th = new Thread(new GetThread());
            th.setDaemon(true);
            th.start();

            System.out.println("Enter your message: ");
            while (true) {
                String text = scanner.nextLine();
                if (text.isEmpty()){
                    Message offline = new Message(login, "false", "server");
                    int er = offline.send(Utils.getURL() + "/add");
                    if (er != 200) {
                        System.out.println("HTTP req error: " + er);
                        return;
                    }
                    break;
                }
                String to = null;
                if(text.startsWith("@")){
                    to = text.substring(1, text.indexOf(" "));
                    text = text.substring(text.indexOf(" ") + 1);
                }
                Message message = new Message(login,text,to);
                int res = message.send(Utils.getURL() + "/add");

                if (res != 200) {
                    System.out.println("HTTP request error: " + res);
                    return;
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
