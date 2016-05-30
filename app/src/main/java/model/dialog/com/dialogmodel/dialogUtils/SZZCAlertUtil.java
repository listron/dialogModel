package model.dialog.com.dialogmodel.dialogUtils;

public class SZZCAlertUtil 
{
	public static  final String readColor = "#FF0000";
	public static  final String yellowColor = "#fbae1a";//黄
	public static  final String greenColor = "#2ebe8d";//绿色
	public static  final String redColor = "#ff4444";//红色
	public static  final String blueColor = "#4bb7f8";//蓝色
	public static  final String grayColor = "#666666";//灰色
	
	/****
	 * 返还颜色工具
	 * @param corlor
	 * @param str
	 * @return
	 */
	public static String getSZZCAlertColorStr(String corlor,String str)
	{
	    if(corlor == null  || corlor.equals(""))
	    {
	    	corlor = SZZCAlertUtil.readColor;
	    }
	    
	    if(str == null )
	    {
	    	str ="";
 	    }
	    
       return "<font color='"+corlor+"'>"+str+"</font>";
 
 	}
}
