package model.dialog.com.dialogmodel;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import model.dialog.com.dialogmodel.dialogUtils.SZZCAlertDiaLog;
import model.dialog.com.dialogmodel.dialogUtils.SZZCAlertDiaLogDto;
import model.dialog.com.dialogmodel.dialogUtils.SZZCAlertListener;

public class DialogActivity extends AppCompatActivity {
    SZZCAlertDiaLogDto dto = null;
    private AlertDialog doubtDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        //系统的dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Dialog");
        builder.setMessage("少数派客户端");
        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("Cancel", null);
        builder.show();

        //自定义的dialog
        dto = SZZCAlertDiaLogDto.createOneTitleOneDescTwoStyle1Button(getString(R.string.pls_check), getString(R.string.contact_you),
                getString(R.string.make_sure), getString(R.string.cancel));

        doubtDialog = new SZZCAlertDiaLog().alertDialog(this, dto, new SZZCAlertListener() {

            @Override
            public void onLeftButtonClick(int buttonId) {
                doubtDialog.dismiss();
            }

            @Override
            public void onRightButtonClick(int buttonId) {
                doubtDialog.dismiss();
            }
        });
    }
}
