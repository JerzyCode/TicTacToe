import javax.swing.SwingUtilities;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI main = new GUI();
            main.show();
        });
    }
}