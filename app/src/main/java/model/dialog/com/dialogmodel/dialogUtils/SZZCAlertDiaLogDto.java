package model.dialog.com.dialogmodel.dialogUtils;

public class SZZCAlertDiaLogDto
{
	public static final int ONETITLE_ONEBUTTON = 0; // 一行标题 单按钮
	public static final int ONETITLE_TWOBUTTON = 1; // 一行标题 两个按钮
	public static final int ONETITLE_ONEDESC_TWOBUTTON_STYLE1 = 2; // 一行标题 一行描述 两个按钮
	public static final int ONETITLE_ONEDESC_TWOBUTTON_STYLE2 = 3; // 一行标题 一行描述  两个按钮  （第二个描述 字体颜色为灰色，高度比的一种高）
	public static final int ONETITLE_TWODESC_TWOBUTTON = 4; // 一行标题 两行描述 两个按钮
	public static final int ONETITLE_ONELOCATIONIMG_TWODESC_TWOBUTTON = 5; // 一行标题  +  本地图片 两行描述 两个BUTTON
	public static final int ONETITLE_THIRDDESC_TWOBUTTON = 6; // 一行标题 三行描述 两个按钮
	public static final int ONETITLE_ONEDESC_TWOBUTTON_STYLE3 = 7;//一行标题 一行描述  两个按钮  （第三个描述 title与desc有分隔，背景图不同）
	// dialog 样式 选择
	public int dialogType = 0;

	// Dialog 标题
	public String diaTitle;
	// Dialog 描述
	public String diaDesc;

	public String diaDesc2;

	// 第一个Button 按钮文字
	public String firstButtonText;
	// 第二个Button 按钮文字
	public String secondButtonText;

	// Dialog 是否可以取消
	public boolean cancelable = true;

	// 图片本地
	public int localimage;
	// 图片远程
	public String remoteimage;

	public boolean buildDecsNumber = false;

	public int marks = 0;

	/***
	 * 返回一个单按钮+标题 DTO
	 * 
	 * @param dialogType
	 * @param title
	 * @param buttonText
	 * @return
	 */
	public static SZZCAlertDiaLogDto createOneTitleOneButton(String title, String buttonText)
	{
		SZZCAlertDiaLogDto dto = new SZZCAlertDiaLogDto();
		dto.dialogType = ONETITLE_ONEBUTTON;
		dto.diaTitle = title;
		dto.firstButtonText = buttonText;

		return dto;
	}

	/****
	 * 返回两个按钮 + 标题 DTO
	 * 
	 * @param title
	 * @param firstButtonText
	 * @param secondButtonText
	 * @return
	 */
	public static SZZCAlertDiaLogDto createOneTitleTwoButton(String title, String firstButtonText, String secondButtonText)
	{
		SZZCAlertDiaLogDto dto = new SZZCAlertDiaLogDto();
		dto.dialogType = ONETITLE_TWOBUTTON;
		dto.diaTitle = title;
		dto.firstButtonText = firstButtonText;
		dto.secondButtonText = secondButtonText;

		return dto;
	}

	/***
	 * 返回两个按钮 + 标题 +描述 风格1
	 * 
	 * @param title
	 * @param desc
	 * @param firstButtonText
	 * @param secondButtonText
	 * @return
	 */
	public static SZZCAlertDiaLogDto createOneTitleOneDescTwoStyle1Button(String title, String desc, String firstButtonText, String secondButtonText)
	{
		SZZCAlertDiaLogDto dto = new SZZCAlertDiaLogDto();
		dto.dialogType = ONETITLE_ONEDESC_TWOBUTTON_STYLE1;
		dto.diaTitle = title;
		dto.firstButtonText = firstButtonText;
		dto.secondButtonText = secondButtonText;
		dto.diaDesc = desc;

		return dto;
	}

