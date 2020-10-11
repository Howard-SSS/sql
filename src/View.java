
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Stack;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;


public class View extends javax.swing.JFrame {
    private static final String url="jdbc:mysql://localhost:3306/student_course?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
    private static final String username="root";
    private static final String password="123456";
    private Connection conn=null;
    private Statement stmt;
    private String[] StudentHead=new String[]{"Sno", "Sname", "Ssex", "Sage", "Sdept"};
    private String[] CourseHead=new String[]{"Cno", "Cname", "Cpno", "Ccredit"};
    private String[] ScHead=new String[]{"Sno", "Cno", "Grade"};
    private int[] Sno=new int[20];//主键
    private int[] Cno=new int[20];//主键
    private int[][] Sno_Cno=new int[20][2];//主键
    private boolean[][] StudentIsturn=new boolean[20][6];
    private boolean[][] CourseIsturn=new boolean[20][5];
    private boolean[][] ScIsturn=new boolean[20][4];
    private String oldvalue="";
    public View() throws Exception{
        initComponents();
        conn=DriverManager.getConnection(url,username,password);
        stmt = conn.createStatement();
        SetRenderer();
        jTableStudent.getModel().addTableModelListener(new TableModelListener(){
            @Override
            public void tableChanged(TableModelEvent e)
            {
                //焦点失去时记录是否修改
                if(e.getType() == TableModelEvent.UPDATE){
                    int row=jTableStudent.getSelectedRow();
                    int col=jTableStudent.getSelectedColumn();
                    if(row==jTableStudent.getRowCount()-1)//空行做修改不记录
                        return ;
                    String newvalue=jTableStudent.getValueAt(row,col).toString();
                    if(!newvalue.equals(oldvalue)){
                        StudentIsturn[row][0]=true;
                        StudentIsturn[row][col+1]=true;
                    }
                }
            }});
    }
    /*
    *设置表格渲染器
    */
    private void SetRenderer(){
        MyTableReander reander=new MyTableReander();
        jTableStudent.setDefaultRenderer(String.class,reander);
        jTableStudent.setDefaultRenderer(Integer.class,reander);
        jTableStudent.setDefaultRenderer(Double.class,reander);
        jTableCourse.setDefaultRenderer(String.class,reander);
        jTableCourse.setDefaultRenderer(Integer.class,reander);
        jTableCourse.setDefaultRenderer(Double.class,reander);
        jTableSc.setDefaultRenderer(Object.class,reander);
        jTableSc.setDefaultRenderer(Integer.class,reander);
        jTableSc.setDefaultRenderer(Double.class, reander);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaShow = new javax.swing.JTextArea();
        jButtonAdd = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableStudent = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableCourse = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableSc = new javax.swing.JTable();
        jButtonSelect = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonGrade = new javax.swing.JButton();
        jButtonAvgGrade = new javax.swing.JButton();
        jTextFieldCondition = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));

        jTextAreaShow.setEditable(false);
        jTextAreaShow.setColumns(20);
        jTextAreaShow.setLineWrap(true);
        jTextAreaShow.setTabSize(0);
        jScrollPane1.setViewportView(jTextAreaShow);

        jButtonAdd.setText("添加");
        jButtonAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAddMouseClicked(evt);
            }
        });

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTableStudent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sno", "Sname", "Ssex", "Sage", "Sdept", "Cname", "Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableStudent.setCellSelectionEnabled(true);
        jTableStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableStudentMouseClicked(evt);
            }
        });
        jTableStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableStudentKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTableStudent);

        jTabbedPane1.addTab("Student", jScrollPane2);

        jTableCourse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Cno", "Cname", "Cpno", "Ccredit", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCourse.setCellSelectionEnabled(true);
        jTableCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCourseMouseClicked(evt);
            }
        });
        jTableCourse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableCourseKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(jTableCourse);

        jTabbedPane1.addTab("Course", jScrollPane3);

        jTableSc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Sno", "Cno", "Grade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableSc.setCellSelectionEnabled(true);
        jTableSc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableScMouseClicked(evt);
            }
        });
        jTableSc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableScKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(jTableSc);

        jTabbedPane1.addTab("Sc", jScrollPane4);

        jButtonSelect.setText("查询");
        jButtonSelect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSelectMouseClicked(evt);
            }
        });

        jButtonUpdate.setText("修改");
        jButtonUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonUpdateMouseClicked(evt);
            }
        });

        jButtonDelete.setText("删除");
        jButtonDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonDeleteMouseClicked(evt);
            }
        });

        jButtonGrade.setText("个人成绩");
        jButtonGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGradeMouseClicked(evt);
            }
        });

        jButtonAvgGrade.setText("平均成绩");
        jButtonAvgGrade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonAvgGradeMouseClicked(evt);
            }
        });

        jTextFieldCondition.setToolTipText("条件：");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextFieldCondition, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAvgGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAdd)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonUpdate)
                    .addComponent(jButtonSelect)
                    .addComponent(jButtonAvgGrade))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGrade)
                    .addComponent(jTextFieldCondition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAddMouseClicked
        int index=jTabbedPane1.getSelectedIndex();
        if(index==0){
            DefaultTableModel studentModel=(DefaultTableModel)jTableStudent.getModel();
            int lastRowIndex=jTableStudent.getRowCount()-1;
            Integer Sno=(Integer)jTableStudent.getValueAt(lastRowIndex, 0);
            String Sname=(String)jTableStudent.getValueAt(lastRowIndex,1);
            String Ssex=(String)jTableStudent.getValueAt(lastRowIndex,2);
            String Sage=(String)jTableStudent.getValueAt(lastRowIndex, 3);
            String Sdept=(String)jTableStudent.getValueAt(lastRowIndex,4);
            if(Sno==null&&Sname==null&&Ssex==null&&Sage==null&&Sdept==null){
                return ;
            }
            try{
                String sql="insert into student(Sno";
                String value="Value('"+Sno+"'";
                if(Sname!=null){
                    sql+=",Sname";
                    value=value+",'"+Sname+"'";
                }
                if(Ssex!=null){
                    sql+=",Ssex";
                    value=value+",'"+Ssex+"'";
                }
                if(Sage!=null){
                    sql+=",Sage";
                    value=value+",'"+Sage+"'";
                }
                if(Sdept!=null){
                    sql+=",Sdept";
                    value=value+",'"+Sdept+"'";
                }
                sql=sql+")"+value+")";
                jTextAreaShow.append(sql+"\n\n");
                stmt.executeUpdate(sql);
                studentModel.addRow(new Object[]{null,null,null,null,null});
                jTableStudent.setModel(studentModel);
            }catch(SQLException ex){jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");}
        }else if(index==1){
            DefaultTableModel courseModel=(DefaultTableModel)jTableCourse.getModel();
            int lastRowIndex=jTableCourse.getRowCount()-1;
            Integer Cno=(Integer)jTableCourse.getValueAt(lastRowIndex, 0);
            String Cname=(String)jTableCourse.getValueAt(lastRowIndex, 1);
            String Cpno=(String)jTableCourse.getValueAt(lastRowIndex, 2);
            String Ccredit=(String)jTableCourse.getValueAt(lastRowIndex, 3);
            if(Cno==null&&Cname==null&&Cpno==null&&Ccredit==null){
                return ;
            }
            try{
                String sql="insert into course(Cno";
                String value="Value('"+Cno+"'";
                if(Cname!=null){
                    sql+=",Cname";
                    value=value+",'"+Cname+"'";
                }
                if(Cpno!=null){
                    sql+=",Cpno";
                    value=value+",'"+Cpno+"'";
                }
                if(Ccredit!=null){
                    sql+=",Ccredit";
                    value=value+",'"+Ccredit+"'";
                }
                sql=sql+")"+value+")";
                jTextAreaShow.setText(sql+"\n\n");
                stmt.executeUpdate(sql);
                courseModel.addRow(new Object[]{null,null,null,null});
                jTableCourse.setModel(courseModel);
            }catch(SQLException ex){jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");}
        }else if(index==2){
            DefaultTableModel scModel=(DefaultTableModel)jTableSc.getModel();
            int lastRowIndex=jTableSc.getRowCount()-1;
            Integer Sno=(Integer)jTableSc.getValueAt(lastRowIndex,0);
            Integer Cno=(Integer)jTableSc.getValueAt(lastRowIndex,1);
            Double Grade=(Double)jTableSc.getValueAt(lastRowIndex,2);
            if(Sno==null&&Cno==null&&Grade==null){
                return ;
            }
            try{
                String sql="insert into sc(Sno,Cno";
                String value="Value('"+Sno+"','"+Cno+"'";
                if(Grade!=null){
                    sql+=",Grade";
                    value=value+",'"+Grade+"'";
                }
                sql=sql+")"+value+")";
                jTextAreaShow.setText(sql+"\n\n");
                stmt.executeUpdate(sql);
                scModel.addRow(new Object[]{null,null,null});
                jTableSc.setModel(scModel);
            }catch(SQLException ex){jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");}
        }   
    }//GEN-LAST:event_jButtonAddMouseClicked

    private void jButtonSelectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSelectMouseClicked
        int index=jTabbedPane1.getSelectedIndex();
        if(index==0)
            if(jTextFieldCondition.getText().equals(""))
                Select("select Sno,Sname,Ssex,Sage,Sdept from student",index);
            else
                Select("select Sno,Sname,Ssex,Sage,Sdept from student where "+jTextFieldCondition.getText(),index);
        else if(index==1)
            Select("select Cno,Cname,Cpno,Ccredit from course",index);
        else if(index==2)
            Select("select Sno,Cno,Grade from sc",index);
    }//GEN-LAST:event_jButtonSelectMouseClicked

    private void Select(String sql,int index){
        if(index==0){//Student
            try{
                DefaultTableModel studentModel=(DefaultTableModel)jTableStudent.getModel();
                jTextAreaShow.append(sql+"\n\n");
                ResultSet rs = stmt.executeQuery(sql);
                Object[] temp=new Object[7];
                int row=studentModel.getRowCount();
                for(int i=0;i<row;i++)
                    studentModel.removeRow(0);
                int i=0;
                while(rs.next()){
                    temp[0]=rs.getInt("Sno");
                    temp[1]=rs.getString("Sname");
                    temp[2]=rs.getString("Ssex");
                    temp[3]=rs.getString("Sage");
                    temp[4]=rs.getString("Sdept");
                    try{
                        temp[5]=rs.getString(6);
                    }catch(SQLException ex){}
                    try{
                        temp[6]=rs.getDouble(7);
                    }catch(SQLException ex){}
                    StudentIsturn[i]=new boolean[]{false,false,false,false,false,false};
                    Sno[i]=((Integer)temp[0]).intValue();
                    i++;
                    studentModel.addRow(temp);
                }
                
                studentModel.addRow(new Object[]{});//补一行
                jTableStudent.setModel(studentModel);
             }catch(SQLException ex){
                jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");
             }
        }else if(index==1){//Course
            try{
                DefaultTableModel courseModel=(DefaultTableModel)jTableCourse.getModel();
                jTextAreaShow.append(sql+"\n\n");
                ResultSet rs = stmt.executeQuery(sql);
                Object[] temp=new Object[5];
                int row=courseModel.getRowCount();
                for(int i=0;i<row;i++)
                    courseModel.removeRow(0);
                int i=0;
                while(rs.next()){//如果对象中有数据，就会循环打印出来
                    temp[0]=rs.getInt("Cno");
                    temp[1]=rs.getString("Cname");
                    temp[2]=rs.getString("Cpno");//有些为空，getInt显示0，用getString代替
                    temp[3]=rs.getString("Ccredit");
                    try{
                        temp[4]=rs.getDouble(5);
                    }catch(SQLException ex){}
                    CourseIsturn[i]=new boolean[]{false,false,false,false,false};   
                    Cno[i]=((Integer)temp[0]).intValue();
                    i++;
                    courseModel.addRow(temp);
                }
                courseModel.addRow(new Object[]{});
                jTableCourse.setModel(courseModel);
            }catch(SQLException ex){
                jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");
            }
        }else if(index==2){//Cs
            try{
                DefaultTableModel scModel=(DefaultTableModel)jTableSc.getModel();
                jTextAreaShow.append(sql+"\n\n");
                ResultSet rs = stmt.executeQuery(sql);
                Object[] temp=new Object[3];
                int row=scModel.getRowCount();
                for(int i=0;i<row;i++)
                    scModel.removeRow(0);
                int i=0;
                while(rs.next()){//如果对象中有数据，就会循环打印出来
                    temp[0]=rs.getInt("Sno");
                    temp[1]=rs.getInt("Cno");
                    temp[2]=rs.getString("Grade");
                    ScIsturn[i]=new boolean[]{false,false,false,false};
                    Sno_Cno[i][0]=((Integer)temp[0]).intValue();
                    Sno_Cno[i][1]=((Integer)temp[1]).intValue();
                    i++;
                    scModel.addRow(temp);
                }
                scModel.addRow(new Object[]{});
                jTableSc.setModel(scModel);
            }catch(SQLException ex){
                jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");
            }
        }
    }
    
    private void jButtonUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonUpdateMouseClicked
        int index=jTabbedPane1.getSelectedIndex();
        Stack<Point> temp=new Stack<Point>();
        if(index==0){
            for(int i=0;i<StudentIsturn.length;i++){
                if(StudentIsturn[i][0]==true){//这行变了
                    String sql="update student set ";
                    temp.push(new Point(i,0));
                    for(int j=1;j<StudentIsturn[i].length;j++){
                        if(StudentIsturn[i][j]==true){//是这个
                            sql+=StudentHead[j-1]+"='"+jTableStudent.getValueAt(i, j-1)+"',";
                            temp.push(new Point(i,j));
                        }
                    }
                    sql=sql.substring(0, sql.length()-1);
                    sql+="where Sno='"+Sno[i]+"'";
                    try{
                        jTextAreaShow.append(sql+"\n\n");
                        int retVal=stmt.executeUpdate(sql);
                        jTextAreaShow.append("修改成功\n\n");
                        for(Point p:temp){
                            StudentIsturn[(int)p.getX()][(int)p.getY()]=false;
                            StudentIsturn[(int)p.getX()][0]=false;
                        }
                        temp.clear();
                    }catch(SQLException ex){
                        jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");
                    }
                }
            }
        }else if(index==1){
            for(int i=0;i<CourseIsturn.length;i++){
                if(CourseIsturn[i][0]==true){//这行变了
                    String sql="update course set ";
                    temp.push(new Point(i,0));
                    for(int j=1;j<CourseIsturn[i].length;j++){
                        if(CourseIsturn[i][j]==true){//是这个
                            sql+=CourseHead[j-1]+"='"+jTableCourse.getValueAt(i, j-1)+"',";
                            temp.push(new Point(i,j));
                        }
                    }
                    sql=sql.substring(0, sql.length()-1);
                    sql+="where Cno='"+Cno[i]+"'";
                    try{
                        jTextAreaShow.append(sql+"\n\n");
                        int retVal=stmt.executeUpdate(sql);
                        jTextAreaShow.append("修改成功\n\n");
                        for(Point p:temp){
                            CourseIsturn[(int)p.getX()][(int)p.getY()]=false;
                            CourseIsturn[(int)p.getX()][0]=false;
                        }
                        temp.clear();
                    }catch(SQLException ex){
                        jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");
                    }
                }
            }
        }else if(index==2){
            for(int i=0;i<ScIsturn.length;i++){
                if(ScIsturn[i][0]==true){//这行变了
                    String sql="update sc set ";
                    temp.push(new Point(i,0));
                    for(int j=1;j<ScIsturn[i].length;j++){
                        if(ScIsturn[i][j]==true){//是这个
                            sql+=ScHead[j-1]+"='"+jTableSc.getValueAt(i, j-1)+"',";
                            temp.push(new Point(i,j));
                        }
                    }
                    sql=sql.substring(0, sql.length()-1);
                    sql+="where Sno='"+Sno+"' and Cno='"+Cno[i]+"'";
                    try{
                        jTextAreaShow.append(sql+"\n\n");
                        int retVal=stmt.executeUpdate(sql);
                        jTextAreaShow.append("修改成功\n\n");
                        for(Point p:temp){
                            ScIsturn[(int)p.getX()][(int)p.getY()]=false;
                            ScIsturn[(int)p.getX()][0]=false;
                        }
                        temp.clear();
                    }catch(SQLException ex){
                        jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");
                    }
                }
            }
        }
    }//GEN-LAST:event_jButtonUpdateMouseClicked

    private void jButtonDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonDeleteMouseClicked
        int index=jTabbedPane1.getSelectedIndex();
        if(index==0){
            int[] rows=jTableStudent.getSelectedRows();
            if(rows==null)
                return ;
            DefaultTableModel studentModel=(DefaultTableModel)jTableStudent.getModel();
         try{
             for(int i:rows){
                String sql="delete from student where Sno="+"'"+(Integer)jTableStudent.getValueAt(i, 0)+"'";
                jTextAreaShow.append(sql+"\n\n");
                stmt.executeUpdate(sql);
                studentModel.removeRow(i);
                jTableStudent.setModel(studentModel);
             }
         }catch(SQLException ex){jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");}
        }else if(index==1){
            int[] rows=jTableCourse.getSelectedRows();
            if(rows==null)
                return ;
            DefaultTableModel courseModel=(DefaultTableModel)jTableCourse.getModel();
         try{
             for(int i:rows){
                String sql="delete from course where Cno="+"'"+(Integer)jTableCourse.getValueAt(i, 0)+"'";
                jTextAreaShow.append(sql+"\n\n");
                stmt.executeUpdate(sql);
                courseModel.removeRow(i);
                jTableCourse.setModel(courseModel);
             }
         }catch(SQLException ex){jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");}
        }else if(index==2){
            int[] rows=jTableSc.getSelectedRows();
            if(rows==null)
                return ;
            DefaultTableModel scModel=(DefaultTableModel)jTableSc.getModel();
         try{
             for(int i:rows){
                String sql="delete from sc where Sno="+"'"+(Integer)jTableSc.getValueAt(i, 0)+"'And Cno='"+(Integer)jTableSc.getValueAt(i, 1)+"'";
                jTextAreaShow.append(sql+"\n\n");
                stmt.executeUpdate(sql);
                scModel.removeRow(i);
                jTableSc.setModel(scModel);
             }
         }catch(SQLException ex){jTextAreaShow.append("ERROR:\n"+ex.getMessage()+"\n\n");}
        }
    }//GEN-LAST:event_jButtonDeleteMouseClicked

    private void jTableStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableStudentMouseClicked
        int row=jTableStudent.getSelectedRow();
        int col=jTableStudent.getSelectedColumn();
        if(jTableStudent.getValueAt(row,col)==null)
            return ;
        oldvalue=jTableStudent.getValueAt(row,col).toString();
    }//GEN-LAST:event_jTableStudentMouseClicked

    private void jTableCourseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableCourseKeyReleased
        if(evt.getKeyChar()=='\t'){
            int col=jTableCourse.getSelectedColumn();
            int row=jTableCourse.getSelectedRow();
            jTableCourse.editCellAt(row,col);
            if(row!=jTableCourse.getRowCount()-1&&jTableCourse.getValueAt(row,col)!=null)
                oldvalue=jTableCourse.getValueAt(row,col).toString();
        }
    }//GEN-LAST:event_jTableCourseKeyReleased

    private void jTableCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCourseMouseClicked
        int row=jTableCourse.getSelectedRow();
        int col=jTableCourse.getSelectedColumn();
        if(jTableCourse.getValueAt(row,col)==null)
            return ;
        oldvalue=jTableCourse.getValueAt(row,col).toString();
    }//GEN-LAST:event_jTableCourseMouseClicked

    private void jTableScMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableScMouseClicked
        int row=jTableSc.getSelectedRow();
        int col=jTableSc.getSelectedColumn();
        if(jTableSc.getValueAt(row,col)==null)
            return ;
        oldvalue=jTableSc.getValueAt(row,col).toString();
    }//GEN-LAST:event_jTableScMouseClicked

    private void jTableScKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableScKeyReleased
        if(evt.getKeyChar()=='\t'){
            int col=jTableSc.getSelectedColumn();
            int row=jTableSc.getSelectedRow();
            jTableSc.editCellAt(row,col);
            if(row!=jTableSc.getRowCount()-1&&jTableSc.getValueAt(row,col)!=null)
                oldvalue=jTableSc.getValueAt(row,col).toString();
        }
    }//GEN-LAST:event_jTableScKeyReleased

    private void jButtonGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGradeMouseClicked
        int index=jTabbedPane1.getSelectedIndex();
        if(index==0){
            if(jTextFieldCondition.getText().equals(""))
                Select("select student.Sno,Sname,Ssex,Sage,Sdept,Cname,Grade from student,course,sc where student.Sno=sc.Sno and course.Cno=sc.Cno order by student.Sno",index);
            else
                Select("select student.Sno,Sname,Ssex,Sage,Sdept,Cname,Grade from student,course,sc where student.Sno=sc.Sno and course.Cno=sc.Cno and "+jTextFieldCondition.getText()+" order by student.Sno",index);
        }
    }//GEN-LAST:event_jButtonGradeMouseClicked

    private void jButtonAvgGradeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonAvgGradeMouseClicked
        int index=jTabbedPane1.getSelectedIndex();
        if(index==0){
            //个人平均分
            if(jTextFieldCondition.getText().equals(""))
                Select("select student.Sno,Sname,Ssex,Sage,Sdept,avg(Grade) as Grade from student,course,sc where student.Sno=sc.Sno group by student.Sno order by student.Sno",index);
            else
                Select("select student.Sno,Sname,Ssex,Sage,Sdept,avg(Grade) as Grade from student,course,sc where student.Sno=sc.Sno and "+jTextFieldCondition.getText()+" group by student.Sno order by student.Sno",index);
        }else if(index==1){
            //科目平均分
            if(jTextFieldCondition.getText().equals(""))
                Select("select course.Cno,Cname,Cpno,Ccredit,avg(Grade) as Grade from course,sc where course.Cno=sc.Cno group by course.Cno",index);
            else
                Select("select course.Cno,Cname,Cpno,Ccredit,avg(Grade) as Grade from course,sc where course.Cno=sc.Cno and "+jTextFieldCondition.getText()+" group by course.Cno",index);
        }
    }//GEN-LAST:event_jButtonAvgGradeMouseClicked

    private void jTableStudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableStudentKeyReleased
        //释放完毕后根据changeSelection会跳到后一个单元聚焦
            if(evt.getKeyChar()=='\t'){
                int col=jTableStudent.getSelectedColumn();
                int row=jTableStudent.getSelectedRow();
                jTableStudent.editCellAt(row,col);
                if(row!=jTableStudent.getRowCount()-1&&jTableStudent.getValueAt(row,col)!=null)
                    oldvalue=jTableStudent.getValueAt(row,col).toString();
            }
    }//GEN-LAST:event_jTableStudentKeyReleased

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                new View().setVisible(true);
                }catch(Exception ex){System.out.println(ex);}
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonAvgGrade;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonGrade;
    private javax.swing.JButton jButtonSelect;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableCourse;
    private javax.swing.JTable jTableSc;
    private javax.swing.JTable jTableStudent;
    private javax.swing.JTextArea jTextAreaShow;
    private javax.swing.JTextField jTextFieldCondition;
    // End of variables declaration//GEN-END:variables
}
