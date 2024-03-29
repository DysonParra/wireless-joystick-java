/*
 * @fileoverview    {ButtonActionSetterFrame}
 *
 * @version         2.0
 *
 * @author          Dyson Arley Parra Tilano <dysontilano@gmail.com>
 *
 * @copyright       Dyson Parra
 * @see             github.com/DysonParra
 *
 * History
 * @version 1.0     Implementation done.
 * @version 2.0     Documentation added.
 */
package com.project.dev.wirelessjoystick.desktop.frame;

import com.project.dev.joystick.button.GenericButton;
import com.project.dev.joystick.button.GenericButtonActionListener;
import com.project.dev.tray.setter.TrayIconSetter;
import com.project.dev.wirelessjoystick.desktop.nativecode.VirtualEvent;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * TODO: Description of {@code ButtonActionSetterFrame}.
 *
 * @author Dyson Parra
 * @since 11
 */
public class ButtonActionSetterFrame extends JFrame implements KeyListener {

    /*
     * Crea constantes para indicar los ejes de coordenadas donde se mueve el mouse.
     */
    private static final int AXIS_X = 0;
    private static final int AXIS_Y = 1;

    /*
     * Obtiene el alcho y alto de la pantalla.
     */
    private final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Obtiene la resolución de la pantalla.
    private final int screenWith = screenSize.width;                                   // Obtiene el ancho de la pantalla.
    private final int screenHeight = screenSize.height;                                // Obtiene el alto de la pantalla.

    /*
     * Variables locales.
     */
    private GenericButton button;

    /**
     * TODO: Description of {@code getButton}.
     *
     * @return
     */
    public GenericButton getButton() {
        return button;
    }

    /**
     * TODO: Description of {@code setButton}.
     *
     * @param button
     */
    public void setButton(GenericButton button) {
        this.button = button;
    }

    /*
     * Variables usadas para asignar datos a los spinner.
     */
    private static final String[] BUTTON_ACTIONS = {
        "Tecla",
        "Comando",
        "Clic",
        "Clic derecho",
        "Clic medio",
        "Doble clic",
        "Mover mouse izquierda",
        "Mover mouse derecha",
        "Mover mouse arriba",
        "Mover mouse abajo"
    };
    private static final String[] LABEL_MESSAGES = {
        "Escoja el tipo de acción para el botón",
        "Presione una tecla."
    };

    /**
     * TODO: Description of {@code ButtonActionSetterFrame}.
     *
     */
    public ButtonActionSetterFrame() {
        initComponents();

        // Asigna valores al spinner con las acciones para el botón.
        for (String action : BUTTON_ACTIONS)
            spnButtonAction.addItem(action);
        messageLabel.setText(LABEL_MESSAGES[0]);
        messageLabel.setHorizontalAlignment(JTextField.CENTER);
    }

