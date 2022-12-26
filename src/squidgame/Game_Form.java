/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package squidgame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author shrig
 */
public class Game_Form extends javax.swing.JFrame {

    /**
     * Creates new form Game_Form
     */
    
    Border black_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE);
    
    String footsteps = "\\/images/newfoot.png";
    String nosteps = "\\/images/noSteps.png";
    String cracks = "\\/images/glass1.png";
    
    Component[] comp1;
    Component[] comp2;
    
    Random random = new Random();
    String randomImage;
    JLabel[][] labels;
    String[][] imagesOrder = new String[6][2];
    ArrayList<String> list = new ArrayList<>();
    
    int counter = 0;
    boolean won = true;
    
    
    public Game_Form() {
        initComponents();
        this.setLocationRelativeTo(null);
        jPanel_Start.setBorder(black_border);
        jPanel_Finish.setBorder(black_border);
        jLabel_PlayerStart.setBorder(black_border);
        jLabel_PlayerFinish.setBorder(black_border);
        
        displayImage(footsteps,jLabel_PlayerStart);
        
        labels = new JLabel[][]{{jLabel_11,jLabel_21},{jLabel_12,jLabel_22},
                                {jLabel_13,jLabel_23},{jLabel_14,jLabel_24},
                                {jLabel_15,jLabel_25},{jLabel_16,jLabel_26}};
        
        for(JLabel[] lbls : labels){
            lbls[0].setEnabled(false);
             lbls[1].setEnabled(false);
        }
        
        list.add(footsteps);
        list.add(cracks);
        comp1 = jPanel2.getComponents();
        comp2 = jPanel3.getComponents();
        randomImages(); 
        addAction();  
        
    }
    public void enableLabels(int index){
        if(index <= labels.length-1){
            JLabel[] lbls = labels[index];
            lbls[0].setEnabled(true);
             lbls[1].setEnabled(true);
        }
    };
    public void randomImages()
    {
        for(int i=0;i<labels.length;i++)
        {
            randomImage = list.get(random.nextInt(list.size()));
            imagesOrder[i][0] = randomImage;
            
            if(randomImage.equals(footsteps)){
                imagesOrder[i][1] = cracks;
            }else{
                imagesOrder[i][1] = footsteps;
            }
            
            
            System.out.println(imagesOrder[i][1]);
            System.out.println(imagesOrder[i][0 ]);
            System.out.println("-------------");
        }
    }
    public void addAction(){
        enableLabels(counter);
        for(Component comp : comp1){
            if(comp instanceof JLabel)
            {
                JLabel label = (JLabel) comp;
                label.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt)
                    {
                        if(label.isEnabled()){
                             displayImage(imagesOrder[counter][1],label);
                             if(imagesOrder[counter][1].equals(cracks)){
                                 won = false;
                             }
                             
                             JLabel label = (JLabel) comp2[counter];
                             label.setEnabled(false);
                             if(counter ==  imagesOrder.length-1 && won == true){
                                 displayImage(footsteps,jLabel_PlayerFinish);
                                 jLabel_Message.setText("You,ve Won :)");
                             }
                             else if( won == false){
                                 
                                 jLabel_Message.setText("You,ve Lost :(");
                             }
                             counter++;
                             enableLabels(counter);
                        }   
                             
                    }  
                
                });
                
                
            }
        }
        
        
        for(Component comp : comp2){
            if(comp instanceof JLabel)
            {
                JLabel label = (JLabel) comp;
                label.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt)
                    {
                        if(label.isEnabled()){
                            displayImage(imagesOrder[counter][0],label);
                            if(imagesOrder[counter][0].equals(cracks)){
                                 won = false;
                             }
                            
                            JLabel label = (JLabel) comp1[counter];
                            label.setEnabled(false);
                             if(counter ==  imagesOrder.length-1 && won == true){
                                 displayImage(footsteps,jLabel_PlayerFinish);
                                 jLabel_Message.setText("You,ve Won :)");
                             }
                             else if(  won == false){
                                 
                                 jLabel_Message.setText("You,ve Lost :(");
                             
                             }
                            counter++;
                            enableLabels(counter);
                        }
                    }
                
                });
                
            }
        }
    }
    
    public void displayImage(String imgPath, JLabel label){
        ImageIcon imgIco = new ImageIcon(getClass().getResource(imgPath));
        Image image = imgIco.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(image));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel_Start = new javax.swing.JPanel();
        jLabel_PlayerStart = new javax.swing.JLabel();
        jPanel_Finish = new javax.swing.JPanel();
        jLabel_PlayerFinish = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_22 = new javax.swing.JLabel();
        jLabel_23 = new javax.swing.JLabel();
        jLabel_21 = new javax.swing.JLabel();
        jLabel_24 = new javax.swing.JLabel();
        jLabel_25 = new javax.swing.JLabel();
        jLabel_26 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel_12 = new javax.swing.JLabel();
        jLabel_13 = new javax.swing.JLabel();
        jLabel_11 = new javax.swing.JLabel();
        jLabel_14 = new javax.swing.JLabel();
        jLabel_15 = new javax.swing.JLabel();
        jLabel_16 = new javax.swing.JLabel();
        jButton_PlayAgain = new javax.swing.JButton();
        jLabel_Message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel_Start.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel_StartLayout = new javax.swing.GroupLayout(jPanel_Start);
        jPanel_Start.setLayout(jPanel_StartLayout);
        jPanel_StartLayout.setHorizontalGroup(
            jPanel_StartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_StartLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel_PlayerStart, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel_StartLayout.setVerticalGroup(
            jPanel_StartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_StartLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(jLabel_PlayerStart, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        jPanel_Finish.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel_FinishLayout = new javax.swing.GroupLayout(jPanel_Finish);
        jPanel_Finish.setLayout(jPanel_FinishLayout);
        jPanel_FinishLayout.setHorizontalGroup(
            jPanel_FinishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FinishLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel_PlayerFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel_FinishLayout.setVerticalGroup(
            jPanel_FinishLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_FinishLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel_PlayerFinish, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel_22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_22.setOpaque(true);

        jLabel_23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_23.setOpaque(true);

        jLabel_21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_21.setOpaque(true);

        jLabel_24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_24.setOpaque(true);

        jLabel_25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_25.setOpaque(true);

        jLabel_26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_26.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_21, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_22, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_23, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_24, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_25, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_26, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_22, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel_23, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel_21, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel_24, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel_25, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel_26, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        jLabel_12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_12.setOpaque(true);

        jLabel_13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_13.setOpaque(true);

        jLabel_11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_11.setOpaque(true);

        jLabel_14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_14.setOpaque(true);

        jLabel_15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_15.setOpaque(true);

        jLabel_16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel_16.setOpaque(true);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_12, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_13, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_14, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_15, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel_16, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_12, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel_13, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel_11, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel_14, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel_15, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(jLabel_16, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton_PlayAgain.setBackground(new java.awt.Color(204, 204, 255));
        jButton_PlayAgain.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton_PlayAgain.setForeground(new java.awt.Color(204, 204, 255));
        jButton_PlayAgain.setText("Play Again");
        jButton_PlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_PlayAgainActionPerformed(evt);
            }
        });

        jLabel_Message.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel_Message.setForeground(new java.awt.Color(204, 204, 255));
        jLabel_Message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel_Finish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(563, 563, 563)
                        .addComponent(jButton_PlayAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(513, 513, 513)
                        .addComponent(jLabel_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel_Finish, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addComponent(jPanel_Start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel_Message, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton_PlayAgain, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_PlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_PlayAgainActionPerformed
        randomImages();
        for(JLabel[] lbls : labels){
            lbls[0].setIcon(null);
            lbls[1].setIcon(null);
        }
        jLabel_PlayerFinish.setIcon(null);
        counter =0;
        won = true;
        jLabel_Message.setText("");
        enableLabels(counter);
    }//GEN-LAST:event_jButton_PlayAgainActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game_Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_PlayAgain;
    private javax.swing.JLabel jLabel_11;
    private javax.swing.JLabel jLabel_12;
    private javax.swing.JLabel jLabel_13;
    private javax.swing.JLabel jLabel_14;
    private javax.swing.JLabel jLabel_15;
    private javax.swing.JLabel jLabel_16;
    private javax.swing.JLabel jLabel_21;
    private javax.swing.JLabel jLabel_22;
    private javax.swing.JLabel jLabel_23;
    private javax.swing.JLabel jLabel_24;
    private javax.swing.JLabel jLabel_25;
    private javax.swing.JLabel jLabel_26;
    private javax.swing.JLabel jLabel_Message;
    private javax.swing.JLabel jLabel_PlayerFinish;
    private javax.swing.JLabel jLabel_PlayerStart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel_Finish;
    private javax.swing.JPanel jPanel_Start;
    // End of variables declaration//GEN-END:variables
}
