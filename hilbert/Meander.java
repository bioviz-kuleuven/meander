package hilbert;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author gpavlopo
 */
public class Meander extends javax.swing.JFrame {

    /** Creates new form JFrame */
    public Meander() {

        initComponents();


        load_chromosome_lengths();
        disable_interface();
    }
    private boolean rd_loaded = false;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_chromosome = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        this.addKeyListener(new MyKeyListener());
        label_zoom_level = new javax.swing.JLabel();
        panel_zoom = new javax.swing.JPanel();
        jComboBox_zoom_levels = new javax.swing.JComboBox();
        jComboBox_zoom_levels.setLightWeightPopupEnabled(false);
        jButton_zoom = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        panel_position_in_chromosome = new javax.swing.JPanel();
        panel_hilbert = new javax.swing.JPanel();
        jLabel_status = new javax.swing.JLabel();
        jProgressBar = new javax.swing.JProgressBar();
        panel_pairEnd = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu_variations = new javax.swing.JMenu();
        jMenu_variations.getPopupMenu().setLightWeightPopupEnabled(false);
        jMenuItem6 = new javax.swing.JMenuItem();
        file_Open = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenu3.getPopupMenu().setLightWeightPopupEnabled(false);
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItemSampleColor = new javax.swing.JMenuItem();
        hilbert.SliderColorSample slider = new hilbert.SliderColorSample();
        jMenuItemSampleColor.setPreferredSize(new java.awt.Dimension(slider.getPreferredSize().width+25, slider.getPreferredSize().height+5));
        jMenuItemSampleColor.setLayout(new BorderLayout());
        jMenuItemSampleColor.add(slider);
        jMenuItemSampleColor.repaint();
        jMenuItemReferenceColor = new javax.swing.JMenuItem();
        hilbert.SliderColorReference slider2 = new hilbert.SliderColorReference();
        jMenuItemReferenceColor.setPreferredSize(new java.awt.Dimension(slider2.getPreferredSize().width+25, slider2.getPreferredSize().height+5));
        jMenuItemReferenceColor.setLayout(new BorderLayout());
        jMenuItemReferenceColor.add(slider2);
        jMenuItemReferenceColor.repaint();
        jMenuItemRatioColor = new javax.swing.JMenuItem();
        hilbert.SliderColorRatio slider3 = new hilbert.SliderColorRatio();
        jMenuItemRatioColor.setPreferredSize(new java.awt.Dimension(slider3.getPreferredSize().width+25, slider3.getPreferredSize().height+5));
        jMenuItemRatioColor.setLayout(new BorderLayout());
        jMenuItemRatioColor.add(slider3);
        jMenuItemRatioColor.repaint();
        jMenuItemContrast = new javax.swing.JMenuItem();
        hilbert.SliderContrast slider4 = new hilbert.SliderContrast();
        jMenuItemContrast.setPreferredSize(new java.awt.Dimension(slider4.getPreferredSize().width+25, slider4.getPreferredSize().height+5));
        jMenuItemContrast.setLayout(new BorderLayout());
        jMenuItemContrast.add(slider4);
        jMenuItemContrast.repaint();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu2.getPopupMenu().setLightWeightPopupEnabled(false);
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meander 1.0");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_chromosome.setBackground(new java.awt.Color(255, 255, 255));
        panel_chromosome.setForeground(new java.awt.Color(255, 255, 255));