    /**
     * FIXME: Description of {@code startFrame}. Inicializa el frame con la información obtenida del
     * frame anterior.
     */
    public void startFrame() {
        if (button != null) {
            this.setTitle(button.getName());
            this.setIconImage(((ImageIcon) (button.getButtonImage(GenericButton.BUTTON_RELEASED).getGraphic())).getImage());
            TrayIconSetter.setTrayIconToFrame(this);
        } else
            dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT
     * modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        messageLabel = new javax.swing.JLabel();
        spnButtonAction = new javax.swing.JComboBox<>();
        btnAssignAction = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusCycleRoot(false);
        setResizable(false);

        messageLabel.setText(" ");

        spnButtonAction.setFocusable(false);
        spnButtonAction.addActionListener(this::spnButtonActionActionPerformed);

        btnAssignAction.setText("Asignar");
        btnAssignAction.setFocusable(false);
        btnAssignAction.setPreferredSize(new java.awt.Dimension(90, 32));
        btnAssignAction.addActionListener(this::btnAssignActionActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(messageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(112, 112, 112)
                                                .addComponent(btnAssignAction, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(spnButtonAction, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(messageLabel)
                                .addGap(30, 30, 30)
                                .addComponent(spnButtonAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnAssignAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * TODO: Description of {@code btnAssignActionActionPerformed}.
     *
     * @param evt
     */
    private void btnAssignActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignActionActionPerformed

        // Evalúa el tipo de acción a asignar al botón.
        switch (BUTTON_ACTIONS[spnButtonAction.getSelectedIndex()]) {
            case "Tecla":
                messageLabel.setText(LABEL_MESSAGES[1]);
                addKeyListener(this);
                spnButtonAction.setEnabled(false);
                btnAssignAction.setEnabled(false);
                break;

            case "Comando":
                String result = JOptionPane.showInputDialog(this, "Escriba un comando", null);

                if (result != null) {
                    if (result.isEmpty())
                        JOptionPane.showMessageDialog(this, "Escriba un comando primero.");
                    else {
                        String[] cmd = result.split(" ");
                        addButtonCommandEvent(button, cmd);
                        dispose();
                    }
                }
                break;

            case "Clic":
                if (!addButtonActionMouseClicEvent(button, VirtualEvent.VK_MOUSE_CLIC_EVENT_LEFT))
                    printLinkError();
                dispose();
                break;

            case "Clic derecho":
                if (!addButtonActionMouseClicEvent(button, VirtualEvent.VK_MOUSE_CLIC_EVENT_RIGHT))
                    printLinkError();
                dispose();
                break;

            case "Clic medio":
                if (!addButtonActionMouseClicEvent(button, VirtualEvent.VK_MOUSE_CLIC_EVENT_MIDDLE))
                    printLinkError();
                dispose();
                break;

            case "Doble clic":
                if (!addButtonActionMouseClicEvent(button, VirtualEvent.VK_MOUSE_CLIC_EVENT_LEFT_DOUBLE))
                    printLinkError();
                dispose();
                break;

            case "Mover mouse izquierda":
                int leftPixels = getButtonMouseMoveEventPixels(AXIS_X);
                if (leftPixels >= 0) {
                    if (!addButtonActionMouseMoveEvent(button, VirtualEvent.VK_MOUSE_MOVE_EVENT_LEFT, leftPixels))
                        printLinkError();
                    dispose();
                }
                break;

            case "Mover mouse derecha":
                int rightPixels = getButtonMouseMoveEventPixels(AXIS_X);
                if (rightPixels >= 0) {
                    if (!addButtonActionMouseMoveEvent(button, VirtualEvent.VK_MOUSE_MOVE_EVENT_RIGHT, rightPixels))
                        printLinkError();
                    dispose();
                }
                break;

            case "Mover mouse arriba":
                int upPixels = getButtonMouseMoveEventPixels(AXIS_Y);
                if (upPixels >= 0) {
                    if (!addButtonActionMouseMoveEvent(button, VirtualEvent.VK_MOUSE_MOVE_EVENT_UP, upPixels))
                        printLinkError();
                    dispose();
                }
                break;

            case "Mover mouse abajo":
                int downPixels = getButtonMouseMoveEventPixels(AXIS_Y);
                if (downPixels >= 0) {
                    if (!addButtonActionMouseMoveEvent(button, VirtualEvent.VK_MOUSE_MOVE_EVENT_DOWN, downPixels))
                        printLinkError();
                    dispose();
                }
                break;
        }
    }//GEN-LAST:event_btnAssignActionActionPerformed

    /**
     * TODO: Description of {@code spnButtonActionActionPerformed}.
     *
     * @param evt
     */
    private void spnButtonActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spnButtonActionActionPerformed
    }//GEN-LAST:event_spnButtonActionActionPerformed

    /**
     * Entrada principal del sistema.
     *
     * @param args argumentos de la linea de comandos.
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ButtonActionSetterFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new ButtonActionSetterFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignAction;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JComboBox<String> spnButtonAction;
    // End of variables declaration//GEN-END:variables

    /**
     * TODO: Description of {@code keyTyped}.
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * TODO: Description of {@code keyReleased}.
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * TODO: Description of {@code keyPressed}.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();
        int keyInt = keyChar;
        //System.out.println(keyCode + " " + keyInt + " " + "'" + keyChar + "'");

        // Si la tecla oprimida tiene igual código en java y en C.
        if ((keyCode == 8)
                || (keyCode >= 16 && keyCode <= 18)
                || (keyCode == 20)
                || (keyCode == 27)
                || (keyCode >= 32 && keyCode <= 40)
                || (keyCode >= 48 && keyCode <= 57)
                || (keyCode >= 65 && keyCode <= 90)
                || (keyCode >= 96 && keyCode <= 107)
                || (keyCode >= 109 && keyCode <= 123)
                || (keyCode == 144)) {
            if (!addButtonActionKeyEvent(button, keyCode))
                printLinkError();
            dispose();
        } // Si la tecla oprimida tiene diferente código en java y en C, pero solo es necesario un cambio de código.
        else if ((keyCode == 9)
                || (keyCode == 10)
                || (keyCode == 154)
                || (keyCode == 155)
                || (keyCode == 127)
                || (keyCode == 524)
                || (keyCode == 525)
                || (keyCode == 44)
                || (keyCode == 46)) {
            int keyCodeForC = 0;
            switch (keyCode) {
                case 9:
                    keyCodeForC = 9;
                    break;
                case 10:
                    keyCodeForC = 13;
                    break;
                case 154:
                    keyCodeForC = 44;
                    break;
                case 155:
                    keyCodeForC = 45;
                    break;
                case 127:
                    keyCodeForC = 46;
                    break;
                case 524:
                    keyCodeForC = 91;
                    break;
                case 525:
                    keyCodeForC = 93;
                    break;
                case 44:
                    keyCodeForC = 188;
                    break;
                case 46:
                    keyCodeForC = 190;
                    break;
            }
            if (!addButtonActionKeyEvent(button, keyCodeForC))
                printLinkError();
            dispose();
        } // Si la tecla oprimida tiene diferente código en java y en C, y no es posile.
        // hacer la traducción del código de tecla actual a uno de C independiente del idioma del teclado.
        else if ((keyCode == 0)
                || (keyCode == 192)
                || (keyCode == 222) // Repetido.
                || (keyCode == 45) // Repetido.

                || (keyCode == 0)
                || (keyCode == 61)
                || (keyCode == 129)
                || (keyCode == 91)
                || (keyCode == 521)
                || (keyCode == 93)
                || (keyCode == 0)
                || (keyCode == 59)
                || (keyCode == 161)
                || (keyCode == 222) // Repetido.

                || (keyCode == 162)
                || (keyCode == 92) // Repetido.

                || (keyCode == 153)
                || (keyCode == 92) // Repetido.

                || (keyCode == 45) // Repetido.
                || (keyCode == 47)) {
            int response = JOptionPane.showConfirmDialog(this,
                    "Ha escogido una tecla OEM,\n"
                    + "dependiendo del idioma del\n"
                    + "sistema y de la configuración\n"
                    + "regional la tecla podría no\n"
                    + "funcionar correctamente,\n"
                    + "¿aún así desea continuar?");
            if (response == JOptionPane.OK_OPTION) {
                int keyCodeForC = 0;
                switch (keyCode) {
                    // Códigos OEM en teclado latinoamericano.

                    case 0:
                        switch (keyChar) {
                            case '|':
                                keyCodeForC = 220;
                                break;

                            case '¿':
                                keyCodeForC = 221;
                                break;

                            case 'ñ':
                            case 'Ñ':
                                keyCodeForC = 192;
                                break;
                        }
                        break;

                    case 222:
                        keyCodeForC = 219;
                        break;

                    case 129:
                        keyCodeForC = 186;
                        break;

                    case 521:
                        keyCodeForC = 187;
                        break;

                    case 161:
                        keyCodeForC = 222;
                        break;

                    case 162:
                        keyCodeForC = 191;
                        break;

                    case 153:
                        keyCodeForC = 226;
                        break;

                    case 45:
                        keyCodeForC = 189;
                        break;

                    // Códigos OEM en teclado ingles.
                    case 192:
                        keyCodeForC = 192;
                        break;
                    /*
                     * -
                     * case 45: keyCodeForC = 189; break;
                     */
                    case 61:
                        keyCodeForC = 187;
                        break;

                    case 91:
                        keyCodeForC = 219;
                        break;

                    case 93:
                        keyCodeForC = 221;
                        break;

                    case 59:
                        keyCodeForC = 186;
                        break;
                    /*
                     * -
                     * case 222: keyCodeForC = 222; break;
                     */
                    case 92:
                        keyCodeForC = 220;
                        break;
                    /*
                     * -
                     * case 92: keyCodeForC = 226; break;
                     */
                    case 47:
                        keyCodeForC = 191;
                        break;
                }

                if (keyCodeForC != 0) {
                    if (!addButtonActionKeyEvent(button, keyCodeForC))
                        printLinkError();
                    dispose();
                } else
                    JOptionPane.showMessageDialog(this, "Escoja una tecla diferente.");
            }
        } // Si la tecla oprimida no está en un teclado estándar. (Como teclas multimedia).
        else {
            JOptionPane.showMessageDialog(this, "Escoja una tecla diferente.");
        }

        messageLabel.setText(LABEL_MESSAGES[0]);
        removeKeyListener(this);
        spnButtonAction.setEnabled(true);
        btnAssignAction.setEnabled(true);
    }

