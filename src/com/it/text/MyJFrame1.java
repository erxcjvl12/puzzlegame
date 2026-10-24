package com.it.text;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame1 extends JFrame implements KeyListener {
    public MyJFrame1() {
        //界面大小
        this.setSize(603, 680);
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

        //给整个界面添加键盘监听
        //第一个this是调用者this：本类对象，当前界面中的对象给整个界面添加键盘监听
        //第二个this：事件触发以后执行本类中的代码也就是接口中重写的函数
        this.addKeyListener(this);


        //让整个页面显现出来
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下不送");

    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开按键");
        //利用getKeyCode()去给每一个编一个值
        int code = e.getKeyCode();
        System.out.println(code);
        if(code == 65){
            System.out.println("现在按的是a");
        }else if(code == 66){
            System.out.println("我现在按的是b");
        }
    }
}
