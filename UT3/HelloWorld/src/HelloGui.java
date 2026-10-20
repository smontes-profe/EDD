import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HelloGui {

    private static final Color BG = new Color(250, 250, 250);
    private static final Color INK = new Color(24, 24, 24);
    private static final Color MUTED = new Color(138, 138, 138);
    private static final Color ACCENT = new Color(24, 24, 24);
    private static final Color ACCENT_HOVER = new Color(64, 64, 64);
    private static final Color ON_ACCENT = new Color(250, 250, 250);

    private static final String[] SALUDOS = {
            "Hello, World!",
            "Hola, Mundo!",
            "Bonjour, Monde!",
            "Hallo, Welt!",
            "Ciao, Mondo!"
    };

    private static final String[] SUBTITULOS = {
            "Edicion minimalista",
            "Interfaz en Java Swing",
            "Sin dependencias externas",
            "Un solo archivo",
            "HelloWorld"
    };

    private static int indice = 0;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(HelloGui::crearVentana);
    }

    private static void crearVentana() {
        JFrame frame = new JFrame("HelloWorld");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JLabel saludo = new JLabel(SALUDOS[indice], SwingConstants.CENTER);
        saludo.setFont(fuente(Font.BOLD, 34));
        saludo.setForeground(INK);
        saludo.setAlignmentX(Component.CENTER_ALIGNMENT);
        saludo.setMaximumSize(new Dimension(Short.MAX_VALUE, 46));

        JLabel subtitulo = new JLabel(SUBTITULOS[indice], SwingConstants.CENTER);
        subtitulo.setFont(fuente(Font.PLAIN, 13));
        subtitulo.setForeground(MUTED);
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitulo.setMaximumSize(new Dimension(Short.MAX_VALUE, 20));

        RoundedButton boton = new RoundedButton("Cambiar saludo");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.addActionListener(e -> {
            indice = (indice + 1) % SALUDOS.length;
            saludo.setText(SALUDOS[indice]);
            subtitulo.setText(SUBTITULOS[indice]);
        });

        JPanel content = new JPanel();
        content.setBackground(BG);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createEmptyBorder(56, 64, 56, 64));

        content.add(Box.createVerticalGlue());
        content.add(saludo);
        content.add(Box.createVerticalStrut(10));
        content.add(subtitulo);
        content.add(Box.createVerticalStrut(32));
        content.add(boton);
        content.add(Box.createVerticalGlue());

        frame.setContentPane(content);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static Font fuente(int estilo, int tamano) {
        String[] nombres = { "Segoe UI", "Helvetica Neue", "Dialog" };
        for (String nombre : nombres) {
            Font f = new Font(nombre, estilo, tamano);
            if (!nombre.equals("Dialog") && f.getFamily().equals(Font.DIALOG)) {
                continue;
            }
            return f;
        }
        return new Font(Font.DIALOG, estilo, tamano);
    }

    private static class RoundedButton extends JButton {

        private static final int RADIO = 44;
        private boolean hover = false;

        RoundedButton(String texto) {
            super(texto);
            setContentAreaFilled(false);
            setBorderPainted(false);
            setFocusPainted(false);
            setOpaque(false);
            setForeground(ON_ACCENT);
            setFont(fuente(Font.PLAIN, 13));
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            setPreferredSize(new Dimension(160, 44));

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    hover = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    hover = false;
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(hover ? ACCENT_HOVER : ACCENT);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), RADIO, RADIO);
            g2.dispose();
            super.paintComponent(g);
        }
    }
}
