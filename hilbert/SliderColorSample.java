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
public class SliderColorSample extends javax.swing.JPanel {

    /** Creates new form SliderZooming */
    public SliderColorSample() {
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

        scaleSlider_Sample = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(200, 20));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scaleSlider_Sample.setBackground(new java.awt.Color(255, 255, 255));
        scaleSlider_Sample.setMajorTickSpacing(100);
        scaleSlider_Sample.setMaximum(500);
        scaleSlider_Sample.setMinimum(10);
        scaleSlider_Sample.setPaintLabels(true);
        scaleSlider_Sample.setValue(300);
        scaleSlider_Sample.setOpaque(true);
        scaleSlider_Sample.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                scaleSlider_SampleStateChanged(evt);
            }
        });
        add(scaleSlider_Sample, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 210, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sample");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void scaleSlider_SampleStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_scaleSlider_SampleStateChanged
        JSlider src = (JSlider) evt.getSource();
        if (!src.getValueIsAdjusting()) {
            // Meander.jMenuItem10.setScale(src);
            if (Variables.sample_enabled == true) {
                {
                    Variables.max_value_color_for_sample = (int) (src.getValue());
                    Meander.jProgressBar.setValue(0);
                    Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
                    Meander.jProgressBar.repaint();
                    Meander.jProgressBar.setVisible(true);
                    Hilbert.changeHilbert();
                }
            }
        } else {
            Meander.jMenuItemSampleColor.repaint();
            Meander.jMenuItemSampleColor.revalidate();
            Variables.max_value_color_for_sample = (int) (src.getValue());


        }
        Meander.jMenuItemSampleColor.revalidate();
    }//GEN-LAST:event_scaleSlider_SampleStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JSlider scaleSlider_Sample;
    // End of variables declaration//GEN-END:variables
}
