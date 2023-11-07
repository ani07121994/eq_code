/*     */ package ap.quantas.com;
/*     */ 
/*     */ import ap.quantas.com.PropertyLoader;
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import javax.naming.Context;
/*     */ import javax.naming.InitialContext;
/*     */ import javax.naming.NamingException;
/*     */ import javax.servlet.ServletContextEvent;
/*     */ import javax.servlet.ServletContextListener;
/*     */ import javax.sql.DataSource;
/*     */ 
/*     */ public class ContextInitializer implements ServletContextListener {
/*     */   public static final String deployment_env = "PROD";
/*     */   
/*     */   public DataSource getDataSource() throws NamingException {
/*  37 */     String jndi_name = "";
/*  39 */     if (deployment_env.equals("DEV"))
/*  40 */       jndi_name = "jdbc/DEV_EQFILES_NXA"; 
/*  42 */     if (deployment_env.equals("SIT")) {
/*  43 */       jndi_name = "jdbc/CRP2_EQFILES_NXA";
/*  44 */     } else if (deployment_env.equals("PSP")) {
/*  45 */       jndi_name = "jdbc/PROD_EQFILES_NXA";
/*  46 */     } else if (deployment_env.equals("PROD")) {
/*  47 */       jndi_name = "jdbc/PROD_EQFILES_NXA";
/*     */     } 
/*  51 */     Context initContext = new InitialContext();
/*  52 */     DataSource ds = (DataSource)initContext.lookup(jndi_name);
/*  54 */     return ds;
/*     */   }
/*     */   
/*     */   public void contextInitialized(ServletContextEvent servletContextEvent) {
/*  59 */     System.out.println("Context Initialized during deployment");
/*  61 */     System.out.println("--- loading properties ---");
/*  62 */     ResultSet rs = null;
/*  63 */     ResultSet rs2 = null;
/*  64 */     Connection conn = null;
/*     */     try {
/*  66 */       conn = getDataSource().getConnection();
/*  67 */       rs = conn.createStatement().executeQuery("select * from js_ap_properties_table");
/*  68 */       int n = 1;
/*  69 */       while (rs.next()) {
/*  70 */         System.out.println("Record-" + n++);
/*  71 */         PropertyLoader.getInstance().addProperty(rs.getString(1), rs.getString(2));
/*     */       } 
/*  75 */       rs2 = conn.createStatement().executeQuery("select * from js_ap_email_table");
/*  76 */       while (rs2.next())
/*  78 */         PropertyLoader.getInstance().addProperty(rs2.getString(1), rs2.getString(2)); 
/*  81 */       rs.close();
/*  82 */       rs2.close();
/*  83 */       getDataSource().getConnection().close();
/*  86 */     } catch (Exception e) {
/*  88 */       e.printStackTrace();
/*     */     } finally {
/*     */       try {
/*  93 */         if (rs != null)
/*  94 */           rs.close(); 
/*  96 */         if (rs2 != null)
/*  97 */           rs2.close(); 
/*  99 */         if (conn != null)
/* 100 */           System.out.println("Closing connection after contextInitialization"); 
/* 101 */         conn.close();
/* 103 */       } catch (SQLException e) {
/* 104 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/* 117 */     System.out.println(PropertyLoader.getInstance().getProperty("IMAGE_URL"));
/* 119 */     System.out.println("--- property loaded successfully ---");
/*     */   }
/*     */   
/*     */   public void contextDestroyed(ServletContextEvent servletContextEvent) {}
/*     */ }


/* Location:              C:\Users\2033471\techstack_ugrade_jetstar\JS_Ap_AutoReject_mailSender.ear!\JS_EmailSender-JS_EmailSenderProj-context-root.war!\WEB-INF\classes\ap\quantas\com\ContextInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */