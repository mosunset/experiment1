import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BadProgram {
    static JTextField[] ansBox;
    static JTextArea result;
    static int guessCount = 0;
    static int[] correct;

    public static void main(String[] args) {
        guessCount = 0;
        correct = GenProblem(4);
        JFrame FRAME = new JFrame("Hit & Blow Game");
        FRAME.setBounds(200, 200, 200, 400);
        FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FRAME.getContentPane().add(createPanel());
        FRAME.setVisible(true);
    }

    static int[] GenProblem(int num) {
        Random rand = new Random();
        int[] p = new int[10];
        for (int i = 0; i < 10; i++) {
            int j = rand.nextInt(i + 1);
            p[i] = p[j];
            p[j] = i;
        }
        int[] ret = new int[4];
        for (int i = 0; i < 4; i++) {
            ret[i] = p[i];
        }
        return ret;
    }
}