	/***
	 * 返回两个按钮 + 标题 +描述 风格2
	 * 
	 * @param title
	 * @param desc
	 * @param firstButtonText
	 * @param secondButtonText
	 * @return
	 */
	public static SZZCAlertDiaLogDto createOneTitleOneDescTwoStyle2Button(String title, String desc, String firstButtonText, String secondButtonText)
	{
		SZZCAlertDiaLogDto dto = new SZZCAlertDiaLogDto();
		dto.dialogType = ONETITLE_ONEDESC_TWOBUTTON_STYLE2;
		dto.diaTitle = title;
		dto.firstButtonText = firstButtonText;
		dto.secondButtonText = secondButtonText;
		dto.diaDesc = desc;
		return dto;
	}

	/***
	 * 返回两个按钮 + 标题 +描述 风格3
	 *
	 * @param title
	 * @param desc
	 * @param firstButtonText
	 * @param secondButtonText
	 * @return
	 */
	public static SZZCAlertDiaLogDto createOneTitleOneDescTwoStyle3Button(String title, String desc, String firstButtonText, String secondButtonText)
	{
		SZZCAlertDiaLogDto dto = new SZZCAlertDiaLogDto();
		dto.dialogType = ONETITLE_ONEDESC_TWOBUTTON_STYLE3;
		dto.diaTitle = title;
		dto.firstButtonText = firstButtonText;
		dto.secondButtonText = secondButtonText;
		dto.diaDesc = desc;
		return dto;
	}

	/***
	 * 返回一个标题+两个描述+两个button
	 * 
	 * @param title
	 * @param desc
	 * @param firstButtonText
	 * @param secondButtonText
	 * @return
	 */
	public static SZZCAlertDiaLogDto createOneTitleTwoDescTwoButton(String title, String firstDesc, String secondDesc, String firstButtonText, String secondButtonText)
	{
		SZZCAlertDiaLogDto dto = new SZZCAlertDiaLogDto();
		dto.dialogType = ONETITLE_TWODESC_TWOBUTTON;
		dto.diaTitle = title;
		dto.firstButtonText = firstButtonText;
		dto.secondButtonText = secondButtonText;
		dto.diaDesc = firstDesc;
		dto.diaDesc2 = secondDesc;
		return dto;
	}

	/***
	 * 返回一个标题+三个描述+两个button
	 * 
	 * @param title
	 * @param desc
	 * @param firstButtonText
	 * @param secondButtonText
	 * @return
	 */
	public static SZZCAlertDiaLogDto createOneTitleThirdDescTwoButton(String title, String firstDesc, String secondDesc, String thirdDesc, String firstButtonText, String secondButtonText)
	{
		SZZCAlertDiaLogDto dto = new SZZCAlertDiaLogDto();
		dto.dialogType = ONETITLE_THIRDDESC_TWOBUTTON;
		dto.diaTitle = title;
		dto.firstButtonText = firstButtonText;
		dto.secondButtonText = secondButtonText;
		dto.diaDesc = "<p align='center' style='line-height:2px;color:#B9B9B9;font-size:13px'>" + firstDesc + "</p><p  align='center' style='line-height:2px;color:#B9B9B9;font-size:13px'>"
				+ secondDesc + "</p><p align='center' style='line-height:20px;color:#666666;font-size:15px'>" + thirdDesc + "</p>";
		return dto;
	}

	/****
	 * 返回一个标题+ 两个描述+两个Button+ 一个本地图片
	 * 
	 * @param title
	 * @param firstDesc
	 * @param secondDesc
	 * @param firstButtonText
	 * @param secondButtonText
	 * @return
	 */
	public static SZZCAlertDiaLogDto createOneTitleOneLocationImgTwoDescTwoButton(String firstDesc, String secondDesc, String firstButtonText, String secondButtonText, int drawableImageId)
	{
		SZZCAlertDiaLogDto dto = new SZZCAlertDiaLogDto();
		dto.dialogType = ONETITLE_ONELOCATIONIMG_TWODESC_TWOBUTTON;
		dto.firstButtonText = firstButtonText;
		dto.secondButtonText = secondButtonText;
		dto.diaDesc = "<p align='center' style='line-height:2px;color:#000000;font-size:17px'>" + firstDesc + "</p><p  align='center' style='line-height:20px;color:#B9B9B9;font-size:13px'>"
				+ secondDesc + "</p>";
		dto.localimage = drawableImageId;
		return dto;
	}

}
