import com.company.CoffeMachine;
import com.company.UserInputProvider;

import java.util.Scanner;

public class MainElo {
    public static void main(String[] args) {
        CoffeMachine coffeMachine = new CoffeMachine(new UserInputProvider(new Scanner(System.in)));
        coffeMachine.displayMachineStat();
        coffeMachine.run();
    }
}
