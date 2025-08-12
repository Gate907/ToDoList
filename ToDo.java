

import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author HP 001
 */
public class ToDo extends JFrame{

    /**
     * @param args the command line arguments
     */
  

	private DefaultListModel<String> taskModel;
	private JList<String> taskList;
	private JTextField task;
	private JButton addBtn,deleteBtn;
	
        
	public ToDo(){
            setTitle("ToDo List :");
            setSize(600, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            task=new JTextField(20);
            addBtn=new JButton("Add Button");
            deleteBtn=new JButton("Delete Button");
            
            
            taskModel=new DefaultListModel<>();
            taskList=new JList<>(taskModel);
            
            
            //output screen
            JScrollPane scroll=new JScrollPane(taskList);
            
            JPanel top=new JPanel();
            top.add(task);
            top.add(addBtn);
            
            JPanel bottom=new JPanel();
            top.add(deleteBtn);
            
            
            add(scroll,BorderLayout.CENTER);
            add(top,BorderLayout.NORTH);
            add(bottom,BorderLayout.SOUTH);
            
            addBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                   String text=task.getText().trim();
                   if(!text.isEmpty()){
                       taskModel.addElement(text);
                       task.setText("");
                   }else{
                       JOptionPane.showMessageDialog(null, "Enter Text First");
                   }
                }
            });
            
            
            deleteBtn.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                 int index=taskList.getSelectedIndex();
                 if(index!=-1){
                     taskModel.remove(index);
                 }else{
                       JOptionPane.showMessageDialog(null, "Select index First");
                   }
                }
            });
            
        }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
                   new ToDo().setVisible(true);
	}

}

    

