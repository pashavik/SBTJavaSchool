package terminal;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TerminalImpl terminal = new TerminalImpl(new TerminalServer(), new Validator());

//        if (terminal.start("dsfsds")) {
//
//        } else {
            terminal.start("1111_1111_1111_1111");
//            terminal.getAccountBalance();
//
//terminal.enterPin("wrong pin");
//
//                terminal.enterPin("1235");
//                terminal.enterPin("1235");
//                terminal.enterPin("1235");
//
////                terminal.getAccountBalance();
//
////                // необходимо подождать когда счет разблокируется
//                System.out.println("Ждем 3 секунды");
////                Thread.sleep(3 * 1000);
//                terminal.enterPin("1234");
//                System.out.println("Ждем еще 2 секунды");
//              //  Thread.sleep(3 * 1000);
//
//
//                // корректный пин
           terminal.enterPin("1111");
//
  terminal.getAccountBalance();
//
//                terminal.withdrawMoney(150);
//                terminal.withdrawMoney(200);
//
                terminal.putMoney(150);
                terminal.putMoney(500);
//
//                terminal.putMoney(300);
 terminal.stop();
            }
        }

