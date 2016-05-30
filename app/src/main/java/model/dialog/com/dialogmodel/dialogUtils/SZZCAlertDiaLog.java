package model.dialog.com.dialogmodel.dialogUtils;

//import android.app.AlertDialog;
import android.support.v7.app.AlertDialog;//此处应该用v7中的 dialog
import android.content.Context;
import android.content.DialogInterface;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import model.dialog.com.dialogmodel.R;

public class SZZCAlertDiaLog
{

	private AlertDialog myDialog;

	public AlertDialog alertDialog(Context context, SZZCAlertDiaLogDto dialog, final SZZCAlertListener listener)
	{
		myDialog = new AlertDialog.Builder(context).create();
		myDialog.show();
		myDialog.getWindow().setContentView(R.layout.common_szzc_alert_dialog);
		myDialog.setCancelable(dialog != null ? dialog.cancelable : true);
		myDialog.setCanceledOnTouchOutside(false);
		if(listener != null){
			setOnCancelListener(listener);
		}
		if (dialog == null) {
			return myDialog;
		}
		switch (dialog.dialogType)
		{
			case SZZCAlertDiaLogDto.ONETITLE_ONEBUTTON:
			{
				setOneTitle_OneButton(dialog, listener);
			}
				break;
			case SZZCAlertDiaLogDto.ONETITLE_TWOBUTTON:
			{
				setOneTitle_TwoButton(dialog, listener);
			}
				break;
			case SZZCAlertDiaLogDto.ONETITLE_ONEDESC_TWOBUTTON_STYLE1:
			{
				setOneTitle_OneDesc_TwoButton_Style1(dialog, listener);
			}
				break;
			case SZZCAlertDiaLogDto.ONETITLE_ONEDESC_TWOBUTTON_STYLE2:
			{
				setOneTitle_OneDesc_TwoButton_Style2(dialog, listener);
			}
				break;
			case SZZCAlertDiaLogDto.ONETITLE_TWODESC_TWOBUTTON:
			{
				setOneTitleTwoDescTwoButton(dialog, listener);
			}
				break;
			case SZZCAlertDiaLogDto.ONETITLE_THIRDDESC_TWOBUTTON:
			{
				setOneTitleThirdDescTwoButton(dialog, listener);
			}
				break;
			case SZZCAlertDiaLogDto.ONETITLE_ONELOCATIONIMG_TWODESC_TWOBUTTON:
			{
				setOneTitleOneLocationImgTwoDescTwoButton(dialog, listener);
			}
				break;
			case SZZCAlertDiaLogDto.ONETITLE_ONEDESC_TWOBUTTON_STYLE3:
			{
				setOneTitle_OneDesc_TwoButton_Style3(dialog, listener);
			}
				break;

		}

		return myDialog;

	}

