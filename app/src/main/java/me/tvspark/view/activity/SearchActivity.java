package me.tvspark.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;
import butterknife.OnClick;
import com.stub.StubApp;
import me.tvspark.adapter.SearchWebSourceAdapter;
import me.tvspark.bl0;
import me.tvspark.common.view.BaseActivity;
import me.tvspark.data.sql.WebSourceIndexData;
import me.tvspark.eo0;
import me.tvspark.mn0;
import me.tvspark.tt0;
import me.tvspark.un0;
import me.tvspark.view.fragment.SearchHistoryFragment;
import me.tvspark.view.fragment.SearchWebFragment;
import me.tvspark.view.fragment.SearchWebSourceAllFragment;
import me.tvspark.view.fragment.SearchWebSourceAllFrameFragment;
import me.tvspark.view.fragment.SearchWebSourceSignalFragment;
import me.tvspark.view.fragment.WebSoFragment;
import white.whale.R;

/* loaded from: classes4.dex */
public class SearchActivity extends BaseActivity {
    public SearchWebSourceSignalFragment Wwwwwwwwwwwwwww;
    public SearchWebSourceAllFrameFragment Wwwwwwwwwwwwwwww;
    public SearchWebFragment Wwwwwwwwwwwwwwwww;
    public SearchHistoryFragment Wwwwwwwwwwwwwwwwww;
    public WebSourceIndexData Wwwwwwwwwwwwwwwwwww;
    @BindView(R.id.et_search)
    public EditText etSearch;
    @BindView(R.id.flyt_history)
    public FrameLayout flytHistory;
    @BindView(R.id.flyt_web)
    public FrameLayout flytWeb;
    @BindView(R.id.flyt_web_source_all)
    public FrameLayout flytWebSourceAll;
    @BindView(R.id.flyt_web_source_signal)
    public FrameLayout flytWebSourceSignal;
    @BindView(R.id.iv_search)
    public ImageView ivSearch;
    public boolean Wwwwwwwwwwwwww = true;
    public boolean Wwwwwwwwwwwww = true;
    public int Wwwwwwwwwwww = 0;

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TextView.OnEditorActionListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3 || (keyEvent != null && keyEvent.getKeyCode() == 66)) {
                return SearchActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
            }
            return false;
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements TextWatcher {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable.toString())) {
                SearchActivity.this.flytWebSourceAll.setVisibility(8);
                SearchActivity.this.flytWeb.setVisibility(8);
                SearchActivity.this.flytWebSourceSignal.setVisibility(8);
                SearchActivity.this.flytHistory.setVisibility(0);
                SearchActivity.this.Wwwwwwwwwwwwww = true;
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
    public class Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww implements View.OnClickListener {
        public Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchActivity.this.Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(null);
        }
    }

    static {
        StubApp.interface11(11253);
    }

    @Override // me.tvspark.common.view.BaseActivity
    public boolean Wwwwwwwwwwwwwww() {
        return true;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public bl0 Wwwwwwwwwwwwwwww() {
        return null;
    }

    @Override // me.tvspark.common.view.BaseActivity
    public int Wwwwwwwwwwwwwwwww() {
        return R.layout.activity_search;
    }

    public boolean Wwwwwwwwwwwwwwwwwwwwwwwwwwwww(String str) {
        FragmentTransaction beginTransaction;
        int i;
        Fragment fragment;
        SearchWebSourceAllFragment searchWebSourceAllFragment;
        if (this.etSearch == null) {
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            this.etSearch.setText(str);
            this.etSearch.setSelection(str.length());
        } else {
            str = this.etSearch.getText().toString();
        }
        if (TextUtils.isEmpty(str)) {
            eo0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.Wwwwwwwwwwwwwwwwwwwwwwww, "请输入搜索内容");
            return false;
        }
        this.etSearch.clearFocus();
        Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.etSearch);
        int i2 = this.Wwwwwwwwwwww;
        if (i2 == 1) {
            this.flytWeb.setVisibility(8);
            this.flytWebSourceAll.setVisibility(8);
            this.flytWebSourceSignal.setVisibility(0);
            this.flytHistory.setVisibility(8);
            this.Wwwwwwwwwwwwww = false;
            SearchWebSourceSignalFragment searchWebSourceSignalFragment = this.Wwwwwwwwwwwwwww;
            if (searchWebSourceSignalFragment != null) {
                searchWebSourceSignalFragment.Wwwwwww = str;
                SearchWebSourceAdapter searchWebSourceAdapter = searchWebSourceSignalFragment.Wwwwwwwwwwwwww;
                if (searchWebSourceAdapter != null) {
                    searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwwww = str;
                    searchWebSourceAdapter.Wwwwwwwwwwwwwwwwwwwwwww.clear();
                    searchWebSourceAdapter.notifyDataSetChanged();
                }
                searchWebSourceSignalFragment.Wwwwwwwwwwww();
            }
        } else if (i2 == 0) {
            this.flytWeb.setVisibility(8);
            this.flytWebSourceAll.setVisibility(0);
            this.flytWebSourceSignal.setVisibility(8);
            this.flytHistory.setVisibility(8);
            this.Wwwwwwwwwwwwww = false;
            SearchWebSourceAllFrameFragment searchWebSourceAllFrameFragment = this.Wwwwwwwwwwwwwwww;
            if (searchWebSourceAllFrameFragment != null) {
                searchWebSourceAllFrameFragment.Wwwwwwwwww = str;
                if (searchWebSourceAllFrameFragment.Wwwwwwwwwww && (searchWebSourceAllFragment = searchWebSourceAllFrameFragment.Wwwwwwwwwwwwww) != null) {
                    searchWebSourceAllFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, true);
                    SearchWebSourceAllFragment searchWebSourceAllFragment2 = searchWebSourceAllFrameFragment.Wwwwwwwwwwwww;
                    if (searchWebSourceAllFragment2 != null) {
                        searchWebSourceAllFragment2.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, false);
                    }
                } else if (searchWebSourceAllFrameFragment.Wwwwwwwwwwwww != null) {
                    SearchWebSourceAllFragment searchWebSourceAllFragment3 = searchWebSourceAllFrameFragment.Wwwwwwwwwwwwww;
                    if (searchWebSourceAllFragment3 != null) {
                        searchWebSourceAllFragment3.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, false);
                    }
                    searchWebSourceAllFrameFragment.Wwwwwwwwwwwww.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str, true);
                }
            } else {
                SearchWebSourceAllFrameFragment searchWebSourceAllFrameFragment2 = new SearchWebSourceAllFrameFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key_string", str);
                searchWebSourceAllFrameFragment2.setArguments(bundle);
                this.Wwwwwwwwwwwwwwww = searchWebSourceAllFrameFragment2;
                beginTransaction = getSupportFragmentManager().beginTransaction();
                i = R.id.flyt_web_source_all;
                fragment = this.Wwwwwwwwwwwwwwww;
                beginTransaction.add(i, fragment).commit();
            }
        } else if (i2 == 2) {
            if (un0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(str)) {
                mn0.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww((Context) this.Wwwwwwwwwwwwwwwwwwwwwwww, str, true);
                return true;
            }
            this.flytWeb.setVisibility(0);
            this.flytWebSourceAll.setVisibility(8);
            this.flytWebSourceSignal.setVisibility(8);
            this.flytHistory.setVisibility(8);
            this.Wwwwwwwwwwwwww = false;
            SearchWebFragment searchWebFragment = this.Wwwwwwwwwwwwwwwww;
            if (searchWebFragment != null) {
                searchWebFragment.Wwwwwwwwwwwww = str;
                for (int i3 = 0; i3 < searchWebFragment.Wwwwwwwwwwwwwww.size(); i3++) {
                    WebSoFragment webSoFragment = (WebSoFragment) searchWebFragment.Wwwwwwwwwwwwwww.valueAt(i3);
                    webSoFragment.Wwwwwwwwwwwww = str;
                    webSoFragment.Wwwwwwwwwwwwww();
                }
            } else {
                SearchWebFragment searchWebFragment2 = new SearchWebFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putString("key_string", str);
                searchWebFragment2.setArguments(bundle2);
                this.Wwwwwwwwwwwwwwwww = searchWebFragment2;
                beginTransaction = getSupportFragmentManager().beginTransaction();
                i = R.id.flyt_web;
                fragment = this.Wwwwwwwwwwwwwwwww;
                beginTransaction.add(i, fragment).commit();
            }
        }
        SearchHistoryFragment searchHistoryFragment = this.Wwwwwwwwwwwwwwwwww;
        if (searchHistoryFragment != null) {
            searchHistoryFragment.Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(new tt0(searchHistoryFragment, str));
        }
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.Wwwwwwwwwwwwww || !this.Wwwwwwwwwwwww) {
            finish();
            return;
        }
        this.flytWeb.setVisibility(8);
        this.flytWebSourceSignal.setVisibility(8);
        this.flytWebSourceAll.setVisibility(8);
        this.flytHistory.setVisibility(0);
        this.Wwwwwwwwwwwwww = true;
    }

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // me.tvspark.common.view.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        try {
            this.etSearch.clearFocus();
            Wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww(this.etSearch);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.iv_back})
    public void onViewClicked(View view) {
        if (view.getId() != R.id.iv_back) {
            return;
        }
        onBackPressed();
    }
}
