import javax.swing.*;

public class main {

    public static void main(String[] args) {

        //new Sorting();

        int result = Integer.parseInt(JOptionPane.showInputDialog("Please enter n Fakult�t:"));
        int out = 1;
        for (int i = 2; i <= result; i++) {
            out *= i;
        }
        System.out.println(out);

    }

}