    /**
     * FIXME: Description of {@code addButtonActionKeyEvent}. Agrega un evento de teclado en código
     * nativo a un botón
     *
     * @param button         es el botón
     * @param virtualKeyCode es el código del evento de teclado virtual.
     * @return si fue posible agregar el evento de teclado al botón.
     */
    public boolean addButtonActionKeyEvent(GenericButton button, final int virtualKeyCode) {
        final VirtualEvent virtualEvent = new VirtualEvent();
        if (VirtualEvent.isLinkedDll()) {
            if (button != null)
                button.setOnActionListener(new GenericButtonActionListener() {
                    int eventCode = virtualKeyCode;

                    @Override
                    public void onReleased() {

                    }

                    @Override
                    public void onTyped() {
                        //System.out.println("Typed Key is: " + eventCode);
                        virtualEvent.runVirtualKeyEvent(eventCode);
                    }

                    @Override
                    public void onPressed() {
                        //System.out.println("Pressed Key is: " + eventCode);
                        virtualEvent.runVirtualKeyEvent(eventCode);
                    }

                    @Override
                    public void onUnpressed() {

                    }
                });

            return true;
        }

        return false;
    }

    /**
     * FIXME: Description of {@code addButtonCommandEvent}. Agrega un evento de ejecución de un
     * comando a un botón.
     *
     * @param button  es el botón
     * @param command es el comando.
     */
    public void addButtonCommandEvent(GenericButton button, final String[] command) {
        if (button != null)
            button.setOnActionListener(new GenericButtonActionListener() {
                String[] buttonCommand = command;

                @Override
                public void onReleased() {

                }

                @Override
                public void onTyped() {
                    //shutdown -s -t 3600
                    //shutdown /a
                    try {
                        Runtime.getRuntime().exec(buttonCommand);
                    } catch (IOException ex) {
                        Logger.getLogger(ButtonActionSetterFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                @Override
                public void onPressed() {

                }

                @Override
                public void onUnpressed() {

                }
            });
    }

    /**
     * FIXME: Description of {@code addButtonActionMouseClicEvent}. Agrega un evento de clic en
     * código nativo a un botón
     *
     * @param button             es el botón
     * @param mouseClicEventCode es el código del evento de clic.
     * @return si fue posible agregar el evento de clic al botón.
     */
    public boolean addButtonActionMouseClicEvent(GenericButton button, final int mouseClicEventCode) {
        final VirtualEvent virtualEvent = new VirtualEvent();
        if (VirtualEvent.isLinkedDll()) {
            if (button != null)
                button.setOnActionListener(new GenericButtonActionListener() {
                    int eventCode = mouseClicEventCode;

                    @Override
                    public void onReleased() {

                    }

                    @Override
                    public void onTyped() {
                        //System.out.println("Typed mouse event clic is: " + eventCode);
                        virtualEvent.runVirtualMouseClicEvent(eventCode);
                    }

                    @Override
                    public void onPressed() {
                        //System.out.println("Pressed mouse event clic is: " + eventCode);
                        virtualEvent.runVirtualMouseClicEvent(eventCode);
                    }

                    @Override
                    public void onUnpressed() {

                    }
                });

            return true;
        }

        return false;
    }

    /**
     * FIXME: Description of {@code printLinkError}. Imprime un error si no es posible asignar el
     * avente algún botón.
     */
    private void printLinkError() {
        JOptionPane.showMessageDialog(
                this, "No es posible asignar el evento:\n"
                + "(" + VirtualEvent.getLinkErrorMessage() + ")"
                + "\nAsegurese de estar usando una versión de java de 32 bits");
    }

    /**
     * FIXME: Description of {@code getButtonMouseMoveEventPixels}. Obtiene la cantidad de píxeles
     * para un evento de mover mouse.
     *
     * @param axis es el eje de coordenas dond se moverá el mouse (x ó y).
     * @return la cantiad de píxeles obtenida.
     */
    public int getButtonMouseMoveEventPixels(int axis) {
        String pixelsInput = JOptionPane.showInputDialog(this, "Escriba la cantidad de píxeles", null);

        if (pixelsInput != null) {
            if (pixelsInput.isEmpty())
                JOptionPane.showMessageDialog(this, "Escriba un valor primero.");
            else {
                int pixelQuantity;
                try {
                    pixelQuantity = Integer.parseInt(pixelsInput);
                    //System.out.println("pixels is: " + pixelQuantity);
                    if (pixelQuantity > 0) {
                        switch (axis) {
                            case AXIS_X:
                                if (pixelQuantity < screenWith)
                                    return pixelQuantity;
                                else
                                    JOptionPane.showMessageDialog(this, "Escriba un valor menor que el ancho de la pantalla.");
                                break;

                            case AXIS_Y:
                                if (pixelQuantity < screenHeight)
                                    return pixelQuantity;
                                else
                                    JOptionPane.showMessageDialog(this, "Escriba un valor menor que el alto de la pantalla.");
                                break;
                        }
                    } else
                        throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Escriba un valor válido.");
                }
            }
        }
        return -1;
    }

    /**
     * FIXME: Description of {@code addButtonActionMouseMoveEvent}. Agrega un evento de mover mouse
     * en código nativo a un botón
     *
     * @param button             es el botón
     * @param mouseMoveEventCode es el código del evento de mover.
     * @param pixelQuantity      es la acnditdad de píxeles que se moverá el mouse.
     * @return si fue posible agregar el evento de mover el mouse al botón.
     */
    public boolean addButtonActionMouseMoveEvent(GenericButton button, final int mouseMoveEventCode, final int pixelQuantity) {
        final VirtualEvent virtualEvent = new VirtualEvent();

        if (VirtualEvent.isLinkedDll()) {
            if (button != null)
                button.setOnActionListener(new GenericButtonActionListener() {
                    int eventCode = mouseMoveEventCode;

                    @Override
                    public void onReleased() {

                    }

                    @Override
                    public void onTyped() {
                        //System.out.println("Typed mouse event move is: " + eventCode);
                        virtualEvent.runVirtualMouseMoveEvent(eventCode, pixelQuantity);
                    }

                    @Override
                    public void onPressed() {
                        //System.out.println("Pressed mouse event move is: " + eventCode);
                        virtualEvent.runVirtualMouseMoveEvent(eventCode, pixelQuantity);
                    }

                    @Override
                    public void onUnpressed() {

                    }
                });

            return true;
        }

        return false;
    }
}
