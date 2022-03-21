package Semana_8.Hilos;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class Carreras {

    JFrame frame;
    JProgressBar pony1 = new JProgressBar(0, 100);
    JProgressBar pony2 = new JProgressBar(0, 100);
    JProgressBar pony3 = new JProgressBar(0, 100);

    JLabel msg = new JLabel("");

    static boolean runRaceBtn = false;
    static boolean resetRaceBtn = false;

    static int win = 0;

    static boolean winner = false;

    public synchronized void end(int contar) {
        msg.setVisible(true);
        msg.setText("El pony #" + win + " gano la carrera");
        if (contar == 100) {
            winner = true;
            msg.setText("El pony #" + win + " gano la carrera");
        }
        frame.getContentPane().add(msg);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Carreras window = new Carreras();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Carreras() {
        initFrame();
    }

    private void initFrame() {
        frame = new JFrame();
        frame.setBounds(100, 100, 590, 430);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        pony1.setStringPainted(true);
        pony1.setForeground(Color.RED);
        pony1.setBounds(150, 129, 259, 14);
        frame.getContentPane().add(pony1);

        pony2.setStringPainted(true);
        pony2.setForeground(Color.BLUE);
        pony2.setBounds(150, 159, 259, 14);
        frame.getContentPane().add(pony2);

        pony3.setStringPainted(true);
        pony3.setForeground(Color.GREEN);
        pony3.setBounds(150, 189, 259, 14);
        frame.getContentPane().add(pony3);

        msg.setBounds(85, 100, 410, 14);
        msg.setVisible(false);
        frame.getContentPane().add(msg);

        JButton btnRunRace = new JButton("Run");
        btnRunRace.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnRunRace.addActionListener(new ejecutar());
        btnRunRace.setBounds(50, 287, 155, 40);

        frame.getContentPane().add(btnRunRace);

        JButton btnResetRace = new JButton("Reset");
        btnResetRace.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnResetRace.addActionListener(new reinciar());

        btnResetRace.setBounds(205, 287, 155, 40);
        frame.getContentPane().add(btnResetRace);
    }

    class ejecutar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!runRaceBtn) {
                msg.setVisible(false);
                resetRaceBtn = false;
                runRaceBtn = true;

                // Threads
                Pony1 p1 = new Pony1();
                p1.runRace();
                Pony2 p2 = new Pony2();
                p2.runRace();
                Pony3 p3 = new Pony3();
                p3.runRace();
            }
        }
    }

    class reinciar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!resetRaceBtn) {
                msg.setVisible(false);
                resetRaceBtn = true;
                runRaceBtn = false;
                winner = false;

                // Threads
                Pony1 p1 = new Pony1();
                p1.reset();
                Pony2 p2 = new Pony2();
                p2.reset();
                Pony3 p3 = new Pony3();
                p3.reset();
            }
        }
    }

    class Pony1 extends Thread {
        public void reset() {
            pony1.setValue(0);
            pony1.repaint();
        }

        public void runRace() {
            for (int i = 0; i < 101; i++) {
                if (winner) {
                    break;
                }

                pony1.setValue(i);
                pony1.repaint();

                if (i == 100) {
                    win = 1;
                    end(i);
                }

                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits() % 60));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Pony2 extends Thread {
        public void reset() {
            pony2.setValue(0);
            pony2.repaint();
        }

        public void runRace() {
            for (int i = 0; i < 101; i++) {
                if (winner) {
                    break;
                }

                pony2.setValue(i);
                pony2.repaint();

                if (i == 100) {
                    win = 2;
                    end(i);
                }

                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits() % 60));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Pony3 extends Thread {
        public void reset() {
            pony3.setValue(0);
            pony3.repaint();
        }

        public void runRace() {
            for (int i = 0; i < 101; i++) {
                if (winner) {
                    break;
                }

                pony3.setValue(i);
                pony3.repaint();

                if (i == 100) {
                    win = 3;
                    end(i);
                }

                try {
                    Thread.sleep(Math.abs(UUID.randomUUID().getMostSignificantBits() % 60));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
