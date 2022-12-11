package me.tvspark.view.activity;

import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import butterknife.BindView;
import butterknife.OnClick;
import com.google.android.material.textfield.TextInputLayout;
import com.stub.StubApp;
import java.util.ArrayList;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.event.CustomWebEvent;
import me.tvspark.data.sql.WebSourceTitaData;
import me.tvspark.eo0;
import me.tvspark.mn0;
import me.tvspark.o11;
import me.tvspark.outline;
import me.tvspark.r40;
import me.tvspark.un0;
import me.tvspark.yn0;
import org.litepal.crud.callback.SaveCallback;
import white.whale.R;

/* loaded from: classes4.dex */
public class EditWebActivity extends BaseActivity {
    public String Wwwwwwwwwwwww;
    public PopupWindow Wwwwwwwwwwwwwww;
    public WebSourceTitaData Wwwwwwwwwwwwwwww;
    @BindView(R.id.et_base_url)
    public EditText etBaseUrl;
    @BindView(R.id.et_channel_groups)
    public EditText etChannelGroups;
    @BindView(R.id.et_detail_cover)
    public EditText etDetailCover;
    @BindView(R.id.et_detail_cover_prefix)
    public EditText etDetailCoverPrefix;
    @BindView(R.id.et_detail_intro)
    public EditText etDetailIntro;
    @BindView(R.id.et_episode_link)
    public EditText etEpisodeLink;
    @BindView(R.id.et_episode_link_prefix)
    public EditText etEpisodeLinkPrefix;
    @BindView(R.id.et_episode_list)
    public EditText etEpisodeList;
    @BindView(R.id.et_episode_title)
    public EditText etEpisodeTitle;
    @BindView(R.id.et_index_1_list)
    public EditText etIndex1List;
    @BindView(R.id.et_index_2_list)
    public EditText etIndex2List;
    @BindView(R.id.et_index_3_list)
    public EditText etIndex3List;
    @BindView(R.id.et_index_4_list)
    public EditText etIndex4List;
    @BindView(R.id.et_index_actor)
    public EditText etIndexActor;
    @BindView(R.id.et_index_cover)
    public EditText etIndexCover;
    @BindView(R.id.et_index_cover_prefix)
    public EditText etIndexCoverPrefix;
    @BindView(R.id.et_index_link)
    public EditText etIndexLink;
    @BindView(R.id.et_index_link_prefix)
    public EditText etIndexLinkPrefix;
    @BindView(R.id.et_index_title)
    public EditText etIndexTitle;
    @BindView(R.id.et_name)
    public EditText etName;
    @BindView(R.id.et_result_cover_prefix)
    public EditText etResultCoverPrefix;
    @BindView(R.id.et_result_link_prefix)
    public EditText etResultLinkPrefix;
    @BindView(R.id.et_result_title)
    public EditText etResultTitle;
    @BindView(R.id.et_rule_result_cover)
    public EditText etRuleResultCover;
    @BindView(R.id.et_rule_result_link)
    public EditText etRuleResultLink;
    @BindView(R.id.et_rule_result_list)
    public EditText etRuleResultList;
    @BindView(R.id.et_search_post_data)
    public EditText etSearchPostData;
    @BindView(R.id.et_search_url)
    public EditText etSearchUrl;
    @BindView(R.id.et_serial_number)
    public EditText etSerialNumber;
    @BindView(R.id.et_user_agent)
    public EditText etUserAgent;
    @BindView(R.id.et_web_index)
    public EditText etWebIndex;
    @BindView(R.id.input_search_post_data)
    public TextInputLayout inputSearchPostData;
    @BindView(R.id.ll_content)
    public LinearLayout llContent;
    @BindView(R.id.scroll)
    public ScrollView scrollView;
    @BindView(R.id.sp_html_charset)
    public Spinner spHtmlCharset;
    @BindView(R.id.sp_req_charset)
    public Spinner spReqCharset;
    @BindView(R.id.sp_req_type)
    public Spinner spReqType;
    @BindView(R.id.switcher_req_detail_web)
    public Switch switcherReqDetailWeb;
    @BindView(R.id.tv_switch_req_detail_web)
    public TextView tvSwitchReqDetailWeb;
    public ArrayList<String> Wwwwwwwwwwwwwwwwwww = new ArrayList<String>() { // from class: me.tvspark.view.activity.EditWebActivity.1
        {
            add("get");
            add("post");
        }
    };
    public ArrayList<String> Wwwwwwwwwwwwwwwwww = new ArrayList<String>() { // from class: me.tvspark.view.activity.EditWebActivity.2
        {
            add("utf-8");
            add("gb2312");
            add("gbk");
        }
    };
    public ArrayList<String> Wwwwwwwwwwwwwwwww = new ArrayList<String>() { // from class: me.tvspark.view.activity.EditWebActivity.3
        {
            add("utf-8");
            add("gb2312");
            add("gbk");
        }
    };
    public boolean Wwwwwwwwwwwwww = false;
    public int Wwwwwwwwwwww = -1;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwww implements ViewTreeObserver.OnGlobalLayoutListener {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements Runnable {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // java.lang.Runnable
            public void run() {
                View findFocus = EditWebActivity.this.getWindow().getDecorView().findFocus();
                if (findFocus instanceof EditText) {
                    EditWebActivity editWebActivity = EditWebActivity.this;
                    if (findFocus == editWebActivity.etName || findFocus == editWebActivity.etSerialNumber) {
                        return;
                    }
                    editWebActivity.scrollView.scrollBy(0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(38));
                }
            }
        }

        public /* synthetic */ Wwwwwwwwwwwwwwwwwwwwwwwww(C27121 c27121) {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            PopupWindow popupWindow;
            Rect rect = new Rect();
            EditWebActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww = r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww);
            boolean z = EditWebActivity.this.Wwwwwwwwwwwwww;
            if (Math.abs(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww - rect.bottom) > Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww / 5) {
                EditWebActivity editWebActivity = EditWebActivity.this;
                editWebActivity.Wwwwwwwwwwwwww = true;
                editWebActivity.scrollView.postDelayed(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(), 100L);
                EditWebActivity editWebActivity2 = EditWebActivity.this;
                if (editWebActivity2.isFinishing()) {
                    return;
                }
                PopupWindow popupWindow2 = editWebActivity2.Wwwwwwwwwwwwwww;
                if (popupWindow2 != null && popupWindow2.isShowing()) {
                    return;
                }
                if (!(true ^ editWebActivity2.isFinishing()) || !(editWebActivity2.Wwwwwwwwwwwwwww != null)) {
                    return;
                }
                editWebActivity2.Wwwwwwwwwwwwwww.showAtLocation(editWebActivity2.llContent, 80, 0, 0);
                return;
            }
            EditWebActivity editWebActivity3 = EditWebActivity.this;
            editWebActivity3.Wwwwwwwwwwwwww = false;
            if (!z || (popupWindow = editWebActivity3.Wwwwwwwwwwwwwww) == null || !popupWindow.isShowing()) {
                return;
            }
            editWebActivity3.Wwwwwwwwwwwwwww.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwww implements SaveCallback {
        public Wwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // org.litepal.crud.callback.SaveCallback
        public void onFinish(boolean z) {
            if (!z) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "操作失败");
                return;
            }
            CustomWebEvent customWebEvent = new CustomWebEvent();
            customWebEvent.setToAdd(true);
            customWebEvent.setWebSourceTitaData(EditWebActivity.this.Wwwwwwwwwwwwwwww);
            o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(customWebEvent);
            EditWebActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {

        /* loaded from: classes4.dex */
        public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements SaveCallback {
            public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
            }

            @Override // org.litepal.crud.callback.SaveCallback
            public void onFinish(boolean z) {
                if (!z) {
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "操作失败");
                    return;
                }
                CustomWebEvent customWebEvent = new CustomWebEvent();
                customWebEvent.setToAdd(true);
                customWebEvent.setWebSourceTitaData(EditWebActivity.this.Wwwwwwwwwwwwwwww);
                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(customWebEvent);
                EditWebActivity.this.finish();
            }
        }

