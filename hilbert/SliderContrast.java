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
public class SliderContrast extends javax.swing.JPanel {

    /** Creates new form SliderZooming */
    public SliderContrast() {
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

        scaleSlider_Ratio = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(200, 20));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scaleSlider_Ratio.setBackground(new java.awt.Color(255, 255, 255));
        scaleSlider_Ratio.setMajorTickSpacing(1);
        scaleSlider_Ratio.setMinimum(1);
        scaleSlider_Ratio.setMinorTickSpacing(1);
        scaleSlider_Ratio.setSnapToTicks(true);
        scaleSlider_Ratio.setValue(1);
        scaleSlider_Ratio.setOpaque(true);
        scaleSlider_Ratio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                scaleSlider_RatioStateChanged(evt);
            }
        });
        add(scaleSlider_Ratio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 200, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Contrast");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void scaleSlider_RatioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_scaleSlider_RatioStateChanged
        JSlider src = (JSlider) evt.getSource();

        if (!src.getValueIsAdjusting()) {
            Variables.contrast = (100 + (double) src.getValue()) / 100;
        } else {
            Variables.contrast_memory = (100 + (double) src.getValue()) / 100;
        }



    }//GEN-LAST:event_scaleSlider_RatioStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JSlider scaleSlider_Ratio;
    // End of variables declaration//GEN-END:variables
}