package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controllers.Controller;

public final class LoginPanel extends JPanel{

	private String msg="Please enter username and Password",failLogin="Username or password is incorrect",
			makeFail="Username already exists",btnCreate="Create",btnCancel="Cancel";
	
	private Label username=new Label("Username:"),password=new Label("Password:"),message=new Label(msg);
	private JTextField nameField=new JTextField(),pField=new JTextField();
	private JPasswordField pwField=new JPasswordField();
	private JButton enter=new JButton("Login"),newUser=new JButton(btnCreate),create=new JButton("Create");
	
	private ActionListener toggle=new ActionListener(){public void actionPerformed(ActionEvent e){
		create.setVisible(!create.isVisible());
		enter.setVisible(!enter.isVisible());
		pField.setVisible(!pField.isVisible());
		pwField.setVisible(!pwField.isVisible());
		toggleText();
		message.setText(msg);
		nameField.setText("");
		pField.setText("");
		pwField.setText("");
	}};
	private JPanel u=new JPanel(),p=new JPanel(),b=new JPanel();
	
	public LoginPanel(){
		newUser.addActionListener(toggle);
		u.add(username);
		u.add(nameField);
		p.add(password);
		p.add(pField);
		pField.setVisible(false);
		p.add(pwField);
		b.add(enter);
		b.add(create);
		create.setVisible(false);
		b.add(newUser);
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		this.add(message);
		this.add(u);
		this.add(p);
		this.add(b);
		Dimension dim=new Dimension(200,20);
		nameField.setPreferredSize(dim);
		pwField.setPreferredSize(dim);
		pField.setPreferredSize(dim);

	}
	public void addController(Controller c){
		enter.addActionListener(c);
		create.addActionListener(c);
	}
	public void setDaLength(){
		int height =nameField.getSize().height;
		System.out.print(height);
	}
	public void failLogin(){message.setText(failLogin);}
	public void failCreate(){message.setText(makeFail);}
	public void showt(){message.setText(msg);}
	private void toggleText(){
		if(newUser.getText().equals(btnCreate))newUser.setText(btnCancel);
		else newUser.setText(btnCreate);
	}
	
	public Label getMessage() {return message;}
	public JTextField getNameField() {return nameField;}
	public JPasswordField getPwField() {return pwField;}
	public JButton getEnter() {return enter;}
	public JButton getCreate(){return create;}
	public JButton getNewUser() {return newUser;}

	


}
