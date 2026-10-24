package com.it.text;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame extends JFrame implements MouseListener, ActionListener {
    JButton jbt1 = new JButton("点我呀");
    public MyJFrame(){
        //界面大小
        this.setSize(603,680);
        //界面标题
        this.setTitle("拼图单机版 v1.0");
        //界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置游戏的控制器关闭模式
        this.setDefaultCloseOperation(3);//这个0，1，2，3有源码设计
        //取消默认的居中放置
        this.setLayout(null);
        //给按钮设置位置与宽高
        jbt1.setBounds(0,0,100,50);
        //给按钮绑定鼠标监听
        jbt1.addMouseListener(this);

        //给按钮添加到界面中
        this.getContentPane().add(jbt1);

        //显示整个界面
        this.getContentPane().add(jbt1);
        //让整个页面显现出来
        this.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("单击");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("按住不送");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("松开");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("划入");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("划出");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