	/***
	 * ONETITLE_ONEBUTTON 样式BUTTON
	 * 
	 * @param dialog
	 * @param listener
	 */
	private void setOneTitle_OneButton(SZZCAlertDiaLogDto dialog, final SZZCAlertListener listener)
	{
		myDialog.findViewById(R.id.onetitle_onebutton).setVisibility(View.VISIBLE);

		TextView popwinContent = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_onebutton_title);
		//只给此样式增加了富文本，其他的如果需要增加，可以copy过去
		if(dialog.marks != 0){
			popwinContent.setAutoLinkMask(dialog.marks);
		}
		popwinContent.setText(dialog.diaTitle);
		Button button = (Button) myDialog.getWindow().findViewById(R.id.onetitle_onebutton_button);
		button.setText(dialog.firstButtonText);
		button.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{
				//如果调用不需要回调，则传null就可以，没必要必须构造一个类
				if(listener != null){
					listener.onButtonClick(R.id.onetitle_onebutton_button);
					listener.onLeftButtonClick(R.id.onetitle_onebutton_button);
				}
				myDialog.dismiss();

			}
		});
	}

	/***
	 * ONETITLE_TWOBUTTON 样式BUTTON
	 * 
	 * @param dialog
	 * @param listener
	 */
	private void setOneTitle_TwoButton(SZZCAlertDiaLogDto dialog, final SZZCAlertListener listener)
	{
		myDialog.findViewById(R.id.onetitle_twobutton).setVisibility(View.VISIBLE);

		TextView popwinContent = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_twobutton_title);
		popwinContent.setText(dialog.diaTitle);

		Button leftButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_twobutton_leftbutton);
		leftButton.setText(dialog.firstButtonText);
		leftButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				if (listener != null) {
					listener.onButtonClick(R.id.onetitle_twobutton_leftbutton);
					listener.onLeftButtonClick(R.id.onetitle_twobutton_leftbutton);
				}
				myDialog.dismiss();

			}
		});

		Button rightButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_twobutton_rightbutton);
		rightButton.setText(dialog.secondButtonText);
		rightButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{
				if(listener != null){
					listener.onButtonClick(R.id.onetitle_twobutton_rightbutton);
					listener.onRightButtonClick(R.id.onetitle_twobutton_rightbutton);
				}

				myDialog.dismiss();
			}
		});

	}

	// ONETITLE_ONEDESC_TWOBUTTON_STYLE1

	private void setOneTitle_OneDesc_TwoButton_Style1(SZZCAlertDiaLogDto dialog, final SZZCAlertListener listener)
	{
		myDialog.findViewById(R.id.onetitle_onedesc_twobutton_style1).setVisibility(View.VISIBLE);

		TextView popwinContent = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style1_title);
		popwinContent.setText(dialog.diaTitle);

		TextView popwinDesc = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style1_desc);
		if(dialog.buildDecsNumber){
			popwinDesc.setText(Html.fromHtml(dialog.diaDesc));
		} else {
			popwinDesc.setText(dialog.diaDesc);
		}

		Button leftButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style1_leftbutton);
		leftButton.setText(dialog.firstButtonText);
		leftButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{
				if(listener != null){
					listener.onButtonClick(R.id.onetitle_onedesc_twobutton_style1_leftbutton);
					listener.onLeftButtonClick(R.id.onetitle_onedesc_twobutton_style1_leftbutton);
				}
				myDialog.dismiss();

			}
		});

		Button rightButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style1_rightbutton);
		rightButton.setText(dialog.secondButtonText);
		rightButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{
				if(listener != null){
					listener.onButtonClick(R.id.onetitle_onedesc_twobutton_style1_rightbutton);
					listener.onRightButtonClick(R.id.onetitle_onedesc_twobutton_style1_rightbutton);
				}
				myDialog.dismiss();
			}
		});

	}

	// ONETITLE_ONEDESC_TWOBUTTON_STYLE2
	private void setOneTitle_OneDesc_TwoButton_Style2(SZZCAlertDiaLogDto dialog, final SZZCAlertListener listener)
	{
		myDialog.findViewById(R.id.onetitle_onedesc_twobutton_style2).setVisibility(View.VISIBLE);

		TextView popwinContent = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style2_title);
		popwinContent.setText(dialog.diaTitle);

		TextView popwinDesc = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style2_desc);
		if(dialog.buildDecsNumber){
			popwinDesc.setText(Html.fromHtml(dialog.diaDesc));
		} else {
			popwinDesc.setText(dialog.diaDesc);
		}

		Button leftButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style2_leftbutton);
		leftButton.setText(dialog.firstButtonText);
		leftButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{

				if(listener != null){
					listener.onButtonClick(R.id.onetitle_onedesc_twobutton_style2_leftbutton);
					listener.onLeftButtonClick(R.id.onetitle_onedesc_twobutton_style2_leftbutton);
				}
				myDialog.dismiss();

			}
		});

		Button rightButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style2_rightbutton);
		rightButton.setText(dialog.secondButtonText);
		rightButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{
				if(listener != null){
					listener.onButtonClick(R.id.onetitle_onedesc_twobutton_style2_rightbutton);
					listener.onRightButtonClick(R.id.onetitle_onedesc_twobutton_style1_rightbutton);
				}

				myDialog.dismiss();
			}
		});

	}

	// ONETITLE_ONEDESC_TWOBUTTON_STYLE3
	private void setOneTitle_OneDesc_TwoButton_Style3(SZZCAlertDiaLogDto dialog, final SZZCAlertListener listener)
	{
		myDialog.findViewById(R.id.onetitle_onedesc_twobutton_style3).setVisibility(View.VISIBLE);

		TextView popwinContent = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style3_title);
		popwinContent.setText(dialog.diaTitle);

		TextView popwinDesc = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style3_desc);
		if(dialog.buildDecsNumber){
			popwinDesc.setText(Html.fromHtml(dialog.diaDesc));
		} else {
			popwinDesc.setText(dialog.diaDesc);
		}

		Button leftButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style3_leftbutton);
		leftButton.setText(dialog.firstButtonText);
		leftButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{

				if(listener != null){
					listener.onButtonClick(R.id.onetitle_onedesc_twobutton_style3_leftbutton);
					listener.onLeftButtonClick(R.id.onetitle_onedesc_twobutton_style3_leftbutton);
				}
				myDialog.dismiss();

			}
		});

		Button rightButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_onedesc_twobutton_style3_rightbutton);
		rightButton.setText(dialog.secondButtonText);
		rightButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view) {
				if (listener != null) {
					listener.onButtonClick(R.id.onetitle_onedesc_twobutton_style3_rightbutton);
					listener.onRightButtonClick(R.id.onetitle_onedesc_twobutton_style3_rightbutton);
				}
				myDialog.dismiss();
			}
		});

	}

	// ONETITLE_ONEIMG_TWODESC_TWOBUTTON
	private void setOneTitleTwoDescTwoButton(SZZCAlertDiaLogDto dialog, final SZZCAlertListener listener)
	{
		myDialog.findViewById(R.id.onetitle_twodesc_twobutton).setVisibility(View.VISIBLE);

		TextView popwinContent = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_twodesc_twobutton_title);
		popwinContent.setText(dialog.diaTitle);

		TextView popwinDesc = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_twodesc_twobutton_desc1);
		popwinDesc.setText(dialog.diaDesc);

		TextView popwinDesc2 = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_twodesc_twobutton_desc2);
		popwinDesc2.setText(dialog.diaDesc2);

		Button leftButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_twodesc_twobutton_leftbutton);
		leftButton.setText(dialog.firstButtonText);
		leftButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{

				if(listener != null){
					listener.onButtonClick(R.id.onetitle_twodesc_twobutton_leftbutton);
					listener.onLeftButtonClick(R.id.onetitle_twodesc_twobutton_leftbutton);
				}

				myDialog.dismiss();

			}
		});

		Button rightButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_twodesc_twobutton_rightbutton);
		rightButton.setText(dialog.secondButtonText);
		rightButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{
				if(listener != null) {
					listener.onButtonClick(R.id.onetitle_twodesc_twobutton_rightbutton);
					listener.onRightButtonClick(R.id.onetitle_twodesc_twobutton_rightbutton);
				}
				myDialog.dismiss();
			}
		});

	}

	// ONETITLE_ONEIMG_THIRDDESC_TWOBUTTON
	private void setOneTitleThirdDescTwoButton(SZZCAlertDiaLogDto dialog, final SZZCAlertListener listener)
	{
		myDialog.findViewById(R.id.onetitle_thirddesc_twobutton).setVisibility(View.VISIBLE);

		TextView popwinContent = (TextView) myDialog.getWindow().findViewById(R.id.onetitle_thirddesc_twobutton_title);
		popwinContent.setText(dialog.diaTitle);

		WebView popwinDesc = (WebView) myDialog.getWindow().findViewById(R.id.onetitle_thirddesc_twobutton_desc);

		popwinDesc.loadData(dialog.diaDesc, "text/html; charset=UTF-8", "UTF-8");

		Button leftButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_thirddesc_twobutton_leftbutton);
		leftButton.setText(dialog.firstButtonText);
		leftButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{
				if(listener != null) {
					listener.onButtonClick(R.id.onetitle_thirddesc_twobutton_leftbutton);
					listener.onLeftButtonClick(R.id.onetitle_thirddesc_twobutton_leftbutton);
				}
				myDialog.dismiss();

			}
		});

		Button rightButton = (Button) myDialog.getWindow().findViewById(R.id.onetitle_thirddesc_twobutton_rightbutton);
		rightButton.setText(dialog.secondButtonText);
		rightButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{
				if(listener != null) {
					listener.onButtonClick(R.id.onetitle_thirddesc_twobutton_rightbutton);
					listener.onRightButtonClick(R.id.onetitle_thirddesc_twobutton_rightbutton);
				}
				myDialog.dismiss();
			}
		});

	}

	/***
	 * ONETITLE_ONELOCATIONIMG_TWODESC_TWOBUTTON
	 * 
	 * @param dialog
	 * @param listener
	 */
	private void setOneTitleOneLocationImgTwoDescTwoButton(SZZCAlertDiaLogDto dialog, final SZZCAlertListener listener)
	{

		myDialog.findViewById(R.id.onelocationimg_twodesc_twobutton).setVisibility(View.VISIBLE);

		ImageView img = (ImageView) myDialog.getWindow().findViewById(R.id.onelocationimg_twodesc_twobutton_localimage);
		img.setImageResource(dialog.localimage);

		WebView popwinDesc = (WebView) myDialog.getWindow().findViewById(R.id.onelocationimg_twodesc_twobutton_desc);

		popwinDesc.loadData(dialog.diaDesc, "text/html; charset=UTF-8", "UTF-8");

		Button leftButton = (Button) myDialog.getWindow().findViewById(R.id.onelocationimg_twodesc_twobutton_leftbutton);
		leftButton.setText(dialog.firstButtonText);
		leftButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {

				if (listener != null) {
					listener.onButtonClick(R.id.onelocationimg_twodesc_twobutton_leftbutton);
					listener.onLeftButtonClick(R.id.onelocationimg_twodesc_twobutton_leftbutton);
				}
				myDialog.dismiss();

			}
		});

		Button rightButton = (Button) myDialog.getWindow().findViewById(R.id.onelocationimg_twodesc_twobutton_rightbutton);
		rightButton.setText(dialog.secondButtonText);
		rightButton.setOnClickListener(new OnClickListener()
		{

			@Override
			public void onClick(View view)
			{
				if(listener != null) {
					listener.onButtonClick(R.id.onelocationimg_twodesc_twobutton_rightbutton);
					listener.onRightButtonClick(R.id.onelocationimg_twodesc_twobutton_rightbutton);
				}
				myDialog.dismiss();
			}
		});
	}

	private void setOnCancelListener(final SZZCAlertListener listener){

		myDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
			@Override
			public void onCancel(DialogInterface dialog) {
				if(listener != null){
					listener.setOnCancleClick();
				}
			}
		});
	}

}
