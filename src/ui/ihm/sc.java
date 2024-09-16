package ui.ihm;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class sc {
    private static void createAndShowGUI() {
        // Créer la fenêtre
        JFrame frame = new JFrame("Scrollable TextArea Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Créer une zone de texte
        JTextArea textArea = new JTextArea(10, 30);
        textArea.setText("Voici quelques informations...\n" +
                         "Vous pouvez ajouter plus de texte ici.\n" +
                         "Le texte ajouté dépassera la taille visible,\n" +
                         "ce qui activera les barres de défilement.");

        // Rendre la zone de texte non éditable (optionnel)
        textArea.setEditable(false);

        // Ajouter la zone de texte dans un JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Ajouter le JScrollPane à la fenêtre
        frame.add(scrollPane);

        // Afficher la fenêtre
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Lancer l'application dans le thread de dispatch d'événements
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
