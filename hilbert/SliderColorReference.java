/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SliderZooming.java
 *
 * Created on Nov 22, 2008, 3:17:24 PM
 */
package hilbert;

import javax.swing.JSlider;

/**
 *
 * @author Georgios
 */
public class SliderColorReference extends javax.swing.JPanel {

    /** Creates new form SliderZooming */
    public SliderColorReference() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scaleSlider_Reference = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(200, 20));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scaleSlider_Reference.setBackground(new java.awt.Color(255, 255, 255));
        scaleSlider_Reference.setMajorTickSpacing(100);
        scaleSlider_Reference.setMaximum(500);
        scaleSlider_Reference.setMinimum(10);
        scaleSlider_Reference.setPaintLabels(true);
        scaleSlider_Reference.setOpaque(true);
        scaleSlider_Reference.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                scaleSlider_ReferenceStateChanged(evt);
            }
        });
        add(scaleSlider_Reference, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 210, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Reference");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void scaleSlider_ReferenceStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_scaleSlider_ReferenceStateChanged
        JSlider src = (JSlider) evt.getSource();
        if (!src.getValueIsAdjusting()) {
            // Meander.jMenuItem10.setScale(src);
            if (Variables.reference_enabled == true) {
                
                Variables.max_value_color_for_reference = (int) (src.getValue());
                    Meander.jProgressBar.setValue(0);
                    Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
                    Meander.jProgressBar.repaint();
                    Meander.jProgressBar.setVisible(true);

                    Hilbert.changeHilbert();

                
            }
        } else {
            Meander.jMenuItemReferenceColor.repaint();
            Meander.jMenuItemReferenceColor.revalidate();
            Variables.max_value_color_for_reference = (int) (src.getValue());

        }
        Meander.jMenuItemReferenceColor.revalidate();
    }//GEN-LAST:event_scaleSlider_ReferenceStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JSlider scaleSlider_Reference;
    // End of variables declaration//GEN-END:variables
}
