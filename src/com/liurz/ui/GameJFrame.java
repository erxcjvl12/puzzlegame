package com.liurz.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {


    //创建条目对象
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem loginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("公众号");


    //定义游戏数组
    int[][] data = new int[4][4];
    //记录空白方块在二维数组中的位置
    int x = 0;
    int y = 0;

    //初始化计数器
    int step = 0;

    //定义胜利数组
    int[][] win = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };

    //定义变量来展示记录的图片
    // 当前选择的图片类别，默认动物
    private String selectedCategory = "animal";

    // 当前类别下的图片序号，从1开始
    private int pictureIndex = 1;

    // 当前游戏使用的图片目录
    String path = "image\\animal\\animal1\\";

    //添加
    JMenu changePictureMenu = new JMenu("更换图片");
    JMenu categoryMenu = new JMenu("选择类别");
    JMenuItem beautyItem = new JMenuItem("美女");
    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem sportItem = new JMenuItem("运动");
    JMenuItem startGameItem = new JMenuItem("开始游戏");

    //跟游戏相关的主界面

    //游戏主界面界面的设置
    public GameJFrame() {

        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuBar();

        //初始化数据（打乱）
        initDate();

        //初始化图片（根据打乱的结果去初始化图片）
        initImage();

        //界面显示（写到最后）
        this.setVisible(true);

        //添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //放置一个键盘监听
        int code = e.getKeyCode();
        if(code == 65){
            //一键作弊功能
            //首先清楚所有图片
            this.getContentPane().removeAll();
            //随后加载完整图片与背景图片
            JLabel jLabel2 = new JLabel(new ImageIcon(path +"all.jpg"));
            //设计位置
            jLabel2.setBounds(83,134,420,420);
            //添加
            this.getContentPane().add(jLabel2);
            //背景
            //背景图片的添加
            JLabel background = new JLabel(new ImageIcon("image\\background.png"));
            //显现出来
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);

            //刷新界面
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //如果游戏胜利就不可以继续进行图片移动了及结束方法
        if(victory()){
            return;
        }
        //先来写键盘监听与上下左右键的使用
        int code = e.getKeyCode();
        if(code == 37){//左
            if(y == 3){
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            //执行完一次移动计步器自动++一次
            step++;
            initImage();
        }else if(code == 38){//向上运动
            if(x == 3){
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            //执行完一次移动计步器自动++一次
            step++;
            initImage();
        }else if(code == 39){//右
            if(y == 0){
                return;
            }
            data[x][y] = data[x][y - 1];//BUG来源！！！
            data[x][y - 1] = 0;
            y--;
            //执行完一次移动计步器自动++一次
            step++;
            initImage();
        }else if(code == 40){//下
            if(x == 0){
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            //执行完一次移动计步器自动++一次
            step++;
            initImage();
        }else if(code == 65){
            initImage();
        }else if(code == 87){
            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}
            };
            initImage();
        }
    }

    //初始化数据的方法
    private void initDate() {
        //定义数组
        int[] temArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //循环遍历打乱通过随机索引打乱数组
        Random r = new Random();
        for (int i = 0; i < temArr.length; i++) {
            int index = r.nextInt(temArr.length);
            //拿着数组索引进行交换
            int temp = temArr[i];
            temArr[i] = temArr[index];
            temArr[index] = temp;
        }
        for (int i = 0; i < temArr.length; i++) {
            System.out.print(temArr[i] + " ");
        }
        System.out.println();
        //下面把打乱的一维数组循环遍历到二维数组中可以采用两种解法
        //解法一：循环遍历一维数组
        for (int i = 0; i < temArr.length; i++) {
            if (temArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            } {
                data[i / 4][i % 4] = temArr[i];
            }
        }
        //解法二：循环遍历二维数组
        /*
        int index = 0;
        for (int i = 0; i < temArr.length; i++) {
            for (int j = 0; j < temArr.length; j++) {
                data[i][j] = temArr[index];
                index++;
            }
        }*/
        //打印二维数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void initImage() {
        //清空已有图片重新加载
        //（1）清空已有图片
        this.getContentPane().removeAll();
    //在添加图片的时候先添加的图片在前后添加的图片在后！！
        if(victory()){
            JLabel jLabel4 = new JLabel(new ImageIcon("C:\\Users\\Broccoil\\IdeaProjects\\basic-code\\puzzlegame\\image\\win.png"));
            jLabel4.setBounds(203,283,197,73);
            this.getContentPane().add(jLabel4);
        }

        //计步器
        JLabel stepCount = new JLabel("步数" + step);
        stepCount.setBounds(50,30,100,20);
        this.getContentPane().add(stepCount);

        //复制4列
        for (int i = 0; i < 4; i++) {
            //内循环-----一行添加四张图片
            for (int j = 0; j < 4; j++) {
                //抓取二维数组中的图片序号
                int num = data[i][j];
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel1 = new JLabel(new ImageIcon(path + num + ".jpg"));
                //指定图片位置
                jLabel1.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                jLabel1.setBorder(new BevelBorder(1));
                //将管理容器添加到界面中
                //需要调用JFrame中的隐藏管理器
                this.getContentPane().add(jLabel1);
            }
        }
        //背景图片的添加
        JLabel background = new JLabel(new ImageIcon("image\\background.png"));
        //显现出来
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();
    }

    private void initJMenuBar() {
        // 创建整个菜单的对象
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单两个选项（功能，关于我们）
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutUsJMenu = new JMenu("关于我们");

        categoryMenu.add(beautyItem);
        categoryMenu.add(animalItem);
        categoryMenu.add(sportItem);

        changePictureMenu.add(categoryMenu);
        changePictureMenu.add(startGameItem);

        functionJMenu.add(changePictureMenu);




        //给条目添加动作监听
        replayItem.addActionListener(this);
        loginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        //新添加的条目
        beautyItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportItem.addActionListener(this);
        startGameItem.addActionListener(this);

        //调用条目对象将其添加进菜单的选项中
        functionJMenu.add(replayItem);
        functionJMenu.add(loginItem);
        functionJMenu.add(closeItem);

        aboutUsJMenu.add(accountItem);

        //将选项添加到菜单
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutUsJMenu);

        //最后给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {

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

        //添加键盘监事件

    }

    //判断胜利
    protected boolean victory(){
        //通过遍历进行数组比较
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if(data[i][j] != win[i][j]){
                    //出现一个不一样就显示false
                    return false;
                }

            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取当前点击的条目对象
        Object obj = e.getSource();
        //进行判断
        if(obj == replayItem){
            //初始化
            //步数清零
            step = 0;
            //打乱数组初始化游戏
            initDate();
            //界面
            initImage();
        } else if (obj == loginItem) {
            //关闭游戏界面
            this.setVisible(false);

            //打开登录界面
            new LoginJFrame();
        } else if (obj == closeItem) {
            System.exit(0);
        } else if (obj == accountItem) {
            //创建一个弹框对象
            JDialog jDialog = new JDialog();

            //创建管理图片对象JLabel
            JLabel jLabel5 = new JLabel(new ImageIcon("image\\about.png"));

            //设置位置和宽高
            jLabel5.setBounds(0,0,258,258);

            //添加进容器
            jDialog.getContentPane().add(jLabel5);

            //设置弹框大小
            jDialog.setSize(344,344);

            //让弹窗置顶
            jDialog.setAlwaysOnTop(true);

            //弹框居中
            jDialog.setLocationRelativeTo(null);

            //不关闭弹窗无法显示界面
            jDialog.setModal(true);

            //让弹框显示
            jDialog.setVisible(true);


        }if (obj == beautyItem) {
            selectedCategory = "girl";
            pictureIndex = 1;
        } else if (obj == animalItem) {
            selectedCategory = "animal";
            pictureIndex = 1;
        } else if (obj == sportItem) {
            selectedCategory = "sport";
            pictureIndex = 1;
        } else if (obj == startGameItem) {
            path = "image\\" + selectedCategory + "\\"
                    + selectedCategory + pictureIndex + "\\";

            // 下一次开始时切换到该类别的下一张，超出后从第1张开始
            pictureIndex++;
            int maxPictures = selectedCategory.equals("girl") ? 13
                    : selectedCategory.equals("animal") ? 8 : 10;
            if (pictureIndex > maxPictures) {
                pictureIndex = 1;
            }

            step = 0;
            initDate();
            initImage();
        } else if (obj == replayItem) {
            // 保留原来的重新游戏逻辑
            }


    }
}