        public Wwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            try {
                if (!TextUtils.isEmpty(EditWebActivity.this.Wwwwwwwwwwwww) && Integer.valueOf(EditWebActivity.this.Wwwwwwwwwwwww).intValue() != EditWebActivity.this.Wwwwwwwwwwwwwwww.getSerialNumber()) {
                    EditWebActivity.this.Wwwwwwwwwwwwwwww.setSortTime(System.currentTimeMillis());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditWebActivity.this.Wwwwwwwwwwwwwwww, new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww());
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            yn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditWebActivity.this.Wwwwwwwwwwwwwwww.getBaseUrl());
            if (EditWebActivity.this.Wwwwwwwwwwww != -1) {
                CustomWebEvent customWebEvent = new CustomWebEvent();
                customWebEvent.setToAdd(false);
                customWebEvent.setWebSourceTitaData(EditWebActivity.this.Wwwwwwwwwwwwwwww);
                customWebEvent.setPositionInList(EditWebActivity.this.Wwwwwwwwwwww);
                o11.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww().Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(customWebEvent);
            }
            EditWebActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwww implements CompoundButton.OnCheckedChangeListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            TextView textView;
            BaseActivity baseActivity;
            int i;
            EditWebActivity editWebActivity = EditWebActivity.this;
            if (z) {
                textView = editWebActivity.tvSwitchReqDetailWeb;
                baseActivity = editWebActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
                i = R.color.green;
            } else {
                textView = editWebActivity.tvSwitchReqDetailWeb;
                baseActivity = editWebActivity.Wwwwwwwwwwwwwwwwwwwwwwww;
                i = R.color.text_gray;
            }
            textView.setTextColor(ContextCompat.getColor(baseActivity, i));
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements AdapterView.OnItemSelectedListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            EditWebActivity.this.inputSearchPostData.setVisibility(i == 1 ? 0 : 8);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            EditWebActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnShowListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditWebActivity editWebActivity) {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            if (TextUtils.isEmpty(this.Wwwwwwwwwwwwwwwwwwwwwwww.getText().toString())) {
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, "不能为空");
            } else {
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww.getText().toString(), EditWebActivity.this.Wwwwwwwwwwwwwwww.trans2WebSourceIndexData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements DialogInterface.OnClickListener {
        public final /* synthetic */ EditText Wwwwwwwwwwwwwwwwwwwwwwww;

        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditText editText) {
            this.Wwwwwwwwwwwwwwwwwwwwwwww = editText;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(EditWebActivity.this.Wwwwwwwwwwwwwwwwwwwwwwww, this.Wwwwwwwwwwwwwwwwwwwwwwww);
            EditWebActivity editWebActivity = EditWebActivity.this;
            mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editWebActivity.Wwwwwwwwwwwwwwwwwwwwwwww, "我的", editWebActivity.Wwwwwwwwwwwwwwww.trans2WebSourceIndexData());
        }
    }

    static {
        StubApp.interface11(11196);
    }

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return false;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public bl0 Wwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_edit_web;
    }

    public final void Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        View findFocus = getWindow().getDecorView().findFocus();
        if (!(findFocus instanceof EditText)) {
            return;
        }
        EditText editText = (EditText) findFocus;
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        Editable editableText = editText.getEditableText();
        if (selectionStart < 0 || selectionStart >= editableText.length()) {
            editableText.append((CharSequence) str);
        } else {
            editableText.replace(selectionStart, selectionEnd, str);
        }
    }

    public final boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(boolean z) {
        String obj = this.etName.getText().toString();
        String obj2 = this.etSerialNumber.getText().toString();
        String obj3 = this.etUserAgent.getText().toString();
        String obj4 = this.etBaseUrl.getText().toString();
        String obj5 = this.etSearchUrl.getText().toString();
        String obj6 = this.etSearchPostData.getText().toString();
        String obj7 = this.etRuleResultList.getText().toString();
        String obj8 = this.etRuleResultLink.getText().toString();
        String obj9 = this.etResultLinkPrefix.getText().toString();
        String obj10 = this.etRuleResultCover.getText().toString();
        String obj11 = this.etResultCoverPrefix.getText().toString();
        String obj12 = this.etResultTitle.getText().toString();
        String obj13 = this.etDetailCover.getText().toString();
        String obj14 = this.etDetailCoverPrefix.getText().toString();
        String obj15 = this.etDetailIntro.getText().toString();
        String obj16 = this.etChannelGroups.getText().toString();
        String obj17 = this.etEpisodeList.getText().toString();
        String obj18 = this.etEpisodeTitle.getText().toString();
        String obj19 = this.etEpisodeLink.getText().toString();
        String obj20 = this.etEpisodeLinkPrefix.getText().toString();
        String obj21 = this.etWebIndex.getText().toString();
        String obj22 = this.etIndex1List.getText().toString();
        String obj23 = this.etIndex2List.getText().toString();
        String obj24 = this.etIndex3List.getText().toString();
        String obj25 = this.etIndex4List.getText().toString();
        String obj26 = this.etIndexLink.getText().toString();
        String obj27 = this.etIndexLinkPrefix.getText().toString();
        String obj28 = this.etIndexTitle.getText().toString();
        String obj29 = this.etIndexCover.getText().toString();
        String obj30 = this.etIndexCoverPrefix.getText().toString();
        String obj31 = this.etIndexActor.getText().toString();
        if (!z) {
            return !TextUtils.isEmpty(obj) || !TextUtils.isEmpty(obj3) || !TextUtils.isEmpty(obj4) || !TextUtils.isEmpty(obj5) || !(this.spReqType.getSelectedItem().toString().toLowerCase().equals("post") ? TextUtils.isEmpty(obj6) : true) || !TextUtils.isEmpty(obj7) || !TextUtils.isEmpty(obj8) || !TextUtils.isEmpty(obj9) || !TextUtils.isEmpty(obj10) || !TextUtils.isEmpty(obj11) || !TextUtils.isEmpty(obj12) || !TextUtils.isEmpty(obj13) || !TextUtils.isEmpty(obj14) || !TextUtils.isEmpty(obj15) || !TextUtils.isEmpty(obj16) || !TextUtils.isEmpty(obj17) || !TextUtils.isEmpty(obj18) || !TextUtils.isEmpty(obj19) || !TextUtils.isEmpty(obj20);
        }
        boolean isEmpty = this.spReqType.getSelectedItem().toString().toLowerCase().equals("post") ? TextUtils.isEmpty(obj6) : false;
        if (TextUtils.isEmpty(obj) || TextUtils.isEmpty(obj2) || TextUtils.isEmpty(obj4) || TextUtils.isEmpty(obj5) || isEmpty || !un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(obj4) || ((!TextUtils.isEmpty(obj16) || !TextUtils.isEmpty(obj17) || !TextUtils.isEmpty(obj18) || !TextUtils.isEmpty(obj19)) && (TextUtils.isEmpty(obj16) || TextUtils.isEmpty(obj17) || TextUtils.isEmpty(obj18) || TextUtils.isEmpty(obj19)))) {
            this.Wwwwwwwwwwwwwwww = null;
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "请先填写完整正确规则");
            return false;
        }
        WebSourceTitaData webSourceTitaData = new WebSourceTitaData();
        this.Wwwwwwwwwwwwwwww = webSourceTitaData;
        webSourceTitaData.setCustomWebSourceSData(obj, obj2, this.spReqType.getSelectedItem().toString(), this.spReqCharset.getSelectedItem().toString(), this.spHtmlCharset.getSelectedItem().toString(), obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj21, obj22, obj23, obj24, obj25, obj26, obj27, obj28, obj29, obj30, obj31, obj12, this.switcherReqDetailWeb.isChecked(), obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(false)) {
            super.onBackPressed();
            return;
        }
        AlertDialog create = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww).setMessage("未保存，是否退出？").setPositiveButton("退出", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww()).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // androidx.appcompat.app.AppCompatActivity
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @OnClick({R.id.iv_back, R.id.action_tutorial, R.id.action_copy, R.id.action_save, R.id.action_test, R.id.tv_del})
    public void onViewClicked(View view) {
        WebSourceTitaData webSourceTitaData;
        AlertDialog.Builder message;
        DialogInterface.OnClickListener wwwwwwwwwwwwwwwwwwwwwwwwwww;
        String str;
        AlertDialog create;
        switch (view.getId()) {
            case R.id.action_copy /* 2131361850 */:
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true) || this.Wwwwwwwwwwwwwwww == null) {
                    return;
                }
                ((ClipboardManager) this.Wwwwwwwwwwwwwwwwwwwwwwww.getSystemService("clipboard")).setText(this.Wwwwwwwwwwwwwwww.toCustomJson());
                eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "网站规则已复制到剪切板");
                return;
            case R.id.action_save /* 2131361858 */:
                if (!Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true) || (webSourceTitaData = this.Wwwwwwwwwwwwwwww) == null) {
                    return;
                }
                WebSourceTitaData Wwwwwwwwwwwwwwwwwwwwwwwwww2 = yn0.Wwwwwwwwwwwwwwwwwwwwwwwwww(webSourceTitaData.getBaseUrl());
                if (Wwwwwwwwwwwwwwwwwwwwwwwwww2 == null) {
                    this.Wwwwwwwwwwwwwwww.saveAsync().listen(new Wwwwwwwwwwwwwwwwwwwwwwwwww());
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("存在相同网站URL的站源【 ");
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(Wwwwwwwwwwwwwwwwwwwwwwwwww2.getName());
                Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.append(" 】，是否覆盖之前的？");
                message = builder.setMessage(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww2.toString());
                wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwww();
                str = "覆盖保存";
                create = message.setPositiveButton(str, wwwwwwwwwwwwwwwwwwwwwwwwwww).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
                create.setCanceledOnTouchOutside(true);
                break;
            case R.id.action_test /* 2131361859 */:
                if (this.Wwwwwwwwwwwwwwww != null) {
                    if (Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(true) && this.Wwwwwwwwwwwwwwww != null) {
                        EditText editText = new EditText(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                        editText.setHint("输入搜索内容");
                        create = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww).setTitle(this.Wwwwwwwwwwwwwwww.getName()).setView(editText).setNegativeButton("搜索测试", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText)).setPositiveButton("搜索\"我的\"", new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(editText)).create();
                        create.setView(editText, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10), 0, r40.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(10), 0);
                        create.setOnShowListener(new Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this));
                        break;
                    } else {
                        return;
                    }
                } else {
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "站源数据错误");
                    return;
                }
            case R.id.iv_back /* 2131362149 */:
                finish();
                return;
            case R.id.tv_del /* 2131362669 */:
                WebSourceTitaData webSourceTitaData2 = this.Wwwwwwwwwwwwwwww;
                if (webSourceTitaData2 != null && !TextUtils.isEmpty(webSourceTitaData2.getName()) && !TextUtils.isEmpty(this.Wwwwwwwwwwwwwwww.getBaseUrl())) {
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(this.Wwwwwwwwwwwwwwwwwwwwwwww);
                    StringBuilder Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3 = outline.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww("是否删除 ");
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(this.Wwwwwwwwwwwwwwww.getName());
                    Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.append(" ？");
                    message = builder2.setMessage(Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww3.toString());
                    wwwwwwwwwwwwwwwwwwwwwwwwwww = new Wwwwwwwwwwwwwwwwwwwwwwwwwwww();
                    str = "删除";
                    create = message.setPositiveButton(str, wwwwwwwwwwwwwwwwwwwwwwwwwww).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create();
                    create.setCanceledOnTouchOutside(true);
                    break;
                } else {
                    eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "站源数据错误");
                    return;
                }
                break;
            default:
                return;
        }
        create.show();
    }
}