        org.jdesktop.layout.GroupLayout panel_chromosomeLayout = new org.jdesktop.layout.GroupLayout(panel_chromosome);
        panel_chromosome.setLayout(panel_chromosomeLayout);
        panel_chromosomeLayout.setHorizontalGroup(
            panel_chromosomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 1070, Short.MAX_VALUE)
        );
        panel_chromosomeLayout.setVerticalGroup(
            panel_chromosomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 162, Short.MAX_VALUE)
        );

        getContentPane().add(panel_chromosome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 1070, 162));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        label_zoom_level.setForeground(new java.awt.Color(102, 0, 0));
        label_zoom_level.setText("Current Zoom Level: 1");

        panel_zoom.setBackground(new java.awt.Color(255, 255, 255));
        panel_zoom.setPreferredSize(new java.awt.Dimension(260, 260));

        org.jdesktop.layout.GroupLayout panel_zoomLayout = new org.jdesktop.layout.GroupLayout(panel_zoom);
        panel_zoom.setLayout(panel_zoomLayout);
        panel_zoomLayout.setHorizontalGroup(
            panel_zoomLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 258, Short.MAX_VALUE)
        );
        panel_zoomLayout.setVerticalGroup(
            panel_zoomLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 258, Short.MAX_VALUE)
        );

        jComboBox_zoom_levels.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Zoom Level:  x1", "Zoom Level:  x2", "Zoom Level:  x3", "Zoom Level:  x4", "Zoom Level:  x5" }));
        jComboBox_zoom_levels.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_zoom_levelsActionPerformed(evt);
            }
        });

        jButton_zoom.setText("Apply");
        jButton_zoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_zoomActionPerformed(evt);
            }
        });

        jLabel3.setText("Whole Chromosome");

        panel_position_in_chromosome.setBackground(new java.awt.Color(255, 255, 255));
        panel_position_in_chromosome.setForeground(new java.awt.Color(255, 255, 255));
        panel_position_in_chromosome.setPreferredSize(new java.awt.Dimension(262, 300));

        org.jdesktop.layout.GroupLayout panel_position_in_chromosomeLayout = new org.jdesktop.layout.GroupLayout(panel_position_in_chromosome);
        panel_position_in_chromosome.setLayout(panel_position_in_chromosomeLayout);
        panel_position_in_chromosomeLayout.setHorizontalGroup(
            panel_position_in_chromosomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 270, Short.MAX_VALUE)
        );
        panel_position_in_chromosomeLayout.setVerticalGroup(
            panel_position_in_chromosomeLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 348, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jComboBox_zoom_levels, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 170, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jButton_zoom))
                    .add(panel_zoom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 258, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(label_zoom_level, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 160, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(12, 12, 12))
            .add(panel_position_in_chromosome, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(73, Short.MAX_VALUE)
                .add(jLabel3)
                .add(71, 71, 71))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(label_zoom_level)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panel_zoom, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 258, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jComboBox_zoom_levels, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton_zoom))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel3)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(panel_position_in_chromosome, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 348, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(41, 41, 41))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 0, 270, 730));

        panel_hilbert.setBackground(new java.awt.Color(255, 255, 255));
        panel_hilbert.setForeground(new java.awt.Color(255, 255, 255));
        panel_hilbert.setPreferredSize(new java.awt.Dimension(560, 560));

        org.jdesktop.layout.GroupLayout panel_hilbertLayout = new org.jdesktop.layout.GroupLayout(panel_hilbert);
        panel_hilbert.setLayout(panel_hilbertLayout);
        panel_hilbertLayout.setHorizontalGroup(
            panel_hilbertLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 560, Short.MAX_VALUE)
        );
        panel_hilbertLayout.setVerticalGroup(
            panel_hilbertLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 560, Short.MAX_VALUE)
        );

        getContentPane().add(panel_hilbert, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 560, -1));

        jLabel_status.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_status.setOpaque(true);
        getContentPane().add(jLabel_status, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 720, 140, 20));

        jProgressBar.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar.setFont(new java.awt.Font("Lucida Grande", 0, 10));
        jProgressBar.setForeground(new java.awt.Color(255, 255, 255));
        jProgressBar.setMaximum(262144);
        jProgressBar.setBorder(null);
        jProgressBar.setBorderPainted(false);
        jProgressBar.setDoubleBuffered(true);
        jProgressBar.setFocusable(false);
        jProgressBar.setRequestFocusEnabled(false);
        getContentPane().add(jProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 720, 910, 20));

        panel_pairEnd.setBackground(new java.awt.Color(255, 255, 255));
        panel_pairEnd.setPreferredSize(new java.awt.Dimension(514, 514));

        org.jdesktop.layout.GroupLayout panel_pairEndLayout = new org.jdesktop.layout.GroupLayout(panel_pairEnd);
        panel_pairEnd.setLayout(panel_pairEndLayout);
        panel_pairEndLayout.setHorizontalGroup(
            panel_pairEndLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 514, Short.MAX_VALUE)
        );
        panel_pairEndLayout.setVerticalGroup(
            panel_pairEndLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 560, Short.MAX_VALUE)
        );

        getContentPane().add(panel_pairEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 514, 560));

        jMenuBar1.setBorder(null);

        jMenu_variations.setText("File");
        jMenu_variations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu_variationsActionPerformed(evt);
            }
        });

        jMenuItem6.setText("Open Meander File");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu_variations.add(jMenuItem6);

        file_Open.setText("Open Zoom Level");
        file_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_OpenActionPerformed(evt);
            }
        });
        jMenu_variations.add(file_Open);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Load Variations");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu_variations.add(jMenuItem4);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem10.setText("Load PairEnds");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu_variations.add(jMenuItem10);

        jMenuBar1.add(jMenu_variations);

        jMenu3.setText("Tools");
        jMenu3.setPreferredSize(new java.awt.Dimension(121, 21));

        jMenuItem1.setText("Red - Green");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem5.setText("Blue - Yellow");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem5);

        jMenuItem8.setText("Blue - Red");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jCheckBoxMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("InterChromosomal variations");
        jCheckBoxMenuItem1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxMenuItem1ItemStateChanged(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem1);

        jCheckBoxMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem2.setText("Show areas with double evidence (RD+PE)");
        jCheckBoxMenuItem2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBoxMenuItem2ItemStateChanged(evt);
            }
        });
        jMenu3.add(jCheckBoxMenuItem2);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Set as Zooming Image");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItemSampleColor.setText("jMenuItem10");
        jMenuItemSampleColor.setPreferredSize(new java.awt.Dimension(289, 49));
        jMenu3.add(jMenuItemSampleColor);

        jMenuItemReferenceColor.setText("jMenuItem11");
        jMenuItemReferenceColor.setPreferredSize(new java.awt.Dimension(289, 49));
        jMenu3.add(jMenuItemReferenceColor);

        jMenuItemRatioColor.setText("jMenuItem12");
        jMenuItemRatioColor.setPreferredSize(new java.awt.Dimension(289, 49));
        jMenuItemRatioColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRatioColorActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemRatioColor);

        jMenuItemContrast.setText("Contrast");
        jMenuItemContrast.setPreferredSize(new java.awt.Dimension(289, 49));
        jMenuItemContrast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemContrastActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemContrast);

        jMenuItem9.setText("PE Threshold");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("About");
        jMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu2ActionPerformed(evt);
            }
        });

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Development team");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Web page");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void load_chromosome_lengths() {
        Variables.get_human_Chr_lengths.add(249250621);
        Variables.get_human_Chr_lengths.add(243199373);
        Variables.get_human_Chr_lengths.add(198022430);
        Variables.get_human_Chr_lengths.add(191154276);
        Variables.get_human_Chr_lengths.add(180915260);
        Variables.get_human_Chr_lengths.add(171115067);
        Variables.get_human_Chr_lengths.add(159138663);
        Variables.get_human_Chr_lengths.add(146364022);
        Variables.get_human_Chr_lengths.add(141213431);
        Variables.get_human_Chr_lengths.add(135534747);
        Variables.get_human_Chr_lengths.add(135006516);
        Variables.get_human_Chr_lengths.add(133851895);
        Variables.get_human_Chr_lengths.add(115169878);
        Variables.get_human_Chr_lengths.add(107349540);
        Variables.get_human_Chr_lengths.add(102531392);
        Variables.get_human_Chr_lengths.add(90354753);
        Variables.get_human_Chr_lengths.add(81195210);
        Variables.get_human_Chr_lengths.add(78077248);
        Variables.get_human_Chr_lengths.add(59128983);
        Variables.get_human_Chr_lengths.add(63025520);
        Variables.get_human_Chr_lengths.add(48129895);
        Variables.get_human_Chr_lengths.add(51304566);
        Variables.get_human_Chr_lengths.add(155270560);
        Variables.get_human_Chr_lengths.add(59373566);
        Variables.get_human_Chr_names.add("1");
        Variables.get_human_Chr_names.add("2");
        Variables.get_human_Chr_names.add("3");
        Variables.get_human_Chr_names.add("4");
        Variables.get_human_Chr_names.add("5");
        Variables.get_human_Chr_names.add("6");
        Variables.get_human_Chr_names.add("7");
        Variables.get_human_Chr_names.add("8");
        Variables.get_human_Chr_names.add("9");
        Variables.get_human_Chr_names.add("10");
        Variables.get_human_Chr_names.add("11");
        Variables.get_human_Chr_names.add("12");
        Variables.get_human_Chr_names.add("13");
        Variables.get_human_Chr_names.add("14");
        Variables.get_human_Chr_names.add("15");
        Variables.get_human_Chr_names.add("16");
        Variables.get_human_Chr_names.add("17");
        Variables.get_human_Chr_names.add("18");
        Variables.get_human_Chr_names.add("19");
        Variables.get_human_Chr_names.add("20");
        Variables.get_human_Chr_names.add("21");
        Variables.get_human_Chr_names.add("22");
        Variables.get_human_Chr_names.add("X");
        Variables.get_human_Chr_names.add("Y");


        Variables.get_arabidopsis_Chr_lengths.add(30427671);
        Variables.get_arabidopsis_Chr_lengths.add(19698289);
        Variables.get_arabidopsis_Chr_lengths.add(23459830);
        Variables.get_arabidopsis_Chr_lengths.add(18585056);
        Variables.get_arabidopsis_Chr_lengths.add(26975502);
        Variables.get_arabidopsis_Chr_names.add("1");
        Variables.get_arabidopsis_Chr_names.add("2");
        Variables.get_arabidopsis_Chr_names.add("3");
        Variables.get_arabidopsis_Chr_names.add("4");
        Variables.get_arabidopsis_Chr_names.add("5");





        Variables.get_chimp_Chr_lengths.add(228333871);
        Variables.get_chimp_Chr_lengths.add(247518478);
        Variables.get_chimp_Chr_lengths.add(113622374);
        Variables.get_chimp_Chr_lengths.add(202329955);
        Variables.get_chimp_Chr_lengths.add(193495092);
        Variables.get_chimp_Chr_lengths.add(182651097);
        Variables.get_chimp_Chr_lengths.add(172623881);
        Variables.get_chimp_Chr_lengths.add(161824586);
        Variables.get_chimp_Chr_lengths.add(143986469);
        Variables.get_chimp_Chr_lengths.add(137840987);
        Variables.get_chimp_Chr_lengths.add(133524379);
        Variables.get_chimp_Chr_lengths.add(133121534);
        Variables.get_chimp_Chr_lengths.add(134246214);
        Variables.get_chimp_Chr_lengths.add(115123233);
        Variables.get_chimp_Chr_lengths.add(106544938);
        Variables.get_chimp_Chr_lengths.add(99548318);
        Variables.get_chimp_Chr_lengths.add(89983829);
        Variables.get_chimp_Chr_lengths.add(82630442);
        Variables.get_chimp_Chr_lengths.add(76611499);
        Variables.get_chimp_Chr_lengths.add(63644993);
        Variables.get_chimp_Chr_lengths.add(61729293);
        Variables.get_chimp_Chr_lengths.add(32799110);
        Variables.get_chimp_Chr_lengths.add(49737984);
        Variables.get_chimp_Chr_lengths.add(156848144);
        Variables.get_chimp_Chr_lengths.add(23952694);
        Variables.get_chimp_Chr_names.add("1");
        Variables.get_chimp_Chr_names.add("2B");
        Variables.get_chimp_Chr_names.add("2A");
        Variables.get_chimp_Chr_names.add("3");
        Variables.get_chimp_Chr_names.add("4");
        Variables.get_chimp_Chr_names.add("5");
        Variables.get_chimp_Chr_names.add("6");
        Variables.get_chimp_Chr_names.add("7");
        Variables.get_chimp_Chr_names.add("8");
        Variables.get_chimp_Chr_names.add("9");
        Variables.get_chimp_Chr_names.add("10");
        Variables.get_chimp_Chr_names.add("11");
        Variables.get_chimp_Chr_names.add("12");
        Variables.get_chimp_Chr_names.add("13");
        Variables.get_chimp_Chr_names.add("14");
        Variables.get_chimp_Chr_names.add("15");
        Variables.get_chimp_Chr_names.add("16");
        Variables.get_chimp_Chr_names.add("17");
        Variables.get_chimp_Chr_names.add("18");
        Variables.get_chimp_Chr_names.add("19");
        Variables.get_chimp_Chr_names.add("20");
        Variables.get_chimp_Chr_names.add("21");
        Variables.get_chimp_Chr_names.add("22");
        Variables.get_chimp_Chr_names.add("X");
        Variables.get_chimp_Chr_names.add("Y");


        Variables.get_drosophila_Chr_names.add("2L");
        Variables.get_drosophila_Chr_names.add("2R");
        Variables.get_drosophila_Chr_names.add("3L");
        Variables.get_drosophila_Chr_names.add("3R");
        Variables.get_drosophila_Chr_names.add("4");
        Variables.get_drosophila_Chr_names.add("X");
        Variables.get_drosophila_Chr_lengths.add(23011544);
        Variables.get_drosophila_Chr_lengths.add(21146708);
        Variables.get_drosophila_Chr_lengths.add(24543557);
        Variables.get_drosophila_Chr_lengths.add(27905053);
        Variables.get_drosophila_Chr_lengths.add(1351857);
        Variables.get_drosophila_Chr_lengths.add(22422827);


        Variables.get_mouse_Chr_names.add("1");
        Variables.get_mouse_Chr_names.add("2");
        Variables.get_mouse_Chr_names.add("3");
        Variables.get_mouse_Chr_names.add("4");
        Variables.get_mouse_Chr_names.add("5");
        Variables.get_mouse_Chr_names.add("6");
        Variables.get_mouse_Chr_names.add("7");
        Variables.get_mouse_Chr_names.add("8");
        Variables.get_mouse_Chr_names.add("9");
        Variables.get_mouse_Chr_names.add("10");
        Variables.get_mouse_Chr_names.add("11");
        Variables.get_mouse_Chr_names.add("12");
        Variables.get_mouse_Chr_names.add("13");
        Variables.get_mouse_Chr_names.add("14");
        Variables.get_mouse_Chr_names.add("15");
        Variables.get_mouse_Chr_names.add("16");
        Variables.get_mouse_Chr_names.add("17");
        Variables.get_mouse_Chr_names.add("18");
        Variables.get_mouse_Chr_names.add("19");
        Variables.get_mouse_Chr_names.add("X");
        Variables.get_mouse_Chr_names.add("Y");
        Variables.get_mouse_Chr_lengths.add(197195432);
        Variables.get_mouse_Chr_lengths.add(181748087);
        Variables.get_mouse_Chr_lengths.add(159599783);
        Variables.get_mouse_Chr_lengths.add(155630120);
        Variables.get_mouse_Chr_lengths.add(152537259);
        Variables.get_mouse_Chr_lengths.add(149517037);
        Variables.get_mouse_Chr_lengths.add(152524553);
        Variables.get_mouse_Chr_lengths.add(131738871);
        Variables.get_mouse_Chr_lengths.add(124076172);
        Variables.get_mouse_Chr_lengths.add(129993255);
        Variables.get_mouse_Chr_lengths.add(121843856);
        Variables.get_mouse_Chr_lengths.add(121257530);
        Variables.get_mouse_Chr_lengths.add(120284312);
        Variables.get_mouse_Chr_lengths.add(125194864);
        Variables.get_mouse_Chr_lengths.add(103494974);
        Variables.get_mouse_Chr_lengths.add(98319150);
        Variables.get_mouse_Chr_lengths.add(95272651);
        Variables.get_mouse_Chr_lengths.add(90772031);
        Variables.get_mouse_Chr_lengths.add(61342430);
        Variables.get_mouse_Chr_lengths.add(166650296);
        Variables.get_mouse_Chr_lengths.add(15902555);


        Variables.get_rat_Chr_names.add("1");
        Variables.get_rat_Chr_names.add("2");
        Variables.get_rat_Chr_names.add("3");
        Variables.get_rat_Chr_names.add("4");
        Variables.get_rat_Chr_names.add("5");
        Variables.get_rat_Chr_names.add("6");
        Variables.get_rat_Chr_names.add("7");
        Variables.get_rat_Chr_names.add("8");
        Variables.get_rat_Chr_names.add("9");
        Variables.get_rat_Chr_names.add("10");
        Variables.get_rat_Chr_names.add("11");
        Variables.get_rat_Chr_names.add("12");
        Variables.get_rat_Chr_names.add("13");
        Variables.get_rat_Chr_names.add("14");
        Variables.get_rat_Chr_names.add("15");
        Variables.get_rat_Chr_names.add("16");
        Variables.get_rat_Chr_names.add("17");
        Variables.get_rat_Chr_names.add("18");
        Variables.get_rat_Chr_names.add("19");
        Variables.get_rat_Chr_names.add("20");
        Variables.get_rat_Chr_names.add("X");
        Variables.get_rat_Chr_lengths.add(267910886);
        Variables.get_rat_Chr_lengths.add(258207540);
        Variables.get_rat_Chr_lengths.add(171063335);
        Variables.get_rat_Chr_lengths.add(187126005);
        Variables.get_rat_Chr_lengths.add(173096209);
        Variables.get_rat_Chr_lengths.add(147636619);
        Variables.get_rat_Chr_lengths.add(143002779);
        Variables.get_rat_Chr_lengths.add(129041809);
        Variables.get_rat_Chr_lengths.add(113440463);
        Variables.get_rat_Chr_lengths.add(110718848);
        Variables.get_rat_Chr_lengths.add(87759784);
        Variables.get_rat_Chr_lengths.add(46782294);
        Variables.get_rat_Chr_lengths.add(111154910);
        Variables.get_rat_Chr_lengths.add(112194335);
        Variables.get_rat_Chr_lengths.add(109758846);
        Variables.get_rat_Chr_lengths.add(90238779);
        Variables.get_rat_Chr_lengths.add(97296363);
        Variables.get_rat_Chr_lengths.add(87265094);
        Variables.get_rat_Chr_lengths.add(59218465);
        Variables.get_rat_Chr_lengths.add(55268282);
        Variables.get_rat_Chr_lengths.add(160699376);


        Variables.get_zebrafish_Chr_names.add("1");
        Variables.get_zebrafish_Chr_names.add("2");
        Variables.get_zebrafish_Chr_names.add("3");
        Variables.get_zebrafish_Chr_names.add("4");
        Variables.get_zebrafish_Chr_names.add("5");
        Variables.get_zebrafish_Chr_names.add("6");
        Variables.get_zebrafish_Chr_names.add("7");
        Variables.get_zebrafish_Chr_names.add("8");
        Variables.get_zebrafish_Chr_names.add("9");
        Variables.get_zebrafish_Chr_names.add("10");
        Variables.get_zebrafish_Chr_names.add("11");
        Variables.get_zebrafish_Chr_names.add("12");
        Variables.get_zebrafish_Chr_names.add("13");
        Variables.get_zebrafish_Chr_names.add("14");
        Variables.get_zebrafish_Chr_names.add("15");
        Variables.get_zebrafish_Chr_names.add("16");
        Variables.get_zebrafish_Chr_names.add("17");
        Variables.get_zebrafish_Chr_names.add("18");
        Variables.get_zebrafish_Chr_names.add("19");
        Variables.get_zebrafish_Chr_names.add("20");
        Variables.get_zebrafish_Chr_names.add("21");
        Variables.get_zebrafish_Chr_names.add("22");
        Variables.get_zebrafish_Chr_names.add("23");
        Variables.get_zebrafish_Chr_names.add("24");
        Variables.get_zebrafish_Chr_names.add("25");
        Variables.get_zebrafish_Chr_lengths.add(60348388);
        Variables.get_zebrafish_Chr_lengths.add(60300536);
        Variables.get_zebrafish_Chr_lengths.add(63268876);
        Variables.get_zebrafish_Chr_lengths.add(62094675);
        Variables.get_zebrafish_Chr_lengths.add(75682077);
        Variables.get_zebrafish_Chr_lengths.add(59938731);
        Variables.get_zebrafish_Chr_lengths.add(77276063);
        Variables.get_zebrafish_Chr_lengths.add(56184765);
        Variables.get_zebrafish_Chr_lengths.add(58232459);
        Variables.get_zebrafish_Chr_lengths.add(46591166);
        Variables.get_zebrafish_Chr_lengths.add(46661319);
        Variables.get_zebrafish_Chr_lengths.add(50697278);
        Variables.get_zebrafish_Chr_lengths.add(54093808);
        Variables.get_zebrafish_Chr_lengths.add(53733891);
        Variables.get_zebrafish_Chr_lengths.add(47442429);
        Variables.get_zebrafish_Chr_lengths.add(58780683);
        Variables.get_zebrafish_Chr_lengths.add(53984731);
        Variables.get_zebrafish_Chr_lengths.add(49877488);
        Variables.get_zebrafish_Chr_lengths.add(50254551);
        Variables.get_zebrafish_Chr_lengths.add(55952140);
        Variables.get_zebrafish_Chr_lengths.add(44544065);
        Variables.get_zebrafish_Chr_lengths.add(42261000);
        Variables.get_zebrafish_Chr_lengths.add(46386876);
        Variables.get_zebrafish_Chr_lengths.add(43947580);
        Variables.get_zebrafish_Chr_lengths.add(38499472);


    }
    private void jMenu_variationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu_variationsActionPerformed
        /*   JFileChooser jFileChooser1 = new JFileChooser(new File("."));
        
        int returnVal = jFileChooser1.showOpenDialog((Component) evt.getSource());
        if (returnVal == jFileChooser1.APPROVE_OPTION) {
        
        String filename = jFileChooser1.getSelectedFile().getAbsolutePath();
        
        Hilbert.load_deletions(filename);
        
        }*/
    }//GEN-LAST:event_jMenu_variationsActionPerformed

    private void jMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed


        String aboutText = "<html><center><h2>Meander v1.0</h2><br>"
                + "<center><br>Georgios Pavlopoulos<br>georgios.pavlopoulos@esat.kuleuven.be"
                + "<p></center>"
                + "<p><center>Jan Aerts<br>jan.aerts@esat.kuleuven.be<br>"
                + "<p><p><center><b>Katholieke Universiteit Leuven<BR> KU.Leuven Belgium<br></b>"
                + " </center></html>";

        JOptionPane.showMessageDialog(this, aboutText);

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //chooseSampleColor();
        //green
        Variables.up_regulated.setColor("green");
        //red
        Variables.down_regulated.setColor("red");
        if (Variables.ratio_enabled == true) {
            Hilbert.changeHilbert();
            Meander.jProgressBar.setVisible(true);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed
    public void chooseColor() {
        JColorChooser tcc = new JColorChooser();
        Color newColor = JColorChooser.showDialog(tcc, "Color Chooser", Meander.this.getBackground());
        Variables.generic_color.R = newColor.getRed();
        Variables.generic_color.G = newColor.getGreen();
        Variables.generic_color.B = newColor.getBlue();

        // Hilbert.ChangeColor();


    }

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        String aboutText = "<html><center><h2>Web site:</h2><br>"
                + "<a href=\"https://sites.google.com/site/meanderviz/\">https://sites.google.com/site/meanderviz/</a>"
                + " </center></html>";

        JOptionPane.showMessageDialog(this, aboutText);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public static void choose_variation_file(java.awt.event.ActionEvent evt) {
        JFileChooser jFileChooser1 = new JFileChooser(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Meander file", "meander", "MEANDER", "Meander");
        jFileChooser1.addChoosableFileFilter(filter);
        int returnVal = jFileChooser1.showOpenDialog((Component) evt.getSource());
        if (returnVal == jFileChooser1.APPROVE_OPTION) {

            Variables.file_with_variations = jFileChooser1.getSelectedFile().getAbsolutePath();

            if (!Variables.file_with_variations.endsWith(".meander")) {
                JOptionPane.showMessageDialog(null, "file with .meander extension could not be found");
            } else {

                try {
                    load_variations(Variables.file_with_variations);
                    JOptionPane.showMessageDialog(null, Variables.file_with_variations + " loaded");

                    Variables.variation_enabled = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }



            }
        }
    }

    public static void choose_pair_end_file(java.awt.event.ActionEvent evt) {

        FileFilter filter = new FileNameExtensionFilter("Meander file", "meander", "MEANDER", "Meander");

        JFileChooser jFileChooser1 = new JFileChooser(new File("."));
        jFileChooser1.addChoosableFileFilter(filter);
        int returnVal = jFileChooser1.showOpenDialog((Component) evt.getSource());
        if (returnVal == jFileChooser1.APPROVE_OPTION) {

            Variables.file_with_pair_ends = jFileChooser1.getSelectedFile().getAbsolutePath();

            if (!Variables.file_with_pair_ends.endsWith(".meander")) {
                JOptionPane.showMessageDialog(null, "file with .meander extension could not be found");
            } else {


                try {
                    load_pair_ends(Variables.file_with_pair_ends);
                    JOptionPane.showMessageDialog(null, Variables.file_with_pair_ends + " loaded");

                    Variables.pair_ends_enabled = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }



            }

            System.out.println("Loaded:" + Variables.file_with_pair_ends);
        }
    }

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        choose_variation_file(evt);

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    static public void load_pair_ends(String filename) {

        ArrayList<String> titles = new ArrayList();


        Variables.pe_marking_for_first_zoom_level.clear();
       


        Variables.pair_end_list_to_highlight_initial_zooming_panel.clear();
        //read titles
        try {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream(filename);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                String str[] = strLine.split("\t");
                for (int i = 0; i < str.length; i++) {
                    String string = str[i];
                    if (!titles.contains(string)) {
                        titles.add(string);
                    }
                }
                break;
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        //assign the columns




        try {
            Meander.jProgressBar.setValue(0);
            Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
            Meander.jProgressBar.repaint();
            Meander.jProgressBar.setVisible(true);
            Meander.jLabel_status.setText("Loading Pair-Ends...");
            Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
            Meander.jLabel_status.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }



        Variables.pair_ends_enabled = true;
        Variables.pair_end_list = new ArrayList();

        if (Variables.pair_ends_enabled == true) {
            try {
                // Open the file that is the first
                // command line parameter
                int lines = GenericMethods.get_lines_of_file(filename);

                FileInputStream fstream = new FileInputStream(filename);
                // Get the object of DataInputStream
                DataInputStream in = new DataInputStream(fstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String strLine;
                //Read File Line By Line
                int counter = 0;
                String[] headers = null;
                while ((strLine = br.readLine()) != null) {
                    if (counter == 0) {
                        headers = strLine.split("\t");
                     
                        counter++;
                        
                    } else {

                        String[] str = strLine.split("\t");

                        counter++;

                        PairEnd pe = new PairEnd();

                        
                        for (int i = 0; i < str.length; i++) 
                          if(headers[i]!=null){
                                                  
                            if (headers[i].trim().compareToIgnoreCase("chromosomeA") == 0) {
                                pe.chromosome_from = str[i];
                                if (!Variables.chromosome_list.contains(pe.chromosome_from) && pe.chromosome_from.compareToIgnoreCase(Variables.chromosome) != 0 && pe.chromosome_from.compareToIgnoreCase("") != 0) {
                                    Variables.chromosome_list.add(pe.chromosome_from);
                                }
                            }
                            if (headers[i].trim().compareToIgnoreCase("chromosomeB") == 0) {
                                pe.chromosome_to = str[i];
                                if (!Variables.chromosome_list.contains(pe.chromosome_to) && pe.chromosome_to.compareToIgnoreCase(Variables.chromosome) != 0 && pe.chromosome_to.compareToIgnoreCase("") != 0) {
                                    Variables.chromosome_list.add(pe.chromosome_to);
                                }
                            }
                            if (headers[i].trim().compareToIgnoreCase("startA") == 0) {
                                if (str[i].length() > 0) {
                                    pe.from_PE1 = Integer.parseInt(str[i]);
                                }
                            }
                            if (headers[i].trim().compareToIgnoreCase("endA") == 0) {
                                if (str[i].length() > 0) {
                                    pe.to_PE1 = Integer.parseInt(str[i]);
                                }
                            }
                            if (headers[i].trim().compareToIgnoreCase("startB") == 0) {
                                if (str[i].length() > 0) {
                                    pe.from_PE2 = Integer.parseInt(str[i]);
                                }
                            }
                            if (headers[i].trim().compareToIgnoreCase("endB") == 0) {
                                if (str[i].length() > 0) {
                                    pe.to_PE2 = Integer.parseInt(str[i]);
                                }
                            }
                            if (headers[i].trim().compareToIgnoreCase("directionA") == 0) {
                                pe.direction_PE1 = str[i];
                            }
                            if (headers[i].trim().compareToIgnoreCase("sample") == 0) {
                                pe.sample = Integer.parseInt(str[i]);
                            }
                            if (headers[i].trim().compareToIgnoreCase("directionB") == 0) {
                                pe.direction_PE2 = str[i];
                            }
                            if (headers[i].trim().compareToIgnoreCase("count") == 0) {
                                if (str[i].length() > 0) {
                                    pe.count = Integer.parseInt(str[i]);
                                }
                            }
                            if (headers[i].trim().compareToIgnoreCase("type") == 0) {
                                pe.variation_type = str[i];
                            }

                           

                        } pe.assign_variation_type();

                        if (pe.chromosome_from.compareTo(Variables.chromosome) == 0 || pe.chromosome_to.compareTo(Variables.chromosome) == 0) {
                            if(pe.count>=Variables.pair_end_count_of_cluster)
                            Variables.pair_end_list.add(pe);
                            // System.out.println(pe.toString());
                        }

                        float progress = (((float) counter / (float) lines) * (float) (512 * 512));
                        if (counter % 400000 == 0) {

                            Meander.jLabel_status.setText("Loading Pair-Ends...");
                            Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
                            Meander.jLabel_status.repaint();
                            Meander.jProgressBar.setValue((int) progress - 10);
                            Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
                            Meander.jProgressBar.repaint();
                        }


                    }
                }
                //Close the input stream
                in.close();
            } catch (Exception e) {//Catch exception if any
                e.printStackTrace();
            }
        }


        try {
            Meander.jProgressBar.setVisible(false);


            Variables.check_variations.setVisible(true);

            assign_pair_ends();

            Meander.jLabel_status.setText("");
            Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
            Meander.jLabel_status.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Hilbert.PE_histogram_initilization();

    }

    public static void assign_pair_ends() {

        Pixel source = null, dest = null;
        int cnttt = 0;
        Variables.pair_ends_initial_loaded = false;
        ArrayList<Pixel> tmp_src = new ArrayList();
        ArrayList<Pixel> tmp_dest = new ArrayList();
        ArrayList<String> tmp_src_variation_type = new ArrayList();
        ArrayList<String> tmp_dest_variation_type = new ArrayList();
        ArrayList<String> tmp_src_chromosome = new ArrayList();
        ArrayList<String> tmp_dest_chromosome = new ArrayList();
        // ArrayList<Integer> tmp_src_sample = new ArrayList();
        // ArrayList<Integer> tmp_dest_sample = new ArrayList();
        ArrayList<Integer> tmp_src_pos = new ArrayList();
        ArrayList<Integer> tmp_dest_pos = new ArrayList();


        int counter = 0;
        int buck = 0;
        int progress = 85;
        Variables.pair_end_list_to_highlight.clear();
        Variables.pair_end_list_to_highlight_initial.clear();

        Variables.pair_ends_for_zoom_level.clear();

        Variables.searchTree_pair_ends = new IntervalST();


        for (int i = 0; i < Variables.pixels.size(); i++) {
            Variables.pixels.get(i).pair_ends.clear();
            Variables.pixels.get(i).pair_end_variation_type.clear();
            Variables.pixels.get(i).pair_end_destination_chromosome.clear();
            Variables.pixels.get(i).pair_end_destination_chromosome_position.clear();
            Variables.pixels.get(i).sample.clear();
            Variables.pixels.get(i).pair_end_source_chromosome.clear();
        }

        for (int i = 0; i < Variables.pixels_initial.size(); i++) {
            Pixel pix = Variables.pixels_initial.get(i);
            int low = pix.getPosition_range_start();
            int high = pix.getPosition_range_end();
            Interval interval = new Interval(low, high, pix);
            Variables.searchTree_pair_ends.put(interval, pix);
        }

        for (int i = 0; i < Variables.pixels.size(); i++) {
            Pixel pix = Variables.pixels.get(i);
            int low = pix.getPosition_range_start();
            int high = pix.getPosition_range_end();
            Interval interval = new Interval(low, high, pix);
            Variables.searchTree_pair_ends.put(interval, pix);
        }

        Meander.jProgressBar.setMaximum(100);
        Meander.jProgressBar.setMinimum(1);
        Meander.jLabel_status.setText("Loading Pair-Ends...");
        Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
        Meander.jLabel_status.repaint();
        Meander.jProgressBar.setValue((int) 90);
        Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
        Meander.jProgressBar.repaint();

        //  for (int i = 0; i < Variables.pair_end_list.size(); i++) {
        //     System.out.println("*****"+Variables.pair_end_list.get(i).toString());     
        // }


        buck = Variables.pair_end_list.size() / 15 + 1;
        for (int i = 0; i < Variables.pair_end_list.size(); i++) {

            PairEnd pe = Variables.pair_end_list.get(i);

            if (pe.sample == Variables.panel) {

                tmp_src.clear();
                tmp_dest.clear();
                tmp_src_variation_type.clear();
                tmp_dest_variation_type.clear();
                tmp_src_chromosome.clear();
                tmp_dest_chromosome.clear();
                // tmp_src_sample.clear();
                // tmp_dest_sample.clear();
                tmp_src_pos.clear();
                tmp_dest_pos.clear();

                Meander.jProgressBar.setMaximum(100);
                Meander.jProgressBar.setMinimum(1);




                if (pe.chromosome_from.compareToIgnoreCase(Variables.chromosome) == 0 && pe.chromosome_to.compareToIgnoreCase(Variables.chromosome) == 0) {


                    Interval interval_x = new Interval(Variables.pair_end_list.get(i).from_PE1, Variables.pair_end_list.get(i).to_PE1, null);

                    for (Interval x : Variables.searchTree_pair_ends.searchAll_intersections(interval_x)) {
                        if (x != null) {


                            if (!tmp_src.contains(x.pix)) {

                                x.pix.setColor_pair_end(pe.color);

                                if (pe.variation_type.compareToIgnoreCase("deletion") == 0) {
                                    tmp_src_variation_type.add("deletion");
                                }
                                else if (pe.variation_type.compareToIgnoreCase("insertion") == 0) {
                                    tmp_src_variation_type.add("insertion");
                                }
                                else if (pe.variation_type.compareToIgnoreCase("duplication") == 0) {
                                    tmp_src_variation_type.add("duplication");
                                }
                                else if (pe.variation_type.compareToIgnoreCase("inversion") == 0) {
                                    tmp_src_variation_type.add("inversion");
                                }
                                else if (pe.variation_type.compareToIgnoreCase("translocation") == 0) {
                                    tmp_src_variation_type.add("translocation");
                                }
                                else
                                {
                                    tmp_src_variation_type.add("deletion");
                                } 




                                tmp_src.add(x.pix);
                                tmp_src_chromosome.add(Variables.pair_end_list.get(i).chromosome_from);
                                tmp_src_pos.add(Variables.pair_end_list.get(i).from_PE1);
                            }
                        }

                    }


                    Interval interval_y = null;

                    interval_y = new Interval(Variables.pair_end_list.get(i).from_PE2, Variables.pair_end_list.get(i).to_PE2, null);
                    for (Interval y : Variables.searchTree_pair_ends.searchAll_intersections(interval_y)) {
                        if (y != null) {
                            if (!tmp_dest.contains(y.pix)) {
                                y.pix.setColor_pair_end(pe.color);

                                if (pe.variation_type.compareToIgnoreCase("deletion") == 0) {
                                    tmp_dest_variation_type.add("deletion");
                                }
                                else if (pe.variation_type.compareToIgnoreCase("insertion") == 0) {
                                    tmp_dest_variation_type.add("insertion");
                                }
                                else if (pe.variation_type.compareToIgnoreCase("duplication") == 0) {
                                    tmp_dest_variation_type.add("duplication");
                                }
                                else if (pe.variation_type.compareToIgnoreCase("inversion") == 0) {
                                    tmp_dest_variation_type.add("inversion");
                                }
                                else if (pe.variation_type.compareToIgnoreCase("translocation") == 0) {
                                    tmp_dest_variation_type.add("translocation");
                                }
                                else
                                    tmp_dest_variation_type.add("deletion");


                                tmp_dest.add(y.pix);
                                tmp_dest_chromosome.add(Variables.pair_end_list.get(i).chromosome_to);
                                //   tmp_dest_sample.add(Variables.pair_end_list.get(i).sample);
                                tmp_dest_pos.add(Variables.pair_end_list.get(i).from_PE2);
                            }
                        }

                    }


                }


                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


                if (pe.chromosome_from.compareToIgnoreCase(Variables.chromosome) == 0 && pe.chromosome_to.compareToIgnoreCase(Variables.chromosome) != 0) {

                    Interval interval_x = new Interval(Variables.pair_end_list.get(i).from_PE1, Variables.pair_end_list.get(i).to_PE1, null);

                    for (Interval x : Variables.searchTree_pair_ends.searchAll_intersections(interval_x)) {
                        if (x != null) {


                            if (!tmp_src.contains(x.pix)) {

                                x.pix.setColor_pair_end(pe.color);

                                if (pe.variation_type.compareToIgnoreCase("deletion") == 0) {
                                    tmp_src_variation_type.add("deletion");
                                }
                                if (pe.variation_type.compareToIgnoreCase("insertion") == 0) {
                                    tmp_src_variation_type.add("insertion");
                                }
                                if (pe.variation_type.compareToIgnoreCase("duplication") == 0) {
                                    tmp_src_variation_type.add("duplication");
                                }
                                if (pe.variation_type.compareToIgnoreCase("inversion") == 0) {
                                    tmp_src_variation_type.add("inversion");
                                }
                                if (pe.variation_type.compareToIgnoreCase("translocation") == 0) {
                                    tmp_src_variation_type.add("translocation");
                                }



                                tmp_src.add(x.pix);
                                tmp_src_chromosome.add(Variables.pair_end_list.get(i).chromosome_from);
                                tmp_src_pos.add(Variables.pair_end_list.get(i).from_PE1);
                            }
                        }

                    }


                    Pixel pix = new Pixel();


                    if (!tmp_dest.contains(pix)) {
                        pix.setColor_pair_end(pe.color);

                        if (pe.variation_type.compareToIgnoreCase("deletion") == 0) {
                            tmp_dest_variation_type.add("deletion");
                        }
                        if (pe.variation_type.compareToIgnoreCase("insertion") == 0) {
                            tmp_dest_variation_type.add("insertion");
                        }
                        if (pe.variation_type.compareToIgnoreCase("duplication") == 0) {
                            tmp_dest_variation_type.add("duplication");
                        }
                        if (pe.variation_type.compareToIgnoreCase("inversion") == 0) {
                            tmp_dest_variation_type.add("inversion");
                        }
                        if (pe.variation_type.compareToIgnoreCase("translocation") == 0) {
                            tmp_dest_variation_type.add("translocation");
                        }


                        tmp_dest.add(pix);
                        tmp_dest_chromosome.add(Variables.pair_end_list.get(i).chromosome_to);
                        // tmp_dest_sample.add(Variables.pair_end_list.get(i).sample);
                        tmp_dest_pos.add(Variables.pair_end_list.get(i).from_PE2);
                        pix.setPosition_range_start(Variables.pair_end_list.get(i).from_PE2);
                        pix.setPosition_range_start(Variables.pair_end_list.get(i).to_PE2);
                    }

                }



                ///////////////////////////////////////////////////////////////////////////////


                if (pe.chromosome_from.compareToIgnoreCase(Variables.chromosome) != 0 && pe.chromosome_to.compareToIgnoreCase(Variables.chromosome) == 0) {

                    Interval interval_x = new Interval(Variables.pair_end_list.get(i).from_PE2, Variables.pair_end_list.get(i).to_PE2, null);

                    for (Interval x : Variables.searchTree_pair_ends.searchAll_intersections(interval_x)) {
                        if (x != null) {


                            if (!tmp_src.contains(x.pix)) {

                                x.pix.setColor_pair_end(pe.color);

                                if (pe.variation_type.compareToIgnoreCase("deletion") == 0) {
                                    tmp_src_variation_type.add("deletion");
                                }
                                if (pe.variation_type.compareToIgnoreCase("insertion") == 0) {
                                    tmp_src_variation_type.add("insertion");
                                }
                                if (pe.variation_type.compareToIgnoreCase("duplication") == 0) {
                                    tmp_src_variation_type.add("duplication");
                                }
                                if (pe.variation_type.compareToIgnoreCase("inversion") == 0) {
                                    tmp_src_variation_type.add("inversion");
                                }
                                if (pe.variation_type.compareToIgnoreCase("translocation") == 0) {
                                    tmp_src_variation_type.add("translocation");
                                }


                                tmp_src.add(x.pix);
                                tmp_src_chromosome.add(Variables.pair_end_list.get(i).chromosome_to);
                                tmp_src_pos.add(Variables.pair_end_list.get(i).from_PE2);

                            }
                        }

                    }


                    Pixel pix = new Pixel();


                    if (!tmp_dest.contains(pix)) {
                        pix.setColor_pair_end(pe.color);

                        if (pe.variation_type.compareToIgnoreCase("deletion") == 0) {
                            tmp_dest_variation_type.add("deletion");
                        }
                        if (pe.variation_type.compareToIgnoreCase("insertion") == 0) {
                            tmp_dest_variation_type.add("insertion");
                        }
                        if (pe.variation_type.compareToIgnoreCase("duplication") == 0) {
                            tmp_dest_variation_type.add("duplication");
                        }
                        if (pe.variation_type.compareToIgnoreCase("inversion") == 0) {
                            tmp_dest_variation_type.add("inversion");
                        }
                        if (pe.variation_type.compareToIgnoreCase("translocation") == 0) {
                            tmp_dest_variation_type.add("translocation");
                        }

                        tmp_dest.add(pix);
                        tmp_dest_chromosome.add(Variables.pair_end_list.get(i).chromosome_from);
                        // tmp_dest_sample.add(Variables.pair_end_list.get(i).sample);
                        tmp_dest_pos.add(Variables.pair_end_list.get(i).from_PE1);
                        pix.pair_end_destination_chromosome_position.add(Variables.pair_end_list.get(i).from_PE1);
                        pix.sample.add(Variables.pair_end_list.get(i).sample);

                        pix.setPosition_range_start(Variables.pair_end_list.get(i).from_PE1);
                        pix.setPosition_range_start(Variables.pair_end_list.get(i).to_PE1);
                    }

                }

                ///////////////////////////////////////////////////



                if (i > 0) {
                    if (i % buck == 0) {
                        progress++;
                        Meander.jLabel_status.setText("Loading Pair-Ends...");
                        Meander.jLabel_status.update(Meander.jLabel_status.getGraphics());
                        Meander.jLabel_status.repaint();
                        Meander.jProgressBar.setValue((int) progress);
                        Meander.jProgressBar.update(Meander.jProgressBar.getGraphics());
                        Meander.jProgressBar.repaint();
                    }
                }




                int cnt = 0;

                // System.out.println(tmp_src.size() + "-" + tmp_src_variation_type.size() + "-" + tmp_src_chromosome.size() + "-" + tmp_src_pos.size());

                for (int j = 0; j < tmp_src.size(); j++) {

                    for (int k = 0; k < tmp_dest.size(); k++) {




                        source = tmp_src.get(j);
                        dest = tmp_dest.get(k);

                        Coordinate cc1 = null;
                        Coordinate cc2 = null;
                        if (source.getZoom_level() == 1) {
                            cc1 = new Coordinate(source.getCoordinate_hilbert());
                        }
                        if (dest.getZoom_level() == 1) {
                            cc2 = new Coordinate(dest.getCoordinate_hilbert());
                        }
                        if (source.getZoom_level() == 1 && source.getZoom_level() == 1) {

                            if (!Variables.pe_marking_for_first_zoom_level.contains(cc1)) {
                                Variables.pe_marking_for_first_zoom_level.add(cc1);
                            }
                            if (!Variables.pe_marking_for_first_zoom_level.contains(cc2)) {
                                Variables.pe_marking_for_first_zoom_level.add(cc2);
                            }
                        }

                        String var_source = tmp_src_variation_type.get(j);
                        String var_dest = tmp_dest_variation_type.get(k);
                        String chr_source = tmp_src_chromosome.get(j);
                        String chr_dest = tmp_dest_chromosome.get(k);



                        //   int sample_src = tmp_src_sample.get(j);
                        //   int sample_dest = tmp_dest_sample.get(k);

                        int chr_source_pos = tmp_src_pos.get(j);
                        int chr_dest_pos = tmp_dest_pos.get(k);


                        //  System.out.println("\n\n"+source.toString()+"____\n____"+dest.toString());


                        if (source != null && dest != null) {

                            source.pair_ends.add(dest);
                            source.pair_end_variation_type.add(var_dest);
                            source.pair_end_destination_chromosome.add(chr_dest);
                            source.pair_end_destination_chromosome_position.add(chr_dest_pos);
                            //   source.sample.add(sample_dest);
                            source.pair_end_source_chromosome.add(chr_source);
                            // System.out.println(chr_source_pos+"-"+chr_dest_pos);


                            cnttt++;
                            dest.pair_ends.add(source);
                            dest.pair_end_variation_type.add(var_source);
                            dest.pair_end_destination_chromosome.add(chr_source);
                            dest.pair_end_source_chromosome.add(chr_dest);
                            //   dest.sample.add(sample_src);
                            // dest.pair_end_destination_chromosome_position.add(chr_source_pos);


                            cnt++;
                        }

                    }

                }


            }

        }//for









        /*   for (int i = 0; i < Variables.pixels_initial.size(); i++) {
        Pixel pix = Variables.pixels_initial.get(i);
        if (pix.pair_ends.size() > 0) {
        System.out.println("[" + pix.getPosition_range_start() + "-" + pix.getPosition_range_end() + "]" + "\t\tneighbors:" + pix.pair_ends.size() + " zoom:" + pix.getZoom_level());
        }
        }
        
        System.out.println("-");
        for (int i = 0; i < Variables.pixels.size(); i++) {
        Pixel pix = Variables.pixels.get(i);
        if (pix.pair_ends.size() > 0) {
        System.out.println("[" + pix.getPosition_range_start() + "-" + pix.getPosition_range_end() + "]" + "\t\tneighbors:" + pix.pair_ends.size() + " zoom:" + pix.getZoom_level());
        }
        }*/

        Variables.pair_ends_initial_loaded = true;
        Variables.finished_pair_end_drawing_for_first_time = false;

    }

    static public void load_variations(String filename) {

        if (filename.length() >= 3) {
            Variables.variation_list.clear();
            if (Variables.variation_enabled == true) {
                try {

                    Meander.jProgressBar.setVisible(true);
                    // Open the file that is the first
                    // command line parameter
                    FileInputStream fstream = new FileInputStream(filename);
                    // Get the object of DataInputStream
                    DataInputStream in = new DataInputStream(fstream);
                    BufferedReader br = new BufferedReader(new InputStreamReader(in));
                    String strLine;
                    //Read File Line By Line
                    while ((strLine = br.readLine()) != null) {
                        String[] str = strLine.split("\t");
                        Variation var = new Variation();
                        var.variation_type = (str[0].toLowerCase());
                        for (int i = 0; i < str.length; i++) {
                            String string = str[i];

                            String[] sss = string.split(":");
                            if (string.startsWith("start")) {
                                var.from = Integer.parseInt(sss[1]);
                            }
                            if (string.startsWith("end")) {
                                var.to = Integer.parseInt(sss[1]);
                            }
                        }
                        int distance = Math.abs(var.from - var.to);
                        //if (distance >= Variables.pair_end_distance_threshold) 
                        Variables.variation_list.add(var);
                        //  System.out.println(var.toString());

                    }
                    //Close the input stream
                    in.close();
                    Meander.jProgressBar.setVisible(false);
                    Variables.check_variations.setVisible(true);
                } catch (Exception e) {//Catch exception if any
                    e.printStackTrace();
                }
            }


        }




    }
    private void jComboBox_zoom_levelsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_zoom_levelsActionPerformed
        JComboBox cb = (JComboBox) evt.getSource();
        Variables.zoom_tmp = (int) cb.getSelectedIndex() + 1;

    }//GEN-LAST:event_jComboBox_zoom_levelsActionPerformed

    public static void highlight_zooming_points() {
        Variables.highlight_zoom_point_list.clear();
        Variables.highlight_zoom_pixel_list.clear();
        if (Variables.zoom != 1 && Variables.zoom != 2) {



            Coordinate last = null;
            Coordinate c = null;

            Pixel min = Variables.pixels.get(0);
            Pixel max = Variables.pixels.get(Variables.pixels.size() - 1);
            double position_min = min.getPosition_range_start();
            double position_max = max.getPosition_range_end();


            ArrayList<Integer> indexes = new ArrayList();

            // System.out.println(Variables.pixels_initial.size());
            for (int i = 0; i < Variables.pixels_initial.size(); i++) {
                Pixel pix = Variables.pixels_initial.get(i);
                if (Variables.highlight_zoom_point_list.size() > 0) {
                    last = Variables.highlight_zoom_point_list.get(Variables.highlight_zoom_point_list.size() - 1);
                }

                if (pix.getPosition_range_start() >= position_min && pix.getPosition_range_start() <= position_max
                        && pix.getPosition_range_end() >= position_min && pix.getPosition_range_end() <= position_max) {

                    c = new Coordinate(pix.getCoordinate_hilbert().X / 2, pix.getCoordinate_hilbert().Y / 2);

                    if (!Variables.highlight_zoom_point_list.contains(c)) {
                        Variables.highlight_zoom_point_list.add(c);
                        Variables.highlight_zoom_pixel_list.add(pix);

                    }

                }


                if (Variables.highlight_zoom_point_list.size() > 0 && c != null && last != null) {
                    if ((Math.abs(last.X - c.X) >= 3 && Math.abs(last.Y - c.Y) >= 3)) {
                        break;
                    }
                }
            }


        }//zoom
    }

    private void jButton_zoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_zoomActionPerformed
        Meander.jProgressBar.setVisible(true);



        Variables.zoom = Variables.zoom_tmp;
        label_zoom_level.setText("Current Zoom level: " + Variables.zoom);

        Variables.pause_everything = true;

        Variables.circles.clear();

        if (Variables.zoom == Variables.zooming_file_to_be_loaded.zoom) {
            String s = Variables.zooming_file_to_be_loaded.filename;

            System.out.println("Currently loaded:" + s);
            Variables.file_with_reads = s;


            Variables.give_coordinate_get_pixel.clear();
            Variables.pixels.clear();


            LoadReads.load_expressions(s);



            for (int j = 0; j < Variables.pixels.size(); j++) {
                Coordinate ccc = new Coordinate();
                ccc.X = Variables.pixels_initial.get(j).getCoordinate_hilbert().X;
                ccc.Y = Variables.pixels_initial.get(j).getCoordinate_hilbert().Y;
                Variables.pixels.get(j).setCoordinate_hilbert(ccc);
                Variables.give_coordinate_get_pixel.put(ccc.toString(), Variables.pixels.get(j));
                Hilbert.color_scale_ratio(Variables.pixels.get(j));
                Hilbert.color_scale_ref(Variables.pixels.get(j));
                Hilbert.color_scale_sample(Variables.pixels.get(j));

            }

            Chromosome_zoomed.update_diagram();
            Hilbert.changeHilbert();



        }



        highlight_zooming_points();


        if (Variables.pair_ends_enabled == true) {
            Meander.assign_pair_ends();
        }

        Variables.pause_everything = false;
    }//GEN-LAST:event_jButton_zoomActionPerformed
    public void chooseInputFile(java.awt.event.ActionEvent evt) {
        int returnVal;
        Variables.zooming_window_enabled = false;
        Variables.something_changed = 0;
        FileFilter filter = new FileNameExtensionFilter("TXT file", "txt", "TXT", "Txt");

        //jFileChooser1=new JFileChooser();
        //jFileChooser1=new JFileChooser(this.getClass().getResource(".").getFile());
        JFileChooser jFileChooser1 = new JFileChooser(new File("."));
        jFileChooser1.addChoosableFileFilter(filter);
        returnVal = jFileChooser1.showOpenDialog((Component) evt.getSource());
        if (returnVal == jFileChooser1.APPROVE_OPTION) {

            String filename = jFileChooser1.getSelectedFile().getAbsolutePath();



            if (filename.endsWith(".txt")) {
                Variables.file_with_reads = filename;
                Variables.codebase = jFileChooser1.getSelectedFile().getParent() + "" + File.separatorChar;



                System.out.println("\n" + "codebase:" + Variables.codebase);
                System.out.println("\n" + "filename:" + Variables.file_with_reads);
            } else {
                JOptionPane.showMessageDialog(this, "This is not a .txt file");
            }

            //   Variables.chromosome = JOptionPane.showInputDialog(null, "Please give chromosome:");


        }
    }

    public void chooseMeandertFile(java.awt.event.ActionEvent evt) {

        int returnVal;
        Variables.something_changed = 0;
        Variables.zooming_window_enabled = true;
        FileFilter filter = new FileNameExtensionFilter("Meander file", "meander", "MEANDER", "Meander");

        //jFileChooser1=new JFileChooser();
        //jFileChooser1=new JFileChooser(this.getClass().getResource(".").getFile());
        JFileChooser jFileChooser1 = new JFileChooser(new File("."));
        jFileChooser1.addChoosableFileFilter(filter);
        returnVal = jFileChooser1.showOpenDialog((Component) evt.getSource());
        if (returnVal == jFileChooser1.APPROVE_OPTION) {

            String meander_file = jFileChooser1.getSelectedFile().getAbsolutePath();
            Variables.meander_file = meander_file;
            if (meander_file.endsWith(".meander")) {
                try {
                    load_meander_file(meander_file);


                    jMenuItem6.setEnabled(false);
                    file_Open.setEnabled(false);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Error interface opening the .meander file");
                }

            } else {
                JOptionPane.showMessageDialog(this, "This is not a .meander file");
            }

        }
    }

    public static void load_meander_file(String input_filename) {

        try {

            FileInputStream fstream = new FileInputStream(input_filename);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {

                if (strLine.startsWith("zoom:")) {
                    Zooming_Info zzz = new Zooming_Info();
                    String[] str = strLine.split("\t");
                    String[] str0 = str[0].split(":");
                    zzz.zoom = Integer.parseInt(str0[1]);

                    String[] str1 = str[1].split(":");
                    zzz.part = Integer.parseInt(str1[1]);

                    String[] str2 = str[2].split(":");
                    zzz.bucket = Integer.parseInt(str2[1]);

                    String[] str3 = str[3].split(":");
                    zzz.range_start = Integer.parseInt(str3[1]);

                    String[] str4 = str[4].split(":");
                    zzz.range_end = Integer.parseInt(str4[1]);

                    zzz.filename = str[5];
                    Variables.zooming_file_list.add(zzz);

                }

                if (strLine.startsWith("maximum_position:")) {
                    String[] str = strLine.split(":");
                    Variables.max_chromosome_position = Integer.parseInt(str[1]);

                }
                if (strLine.startsWith("chromosome:")) {
                    String[] str = strLine.split(":");
                    Variables.chromosome = (str[1]);
                }

                if (strLine.startsWith("organism:")) {
                    String[] str = strLine.split(":");
                    Variables.organism = (str[1]);
                    Variables.organisms_load_allowance = true;
                }

                if (strLine.startsWith("minimum_position:")) {
                    String[] str = strLine.split(":");
                    Variables.min_chromosome_position = Integer.parseInt(str[1]);

                }


            }

            //get the input from the file
            if (Variables.min_chromosome_position != 999999999
                    && Variables.max_chromosome_position != -1) {
                Variables.min_max_position_is_set = true;
            }


            in.close();




        } catch (Exception e) {//Catch exception if any
            e.printStackTrace();
        }

        //    for (int i = 0; i < Variables.zooming_file_list.size(); i++) {
        //        System.out.println(Variables.zooming_file_list.get(i));
        //
        //   }


        Variables.file_with_reads = Variables.zooming_file_list.get(0).filename;
        File f = new File(Variables.file_with_reads);
        Variables.codebase = f.getParent() + "" + File.separatorChar;



        System.out.println("\n" + "codebase:" + Variables.codebase);
        System.out.println("\n" + "filename:" + Variables.file_with_reads);



        //            for (int i = 0; i < Variables.zooming_file_list.size(); i++) {
        //                System.out.println(Variables.zooming_file_list.get(i).toString());
        //            }


    }

    public void chooseVariationFile(java.awt.event.ActionEvent evt) {
        int returnVal;
        //jFileChooser1=new JFileChooser();
        //jFileChooser1=new JFileChooser(this.getClass().getResource(".").getFile());
        JFileChooser jFileChooser1 = new JFileChooser(new File("."));
        returnVal = jFileChooser1.showOpenDialog((Component) evt.getSource());
        if (returnVal == jFileChooser1.APPROVE_OPTION) {
            Variables.file_with_reads = jFileChooser1.getSelectedFile().getAbsolutePath();
            Variables.codebase = jFileChooser1.getSelectedFile().getParent() + "" + File.separatorChar;
            System.out.println("\n" + "codebase:" + Variables.codebase);
            System.out.println("\n" + "filename:" + Variables.file_with_reads);

        }
    }
    private void file_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_OpenActionPerformed
        Meander.jProgressBar.setVisible(true);
        chooseInputFile(evt);

    }//GEN-LAST:event_file_OpenActionPerformed

    void old_application_after_reading_threshold() {
        /*boolean go = true;
        Meander.jProgressBar.setVisible(true);
        if (GenericMethods.isNumber(jTextField_upper_threshold.getText()) == false) {
        JOptionPane.showMessageDialog(this, "The text field takes only numerical values");
        jTextField_upper_threshold.setText("0");
        go = false;
        }
        
        
        if (GenericMethods.isNumber(jTextField_upper_threshold.getText()) == true) {
        int upper = (int) Double.parseDouble(jTextField_upper_threshold.getText());
        
        
        if (upper < 0) {
        JOptionPane.showMessageDialog(this, "The upper threshold should be >0 ");
        go = false;
        }
        
        
        
        
        if (go == true) {
        Variables.upper_threshold = upper;
        
        
        Hilbert.changeHilbert();
        
        }
        }*/
    }

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // chooseReferenceColor();

        //yellow
        Variables.down_regulated.setColor("yellow");


        //blue
        Variables.up_regulated.setColor("blue");


        if (Variables.ratio_enabled == true) {
            Hilbert.changeHilbert();

            Meander.jProgressBar.setVisible(true);

        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Meander.jProgressBar.setVisible(true);
        chooseMeandertFile(evt);

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        if (Variables.zoom == 1) {
            Grid_Zoom.replace_image();
        } else {
            JOptionPane.showMessageDialog(this, "Zoom x1 should be selected");
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        choose_pair_end_file(evt);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        String str = JOptionPane.showInputDialog(this, "Enter range for Pair End distance in min-max format: default 100-100000000",""+Variables.pair_end_minimum_distance_threshold +"-"+Variables.pair_end_maximum_distance_threshold );
        if (str != null) {
            String sss[] = str.trim().split("-");
            
            Variables.pair_end_minimum_distance_threshold = Integer.parseInt(sss[0]);
            Variables.pair_end_maximum_distance_threshold = Integer.parseInt(sss[1]);
            Variables.finished_pair_end_drawing_for_first_time = false;
        }

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItemRatioColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRatioColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemRatioColorActionPerformed

    private void jMenuItemContrastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemContrastActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemContrastActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        //yellow
        Variables.down_regulated.setColor("red");


        //blue
        Variables.up_regulated.setColor("blue");


        if (Variables.ratio_enabled == true) {
            Hilbert.changeHilbert();

            Meander.jProgressBar.setVisible(true);

        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jCheckBoxMenuItem1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ItemStateChanged


        Variables.interchromosomal = !Variables.interchromosomal;
        if (Variables.interchromosomal) {
            JOptionPane.showMessageDialog(null, "Interchromosomal Variations Enabled", "", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Interchromosomal Variations Disabled", "", JOptionPane.INFORMATION_MESSAGE);
        }



    }//GEN-LAST:event_jCheckBoxMenuItem1ItemStateChanged

    private void jCheckBoxMenuItem2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ItemStateChanged
        MyKeyListener.switcher = !MyKeyListener.switcher;

        MyKeyListener.circles(MyKeyListener.switcher);
    }//GEN-LAST:event_jCheckBoxMenuItem2ItemStateChanged

    /*   public static void chromosome_select(java.awt.event.ActionEvent evt)
    {
    int index = jComboBoxChromosome.getSelectedIndex();
    
    String s = null;
    
    Variables.chromosome_selected = null;
    if (index >= 1 && index <= 22) {
    Variables.chromosome_selected = "" + index;
    }
    if (index == 23) {
    Variables.chromosome_selected = "X";
    }
    if (index == 24) {
    Variables.chromosome_selected = "Y";
    }
    
    System.out.println("Chromosome:" + Variables.chromosome_selected + " is selected");
    }*/ public static void disable_interface() {
        boolean activate = false;

        jComboBox_zoom_levels.setEnabled(false);

        jButton_zoom.setEnabled(false);


        // Variables.check_sample_ref_ratio.setVisible(false);


        Meander.jMenuItemRatioColor.setVisible(false);
        Meander.jMenuItemSampleColor.setVisible(false);
        Meander.jMenuItemReferenceColor.setVisible(false);


    }

    public static void activate_interface() {
        Meander.jProgressBar.setVisible(false);

        if (Variables.zooming_window_enabled == true) {
            jComboBox_zoom_levels.setEnabled(true);
        }
        if (Variables.zooming_window_enabled == true) {
            jButton_zoom.setEnabled(true);
        }


        if (Variables.ratio_enabled == true) {
            Meander.jMenuItemRatioColor.setVisible(true);
        }
        if (Variables.sample_enabled == true) {
            Meander.jMenuItemSampleColor.setVisible(true);
        }
        if (Variables.reference_enabled == true) {
            Meander.jMenuItemReferenceColor.setVisible(true);
        }


    }
    static boolean run_once = false;

    public static void main(String args[]) {

        if(args.length>0){
            
            
            
        String proj_file = null;
        String chromosome = "1";
        String organism = "human";
        boolean arg1=false;
        boolean arg2=false;
        boolean arg3=false;
            System.out.println("arguments:" + args.length/2);
        for (int i = 0; i < args.length; i++) {
         
            if (args[i].compareToIgnoreCase("-chr") == 0 || args[i].compareToIgnoreCase("-chromosome") == 0) {
                chromosome = (args[i + 1]);
                arg1=true;
            }

            if (args[i].compareToIgnoreCase("-org") == 0 || args[i].compareToIgnoreCase("-organism") == 0) {
                organism = (args[i + 1]).toLowerCase();
                arg2=true;
            }

            if (args[i].compareToIgnoreCase("-pre") == 0) {
                File ff = new File(args[i + 1]);
                proj_file = ff.getAbsolutePath();
                arg3=true;
            }
            
           
        }
           
        if(arg1==true && arg2==true && arg3==true){
            System.out.println("Chromosome:" + chromosome);
            System.out.println("Organism:"+ organism);
            System.out.println("Input File:"+ proj_file);
            LoadReads.create_zooming_files2(proj_file, chromosome, organism);
            System.exit(0);
        }
        }


        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {


                if (Variables.show_welcome_screen == true) {
                    JOptionPane.showMessageDialog(null,
                            "Welcome to Meander Application",
                            "",
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon(getClass().getResource("/images/meander.jpg")));
                }


                //create a frame for the application
                final Meander frame = new Meander();


                //make sure to shut down the application, when the frame is closed
                frame.setDefaultCloseOperation(Meander.EXIT_ON_CLOSE);

                //create an instance of your processing applet
                final Hilbert hilbert = new Hilbert();
                hilbert.init();
                panel_hilbert.add(hilbert); //this is the panel loaded on the JFrame (public static)




                //create an instance of your processing applet
                final SamplePanel pe = new SamplePanel();
                pe.init();
                panel_pairEnd.add(pe);


                //create an instance of your processing applet
                final Grid_Zoom grid = new Grid_Zoom();
                grid.init();
                panel_zoom.add(grid); //this is the panel loaded on the JFrame (public static)


                //create an instance of your processing applet
                final Chromosome_whole chr = new Chromosome_whole();
                chr.init();
                panel_position_in_chromosome.add(chr); //this is the panel loaded on the JFrame (public static)


                //create an instance of your processing applet
                final Chromosome_zoomed chromosome = new Chromosome_zoomed();
                chromosome.init();
                panel_chromosome.add(chromosome); //this is the panel loaded on the JFrame (public static)


                jMenuItem4.setVisible(false);
                jMenuItem10.setVisible(false);
                //  Variables.check_variations.setVisible(false);
                Container contentPane = frame.getContentPane();

                //display the frame
                frame.setVisible(true);



                //    Variables.something_changed = 0;
                //    Variables.zooming_window_enabled = true;
                //    String meander_file = "/Users/gpavlopo/Desktop/Meander/chr1-cnv-seq/chromosome_1.meander";
                //   Variables.meander_file = meander_file;
                //  load_meander_file(meander_file);


            }
        });


        if (args.length > 0 && run_once == false) {
            for (int i = 0; i < args.length; i++) {




                if (args[i].compareTo("-chr") == 0) {
                    Variables.chromosome = args[i + 1];

                }

                if (args[i].compareTo("-rd") == 0) {
                    File ff = new File(args[i + 1]);
                    String project_file = ff.getAbsolutePath();


                    if (args[i + 1].endsWith(".txt")) {
                        Variables.file_with_reads = ff.getAbsolutePath();
                        Variables.codebase = ff.getParent() + "" + File.separatorChar;

                        if (jMenuItem6 != null) {
                            jMenuItem6.setEnabled(false);
                        }



                        if (file_Open != null) {
                            file_Open.setEnabled(false);
                        }


                    }
                    if (args[i + 1].endsWith(".meander")) {

                        Variables.something_changed = 0;
                        Variables.zooming_window_enabled = true;
                        // Variables.wait_for_first_loading = true;
                        Variables.meander_file = args[i + 1];
                        Meander.load_meander_file(Variables.meander_file);
                        if (jMenuItem6 != null) {
                            jMenuItem6.setEnabled(false);
                        }


                        if (file_Open != null) {
                            file_Open.setEnabled(false);
                        }

                    }

                }



                if (args[i].compareTo("-pe") == 0) {
                    File ff = new File(args[i + 1]);
                    String project_file = ff.getAbsolutePath();
                    Variables.pair_ends_enabled = true;
                    Meander.load_pair_ends(project_file);
                }

                if (args[i].compareTo("-var") == 0) {
                    File ff = new File(args[i + 1]);
                    String project_file = ff.getAbsolutePath();

                    Meander.load_variations(project_file);
                    Variables.variation_enabled = true;
                }


            }
            run_once = true;
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JMenuItem file_Open;
    public static javax.swing.JButton jButton_zoom;
    public static javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    public static javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    public static javax.swing.JComboBox jComboBox_zoom_levels;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel_status;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    public static javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    public static javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    public static javax.swing.JMenuItem jMenuItemContrast;
    public static javax.swing.JMenuItem jMenuItemRatioColor;
    public static javax.swing.JMenuItem jMenuItemReferenceColor;
    public static javax.swing.JMenuItem jMenuItemSampleColor;
    private javax.swing.JMenu jMenu_variations;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JProgressBar jProgressBar;
    public static javax.swing.JLabel label_zoom_level;
    public static javax.swing.JPanel panel_chromosome;
    public static javax.swing.JPanel panel_hilbert;
    public static javax.swing.JPanel panel_pairEnd;
    public static javax.swing.JPanel panel_position_in_chromosome;
    public static javax.swing.JPanel panel_zoom;
    // End of variables declaration//GEN-END:variables
}
