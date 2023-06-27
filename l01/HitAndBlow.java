import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HitAndBlow {
    // constants
    private final static int SIZE = 4;
    // GUI components
    static JTextField[] ansBox;
    static JTextArea result;
    static int guessCount = 0;
    static int[] correct;

    // program starts from here.
    public static void main(String[] args) {
        guessCount = 0;
        correct = genProblem(SIZE);

        JFrame frame = new JFrame("Hit & Blow Game");
        frame.setBounds(200, 200, 250, 400); // Title extended due to lack of visibility.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(createPanel());
        frame.setVisible(true);
    }

    // two functions for hit-and-blow game algorithm.
    static int[] genProblem(int num) {
        Random rand = new Random();
        int[] permutation = new int[10];
        for (int i = 0; i < 10; i++) {
            int j = rand.nextInt(i + 1);
            permutation[i] = permutation[j];
            permutation[j] = i;
        }
        int[] ret = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            ret[i] = permutation[i];
        }
        return ret;
    }

    static int[] check(int[] ans, int[] correct) {
        int[] temp = new int[correct.length];
        for (int i = 0; i < correct.length; i++) {
            temp[i] = correct[i];
        }
        int[] result = new int[2];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == ans[i]) {
                result[0]++;
                temp[i] = -1;
            }
        }
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < ans.length; j++) {
                if (temp[i] == ans[j]) {
                    result[1]++;
                    temp[i] = -1;
                }
            }
        }
        return result;
    }

    // GUI Layouts and Event Handlers
    static JPanel createPanel() {
        JPanel allPanel = new JPanel();
        allPanel.setLayout(new BoxLayout(allPanel, BoxLayout.PAGE_AXIS));

        JLabel lable = new JLabel("Guess \\\\" + SIZE + "// Numbers !!");
        allPanel.add(lable);

        JPanel ansPanel = new JPanel();
        ansPanel.setLayout(new BoxLayout(ansPanel, BoxLayout.LINE_AXIS));

        JButton submit = new JButton("Submit");
        ansBox = new JTextField[SIZE];
        for (int i = 0; i < SIZE; i++) {
            ansBox[i] = new JTextField(1);
            Dimension sz = ansBox[i].getMaximumSize();
            sz.height = submit.getMaximumSize().height;
            ansBox[i].setMaximumSize(sz);
            ansPanel.add(ansBox[i]);
        }
        ansPanel.add(submit);
        allPanel.add(ansPanel);

        result = new JTextArea();
        allPanel.add(result);
        submit.addActionListener(new submitAction());
        return allPanel;
    }

    static class submitAction implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            int[] ans = new int[SIZE];
            for (int i = 0; i < SIZE; i++) {
                try {
                    ans[i] = Integer.parseInt(ansBox[i].getText());
                } catch (Exception e) {
                    ans[i] = -1;
                }
                if (ans[i] < 0 || ans[i] > 9) {
                    result.setText("something wrong at box " + (i + 1) + "\n" + result.getText());
                    return;
                }
            }
            guessCount++;

            int hb[] = check(ans, correct);
            if (hb[0] == SIZE) {
                result.setText("Congraturations!!\n" + "Solved in " + guessCount + " times.\n" + result.getText());
            } else {
                String line = " Try " + guessCount + ". Guess ";
                for (int i = 0; i < SIZE; i++) {
                    line = line + ans[i];
                }
                line = line + ": " + hb[0] + " hits & " + hb[1] + " blows\n";
                result.setText(line + result.getText());
            }
        }
    }
}
