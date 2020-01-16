/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classe.Funcionario;
import Dados.DadosFuncionario;
import Negocio.NegocioFuncionario;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pichau
 */
public class FuncionarioGUIRemover extends javax.swing.JFrame {

    ArrayList<Funcionario> ListarMatricula = new ArrayList<>();

    public void ListarFuncionario() {

        try {
            Funcionario funcionario = new Funcionario();
            DadosFuncionario dados = new DadosFuncionario();

            this.ListarMatricula = dados.listarFuncionarios(funcionario);
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();

            for (Funcionario f : this.ListarMatricula) {
                modelo.addElement(f.getMatricula());
            }
            jComboBoxMatriculaFuncionario.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }

    public void ResetaTabela() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(new Object[]{"Matricula", "Nome", "Cpf", "Rg", "Sálario"});
        jTableRemoverFuncionario.setModel(modelo);
    }

    public FuncionarioGUIRemover() {
        initComponents();
        ListarFuncionario();
        ResetaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jButtonRemoverFuncionario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRemoverFuncionario = new javax.swing.JTable();
        jButtonConsultar = new javax.swing.JButton();
        jLabelSelecionarFuncionario = new javax.swing.JLabel();
        jComboBoxMatriculaFuncionario = new javax.swing.JComboBox<>();
        jLabelInformacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelTitulo.setText("Remover Funcionario");

        jButtonRemoverFuncionario.setText("Remover");
        jButtonRemoverFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverFuncionarioActionPerformed(evt);
            }
        });

        jTableRemoverFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTableRemoverFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTableRemoverFuncionarioMousePressed(evt);
            }
        });
        jTableRemoverFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTableRemoverFuncionarioKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRemoverFuncionario);

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jLabelSelecionarFuncionario.setText("Selecione o Funcionario para remover:");

        jComboBoxMatriculaFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxMatriculaFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBoxMatriculaFuncionarioMouseClicked(evt);
            }
        });

        jLabelInformacao.setText("Não é possivel remover um funcionario que tenha ordem de serviço vinculada");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(250, 250, 250))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabelInformacao))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelSelecionarFuncionario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxMatriculaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jButtonRemoverFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabelTitulo)
                .addGap(18, 18, 18)
                .addComponent(jLabelInformacao)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelSelecionarFuncionario)
                    .addComponent(jComboBoxMatriculaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButtonRemoverFuncionario)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRemoverFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverFuncionarioActionPerformed
        // TODO add your handling code here:

        try {
            
            if (jComboBoxMatriculaFuncionario.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Sem funcionario para remover");
                dispose();
                return;
                
            }

            Funcionario funcionario = new Funcionario();
            funcionario.setMatricula(Integer.parseInt(jComboBoxMatriculaFuncionario.getSelectedItem().toString()));
            NegocioFuncionario negocio = new NegocioFuncionario();
            negocio.removerFuncionario(funcionario);

            int resposta = JOptionPane.showConfirmDialog(rootPane, "Funcionario removido! \nDeseja Remover outro Funcionario?", "Sucesso", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) {
                ResetaTabela();
                ListarFuncionario();

            } else {
                dispose();
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }

    }//GEN-LAST:event_jButtonRemoverFuncionarioActionPerformed

    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        // TODO add your handling code here:

        try {

            if (jComboBoxMatriculaFuncionario.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(rootPane, "Sem funcionario para remover");
                dispose();
                return;
            }

            Funcionario funcionario = new Funcionario();

            funcionario.setMatricula(Integer.parseInt(jComboBoxMatriculaFuncionario.getSelectedItem().toString()));

            DadosFuncionario dados = new DadosFuncionario();
            this.ListarMatricula = dados.listarFuncionarios(funcionario);

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.setColumnIdentifiers(new Object[]{"Matricula", "Nome", "Cpf", "Rg", "Sálario"});

            for (Funcionario f : this.ListarMatricula) {
                modelo.addRow(new Object[]{f.getMatricula(), f.getNome(), f.getCpf(), f.getRg(), f.getSalario()});
            }

            jTableRemoverFuncionario.setModel(modelo);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage());
        }


    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void jComboBoxMatriculaFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBoxMatriculaFuncionarioMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboBoxMatriculaFuncionarioMouseClicked

    private void jTableRemoverFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableRemoverFuncionarioKeyTyped
        // TODO add your handling code here:,
        jTableRemoverFuncionario.editingCanceled(null);
        jTableRemoverFuncionario.editingStopped(null);
    }//GEN-LAST:event_jTableRemoverFuncionarioKeyTyped

    private void jTableRemoverFuncionarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRemoverFuncionarioMousePressed
        // TODO add your handling code here:
        jTableRemoverFuncionario.editingCanceled(null);
        jTableRemoverFuncionario.editingStopped(null);
    }//GEN-LAST:event_jTableRemoverFuncionarioMousePressed

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
            java.util.logging.Logger.getLogger(FuncionarioGUIRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FuncionarioGUIRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FuncionarioGUIRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FuncionarioGUIRemover.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FuncionarioGUIRemover().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonRemoverFuncionario;
    private javax.swing.JComboBox<String> jComboBoxMatriculaFuncionario;
    private javax.swing.JLabel jLabelInformacao;
    private javax.swing.JLabel jLabelSelecionarFuncionario;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRemoverFuncionario;
    // End of variables declaration//GEN-END:variables
}
