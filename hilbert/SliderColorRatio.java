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
public class SliderColorRatio extends javax.swing.JPanel {

    /** Creates new form SliderZooming */
    public SliderColorRatio() {
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
        scaleSlider_Ratio.setMaximum(8);
        scaleSlider_Ratio.setMinimum(1);
        scaleSlider_Ratio.setPaintLabels(true);
        scaleSlider_Ratio.setSnapToTicks(true);
        scaleSlider_Ratio.setValue(3);
        scaleSlider_Ratio.setOpaque(true);
        scaleSlider_Ratio.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                scaleSlider_RatioStateChanged(evt);
            }
        });
        add(scaleSlider_Ratio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 200, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ratio");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void scaleSlider_RatioStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_scaleSlider_RatioStateChanged
        JSlider src = (JSlider) evt.getSource();
        if (!src.getValueIsAdjusting()) {
            // Meander.jMenuItem10.setScale(src);
            if (Variables.ratio_enabled == true) {
                if (Variables.max_value_color_for_ratio == 1.0f
                        || Variables.max_value_color_for_ratio == 2.0f
                        || Variables.max_value_color_for_ratio == 3.0f
                        || Variables.max_value_color_for_ratio == 4.0f
                        || Variables.max_value_color_for_ratio == 5.0f
                        || Variables.max_value_color_for_ratio == 6.0f
                        || Variables.max_value_color_for_ratio == 7.0f
                        || Variables.max_value_color_for_ratio == 8.0f) {

                    Meander.jProgressBar.setValue(0);
                    Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
                    Meander.jProgressBar.repaint();
                    Meander.jProgressBar.setVisible(true);

                    Hilbert.changeHilbert();

                }
            }

        } else {
            Meander.jMenuItemRatioColor.repaint();
            Meander.jMenuItemRatioColor.revalidate();
            Variables.max_value_color_for_ratio = (float) (src.getValue());



        }
        Meander.jMenuItemRatioColor.revalidate();
    }//GEN-LAST:event_scaleSlider_RatioStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JSlider scaleSlider_Ratio;
    // End of variables declaration//GEN-END:variables
}
